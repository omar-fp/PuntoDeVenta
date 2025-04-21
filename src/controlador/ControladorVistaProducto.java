/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.ConsultasProducto;
import modelo.ModeloProducto;
import vista.VistaProducto;

/**
 *
 * @author Omar Figueroa Perez
 */
public class ControladorVistaProducto implements MouseListener {
    private ModeloProducto ModeloProducto;
    private VistaProducto VistaProducto;
    
    private ConsultasProducto ConsultasProducto = new ConsultasProducto();

    public ControladorVistaProducto(ModeloProducto ModeloProducto, VistaProducto VistaProducto) {
        this.ModeloProducto = ModeloProducto;
        this.VistaProducto = VistaProducto;
        oyentesVista();
        
        VistaProducto.setVisible(true);
    }
    private void oyentesVista() {
        VistaProducto.BtnGuardar.addMouseListener(this);
        VistaProducto.BtnActualizar.addMouseListener(this);
        VistaProducto.BtnEliminar.addMouseListener(this);
        VistaProducto.BtnBuscar.addMouseListener(this);
        VistaProducto.BtnSalir.addMouseListener(this);
    }
        
    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource()==VistaProducto.BtnGuardar) {
            guardar();
        }else if(me.getSource()==VistaProducto.BtnActualizar){ 
            modificar();
        }else if(me.getSource()==VistaProducto.BtnEliminar){
            eliminar();
        }else if(me.getSource()==VistaProducto.BtnBuscar){
            buscar();
        }else if(me.getSource()==VistaProducto.BtnSalir){
            salir();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
    private void llenarModeloConVista(){
        ModeloProducto.setId_producto(VistaProducto.TxtCodigo.getText());
        ModeloProducto.setNombre_producto(VistaProducto.TxtNombre.getText());
        ModeloProducto.setCategoria_producto(VistaProducto.TxtCategoria.getText());
        ModeloProducto.setPrecio_producto(Float.parseFloat(VistaProducto.TxtPrecio.getText()));
        ModeloProducto.setStock_producto(Integer.parseInt(VistaProducto.TxtCantidad.getText()));
        ModeloProducto.setDescripcion_producto(VistaProducto.TxtDescripcion.getText());
    }
    
    private void llenarVistaConModelo(){
        VistaProducto.TxtCodigo.setText(ModeloProducto.getId_producto()+"");
        VistaProducto.TxtNombre.setText(ModeloProducto.getNombre_producto()+"");
        VistaProducto.TxtCategoria.setText(ModeloProducto.getCategoria_producto()+"");
        VistaProducto.TxtPrecio.setText(ModeloProducto.getPrecio_producto()+"");
        VistaProducto.TxtCantidad.setText(ModeloProducto.getStock_producto()+"");
        VistaProducto.TxtDescripcion.setText(ModeloProducto.getDescripcion_producto());
    }
    
    private void limpiarCampos(){
        VistaProducto.TxtCodigo.setText("");
        VistaProducto.TxtNombre.setText("");
        VistaProducto.TxtCategoria.setText("");
        VistaProducto.TxtPrecio.setText("");
        VistaProducto.TxtCantidad.setText("");
        VistaProducto.TxtDescripcion.setText("");
    }
    
    private boolean validarCampoId(){
        if (VistaProducto.TxtCodigo.getText().isEmpty())
            return false;
        else
            return true;
    }
    
    private boolean validarTodosLosCampos(){
        if (VistaProducto.TxtCodigo.getText().isEmpty() || 
                VistaProducto.TxtNombre.getText().isEmpty() || 
                VistaProducto.TxtCategoria.getText().isEmpty()||
                VistaProducto.TxtPrecio.getText().isEmpty()||
                VistaProducto.TxtCantidad.getText().isEmpty()||
                VistaProducto.TxtDescripcion.getText().isEmpty())
            return false;
        else
            return true;
    }
    
    private void guardar() {
        if (validarTodosLosCampos()) {
            ModeloProducto.setId_producto(VistaProducto.TxtCodigo.getText());
            if (ConsultasProducto.buscar(ModeloProducto)==true) {
                JOptionPane.showMessageDialog(VistaProducto,"Este Producto ya existe");
            }else{
                llenarModeloConVista();
                if (ConsultasProducto.insertar(ModeloProducto)==true) {
                    JOptionPane.showMessageDialog(null,"Registro Guardado Correctamente");  
                    limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(null,"Error al Guardar el Registro");
                }
            } 
        }else{
            JOptionPane.showMessageDialog(null,"El campo de código/id no debe estar vacío");
        }
    }
    private void modificar() {
        if (validarTodosLosCampos()) {
            llenarModeloConVista();
            
            ModeloProducto ModeloTemporal = new ModeloProducto();
            ModeloTemporal.setId_producto(VistaProducto.TxtCodigo.getText());
            
            if (ConsultasProducto.buscar(ModeloTemporal)==false) {
                JOptionPane.showMessageDialog(VistaProducto,"Ese Producto no Existe");
            }else{
                if (ConsultasProducto.modificar(ModeloProducto)) {
                    JOptionPane.showMessageDialog(VistaProducto,"Registro Modificado Correctamente");
                    limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(null,"Error al Modificar el Registro");
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Los Campos no deben estar vacíos");
        }
    }
    private void eliminar() {
        if (validarCampoId()) {
            ModeloProducto.setId_producto(VistaProducto.TxtCodigo.getText());
            if (ConsultasProducto.buscar(ModeloProducto)==false) {
                JOptionPane.showMessageDialog(VistaProducto,"Ese producto no existe");
            }else{
                if (ConsultasProducto.eliminar(ModeloProducto)) {
                    JOptionPane.showMessageDialog(VistaProducto,"Registro eliminado correctamente");
                    limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(VistaProducto,"Error al eliminar producto");
                }
            }
        }else{
                JOptionPane.showMessageDialog(null,"El campo de Código no debe estar vacío");
        }
    }
    
    private void buscar() {
        if (validarCampoId()) {
            ModeloProducto.setId_producto(VistaProducto.TxtCodigo.getText());
            if (ConsultasProducto.buscar(ModeloProducto)==true) {
                llenarVistaConModelo();
            }else{
                JOptionPane.showMessageDialog(VistaProducto,"Registro no existe");
            } 
        }else{
            JOptionPane.showMessageDialog(null,"Los campos no deben estar vacíos");
        }
    }
    
    private void salir() {
        int opc = JOptionPane.showConfirmDialog(VistaProducto,"¿Quieres Salir de Productos?","Alerta",0,1);
        if(opc ==0) VistaProducto.dispose();
    }
}