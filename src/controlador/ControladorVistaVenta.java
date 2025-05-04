/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.ConsultasVenta;
import modelo.ModeloVenta;
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
        }
    }

    @Override
    public void mousePressed(MouseEvent ge) {}

    @Override
    public void mouseReleased(MouseEvent ge) {}

    @Override
    public void mouseEntered(MouseEvent ge) {}

    @Override
    public void mouseExited(MouseEvent ge) {}
    
    private boolean validarCampoId(){
        if (VistaVenta.TxtIdVenta.getText().isEmpty())
            return false;
        else
            return true;
    }
    
    private void totalPago(){
    }
    
    private void limpiarCampos(){
        VistaVenta.TxtIdVenta.setText("");
        VistaVenta.TxtIdUsuario.setText("");
        VistaVenta.TxtIdCliente.setText("");
        VistaVenta.TxtSucursal.setText("");
        VistaVenta.TxtTotal.setText("");
        VistaVenta.TxtFecha.setText("");
    }
    
    private void llenarModeloConVista(){
        ModeloVenta.setId_venta(VistaVenta.TxtIdVenta.getText());
        ModeloVenta.setId_cliente(VistaVenta.TxtIdCliente.getText());
        ModeloVenta.setId_usuario(VistaVenta.TxtIdUsuario.getText());
        ModeloVenta.setSucursal((VistaVenta.TxtSucursal.getText()));
        ModeloVenta.setTotal(Float.parseFloat(VistaVenta.TxtTotal.getText()));
        //ModeloVenta.setFecha(VistaVenta.TxtFecha.getText());
    }
    
    private void llenarVistaConModelo(){
        VistaVenta.TxtIdVenta.setText(ModeloVenta.getId_venta()+"");
        VistaVenta.TxtIdCliente.setText(ModeloVenta.getId_cliente()+"");
        VistaVenta.TxtIdUsuario.setText(ModeloVenta.getId_usuario()+"");
        VistaVenta.TxtSucursal.setText(ModeloVenta.getSucursal()+"");
        VistaVenta.TxtTotal.setText(ModeloVenta.getTotal()+"");
        //VistaVenta.TxtFecha.setText(ModeloVenta.getFecha());
    }
        
    
    
    
    
    
    
    //Botones
    private void guardar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void modificar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    private void salir() {
        int opc = JOptionPane.showConfirmDialog(VistaVenta,"¿Quieres Salir de Ventas?","Alerta",0,1);
        if(opc ==0) VistaVenta.dispose();
    }
}
