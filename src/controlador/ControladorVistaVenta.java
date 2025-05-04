/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
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
}
