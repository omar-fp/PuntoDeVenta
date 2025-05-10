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
public class ModeloVenta {
    private String id_venta, id_cliente, id_usuario, sucursal, metodo_pago;
    private float total;

    public ModeloVenta(String id_venta, String id_cliente, String id_usuario, String sucursal, String metodo_pago, float total) {
        this.id_venta = id_venta;
        this.id_cliente = id_cliente;
        this.id_usuario = id_usuario;
        this.sucursal = sucursal;
        this.metodo_pago = metodo_pago;
        this.total = total;
    }

    public ModeloVenta() {
    }

    public String getId_venta() {
        return id_venta;
    }

    public void setId_venta(String id_venta) {
        this.id_venta = id_venta;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
}
