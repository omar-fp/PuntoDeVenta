/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JFrame;
/**
 *
 * @author Omar Figueroa Perez
 */
public class VistaVenta extends JDialog{
    //Etiquetas
    public JLabel LblTitulo = new JLabel("Ventana Ventas");
    public JLabel LblIdVenta = new JLabel("IDVenta:");
    public JLabel LblIdUsuario = new JLabel("Usuario:");
    public JLabel LblIdCliente = new JLabel("Cliente:");
    public JLabel LblSucursal  = new JLabel("Sucursal:");
    public JLabel LblTotal = new JLabel("Total:");
    public JLabel LblMetodoPago = new JLabel("Metodo de Pago:");
    public JLabel LblBusquedaAvanzada = new JLabel("Busqueda A.");
    public JLabel LblLimpiar = new JLabel("Limpiar Campos");
    
    public JLabel LblGuardar = new JLabel("Guardar");
    public JLabel LblEliminar = new JLabel("Eliminar");
    public JLabel LblActualizar = new JLabel("Actualizar");
    
    //Texto
    public JTextField TxtIdVenta = new JTextField();
    public JTextField TxtIdUsuario = new JTextField();
    public JTextField TxtIdCliente = new JTextField();
    public JTextField TxtSucursal = new JTextField();
    public JTextField TxtTotal = new JTextField();
    public JTextField TxtMetodoPago = new JTextField(); 
    
    //Botones
    public JButton BtnSalir = new JButton("Salir");
    
    //Botones con imagen
    public JButton BtnBusquedaAvanzada = new JButton(new ImageIcon(getClass().getResource("/imagenes/icono_busqueda.png")));
    public JButton BtnGuardar = new JButton(new ImageIcon(getClass().getResource("/imagenes/icono_guardar.png")));
    public JButton BtnEliminar = new JButton(new ImageIcon(getClass().getResource("/imagenes/icono_borrar.png")));
    public JButton BtnActualizar = new JButton(new ImageIcon(getClass().getResource("/imagenes/icono_actualizar.png")));
    public JButton BtnBuscar = new JButton(new ImageIcon(getClass().getResource("/imagenes/icono_buscar.png")));
    public JButton BtnLimpiar = new JButton(new ImageIcon(getClass().getResource("/imagenes/icono_limpiar.png")));
    
    // Fondo
    ImageIcon Fondo = new ImageIcon(getClass().getResource("/imagenes/psyduck_ventas.png"));
    JLabel lblFondo = new JLabel(Fondo);
    
    
    public VistaVenta(JFrame parent, boolean modal) {
        super(parent, modal);
        configuracion();
        botones();
        etiquetas();
        camposTxt();
        AgregarComponentes();
    }

    private void configuracion() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(Fondo.getIconWidth(), Fondo.getIconHeight());
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        this.setContentPane(lblFondo);
    }

    private void botones() {
        // Botones
        BtnSalir.setBounds(50, 300, 100, 40);
        
        //Botones con imagen
        BtnGuardar.setBounds(50, 100, 32, 32);
        BtnGuardar.setBorderPainted(false);
        BtnGuardar.setContentAreaFilled(false);
        
        BtnBuscar.setBounds(140, 70, 32, 32);
        BtnBuscar.setBorderPainted(false);
        BtnBuscar.setContentAreaFilled(false);
        
        BtnEliminar.setBounds(50, 150, 32, 32);
        BtnEliminar.setBorderPainted(false);
        BtnEliminar.setContentAreaFilled(false);
        
        BtnActualizar.setBounds(50, 200, 32, 32);
        BtnActualizar.setBorderPainted(false);
        BtnActualizar.setContentAreaFilled(false);
        
        BtnBusquedaAvanzada.setBounds(50, 250, 32, 32 ); 
        BtnBusquedaAvanzada.setBorderPainted(false);
        BtnBusquedaAvanzada.setContentAreaFilled(false);
        
        BtnLimpiar.setBounds(200, 300, 32, 32);
        BtnLimpiar.setBorderPainted(false);
        BtnLimpiar.setContentAreaFilled(false);
    }

    private void etiquetas() {
        // Título
        LblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        LblTitulo.setBounds(550, 20, 300, 40);
        
        // Etiquetas
        LblIdVenta.setBounds(200, 50, 100, 30);   
        LblIdCliente.setBounds(300, 50, 100, 30); 
        LblTotal.setBounds(500, 50, 100, 30);
        LblMetodoPago.setBounds(350, 300, 100, 30); 
        LblIdUsuario.setBounds(550, 300, 100, 30); 
        LblSucursal.setBounds(650, 300, 100, 30);
        
        
        // Etiquetas de botones
        LblGuardar.setBounds(90, 100, 60, 32);
        LblGuardar.setForeground(Color.white);
        
        LblEliminar.setBounds(90, 150, 60, 32);
        LblEliminar.setForeground(Color.white);
        
        LblActualizar.setBounds(90, 200, 60, 32);
        LblActualizar.setForeground(Color.white);
        
        LblBusquedaAvanzada.setBounds(90, 250, 100, 32);
        LblBusquedaAvanzada.setForeground(Color.white);
        
        LblLimpiar.setBounds(240, 300, 120, 32);
        LblLimpiar.setForeground(Color.WHITE);
    }

    private void camposTxt() {
        //Campos
        TxtIdVenta.setBounds(190, 70, 60, 30); 
        TxtIdCliente.setBounds(290, 70, 60, 30); 
        TxtTotal.setBounds(460, 70, 120, 30);
        TxtMetodoPago.setBounds(350, 320, 120, 30); 
        TxtIdUsuario.setBounds(550, 320, 60, 30); 
        TxtSucursal.setBounds(650, 320, 60, 30);
    }
    
    private void AgregarComponentes() {
        //Etiquetas
        this.add(LblTitulo);
        this.add(LblIdVenta);
        this.add(TxtIdVenta);
        this.add(LblIdUsuario);
        this.add(TxtIdUsuario);
        this.add(LblIdCliente);
        this.add(TxtIdCliente);
        this.add(LblSucursal);
        this.add(TxtSucursal);
        this.add(LblTotal);
        this.add(TxtTotal);
        this.add(LblMetodoPago);
        this.add(TxtMetodoPago);

        // Etiquetas de los botones
        this.add(LblGuardar);
        this.add(LblEliminar);
        this.add(LblActualizar);
        this.add(LblBusquedaAvanzada);
        this.add(LblLimpiar);
        
        //Botones
        this.add(BtnGuardar);
        this.add(BtnBuscar);
        this.add(BtnEliminar);
        this.add(BtnActualizar);
        this.add(BtnSalir);
        this.add(BtnBusquedaAvanzada);
        this.add(BtnLimpiar);
    }
}
