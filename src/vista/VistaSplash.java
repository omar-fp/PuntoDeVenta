package vista;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Omar Figueroa Perez
 */
public class VistaSplash extends JFrame{
    //Convertir nuestra imagen en objeto
    ImageIcon ImSplash = new ImageIcon(getClass().getResource("/imagenes/psyduck-sinfondo.gif"));
    //Esta etiqueta es la que se agregará al JFrame, con la imanen neko arc incrustada
    public JLabel LblSplash = new JLabel(ImSplash);
    
    public VistaSplash(){
        configuracion();
        agregarComponentes();
    }

    private void configuracion() {
        //No ponemos EXIT_ON_CLOSE porque se cierra la aplicacion
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //Definimos las medidas del tamaño respecto a la imagen
        this.setSize(ImSplash.getIconWidth(),ImSplash.getIconHeight());
        this.setLocationRelativeTo(null); //Lo centramos en la pantalla
        
        //Quitar el decorado de la ventana (botones)
        this.setUndecorated(true);
        //Quitar Fondo del JFrame
        this.setBackground(new Color(0,0,0,0));
        this.setAlwaysOnTop(true);
    
    }
    private void agregarComponentes() {
        this.add(LblSplash);
    }
}