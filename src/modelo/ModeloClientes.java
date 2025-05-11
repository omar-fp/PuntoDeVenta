/*
 * AUTOR: Fatima Jazmin Arellano Becerra
 */
package modelo;

/**
 *
 * @author L13 YOGA
 */
public class ModeloClientes {
    private String nombre_cliente, apellido_cliente, correo_cliente, rfc_cliente;
    private float id_cliente;
    private int telefono_cliente;

    public ModeloClientes(String nombre_cliente, String apellido_cliente, String correo_cliente, String rfc_cliente, float id_cliente, int telefono_cliente) {
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.correo_cliente = correo_cliente;
        this.rfc_cliente = rfc_cliente;
        this.id_cliente = id_cliente;
        this.telefono_cliente = telefono_cliente;
    }
    
    public ModeloClientes() {
    }

    public float getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(float id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido_cliente() {
        return apellido_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }

    public int getTelefono_cliente() {
        return telefono_cliente;
    }

    public void setTelefono_cliente(int telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public String getCorreo_cliente() {
        return correo_cliente;
    }

    public void setCorreo_cliente(String correo_cliente) {
        this.correo_cliente = correo_cliente;
    }

    public String getRfc_cliente() {
        return rfc_cliente;
    }

    public void setRfc_cliente(String rfc_cliente) {
        this.rfc_cliente = rfc_cliente;
    }
    
}
    