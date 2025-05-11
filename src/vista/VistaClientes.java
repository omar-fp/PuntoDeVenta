/*
Autor: Fatima Jazmin Arellano Becerra
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
 * @author L13 YOGA
 */

public class VistaClientes extends JDialog{
    
    // Etiquetas
    public JLabel LblTitulo = new JLabel("Ventana Clientes");
    public JLabel LblID = new JLabel("ID:");
    public JLabel LblNombre = new JLabel("Nombre:");
    public JLabel LblApellido = new JLabel("Apellido:");
    public JLabel LblTelefono = new JLabel("Telefono:");
    public JLabel LblCorreo = new JLabel("Correo:");
    public JLabel LblRFC = new JLabel("RFC:");

    // Texto
    public JTextField TxtID = new JTextField();
    public JTextField TxtNombre = new JTextField();
    public JTextField TxtApellido = new JTextField();
    public JTextField TxtTelefono = new JTextField();
    public JTextField TxtCorreo = new JTextField();
    public JTextField TxtRFC = new JTextField();

    // Botones
    public JButton BtnGuardar = new JButton("Guardar");
    public JButton BtnBuscar = new JButton("Buscar");
    public JButton BtnEliminar = new JButton("Eliminar");
    public JButton BtnActualizar = new JButton("Actualizar");
    public JButton BtnSalir = new JButton("Salir");

    // Fondo
    ImageIcon Fondo = new ImageIcon(getClass().getResource("/imagenes/psyduck_productos.png"));
    JLabel lblFondo = new JLabel(Fondo);

    // Constructor
    public VistaClientes(JFrame parent, boolean modal) {
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
        BtnGuardar.setBounds(150, 250, 100, 40);
        BtnBuscar.setBounds(270, 250, 100, 40);
        BtnEliminar.setBounds(390, 250, 100, 40);
        BtnActualizar.setBounds(510, 250, 100, 40);
        BtnSalir.setBounds(630, 250, 100, 40);
    }
    private void etiquetas() {
        // Título
        LblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        LblTitulo.setBounds(250, 20, 300, 40);
        // Etiquetas
        LblID.setBounds(150, 80, 100, 30);  
        LblApellido.setBounds(320, 80, 100, 30);  
        LblTelefono.setBounds(510, 80, 100, 30); 
        LblNombre.setBounds(150, 120, 100, 30);
        LblCorreo.setBounds(150, 160, 100, 30);
        LblRFC.setBounds(150, 200, 100, 30);
        
    }
    private void camposTxt() {
        //Campos
        TxtID.setBounds(250, 80, 60, 30); 
        TxtApellido.setBounds(420, 80, 80, 30);   
        TxtTelefono.setBounds(610, 80, 60, 30);
        TxtNombre.setBounds(250, 120, 150, 30);
        TxtCorreo.setBounds(250, 160, 150, 30);
        TxtRFC.setBounds(250, 200, 300, 30);
    }
    private void AgregarComponentes() {
        //Etiquetas
        this.add(LblTitulo);
        this.add(LblID);
        this.add(TxtID);
        this.add(LblNombre);
        this.add(TxtNombre);
        this.add(LblApellido);
        this.add(TxtApellido);
        this.add(LblTelefono);
        this.add(TxtTelefono);
        this.add(LblRFC);
        this.add(TxtRFC);
        this.add(LblCorreo);
        this.add(TxtCorreo);
        
        //Botones
        this.add(BtnGuardar);
        this.add(BtnBuscar);
        this.add(BtnEliminar);
        this.add(BtnActualizar);
        this.add(BtnSalir);
    }

}
