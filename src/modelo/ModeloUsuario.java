package modelo;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import conexion.Conexion;
/**
 *
 * @author Omar Figueroa Perez
 */
public class ModeloUsuario {
    //Atributos
    String id_usuario,nombre_usuario,apellido_usuario,password_usuario,decripcion_usuario,rol_usuario;
    private final Conexion conexion = new Conexion();
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

    public boolean guardarUsuario() {
        String sql = "INSERT INTO usuarios (id_usuario, nombre_usuario, apellido_usuario, password_usuario, decripcion_usuario, rol_usuario) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, id_usuario);
            ps.setString(2, nombre_usuario);
            ps.setString(3, apellido_usuario);
            ps.setString(4, encriptarSHA256(password_usuario));
            ps.setString(5, decripcion_usuario);
            ps.setString(6, rol_usuario);

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String encriptarSHA256(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes("UTF-8"));

        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
