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
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Omar Figueroa Perez
 */


// public ModeloVenta(String id_venta, String id_cliente, String id_usuario, String sucursal, float total, LocalDate Fecha) {
public class ConsultasVenta extends Conexion{
    Connection Con = getConexion();
    
    public boolean insertar(ModeloVenta Modelo){
        try {
            PreparedStatement Ps;
            String SQL =
                    "INSERT INTO venta (id_venta, id_cliente, id_usuario, sucursal, total, fecha) VALUES (?,?,?,?,?,?)";
            Ps = Con.prepareCall(SQL);
            Ps.setString(1, Modelo.getId_venta());
            Ps.setString(2, Modelo.getId_cliente());
            Ps.setString(3, Modelo.getId_usuario());
            Ps.setString(4, Modelo.getSucursal());
            Ps.setFloat(5, Modelo.getTotal());
            Ps.setObject(6, Modelo.getFecha());
            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL: Insertar()\n "+e);
            return false;
        }
    }
    
    public boolean modificar(ModeloVenta Modelo){
    try {
        PreparedStatement Ps;
        String SQL =
            "UPDATE venta SET id_cliente=?, id_usuario=?, sucursal=?, total=?, fecha=? WHERE id_venta=?";
        Ps = Con.prepareCall(SQL);
        Ps.setString(1, Modelo.getId_cliente());
        Ps.setString(2, Modelo.getId_usuario());
        Ps.setString(3, Modelo.getSucursal());
        Ps.setFloat(4, Modelo.getTotal());
        Ps.setObject(5, Modelo.getFecha());  
        Ps.setString(6, Modelo.getId_venta());
        Ps.executeUpdate();
        return true;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error SQL: modificar()\n" + e);
        return false;
    }
}
    
    public boolean eliminar(ModeloVenta Modelo){
    try {
        PreparedStatement Ps;
        String SQL = "DELETE FROM venta WHERE id_venta=?";
        Ps = Con.prepareCall(SQL);
        Ps.setString(1, Modelo.getId_venta());
        Ps.executeUpdate();
        return true;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error SQL: eliminar()\n" + e);
        return false;
    }
}
    
    public boolean buscar(ModeloVenta Modelo){
    try {
        PreparedStatement Ps;
        String SQL = "SELECT * FROM venta WHERE id_venta=?";
        Ps = Con.prepareCall(SQL);
        Ps.setString(1, Modelo.getId_venta());
        ResultSet Rs = Ps.executeQuery();
        if (Rs.next()) {
            Modelo.setId_cliente(Rs.getString("id_cliente"));
            Modelo.setId_usuario(Rs.getString("id_usuario"));
            Modelo.setSucursal(Rs.getString("sucursal"));
            Modelo.setTotal(Rs.getFloat("total"));
            Modelo.setFecha(Rs.getObject("fecha", LocalDate.class)); 
            return true;
        }
        return false;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error SQL: buscar()\n" + e);
        return false;
    }
}
}
