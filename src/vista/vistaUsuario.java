package vista;

import javax.swing.*;
import java.awt.*;

public class vistaUsuario extends JFrame {
    // Botones
    public JButton BtnGuardar = new JButton("Guardar");
    public JButton BtnActualizar = new JButton("Actualizar");
    public JButton BtnEliminar = new JButton("Eliminar");
    public JButton BtnBuscar = new JButton("Buscar");
    public JButton BtnSalir = new JButton("Salir");

    // Campos de texto
    public JTextField TxtId = new JTextField();
    public JTextField TxtNombre = new JTextField();
    public JTextField TxtApellido = new JTextField();
    public JTextField TxtDescripcion = new JTextField();
    public JTextField TxtRol = new JTextField();
    public JTextField TxtUsuario = new JTextField();
    public JPasswordField TxtPassword = new JPasswordField();

    // Iconos
    ImageIcon ImFondo = new ImageIcon(getClass().getResource("/imagenes/fondoUsuarios.jpg"));
    JLabel LblFondo = new JLabel(ImFondo);

    public vistaUsuario() {
        configuracion();
        agregarComponentes();
    }

    private void configuracion() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(ImFondo.getIconWidth(), ImFondo.getIconHeight());
        this.setLocationRelativeTo(null);
        this.setTitle("Gestión de Usuarios");
        this.setLayout(null);
        this.setResizable(false);
        this.setContentPane(LblFondo);
    }

    private void agregarComponentes() {
        // Campos
        TxtId.setBounds(150, 50, 200, 50);
        TxtId.setBorder(BorderFactory.createTitledBorder("ID Usuario"));
        this.add(TxtId);

        TxtNombre.setBounds(150, 100, 200, 50);
        TxtNombre.setBorder(BorderFactory.createTitledBorder("Nombre"));
        this.add(TxtNombre);

        TxtPassword.setBounds(150, 200, 200, 50);
        TxtPassword.setBorder(BorderFactory.createTitledBorder("Contraseña"));
        this.add(TxtPassword);

        TxtApellido.setBounds(400, 100, 200, 50);
        TxtApellido.setBorder(BorderFactory.createTitledBorder("Apellido"));
        this.add(TxtApellido);

        TxtDescripcion.setBounds(150, 150, 200, 50);
        TxtDescripcion.setBorder(BorderFactory.createTitledBorder("Descripcion"));
        this.add(TxtDescripcion);

        TxtRol.setBounds(400, 150, 200, 50);
        TxtRol.setBorder(BorderFactory.createTitledBorder("Rol de usuario"));
        this.add(TxtRol);

        // Botones
        BtnGuardar.setBounds(100, 260, 100, 30);
        this.add(BtnGuardar);

        BtnActualizar.setBounds(210, 260, 100, 30);
        this.add(BtnActualizar);

        BtnEliminar.setBounds(320, 260, 100, 30);
        this.add(BtnEliminar);

        BtnBuscar.setBounds(100, 300, 100, 30);
        this.add(BtnBuscar);

        BtnSalir.setBounds(210, 300, 100, 30);
        this.add(BtnSalir);
    }
}