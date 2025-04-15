/*
Controlador de la Vista Login

Hola no quiero tupinche chuleta
 */
package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JOptionPane;
import modelo.ConsultasUsuario;
import modelo.ModeloUsuario;
import vista.VistaLogin;
import vista.VistaPantallaPrincipal;
/**
 * @since 04/06/2025
 * @author Omar Figueroa Perez
 * @version 1.
 */
public class ControladorVistaLogin implements MouseListener, MouseMotionListener{
    VistaLogin VistaLogin;
    ModeloUsuario ModeloUsuario;
    ConsultasUsuario ConsultasUsuario = new ConsultasUsuario();
    
    //Para que no se borre si se pone el mismo texto del campo
    boolean clicUser = true;
    boolean clicPass = true;
    
    
    public ControladorVistaLogin (VistaLogin VistaLogin, ModeloUsuario ModeloUsuario) {
        this.VistaLogin = VistaLogin;
        this.ModeloUsuario = ModeloUsuario;
        oyentes();
        VistaLogin.setVisible(true);
    }
    
    private void oyentes() {
        VistaLogin.LblVerPassword.addMouseListener(this);
    VistaLogin.TxtPassword.addMouseListener(this); 
    VistaLogin.TxtUsuario.addMouseListener(this);  
    VistaLogin.BtnLogin.addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == VistaLogin.BtnLogin) {
        buscarUsuarioPassWord();
    }

    if (e.getSource() == VistaLogin.TxtUsuario && clicUser) {
        if (VistaLogin.TxtUsuario.getText().equals("Usuario")) {
            VistaLogin.TxtUsuario.setText("");
            clicUser = false;
        }
    }

    if (e.getSource() == VistaLogin.TxtPassword && clicPass) {
        String texto = String.valueOf(VistaLogin.TxtPassword.getPassword());
        if (texto.equals("Contraseña")) {
            VistaLogin.TxtPassword.setText("");
            VistaLogin.TxtPassword.setEchoChar('\u2022');
            clicPass = false;
        }
    }
}

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == VistaLogin.LblVerPassword) { 
        VistaLogin.TxtPassword.setEchoChar((char) 0); // Mostrar contraseña
        VistaLogin.LblVerPassword.setIcon(VistaLogin.ImEyeA); 
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == VistaLogin.LblVerPassword) {
        VistaLogin.TxtPassword.setEchoChar('\u2022'); // Ocultar contraseña
        VistaLogin.LblVerPassword.setIcon(VistaLogin.ImEyeC); 
        }
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource()==VistaLogin.LblVerPassword) {
            VistaLogin.LblVerPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource()==VistaLogin.BtnLogin) {
            VistaLogin.BtnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}
    

    public boolean camposValidos() {
        if (VistaLogin.TxtUsuario.getText().isEmpty() || VistaLogin.TxtPassword.getPassword().length==0) {
            return false;
        }else {
            return true;
        }
    }
   private void llenarModeloConCampos(){
       ModeloUsuario.setId_usuario(VistaLogin.TxtUsuario.getText());
       ModeloUsuario.setPassword_usuario(new String(VistaLogin.TxtPassword.getPassword()));
       ModeloUsuario.setNombre_usuario("");
       ModeloUsuario.setRol_usuario("");
   }
   private void buscarUsuarioPassWord() {
       if (camposValidos()==true) {
           llenarModeloConCampos();
           if (ConsultasUsuario.buscarLogin(ModeloUsuario)==true) {
               JOptionPane.showMessageDialog(null, "Bienvenido: "+ModeloUsuario.getNombre_usuario(),
                                                    "Rol: "+ModeloUsuario.getRol_usuario(),1);
               
               VistaLogin.dispose();
               
               VistaPantallaPrincipal VistaPantallaPrincipal = new VistaPantallaPrincipal();
               ControladorVistaPantallaPrincipal ControladorVistaPantallaPrincipal = new
                   ControladorVistaPantallaPrincipal(VistaPantallaPrincipal);
           }else{
               JOptionPane.showMessageDialog(null, "Usuario o Password Incorrecta");
           }
           }else{
           JOptionPane.showMessageDialog(null, "Debes Colocar Texto en los campos Usuario y Password");
       }
   }
}
