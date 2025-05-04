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
            String SQL = "select * from usuarios where id_usuario = ? and password_usuario = ?";
            Ps = Con.prepareCall(SQL);
            Ps.setString(1,Modelo.getId_usuario());
            Ps.setString(2,Modelo.getPassword_usuario());
            ResultSet Rs = Ps.executeQuery();
            if (Rs.next()) {
                Modelo.setNombre_usuario(Rs.getString("nombre_usuario"));
                Modelo.setRol_usuario(Rs.getString("rol_usuario"));
                return true;
            }
                return false;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error: "+e);
                return false;

            }
    }
    public boolean registrarUsuario(ModeloUsuario modelo) {
        String sql = "INSERT INTO usuarios (id_usuario, nombre_usuario, apellido_usuario, password_usuario, decripcion_usuario, rol_usuario) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = Con.prepareStatement(sql)) {
            ps.setString(1, modelo.getId_usuario());
            ps.setString(2, modelo.getNombre_usuario());
            ps.setString(3, modelo.getApellido_usuario());
            ps.setString(4, (modelo.getPassword_usuario()));
            ps.setString(5, modelo.getDecripcion_usuario());
            ps.setString(6, modelo.getRol_usuario());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarUsuario(String id_usuario) {
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
        try (PreparedStatement ps = Con.prepareStatement(sql)) {
            ps.setString(1, id_usuario);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarUsuario(ModeloUsuario modelo) {
        String sql = "UPDATE usuarios SET nombre_usuario=?, apellido_usuario=?, password_usuario=?, decripcion_usuario=?, rol_usuario=? WHERE id_usuario=?";
        try (PreparedStatement ps = Con.prepareStatement(sql)) {
            ps.setString(1, modelo.getNombre_usuario());
            ps.setString(2, modelo.getApellido_usuario());
            ps.setString(3, (modelo.getPassword_usuario())); 
            ps.setString(4, modelo.getDecripcion_usuario());
            ps.setString(5, modelo.getRol_usuario());
            ps.setString(6, modelo.getId_usuario());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage());
            return false;
        }
    }
    public ModeloUsuario buscarUsuarioPorId(String id_usuario) {
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
        try (PreparedStatement ps = Con.prepareStatement(sql)) {
            ps.setString(1, id_usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ModeloUsuario modelo = new ModeloUsuario();
                modelo.setId_usuario(rs.getString("id_usuario"));
                modelo.setNombre_usuario(rs.getString("nombre_usuario"));
                modelo.setApellido_usuario(rs.getString("apellido_usuario"));
                modelo.setPassword_usuario(rs.getString("password_usuario"));
                modelo.setDecripcion_usuario(rs.getString("decripcion_usuario"));
                modelo.setRol_usuario(rs.getString("rol_usuario"));
                return modelo;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar: " + e.getMessage());
        }
        return null;
    }

}

