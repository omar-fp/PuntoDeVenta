/*
 * Autor: Fatima Jazmin Arellano Becerra
 */
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.ConsultasClientes;
import modelo.ModeloClientes;
import vista.VistaClientes;

public class ControladorVistaClientes implements MouseListener {
    private ModeloClientes modeloClientes;
    private VistaClientes vistaClientes;
    private ConsultasClientes consultasClientes = new ConsultasClientes();

    public ControladorVistaClientes(ModeloClientes modeloClientes, VistaClientes vistaClientes) {
        this.modeloClientes = modeloClientes;
        this.vistaClientes = vistaClientes;
        oyentesVista();
        vistaClientes.setVisible(true);
    }

    private void oyentesVista() {
        vistaClientes.BtnGuardar.addMouseListener(this);
        vistaClientes.BtnActualizar.addMouseListener(this);
        vistaClientes.BtnEliminar.addMouseListener(this);
        vistaClientes.BtnBuscar.addMouseListener(this);
        vistaClientes.BtnSalir.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vistaClientes.BtnGuardar) {
            guardar();
        } else if (e.getSource() == vistaClientes.BtnActualizar) {
            modificar();
        } else if (e.getSource() == vistaClientes.BtnEliminar) {
            eliminar();
        } else if (e.getSource() == vistaClientes.BtnBuscar) {
            buscar();
        } else if (e.getSource() == vistaClientes.BtnSalir) {
            salir();
        }
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}

    private void llenarModeloConVista() {
        modeloClientes.setId_cliente(Float.parseFloat(vistaClientes.TxtID.getText()));
        modeloClientes.setNombre_cliente(vistaClientes.TxtNombre.getText());
        modeloClientes.setApellido_cliente(vistaClientes.TxtApellido.getText());
        modeloClientes.setTelefono_cliente(Integer.parseInt(vistaClientes.TxtTelefono.getText()));
        modeloClientes.setCorreo_cliente(vistaClientes.TxtCorreo.getText());
        modeloClientes.setRfc_cliente(vistaClientes.TxtRFC.getText());
    }

    private void llenarVistaConModelo() {
        vistaClientes.TxtID.setText(String.valueOf(modeloClientes.getId_cliente()));
        vistaClientes.TxtNombre.setText(modeloClientes.getNombre_cliente());
        vistaClientes.TxtApellido.setText(modeloClientes.getApellido_cliente());
        vistaClientes.TxtTelefono.setText(String.valueOf(modeloClientes.getTelefono_cliente()));
        vistaClientes.TxtCorreo.setText(modeloClientes.getCorreo_cliente());
        vistaClientes.TxtRFC.setText(modeloClientes.getRfc_cliente());
    }

    private void limpiarCampos() {
        vistaClientes.TxtID.setText("");
        vistaClientes.TxtNombre.setText("");
        vistaClientes.TxtApellido.setText("");
        vistaClientes.TxtTelefono.setText("");
        vistaClientes.TxtCorreo.setText("");
        vistaClientes.TxtRFC.setText("");
    }

    private boolean validarCampoId() {
        return !vistaClientes.TxtID.getText().isEmpty();
    }

    private boolean validarTodosLosCampos() {
        return !vistaClientes.TxtID.getText().isEmpty() &&
               !vistaClientes.TxtNombre.getText().isEmpty() &&
               !vistaClientes.TxtApellido.getText().isEmpty() &&
               !vistaClientes.TxtTelefono.getText().isEmpty() &&
               !vistaClientes.TxtCorreo.getText().isEmpty() &&
               !vistaClientes.TxtRFC.getText().isEmpty();
    }

    private void guardar() {
        if (validarTodosLosCampos()) {
            modeloClientes.setId_cliente(Float.parseFloat(vistaClientes.TxtID.getText()));
            if (consultasClientes.buscar(modeloClientes)) {
                JOptionPane.showMessageDialog(vistaClientes, "Este cliente ya existe");
            } else {
                llenarModeloConVista();
                if (consultasClientes.insertar(modeloClientes)) {
                    JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar el registro");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos");
        }
    }

    private void modificar() {
        if (validarTodosLosCampos()) {
            llenarModeloConVista();
            ModeloClientes clienteTemporal = new ModeloClientes();
            clienteTemporal.setId_cliente(modeloClientes.getId_cliente());

            if (!consultasClientes.buscar(clienteTemporal)) {
                JOptionPane.showMessageDialog(vistaClientes, "Este cliente no existe");
            } else {
                if (consultasClientes.modificar(modeloClientes)) {
                    JOptionPane.showMessageDialog(vistaClientes, "Registro modificado correctamente");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar el registro");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Los campos no deben estar vacíos");
        }
    }

    private void eliminar() {
        if (validarCampoId()) {
            modeloClientes.setId_cliente(Float.parseFloat(vistaClientes.TxtID.getText()));
            if (!consultasClientes.buscar(modeloClientes)) {
                JOptionPane.showMessageDialog(vistaClientes, "Este cliente no existe");
            } else {
                if (consultasClientes.eliminar(modeloClientes)) {
                    JOptionPane.showMessageDialog(vistaClientes, "Registro eliminado correctamente");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(vistaClientes, "Error al eliminar el cliente");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "El campo de código no debe estar vacío");
        }
    }

    private void buscar() {
        if (validarCampoId()) {
            modeloClientes.setId_cliente(Float.parseFloat(vistaClientes.TxtID.getText()));
            if (consultasClientes.buscar(modeloClientes)) {
                llenarVistaConModelo();
            } else {
                JOptionPane.showMessageDialog(vistaClientes, "Registro no existe");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El campo de código no debe estar vacío");
        }
    }

    private void salir() {
        int opc = JOptionPane.showConfirmDialog(vistaClientes, "¿Quieres salir del módulo de clientes?", "Alerta", JOptionPane.YES_NO_OPTION);
        if (opc == JOptionPane.YES_OPTION) {
            vistaClientes.dispose();
        }
    }
}
