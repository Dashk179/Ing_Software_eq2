package Modelo;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class cons {

    /**
     * Constantes de la tabla 'productos'
     */
    private static final String Productos[] = {
        "ID",
        "Clave",
        "Nombre",
        "Marca",
        "Contenido",
        "UDM",
        "Precio"
    };
    /**
     * Constantes de la tabla 'empleados'
     */
    private static final String Usuarios[] = {
        "ID",
        "Usuario",
        "Nombre",
        "A_paterno",
        "A_materno",
        "Edad",
        "Cargo",
        "Contra"
    };
    /**
     * Constantes de la tabla 'movimientos'
     */
    public static final String Movimientos[] = {
        "ID",
        "Dia",
        "Mes",
        "AÑo",
        "Hora",
        "MIn",
        "Seg",
        "Tipo",
        "Usuario"
    };

    /**
     * Constantes de los dias de la semana
     */
    private static final String Dias[] = {
        "Domingo",
        "Lunes",
        "Martes",
        "Miercoles",
        "Juves",
        "Viernes",
        "Sabado"
    };

    /**
     * Constantes de los meses del año
     */
    private static final String meses[] = {
        "Enero",
        "Febrero",
        "Marzo",
        "Abril",
        "Mayo",
        "Junio",
        "Julio",
        "Agosto",
        "Septiembre",
        "Octubre",
        "Noviembre",
        "Diciembre"
    };

    //tipos de movimientos
    private static final String Movimiento[] = {
        "Inicio de sesion",
        "Cierre de sesion",
        "Realizo una venta",
        "Hizo una alta",
        "Hizo una baja",
        "Hizo una modificacion",
        "Hizo una baja",
        "Hizo una baja",
        "Hizo una baja",
        "Hizo una baja",
        "Hizo una baja",
        "Hizo una baja",};

    private static final LineBorder OkBorder = new LineBorder(Color.black);

    private static final LineBorder BadBorder = new LineBorder(Color.red);

    public static String[] getProductos() {
        return Productos;
    }

    public static String[] getUsuarios() {
        return Usuarios;
    }

    public static String[] getMovimientos() {
        return Movimientos;
    }

    public static Border getOkBorder() {
        return OkBorder;
    }

    public static Border getBadBorder() {
        return BadBorder;
    }

    public static String getDay(int i) {
        return Dias[i - 1];
    }

    public static String getMes(int i) {
        return meses[i];
    }

    /**
     * @param i tipo de movimiento
     * @return el movimiento segun el index
     * <br> 0.-
     * <br> 0.-
     * <br> 0.-
     * <br> 0.-
     * <br> 0.-
     * <br> 0.-
     * <br> 0.-
     * <br> 0.-
     * <br> 0.-
     * <br> 0.-
     * <br> 0.-
     *
     */
    public static String getMovimiento(int i) {
        return Movimiento[i];
    }

    public static void getMessage(String obj, String txt, String title, int i) {
            JOptionPane.showMessageDialog(null, obj + " " + txt, title, i);
    }

}
