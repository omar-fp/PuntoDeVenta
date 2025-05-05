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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Omar Figueroa Perez
 */

public class ConsultasVenta extends Conexion{
    Connection Con = getConexion();
    
    public boolean insertar(ModeloVenta Modelo){
        try {
            PreparedStatement Ps;
            String SQL =
                    "INSERT INTO ventas (id_venta, id_cliente, id_usuario, sucursal, metodo_pago, total) VALUES (?,?,?,?,?,?)";
            Ps = Con.prepareCall(SQL);
            Ps.setString(1, Modelo.getId_venta());
            Ps.setString(2, Modelo.getId_cliente());
            Ps.setString(3, Modelo.getId_usuario());
            Ps.setString(4, Modelo.getSucursal());
            Ps.setString(5, Modelo.getMetodo_pago());
            Ps.setFloat(6, Modelo.getTotal());
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
            "UPDATE ventas SET id_cliente=?, id_usuario=?, sucursal=?, total=?, metodo_pago=? WHERE id_venta=?";
        Ps = Con.prepareCall(SQL);
        Ps.setString(1, Modelo.getId_cliente());
        Ps.setString(2, Modelo.getId_usuario());
        Ps.setString(3, Modelo.getSucursal());
        Ps.setFloat(4, Modelo.getTotal());
        Ps.setString(5, Modelo.getMetodo_pago());  
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
        String SQL = "DELETE FROM ventas WHERE id_venta=?";
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
        String SQL = "SELECT * FROM ventas WHERE id_venta=?";
        Ps = Con.prepareCall(SQL);
        Ps.setString(1, Modelo.getId_venta());
        ResultSet Rs = Ps.executeQuery();
        if (Rs.next()) {
            Modelo.setId_cliente(Rs.getString("id_cliente"));
            Modelo.setId_usuario(Rs.getString("id_usuario"));
            Modelo.setSucursal(Rs.getString("sucursal"));
            Modelo.setTotal(Rs.getFloat("total"));
            Modelo.setMetodo_pago(Rs.getString("metodo_pago")); 
            return true;
        }
        return false;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error SQL: buscar()\n" + e);
        return false;
    }
    }
    
    public boolean buscarTodasLasVentas (DefaultTableModel Modelo) {
        try {
            PreparedStatement Ps;
            String SQL = "SELECT * FROM ventas ORDER BY metodo_pago";
            Ps = Con.prepareCall(SQL);
            ResultSet Rs = Ps.executeQuery();
            int numeroDeCampos = Rs.getMetaData().getColumnCount();
            while (Rs.next()) {
                Object Fila[] = new Object[numeroDeCampos];
                Fila[0] = Rs.getString("id_venta");
                Fila[1] = Rs.getString("id_cliente");
                Fila[2] = Rs.getString("id_usuario");
                Fila[3] = Rs.getString("sucursal");
                Fila[4] = Rs.getString("total");
                Fila[5] = Rs.getString("metodo_pago");
                
                Modelo.addRow(Fila);
            }
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: buscarTodasLasVentas()\n "+e);
            return false;
        }
    }
    
    public boolean buscarFrase(JTextField TxtConsultar, DefaultTableModel ModeloTabla) {
        try {
            PreparedStatement Ps;
            String SQL = "SELECT * FROM ventas WHERE metodo_pago LIKE '%"+
                    TxtConsultar.getText()+"%'";
            Ps = Con.prepareCall(SQL);
            ResultSet Rs = Ps.executeQuery();
            int numeroDeCampos = Ps.getMetaData().getColumnCount();
            ModeloTabla.setRowCount(0);
            while (Rs.next()) {
                Object Fila[] = new Object[numeroDeCampos];
                Fila[0] = Rs.getString("id_venta"+"");
                Fila[1] = Rs.getString("id_cliente");
                Fila[2] = Rs.getString("id_usuario");
                Fila[3] = Rs.getString("sucursal");
                Fila[4] = Rs.getString("total");
                Fila[5] = Rs.getString("metodo_pago");
                
                ModeloTabla.addRow(Fila);
            }
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: buscarFrase()\n "+e);
            return false;
        }
    }
}
