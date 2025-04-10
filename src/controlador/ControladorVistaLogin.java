/*
Controlador de la Vista Login

Hola no quiero tupinche chuleta
 */
package controlador;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import vista.VistaLogin;

/**
 * @since 04/06/2025
 * @author Omar Figueroa Perez
 * @version 1.
 */
public class ControladorVistaLogin implements MouseListener, MouseMotionListener, FocusListener{
    VistaLogin VistaLogin;
    
    //Para que no se borre si se pone el mismo texto del campo
    boolean clicUser = true;
    boolean clicPass = true;
    
    
    public ControladorVistaLogin (VistaLogin VistaLogin) {
        this.VistaLogin = VistaLogin;
        oyentes();
        VistaLogin.setVisible(true);
    }
    
    private void oyentes() {
        VistaLogin.LblVerPassword.addMouseListener(this);
        VistaLogin.TxtPassword.addFocusListener(this);
        VistaLogin.TxtUsuario.addFocusListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {}

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
        VistaLogin.TxtPassword.setEchoChar('●'); // Ocultar contraseña
        VistaLogin.LblVerPassword.setIcon(VistaLogin.ImEyeC); 
        }
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}
    
    @Override
    public void focusGained(FocusEvent e) { //Esto si es robado
        if (e.getSource() == VistaLogin.TxtPassword) {
            String texto = String.valueOf(VistaLogin.TxtPassword.getPassword());
            
            if (clicPass && texto.equals("Contraseña")) {
                VistaLogin.TxtPassword.setText("");
                VistaLogin.TxtPassword.setEchoChar('●');
                clicPass = false;
            }
        }
        if (e.getSource() == VistaLogin.TxtUsuario) {
            String texto = String.valueOf(VistaLogin.TxtUsuario.getText());
            
            if (clicUser&& texto.equals("Usuario")) {
                VistaLogin.TxtUsuario.setText("");
                clicUser = false;
            }
        }
    }
    @Override
    public void focusLost(FocusEvent e) { //Esto tambien
        if (e.getSource() == VistaLogin.TxtPassword) {
            String texto = String.valueOf(VistaLogin.TxtPassword.getPassword());
            if (texto.isEmpty()) {
                VistaLogin.TxtPassword.setText("Contraseña");
                VistaLogin.TxtPassword.setEchoChar((char) 0);
                clicPass = true; 
            }
        }
        if (e.getSource() == VistaLogin.TxtUsuario) {
            String texto = VistaLogin.TxtUsuario.getText();
            if (texto.isEmpty()) {
                VistaLogin.TxtUsuario.setText("Usuario");
                clicUser = true; 
            }
        }
    }
}
