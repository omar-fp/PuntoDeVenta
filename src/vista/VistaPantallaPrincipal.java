/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * RikaSpark320
 */
public class VistaPantallaPrincipal extends JFrame{

    public VistaPantallaPrincipal() {
        setTitle("PuntoFácil");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // título y usuario
        JPanel panelSuperior = new JPanel(new BorderLayout());
        JLabel titulo = new JLabel("PuntoFácil");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 50));
        panelSuperior.add(titulo, BorderLayout.WEST);
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 10));

        JPanel panelUsuario = new JPanel();
        panelUsuario.add(new JLabel("Usuario:"));
        JTextField campoUsuario = new JTextField(15);
        campoUsuario.setEnabled(false);
        panelUsuario.add(campoUsuario);
        panelSuperior.add(panelUsuario, BorderLayout.EAST);
        add(panelSuperior, BorderLayout.NORTH);

        //botones
        JPanel panelBotones = new JPanel(new GridLayout(4, 2, 15, 15));
            panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

            Dimension tamBoton = new Dimension(300, 100); 

            String[] textos = {
                "Registrar Venta", "Facturación",
                "Inventario", "Reportes",
                "Registro de Producto", "Respaldo de datos", "Configuración General"
            };

            for (String texto : textos) {
                JButton boton = new JButton(texto);
                boton.setFont(new Font("SansSerif", Font.PLAIN, 18));
                boton.setPreferredSize(tamBoton);
                //para que se centren los botones
                JPanel contenedor = new JPanel(new FlowLayout(FlowLayout.CENTER));
                contenedor.add(boton);
                panelBotones.add(contenedor);
            }

        add(panelBotones, BorderLayout.CENTER);
        //boton de vuelta
        JPanel panelSalir = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton botonSalir = new JButton("\u21B6"); 
        panelSalir.add(botonSalir);
        add(panelSalir, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VistaPantallaPrincipal::new);
    }
    
}
