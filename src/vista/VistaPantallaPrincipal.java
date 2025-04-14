/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * @since 04/14/2025
 * @author Omar Figueroa Perez
 * @version 1.
 */
public class VistaPantallaPrincipal extends JFrame{
    //Botones
    public JButton BtnReporte = new JButton(new ImageIcon(getClass().getResource("/imagenes/icono_reporte.png")));
    public JButton BtnVenta = new JButton(new ImageIcon(getClass().getResource("/imagenes/icono_venta.png")));
    public JButton BtnInventario = new JButton(new ImageIcon(getClass().getResource("/imagenes/icono_inventario.png")));
    public JButton BtnProducto = new JButton(new ImageIcon(getClass().getResource("/imagenes/icono_producto.png")));
    public JButton BtnSalir = new JButton(new ImageIcon(getClass().getResource("/imagenes/icono_salir.png")));
    //Texto
    public JLabel Titulo = new JLabel("<html><center>BIENVENIDO<br><br>ver. 0.01</center></html>");
    
    //Fondo
    ImageIcon ImFondo = new ImageIcon(getClass().getResource("/imagenes/fondo_psyduck.png"));
    JLabel LblFondo = new JLabel(ImFondo);
    public VistaPantallaPrincipal(){
        configuracion();
        botones();
        texto();
    }

    private void configuracion() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(ImFondo.getIconWidth(),ImFondo.getIconHeight());
        this.setLocationRelativeTo(null);
        this.setTitle("Punto Fácil");
        this.setLayout(null);
        this.setResizable(false);
        this.setContentPane(LblFondo);
        // this.setUndecorated(true); Por si le quieren quitar la parte de arriba
    }

    private void botones() {
        
        this.add(BtnReporte);
        BtnReporte.setBounds(500, 60, 140, 100); // Tamaño cuadrado para íconos
        BtnReporte.setBorderPainted(false);
        BtnReporte.setContentAreaFilled(false);

        this.add(BtnVenta);
        BtnVenta.setBounds(500, 180, 140, 100);
        BtnVenta.setBorderPainted(false);
        BtnVenta.setContentAreaFilled(false);

        this.add(BtnInventario);
        BtnInventario.setBounds(500, 300, 140, 100);
        BtnInventario.setBorderPainted(false);
        BtnInventario.setContentAreaFilled(false);

        this.add(BtnProducto);
        BtnProducto.setBounds(500, 420, 140, 100);
        BtnProducto.setBorderPainted(false);
        BtnProducto.setContentAreaFilled(false);
        
        this.add(BtnSalir);
        BtnSalir.setBounds(710, 10, 80, 80);
        BtnSalir.setBorderPainted(false);
        BtnSalir.setContentAreaFilled(false);
        
        
    }
    
    private void texto() {
        this.add(Titulo);
        Titulo.setFont(new Font("Arial", Font.BOLD,32));
        Titulo.setBounds(100, 30, 400, 100);
        
        //Botones
        BtnProducto.setText("Agregar Producto");
        BtnProducto.setHorizontalTextPosition(JButton.CENTER);
        BtnProducto.setVerticalTextPosition(JButton.BOTTOM);
        
        BtnReporte.setText("Reportes");
        BtnReporte.setHorizontalTextPosition(JButton.CENTER);
        BtnReporte.setVerticalTextPosition(JButton.BOTTOM);

        BtnVenta.setText("Registrar Venta");
        BtnVenta.setHorizontalTextPosition(JButton.CENTER);
        BtnVenta.setVerticalTextPosition(JButton.BOTTOM);

        BtnInventario.setText("Inventario");
        BtnInventario.setHorizontalTextPosition(JButton.CENTER);
        BtnInventario.setVerticalTextPosition(JButton.BOTTOM);
        
        BtnSalir.setText("Salir");
        BtnSalir.setHorizontalTextPosition(JButton.CENTER);
        BtnSalir.setVerticalTextPosition(JButton.BOTTOM);
    }
}