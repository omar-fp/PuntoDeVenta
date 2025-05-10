/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Omar Figueroa Perez
 */
public class VistaBusquedaPorMetodoPago extends JDialog{
    JLabel LblNombre = new JLabel("Venta a Buscar:");
    public JTextField TxtNombre = new JTextField();
    public JButton BtnAceptar = new JButton("Aceptar");
    
    public JTable Tabla = new JTable();
    JScrollPane ScrollTable = new JScrollPane(Tabla);
    
    public VistaBusquedaPorMetodoPago(Frame owner, boolean modal) {
        super(owner, modal);
        configuracion();
        componentes();
    }

    private void configuracion() {
        this.setSize(400,300);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
    }
    
    private void componentes() {
        LblNombre.setBounds(10,15,100,40);
        TxtNombre.setBounds(130,15,200,40);
        ScrollTable.setBounds(20,70,378,130);
        BtnAceptar.setBounds(150,230,120,40);
        
        
        this.add(LblNombre);
        this.add(TxtNombre);
        this.add(ScrollTable);
        this.add(BtnAceptar);
    }

    
}
