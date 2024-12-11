package unidades.tp_integrador.AO2_Siragusa_Flores.actividad_1.librerias;

import javax.swing.JOptionPane;

public class Egreso {

    public static void mostrarMensaje(String mensaje, String cTitulo) {
        JOptionPane.showMessageDialog(null, mensaje, cTitulo == null ? "Información" : cTitulo,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mostrarAdvertencia(String mensaje, String cTitulo) {
        JOptionPane.showMessageDialog(null, mensaje, cTitulo == null ? "Advertencia" : cTitulo,
                JOptionPane.WARNING_MESSAGE);
    }

    public static void mostrarError(String mensaje, String cTitulo) {
        JOptionPane.showMessageDialog(null, mensaje, cTitulo ==null ? "Error": cTitulo, JOptionPane.ERROR_MESSAGE);
    }

    public static int mostrarConfirmacion(String mensaje, String cTitulo) {
        return JOptionPane.showConfirmDialog(null, mensaje, cTitulo == null ? "Confirmación" : cTitulo,
                JOptionPane.YES_NO_OPTION);
    }
}