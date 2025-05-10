/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.ConsultasVenta;
import modelo.ModeloTablaVenta;
import modelo.ModeloVenta;
import vista.VistaBusquedaPorMetodoPago;

/**
 *
 * @author Omar Figueroa Perez
 */
public class ControladorVistaBusquedaPorMetodoPago implements MouseListener, KeyListener{
    ModeloTablaVenta ModeloTablaVenta;
    ModeloVenta ModeloVenta;
    VistaBusquedaPorMetodoPago VistaBusquedaPorMetodoPago;
    ConsultasVenta ConsultasVenta = new ConsultasVenta();

    public ControladorVistaBusquedaPorMetodoPago(ModeloTablaVenta ModeloTablaVenta, ModeloVenta ModeloVenta, VistaBusquedaPorMetodoPago VistaBusquedaPorMetodoPago) {
        this.ModeloTablaVenta = ModeloTablaVenta;
        this.ModeloVenta = ModeloVenta;
        this.VistaBusquedaPorMetodoPago = VistaBusquedaPorMetodoPago;
        
        VistaBusquedaPorMetodoPago.Tabla.setModel(ModeloTablaVenta.getModeloTabla());
        
        oyentes();
        llenarTablaVentas();
        VistaBusquedaPorMetodoPago.setVisible(true);
    }
    
    private void oyentes() {
        VistaBusquedaPorMetodoPago.TxtNombre.addMouseListener(this);
        VistaBusquedaPorMetodoPago.Tabla.addMouseListener(this);
        VistaBusquedaPorMetodoPago.BtnAceptar.addMouseListener(this);
        
        VistaBusquedaPorMetodoPago.TxtNombre.addKeyListener(this);
    }
    
    private void llenarTablaVentas() {
        ConsultasVenta.buscarTodasLasVentas(ModeloTablaVenta.getModeloTabla());
        VistaBusquedaPorMetodoPago.Tabla.setModel(ModeloTablaVenta.getModeloTabla());
    }
    
    private void llenarModeloConSeleccionFilaTabla() {
        int filaSeleccionada = VistaBusquedaPorMetodoPago.Tabla.getSelectedRow();
        
        if (filaSeleccionada !=-1) {
            String id_venta = ModeloTablaVenta.getModeloTabla().getValueAt(filaSeleccionada,0).toString();
            String metodo_pago = ModeloTablaVenta.getModeloTabla().getValueAt(filaSeleccionada,1).toString();
            String id_cliente = ModeloTablaVenta.getModeloTabla().getValueAt(filaSeleccionada,2).toString();
            String id_usuario = ModeloTablaVenta.getModeloTabla().getValueAt(filaSeleccionada,3).toString();
            float total = Float.parseFloat(ModeloTablaVenta.getModeloTabla().getValueAt(filaSeleccionada,4).toString());
            String sucursal = ModeloTablaVenta.getModeloTabla().getValueAt(filaSeleccionada,5).toString();
            
            ModeloVenta.setId_venta(id_venta);
            ModeloVenta.setMetodo_pago(metodo_pago);
            ModeloVenta.setId_cliente(id_cliente);
            ModeloVenta.setId_usuario(id_usuario);
            ModeloVenta.setTotal(total);
            ModeloVenta.setSucursal(sucursal);
            
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent ye) {
        if (ye.getSource()==VistaBusquedaPorMetodoPago.BtnAceptar) {
            llenarModeloConSeleccionFilaTabla();
            VistaBusquedaPorMetodoPago.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent ye) {}

    @Override
    public void mouseReleased(MouseEvent ye) {}

    @Override
    public void mouseEntered(MouseEvent ye) {}

    @Override
    public void mouseExited(MouseEvent ye) {}

    @Override
    public void keyTyped(KeyEvent ke) {}

    @Override
    public void keyPressed(KeyEvent ke) {}

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getSource()==VistaBusquedaPorMetodoPago.TxtNombre) {
            ConsultasVenta.buscarFrase(VistaBusquedaPorMetodoPago.TxtNombre, 
                    ModeloTablaVenta.getModeloTabla());
        }
    }
}
