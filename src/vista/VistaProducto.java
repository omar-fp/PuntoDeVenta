package vista;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class VistaProducto extends JDialog {

    // Etiquetas
    public JLabel LblTitulo = new JLabel("Ventana Productos");
    public JLabel LblCodigo = new JLabel("Código:");
    public JLabel LblNombre = new JLabel("Nombre:");
    public JLabel LblPrecio = new JLabel("Precio:");
    public JLabel LblCategoria = new JLabel("Categoría:");
    public JLabel LblDescripcion = new JLabel("Descripción:");
    public JLabel LblCantidad = new JLabel("Cantidad:");

    // Texto
    public JTextField TxtCodigo = new JTextField();
    public JTextField TxtNombre = new JTextField();
    public JTextField TxtPrecio = new JTextField();
    public JTextField TxtCantidad = new JTextField();
    public JTextField TxtCategoria = new JTextField();
    public JTextField TxtDescripcion = new JTextField();

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
    public VistaProducto(JFrame parent, boolean modal) {
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
        LblCodigo.setBounds(150, 80, 100, 30);  
        LblPrecio.setBounds(320, 80, 100, 30);  
        LblCantidad.setBounds(510, 80, 100, 30); 
        LblNombre.setBounds(150, 120, 100, 30);
        LblCategoria.setBounds(150, 160, 100, 30);
        LblDescripcion.setBounds(150, 200, 100, 30);
        
    }
    private void camposTxt() {
        //Campos
        TxtCodigo.setBounds(250, 80, 60, 30); 
        TxtPrecio.setBounds(420, 80, 80, 30);   
        TxtCantidad.setBounds(610, 80, 60, 30);
        TxtNombre.setBounds(250, 120, 150, 30);
        TxtCategoria.setBounds(250, 160, 150, 30);
        TxtDescripcion.setBounds(250, 200, 300, 30);
    }
    private void AgregarComponentes() {
        //Etiquetas
        this.add(LblTitulo);
        this.add(LblCodigo);
        this.add(TxtCodigo);
        this.add(LblNombre);
        this.add(TxtNombre);
        this.add(LblPrecio);
        this.add(TxtPrecio);
        this.add(LblCategoria);
        this.add(TxtCategoria);
        this.add(LblDescripcion);
        this.add(TxtDescripcion);
        this.add(LblCantidad);
        this.add(TxtCantidad);
        
        //Botones
        this.add(BtnGuardar);
        this.add(BtnBuscar);
        this.add(BtnEliminar);
        this.add(BtnActualizar);
        this.add(BtnSalir);
    }
}