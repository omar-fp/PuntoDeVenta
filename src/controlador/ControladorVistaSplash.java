
package controlador;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import vista.VistaLogin;
import vista.VistaSplash;

/**
 *
 * @author Omar Figueroa Perez
 */
public class ControladorVistaSplash implements MouseListener, MouseMotionListener, MouseWheelListener{
    VistaSplash VistaSplash;
    int x,y;

    public ControladorVistaSplash (VistaSplash VistaSplash) {
        //Agisna el objeto original a la variable de la clase de arriba
        this.VistaSplash = VistaSplash;
        oyentes();
        VistaSplash.setVisible(true); //pone visible el splash
        
        dormirMatarSplash(5);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    
    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource()== VistaSplash.LblSplash) {
            x = e.getX();
            y = e.getY();       
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == VistaSplash.LblSplash)
            VistaSplash.LblSplash.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.getSource()==VistaSplash.LblSplash) {
            VistaSplash.setLocation(VistaSplash.getLocation().x + e.getX()-x,
                                    VistaSplash.getLocation().y + e.getY()-y);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
    
    private void oyentes() {
        VistaSplash.LblSplash.addMouseListener(this);
        VistaSplash.LblSplash.addMouseMotionListener(this);
        VistaSplash.LblSplash.addMouseWheelListener(this);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getSource()==VistaSplash.LblSplash) 
            VistaSplash.dispose(); //Libera el JFrame de la memoria RAM
    }

    private void dormirMatarSplash(int i) {
        try {
            Thread.sleep(i*1000);
        } catch (InterruptedException ex) {
        }finally{
            VistaSplash.dispose();
            
            VistaLogin VistaLogin = new VistaLogin();
            ControladorVistaLogin ControladorVistaLogin = new ControladorVistaLogin(VistaLogin);
        }
    }
}
