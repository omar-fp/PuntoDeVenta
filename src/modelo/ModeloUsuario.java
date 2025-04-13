/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Omar Figueroa Perez
 */
public class ModeloUsuario {
    //Atributos
    String id_usuario,nombre_usuario,apellido_usuario,password_usuario,decripcion_usuario,rol_usuario;

    public ModeloUsuario(String id_usuario, String nombre_usuario, String apellido_usuario, String password_usuario, String decripcion_usuario, String rol_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.password_usuario = password_usuario;
        this.decripcion_usuario = decripcion_usuario;
        this.rol_usuario = rol_usuario;
    }

    public ModeloUsuario() {
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public String getPassword_usuario() {
        return password_usuario;
    }

    public void setPassword_usuario(String password_usuario) {
        this.password_usuario = password_usuario;
    }

    public String getDecripcion_usuario() {
        return decripcion_usuario;
    }

    public void setDecripcion_usuario(String decripcion_usuario) {
        this.decripcion_usuario = decripcion_usuario;
    }

    public String getRol_usuario() {
        return rol_usuario;
    }

    public void setRol_usuario(String rol_usuario) {
        this.rol_usuario = rol_usuario;
    }
    
}
