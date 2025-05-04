/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

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
    public JLabel LblIdVenta = new JLabel("Código:");
    public JLabel LblIdUsuario = new JLabel("Usuario:");
    public JLabel LblIdCliente = new JLabel("Cliente:");
    public JLabel LblSucursal  = new JLabel("Sucursal:");
    public JLabel LblTotal = new JLabel("Total:");
    public JLabel LblFecha = new JLabel("Fecha:");

    //Texto
    public JTextField TxtIdVenta = new JTextField();
    public JTextField TxtIdUsuario = new JTextField();
    public JTextField TxtIdCliente = new JTextField();
    public JTextField TxtSucursal = new JTextField();
    public JTextField TxtTotal = new JTextField();
    public JTextField TxtFecha = new JTextField(); 
    
    //Botones
    public JButton BtnGuardar = new JButton("Guardar");
    public JButton BtnBuscar = new JButton("Buscar");
    public JButton BtnEliminar = new JButton("Eliminar");
    public JButton BtnActualizar = new JButton("Actualizar");
    public JButton BtnSalir = new JButton("Salir");
    
    // Fondo
    ImageIcon Fondo = new ImageIcon(getClass().getResource("/imagenes/psyduck_productos.png"));
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
        BtnGuardar.setBounds(50, 50, 100, 40);
        BtnBuscar.setBounds(50, 100, 100, 40);
        BtnEliminar.setBounds(50, 150, 100, 40);
        BtnActualizar.setBounds(50, 200, 100, 40);
        BtnSalir.setBounds(50, 300, 100, 40);
    }

    private void etiquetas() {
        // Título
        LblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        LblTitulo.setBounds(550, 20, 300, 40);
        
        // Etiquetas
        LblIdVenta.setBounds(200, 50, 100, 30);   
        LblIdCliente.setBounds(300, 50, 100, 30); 
        LblTotal.setBounds(500, 50, 100, 30);
        LblFecha.setBounds(350, 300, 100, 30); 
        LblIdUsuario.setBounds(550, 300, 100, 30); 
        LblSucursal.setBounds(650, 300, 100, 30);
    }

    private void camposTxt() {
        //Campos
        TxtIdVenta.setBounds(190, 70, 60, 30); 
        TxtIdCliente.setBounds(290, 70, 60, 30); 
        TxtTotal.setBounds(460, 70, 120, 30);
        TxtFecha.setBounds(350, 320, 120, 30); 
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
        this.add(LblFecha);
        this.add(TxtFecha);
        
        //Botones
        this.add(BtnGuardar);
        this.add(BtnBuscar);
        this.add(BtnEliminar);
        this.add(BtnActualizar);
        this.add(BtnSalir);
    }
}
