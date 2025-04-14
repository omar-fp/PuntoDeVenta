/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Omar Figueroa Perez
 */
public class ConsultasUsuario extends Conexion{
    Connection Con = getConexion();
    
    public boolean buscarLogin(ModeloUsuario Modelo) {
        try {
            PreparedStatement Ps;
            String SQL = "select * from usuarios where id_usuario = ? and password ?";
            Ps = Con.prepareCall(SQL);
            Ps.setString(1,Modelo.getId_usuario());
            Ps.setString(2,Modelo.getPassword_usuario());
            ResultSet Rs = Ps.executeQuery();
            if (Rs.next()) {
                Modelo.setNombre_usuario(Rs.getString("Nombre"));
                Modelo.setRol_usuario(Rs.getString("Rol"));
                return true;
            }
                return false;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error: "+e);
                return false;
            }
    }
}
