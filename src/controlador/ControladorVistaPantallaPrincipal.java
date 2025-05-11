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
import vista.VistaPantallaPrincipal;

//Entidad Producto
import modelo.ModeloProducto;
import vista.VistaProducto;

//Entidad Venta
import modelo.ModeloVenta;
import vista.VistaVenta;

//Entidad usuario
import vista.vistaUsuario;
import modelo.ModeloUsuario;

/**
 * @since 04/14/2025
 * @author Omar Figueroa Perez
 * @version 1.
 */
public class ControladorVistaPantallaPrincipal implements MouseListener{
    VistaPantallaPrincipal VistaPantallaPrincipal;
    
    public ControladorVistaPantallaPrincipal(VistaPantallaPrincipal VistaPantallaPrincipal){
        this.VistaPantallaPrincipal = VistaPantallaPrincipal;
        oyentes();
        this.VistaPantallaPrincipal.setVisible(true);
    }
    private void oyentes() {
        VistaPantallaPrincipal.BtnSalir.addMouseListener(this);
        VistaPantallaPrincipal.BtnProducto.addMouseListener(this);
        VistaPantallaPrincipal.BtnVenta.addMouseListener(this);
        VistaPantallaPrincipal.BtnReporte.addMouseListener(this);
        VistaPantallaPrincipal.BtnInventario.addMouseListener(this);
        VistaPantallaPrincipal.BtnUsuario.addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==VistaPantallaPrincipal.BtnSalir) {
            int opc = JOptionPane.showConfirmDialog(null, "¿Estás seguro que quieres salir?",
                    "Salir",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (opc==0) 
                System.exit(0);
            //Entidad Producto
            }else if(e.getSource()==VistaPantallaPrincipal.BtnProducto){
            ModeloProducto ModeloProducto = new ModeloProducto();
            VistaProducto VistaProducto = new VistaProducto(new JFrame(), true);
            
            ControladorVistaProducto ControladorVistaProducto = new ControladorVistaProducto(ModeloProducto, VistaProducto);
            
            
            //Entidad Venta
            }else if(e.getSource()==VistaPantallaPrincipal.BtnVenta){
            ModeloVenta ModeloVenta = new ModeloVenta();
            VistaVenta VistaVenta = new VistaVenta(new JFrame(), true);
            
            ControladorVistaVenta ControladorVistaVenta = new ControladorVistaVenta(ModeloVenta, VistaVenta); 
            
            //Entidad Venta_Detalles
            }else if(e.getSource()==VistaPantallaPrincipal.BtnReporte){    
                
            }else if(e.getSource()==VistaPantallaPrincipal.BtnInventario){    
        }//Entidad usuarios
        else if (e.getSource() == VistaPantallaPrincipal.BtnUsuario) {
            vistaUsuario vistaUsuario = new vistaUsuario();
            vistaUsuario.setVisible(true);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource()==VistaPantallaPrincipal.BtnProducto) {
            VistaPantallaPrincipal.BtnProducto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }else if (e.getSource()==VistaPantallaPrincipal.BtnSalir) {
            VistaPantallaPrincipal.BtnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }else if (e.getSource()==VistaPantallaPrincipal.BtnInventario) {
            VistaPantallaPrincipal.BtnInventario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }else if (e.getSource()==VistaPantallaPrincipal.BtnVenta) {
            VistaPantallaPrincipal.BtnVenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }else if (e.getSource()==VistaPantallaPrincipal.BtnReporte) {
            VistaPantallaPrincipal.BtnReporte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {} 
}
