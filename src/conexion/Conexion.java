/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Omar Figueroa Perez
 */
public class Conexion {
    private final String Servidor = "localhost";
    private final String Database = "PuntoDeVenta";
    private final String Usuario = "root";
    private final String Password = "";
    
    private final String Puerto = "3306";
    private final String Url = "jdbc:mysql://"+Servidor+":"+Puerto+"/"+Database;
    
    private static Connection Con;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Con = (Connection) DriverManager.getConnection(Url,Usuario,Password);
            System.out.println("Conexión establecida con la base de datos: "+Database);
            JOptionPane.showMessageDialog(null,"Conexion Establecida con la base de datos: " + Database);
        } catch (SQLException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
    }
    public Connection getConexion() {
        return Con;
    }
}
