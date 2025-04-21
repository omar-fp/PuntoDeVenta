package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

/**
 *
 * @author Omar Figueroa Perez
 */


public class VistaProducto extends JFrame {
    
    // Etiquetas
    public JLabel lblTitulo = new JLabel("Gestión de Producto");
    public JLabel lblNombre = new JLabel("Nombre:");
    public JLabel lblPrecio = new JLabel("Precio:");
    public JLabel lblCantidad = new JLabel("Cantidad:");

    // Campos de texto
    public JTextField txtNombre = new JTextField();
    public JTextField txtPrecio = new JTextField();
    public JTextField txtCantidad = new JTextField();

    // Botones
    public JButton btnGuardar = new JButton("Guardar");
    public JButton btnEditar = new JButton("Editar");
    public JButton btnEliminar = new JButton("Eliminar");
    public JButton btnCancelar = new JButton("Cancelar");

    // Fondo (opcional, igual que en la pantalla principal)
    ImageIcon Fondo = new ImageIcon(getClass().getResource("/imagenes/fondo_psyduck.png"));
    JLabel lblFondo = new JLabel(Fondo);

    public VistaProducto() {
        configuracion();
        componentes();
    }

    private void configuracion() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(Fondo.getIconWidth(), Fondo.getIconHeight());
        this.setLocationRelativeTo(null);
        this.setTitle("Productos - Punto Fácil");
        this.setLayout(null);
        this.setResizable(false);
        this.setContentPane(lblFondo);
    }

    private void componentes() {
        // Título
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitulo.setBounds(250, 20, 300, 40);
        this.add(lblTitulo);

        // Etiquetas y campos
        lblNombre.setBounds(150, 100, 100, 30);
        txtNombre.setBounds(250, 100, 300, 30);
        
        lblPrecio.setBounds(150, 150, 100, 30);
        txtPrecio.setBounds(250, 150, 300, 30);
        
        lblCantidad.setBounds(150, 200, 100, 30);
        txtCantidad.setBounds(250, 200, 300, 30);

        this.add(lblNombre);
        this.add(txtNombre);
        this.add(lblPrecio);
        this.add(txtPrecio);
        this.add(lblCantidad);
        this.add(txtCantidad);

        // Botones
        btnGuardar.setBounds(150, 280, 100, 40);
        btnEditar.setBounds(270, 280, 100, 40);
        btnEliminar.setBounds(390, 280, 100, 40);
        btnCancelar.setBounds(510, 280, 100, 40);

        this.add(btnGuardar);
        this.add(btnEditar);
        this.add(btnEliminar);
        this.add(btnCancelar);
    }
}