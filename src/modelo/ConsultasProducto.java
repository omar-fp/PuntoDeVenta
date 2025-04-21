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
public class ConsultasProducto extends Conexion{
    Connection Con = getConexion();
    
    public boolean insertar(ModeloProducto Modelo){
        try {
            PreparedStatement Ps;
            String SQL =
                    "insert into productos (id_producto, nombre_producto, categoria_producto, precio_producto, stock_producto, descripcion_producto) values (?,?,?,?,?,?)";
            Ps = Con.prepareCall(SQL);
            Ps.setString(1, Modelo.getId_producto());
            Ps.setString(2, Modelo.getNombre_producto());
            Ps.setString(3, Modelo.getCategoria_producto());
            Ps.setFloat(4, Modelo.getPrecio_producto());
            Ps.setInt(5, Modelo.getStock_producto());
            Ps.setString(6, Modelo.getDescripcion_producto());
            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL: Insertar()\n "+e);
            return false;
        }
    }
    
    public boolean modificar (ModeloProducto Modelo){
        try {
            PreparedStatement Ps;
            String SQL =
                    "update productos set nombre_producto=?, categoria_producto=?, descripcion_producto=?, precio_producto=?, stock_producto=? where id_producto=?, ";
            Ps = Con.prepareCall(SQL);
            Ps.setString(1, Modelo.getNombre_producto());
            Ps.setString(2, Modelo.getCategoria_producto());
            Ps.setFloat(3, Modelo.getPrecio_producto());
            Ps.setInt(4, Modelo.getStock_producto());
            Ps.setString(5, Modelo.getDescripcion_producto());
            Ps.setString(6, Modelo.getId_producto());
            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL: Modificar()\n "+e);
            return false;
        }
    }
    
    public boolean eliminar (ModeloProducto Modelo){
        try {
            PreparedStatement Ps;
            String SQL =
                    "delete from productos where id_producto=? ";
            Ps = Con.prepareCall(SQL);
            Ps.setString(1, Modelo.getId_producto());
            Ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL: Eliminar()\n "+e);
            return false;
        }
    }
    
    public boolean buscar (ModeloProducto Modelo){
        try {
            PreparedStatement Ps;
            String SQL =
                    "SELECT * FROM productos where = id_producto=?";
            Ps = Con.prepareCall(SQL);
            Ps.setString(1, Modelo.getId_producto());
            ResultSet Rs = Ps.executeQuery();
            if (Rs.next()) {
                Modelo.setNombre_producto(Rs.getString("nombre_producto")); //Puse esto, pero a lo mejor jala sin el "_producto"
                Modelo.setCategoria_producto(Rs.getString("categoria_producto"));
                Modelo.setPrecio_producto(Rs.getFloat("precio_producto"));
                Modelo.setStock_producto(Rs.getInt("stock_producto"));
                Modelo.setDescripcion_producto(Rs.getString("descripcion_producto"));
                return true;
            }
            return false;  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL: Buscar()\n "+e);
            return false;
        }
    }
}
