package Controlador;

import Vista.Vista_Inventario;
import Vista.Vista_MenuAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jp
 */
public class Con_Inventario implements ActionListener {

    private Vista_MenuAdmin admin;
    private Vista_Inventario inventario;

    public Con_Inventario(Vista_MenuAdmin admin, Vista_Inventario inventario) {
        this.admin = admin;
        this.inventario = inventario;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Atras" ->
                atras();
        }
    }

    public void atras() {
        inventario.dispose();
        admin.setVisible(true);
    }

}
