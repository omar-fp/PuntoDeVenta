/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * RikaSpark320
 */
public class VistaPantallaPrincipal extends JFrame{

    public VistaPantallaPrincipal() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1200, 1800);
        this.getContentPane().setBackground(new Color(199,150,242));
        this.setTitle("Pantalla principal");
        this.setLocationRelativeTo(null);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setResizable(false);
    }
    
}
