package Controlador;

import Modelo.BD;
import Modelo.cons;
import Modelo.Operaciones;
import Modelo.CL_Producto;
import Modelo.func;
import Vista.Vista_MenuAdmin;
import Vista.Vista_Productos;
import Vista.Vista_Productos.Create;
import Vista.Vista_Productos.Read;
import Vista.Vista_Productos.Update;
import Vista.Vista_Productos.Delete;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author jp
 */
public class Con_Productos implements ActionListener {

    private final Vista_MenuAdmin admin;
    private final Vista_Productos productos;
    private Create create;
    private Read read;
    private Update update;
    private Delete delete;
    private String[] values;
    private final BD conexion;
    private final Operaciones operaciones;

    public Con_Productos(Vista_Productos productos, Vista_MenuAdmin admin) {
        this.productos = productos;
        this.admin = admin;
        this.create = productos.getCreate();
        this.read = productos.getRead();
        this.update = productos.getUpdate();
        this.delete = productos.getDelete();
        this.conexion = BD.getNodo();
        this.operaciones = new Operaciones(conexion);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        values = create.values();
        switch (e.getActionCommand()) {
            case "Atras" ->
                Atras();
            case "Cancelar" ->
                Cancelar(e.getSource());
            case "Buscar" ->
                Buscar(e.getSource());
            case "Agregar" ->
                Agregar();
            case "Mostrar" ->
                Buscar(e.getSource());
            case "Actualizar" ->
                Actualizar();
        }

    }

    public void Atras() {
        productos.dispose();
        admin.setVisible(true);
    }

    public void Cancelar(Object obj) {
        if (create.getJbtCancelar() == obj) {
            create.Empty();
        } else if (true) {

        }
    }

    private void Agregar() {
        if (create.isEmpty()) {
            return;
        }
        values[0] = func.getID(values[1], values[3], values[5]);
        CL_Producto p = new CL_Producto(values);
        operaciones.newProducto(p);
        cons.getMessage("El producto " + values[1] + " " + values[3],
                "\nha sido registrado con la clave: " + values[0],
                "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        create.Empty();
    }

    public void Buscar(Object obj) {
        if (read.getJbtConsultar() == obj) {
            read.getJtConsultas().setModel(operaciones.getTable("productos"));
        } else if (update.getJbtBuscar() == obj) {
            update.clear();
            int opc = update.getJcbMB().getSelectedIndex();
            String campo = update.getJcbMB().getItemAt(opc);
            String mb = update.getJtfMD().getText();
            CL_Producto producto = operaciones.getProducto("*", campo + " = '" + BD.IN(mb) + "'");
            if (producto != null && producto.isExists()) {
                update.setProducto(producto);
            } else {
                cons.getMessage("Este producto", "no existe", "Error", JOptionPane.WARNING_MESSAGE);
            }
            update.clearS();
        }
    }

    public void Actualizar() {
        int opc = JOptionPane.showConfirmDialog(null, "¿Seguro que desea hacer cambios en los campos?");
        if (opc == JOptionPane.YES_NO_OPTION) {
            operaciones.ActProducto(update.getProducto());
            cons.getMessage("Los campos", "se han actualizado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            update.clear();
        }
    }

    public void Borrar() {
    }

}
