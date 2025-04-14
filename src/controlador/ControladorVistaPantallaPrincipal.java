/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import vista.VistaPantallaPrincipal;
/**
 *
 * @author L13 YOGA
 */
public class ControladorVistaPantallaPrincipal {
    VistaPantallaPrincipal VistaPantallaPrincipal;
    
    public ControladorVistaPantallaPrincipal(VistaPantallaPrincipal VistaPantallaPrincipal){
        this.VistaPantallaPrincipal = VistaPantallaPrincipal;
        this.VistaPantallaPrincipal.setVisible(true);
    }
}
