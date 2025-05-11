package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ModeloUsuario;
import vista.vistaUsuario;

public class ControladorVistaUsuario {
    private final vistaUsuario vista;

    public ControladorVistaUsuario(vistaUsuario vista) {
        this.vista = vista;
        this.vista.BtnGuardar.addActionListener(new GuardarListener());
    }

    class GuardarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ModeloUsuario usuario = new ModeloUsuario();
            usuario.setId_usuario(vista.TxtId.getText());
            usuario.setNombre_usuario(vista.TxtNombre.getText());
            usuario.setApellido_usuario(vista.TxtApellido.getText());
            usuario.setPassword_usuario(new String(vista.TxtPassword.getPassword()));
            usuario.setDecripcion_usuario(vista.TxtDescripcion.getText());
            usuario.setRol_usuario(vista.TxtRol.getText());

            if (usuario.guardarUsuario()) {
                JOptionPane.showMessageDialog(null, "Usuario guardado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar usuario.");
            }
        }
    }
}
