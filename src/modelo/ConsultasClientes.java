/*
Autor: Fatima Jazmin Arellano Becerra.
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
 * @author L13 YOGA
 */
public class ConsultasClientes extends Conexion{
    Connection Con = getConexion();
    
    public boolean insertar(ModeloClientes Modelo){
        try {
            PreparedStatement Ps;
            String SQL =
                    "insert into clientes (id_cliente, nombre_cliente, apellido_cliente, telefono_cliente, correo_cliente, rfc_cliente) values (?,?,?,?,?,?)";
            Ps = Con.prepareCall(SQL);
            Ps.setFloat(1, Modelo.getId_cliente());
            Ps.setString(2, Modelo.getNombre_cliente());
            Ps.setString(3, Modelo.getApellido_cliente());
            Ps.setInt(4, Modelo.getTelefono_cliente());
            Ps.setString(5, Modelo.getCorreo_cliente());
            Ps.setString(6, Modelo.getRfc_cliente());
            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL: Insertar()\n "+e);
            return false;
        }
    }
    
    public boolean modificar (ModeloClientes Modelo){
        try {
            PreparedStatement Ps;
            String SQL =
                    "UPDATE productos SET nombre_cliente=?, apellido_cliente=?, telefono_cliente=?, correo_cliente=?, rfc_cliente=? WHERE id_cliente=?";
            Ps = Con.prepareCall(SQL);
            Ps.setString(1, Modelo.getNombre_cliente());
            Ps.setString(2, Modelo.getApellido_cliente());
            Ps.setInt(3, Modelo.getTelefono_cliente());
            Ps.setString(4, Modelo.getCorreo_cliente());
            Ps.setString(5, Modelo.getRfc_cliente());      
            Ps.setFloat(6, Modelo.getId_cliente());
            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL: Modificar()\n "+e);
            return false;
        }
    }
    
    public boolean eliminar (ModeloClientes Modelo){
        try {
            PreparedStatement Ps;
            String SQL =
                    "delete from clientes where id_clientes=? ";
            Ps = Con.prepareCall(SQL);
            Ps.setFloat(1, Modelo.getId_cliente());
            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL: Eliminar()\n "+e);
            return false;
        }
    }
    
    public boolean buscar (ModeloClientes Modelo){
        try {
            PreparedStatement Ps;
            String SQL =
                   "SELECT * FROM productos WHERE id_cliente=?";
            Ps = Con.prepareCall(SQL);
            Ps.setFloat(1, Modelo.getId_cliente());
            ResultSet Rs = Ps.executeQuery();
            if (Rs.next()) {
                Modelo.setNombre_cliente(Rs.getString("nombre_cliente"));
                Modelo.setApellido_cliente(Rs.getString("apellido_cliente"));
                Modelo.setTelefono_cliente(Rs.getInt("telefono_cliente"));
                Modelo.setCorreo_cliente(Rs.getString("correo_cliente"));
                Modelo.setRfc_cliente(Rs.getString("rfc_cliente"));
                return true;
            }
            return false;  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL: Buscar()\n "+e);
            return false;
        }
    } 
}
