/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.ConsultasVenta;
import modelo.ModeloTablaVenta;
import modelo.ModeloVenta;
import vista.VistaBusquedaPorMetodoPago;
import vista.VistaVenta;

/**
 *
 * @author Omar Figueroa Perez
 */
public class ControladorVistaVenta implements MouseListener{
    private ModeloVenta ModeloVenta;
    private VistaVenta VistaVenta;
    
    private ConsultasVenta ConsultasVenta = new ConsultasVenta();

    public ControladorVistaVenta(ModeloVenta ModeloVenta, VistaVenta VistaVenta) {
        this.ModeloVenta = ModeloVenta;
        this.VistaVenta = VistaVenta;
        oyentesVista();
        
        VistaVenta.setVisible(true);
    }

    private void oyentesVista() {
        VistaVenta.BtnSalir.addMouseListener(this);
        VistaVenta.BtnGuardar.addMouseListener(this);
        VistaVenta.BtnActualizar.addMouseListener(this);
        VistaVenta.BtnEliminar.addMouseListener(this);
        VistaVenta.BtnBuscar.addMouseListener(this);
        VistaVenta.BtnBusquedaAvanzada.addMouseListener(this);
        VistaVenta.BtnLimpiar.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent ge) {
        if (ge.getSource()==VistaVenta.BtnGuardar) {
            guardar();
        }else if(ge.getSource()==VistaVenta.BtnActualizar){ 
            modificar();
        }else if(ge.getSource()==VistaVenta.BtnEliminar){
            eliminar();
        }else if(ge.getSource()==VistaVenta.BtnBuscar){
            buscar();
        }else if(ge.getSource()==VistaVenta.BtnSalir){
            salir();
        }else if(ge.getSource()==VistaVenta.BtnLimpiar){
            limpiarTodosLosCampos();
        }else if(ge.getSource()==VistaVenta.BtnBusquedaAvanzada){
            busquedaMVC();
        }
    }

    @Override
    public void mousePressed(MouseEvent ge) {}

    @Override
    public void mouseReleased(MouseEvent ge) {}

