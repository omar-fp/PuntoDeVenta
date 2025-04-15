/*
Vista Login
 */
package vista;
//Mensaje de ejemplo
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @since 04/06/2025
 * @author Omar Figueroa Perez
 * @version 1.
 */
public class VistaLogin extends JFrame {
    //Botones
    public JButton BtnLogin = new JButton("Login");
    JCheckBox ChkRecordar = new JCheckBox();
    //Textos
    public JTextField TxtUsuario = new JTextField();
    public JPasswordField TxtPassword = new JPasswordField();
    JLabel LblRememberMe = new JLabel("Remember Me");
    //Iconos
    public JLabel LblUsuario = new JLabel();
    public JLabel LblPassword = new JLabel();
    public JLabel LblVerPassword = new JLabel();
    
    
    //Convertir nuestra imagen en objeto
    ImageIcon ImFondo = new ImageIcon(getClass().getResource("/imagenes/example.jpg"));
    JLabel LblFondo = new JLabel(ImFondo);
    ImageIcon ImUsuario = new ImageIcon(getClass().getResource("/imagenes/usuario.png"));
    ImageIcon ImPassword = new ImageIcon(getClass().getResource("/imagenes/contra.png"));
    public ImageIcon ImEyeC = new ImageIcon(getClass().getResource("/imagenes/ojoCerrado.png"));
    public ImageIcon ImEyeA = new ImageIcon(getClass().getResource("/imagenes/ojoAbierto.png"));
    
    
    
    public VistaLogin(){
        configuracion();
        iconos();
        botones();
        texto();
    }

    public void configuracion() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(ImFondo.getIconWidth(),ImFondo.getIconHeight());
        //this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setTitle("Punto Fácil");
        this.setLayout(null);
        this.setResizable(false);
        this.setContentPane(LblFondo);
    }
    
    private void botones() {
        //Boton Login
        this.add(BtnLogin);
        BtnLogin.setBounds(350, 340, 100, 40);
        //Texto Remember Me
        
        //Boton CheckBox
        this.add(ChkRecordar);
        ChkRecordar.setBounds(320, 340, 20, 20);
    }
    
    private void texto() {
        //Ingresar Usuario
        TxtUsuario.setBounds(325, 200, 150, 40);
        TxtUsuario.setText("Usuario");
        this.add(TxtUsuario);   
        
        //Texto recuerdame
        LblRememberMe.setBounds(230, 335, 117, 30);
        this.add(LblRememberMe);
        
        //Ingresar Contraseña
        TxtPassword.setBounds(325, 285, 150, 40);
        TxtPassword.setText("Contraseña"); 
        TxtPassword.setEchoChar((char) 0);
        this.add(TxtPassword);
    }

    private void iconos() {
        //Imagen de Usuario
        LblUsuario.setIcon(ImUsuario);
        LblUsuario.setBounds(250, 185, 64, 64);
        this.add(LblUsuario);
        //Imagen de Contraseña
        LblPassword.setIcon(ImPassword);
        LblPassword.setBounds(250, 260, 64, 64);
        this.add(LblPassword);
        //Imagen de Revelar Contraseña
        LblVerPassword.setIcon(ImEyeC);
        LblVerPassword.setBounds(480, 290, 16, 32);
        this.add(LblVerPassword);
    }
}
