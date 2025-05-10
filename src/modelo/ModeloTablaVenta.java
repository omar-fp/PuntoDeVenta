/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Omar Figueroa Perez
 */
public class ModeloTablaVenta {
    DefaultTableModel ModeloTabla = new DefaultTableModel();
    
    public ModeloTablaVenta(){
        ModeloTabla.addColumn("id_venta");
        ModeloTabla.addColumn("id_cliente");
        ModeloTabla.addColumn("id_usuario");
        ModeloTabla.addColumn("sucursal");
        ModeloTabla.addColumn("total");
        ModeloTabla.addColumn("metodo_pago");
    }
    
    public DefaultTableModel getModeloTabla(){
        return ModeloTabla;
    }
    
    public void setModeloTabla(DefaultTableModel ModeloTabla) {
        this.ModeloTabla = ModeloTabla;
    }
}