    @Override
    public void mouseEntered(MouseEvent ge) {
        if (ge.getSource()==VistaVenta.BtnGuardar) {
            VistaVenta.BtnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }else if (ge.getSource()==VistaVenta.BtnSalir) {
            VistaVenta.BtnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }else if (ge.getSource()==VistaVenta.BtnActualizar) {
            VistaVenta.BtnActualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }else if (ge.getSource()==VistaVenta.BtnEliminar) {
            VistaVenta.BtnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }else if (ge.getSource()==VistaVenta.BtnBuscar) {
            VistaVenta.BtnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }else if (ge.getSource()==VistaVenta.BtnLimpiar) {
            VistaVenta.BtnLimpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }else if (ge.getSource()==VistaVenta.BtnBusquedaAvanzada) {
            VistaVenta.BtnBusquedaAvanzada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent ge) {}
    
    private boolean validarCampoId(){
        if (VistaVenta.TxtIdVenta.getText().isEmpty()) 
            return false;
        else
            return true;
    }
    
    private void limpiarCampos(){
        VistaVenta.TxtIdVenta.setText("");
        VistaVenta.TxtIdUsuario.setText("");
        VistaVenta.TxtIdCliente.setText("");
        VistaVenta.TxtTotal.setText("");
    }
    
    private void llenarModeloConVista(){
        ModeloVenta.setId_venta(VistaVenta.TxtIdVenta.getText());
        ModeloVenta.setId_cliente(VistaVenta.TxtIdCliente.getText());
        ModeloVenta.setId_usuario(VistaVenta.TxtIdUsuario.getText());
        ModeloVenta.setSucursal((VistaVenta.TxtSucursal.getText()));
        ModeloVenta.setTotal(Float.parseFloat(VistaVenta.TxtTotal.getText()));
        ModeloVenta.setMetodo_pago(VistaVenta.TxtMetodoPago.getText());
    }
    
    private void llenarVistaConModelo(){
        VistaVenta.TxtIdVenta.setText(ModeloVenta.getId_venta()+"");
        VistaVenta.TxtIdCliente.setText(ModeloVenta.getId_cliente()+"");
        VistaVenta.TxtIdUsuario.setText(ModeloVenta.getId_usuario()+"");
        VistaVenta.TxtSucursal.setText(ModeloVenta.getSucursal()+"");
        VistaVenta.TxtTotal.setText(ModeloVenta.getTotal()+"");
        VistaVenta.TxtMetodoPago.setText(ModeloVenta.getMetodo_pago()+"");
    }
    
    private boolean validarTodosLosCampos(){
        if (VistaVenta.TxtIdVenta.getText().isEmpty() || 
                VistaVenta.TxtIdCliente.getText().isEmpty() || 
                VistaVenta.TxtIdUsuario.getText().isEmpty()||
                VistaVenta.TxtSucursal.getText().isEmpty()||
                VistaVenta.TxtTotal.getText().isEmpty()||
                VistaVenta.TxtMetodoPago.getText().isEmpty())
            return false;
        else
            return true;
    }
    
    private void buscar() {
        if (validarCampoId()) {
            ModeloVenta.setId_venta(VistaVenta.TxtIdVenta.getText());
            if (ConsultasVenta.buscar(ModeloVenta)==true) {
                llenarVistaConModelo();
            }else{
                JOptionPane.showMessageDialog(VistaVenta,"Registro no existe");
            } 
        }else{
            JOptionPane.showMessageDialog(null,"Los campos no deben estar vacíos");
        }
    }
    
    //Botones
    private void guardar() {
        if (validarTodosLosCampos()) {
            ModeloVenta.setId_venta(VistaVenta.TxtIdVenta.getText());
            if (ConsultasVenta.buscar(ModeloVenta)==true) {
                JOptionPane.showMessageDialog(VistaVenta,"Esta venta ya existe");
            }else{
                llenarModeloConVista();
                if (ConsultasVenta.insertar(ModeloVenta)==true) {
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
            
            ModeloVenta ModeloTemporal = new ModeloVenta();
            ModeloTemporal.setId_venta(VistaVenta.TxtIdVenta.getText());
            
            if (ConsultasVenta.buscar(ModeloTemporal)==false) {
                JOptionPane.showMessageDialog(VistaVenta,"Esa Venta no Existe");
            }else{
                if (ConsultasVenta.modificar(ModeloVenta)) {
                    JOptionPane.showMessageDialog(VistaVenta,"Registro Modificado Correctamente");
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
            ModeloVenta.setId_venta(VistaVenta.TxtIdVenta.getText());
            if (ConsultasVenta.buscar(ModeloVenta)==false) {
                JOptionPane.showMessageDialog(VistaVenta,"Esa Venta no existe");
            }else{
                if (ConsultasVenta.eliminar(ModeloVenta)) {
                    JOptionPane.showMessageDialog(VistaVenta,"Venta eliminada correctamente");
                    limpiarCampos();
                }else{
                    JOptionPane.showMessageDialog(VistaVenta,"Error al eliminar Venta");
                }
            }
        }else{
                JOptionPane.showMessageDialog(null,"El campo de Código no debe estar vacío");
        }
    }

    private void salir() {
        int opc = JOptionPane.showConfirmDialog(VistaVenta,"¿Quieres Salir de Ventas?","Alerta",0,1);
        if(opc ==0) VistaVenta.dispose();
    }

    private void limpiarTodosLosCampos() {
        VistaVenta.TxtIdVenta.setText("");
        VistaVenta.TxtIdUsuario.setText("");
        VistaVenta.TxtIdCliente.setText("");
        VistaVenta.TxtSucursal.setText("");
        VistaVenta.TxtTotal.setText("");
        VistaVenta.TxtMetodoPago.setText("");
    }
    
    private void busquedaMVC() {
        ModeloTablaVenta ModeloTablaVenta = new ModeloTablaVenta();
        
        VistaBusquedaPorMetodoPago VistaBusquedaPorMetodoPago =
                new VistaBusquedaPorMetodoPago(new JFrame(), true);
        
        ControladorVistaBusquedaPorMetodoPago ControladorVistaBusquedaPorMetodoPago =
                new ControladorVistaBusquedaPorMetodoPago(ModeloTablaVenta,
                        ModeloVenta,VistaBusquedaPorMetodoPago);
        
        llenarVistaConModelo();
        limpiarTodosLosCampos();
    }
}
