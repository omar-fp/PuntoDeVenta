package principal;

import controlador.ControladorVistaSplash;
import vista.VistaSplash;

/**
 * @since 04/06/2025
 * @author Omar Figueroa Perez
 * @version 1.
 */
public class AppPOS {
    public static void main(String[] args) {
        VistaSplash VistaSplash = new VistaSplash();
        ControladorVistaSplash controladorSplash = new ControladorVistaSplash(VistaSplash);
    }
}
