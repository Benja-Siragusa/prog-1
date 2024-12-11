package unidades.tp_integrador.AO2_Siragusa_Flores.actividad_1.librerias;

import javax.swing.JOptionPane;

public class Ingreso{
    private static String cError="Error de Dato";


    public static int pedirEntero(String cMensaje, String cTitulo) {
        int numero = 0;
        boolean valido = false;
        do {
            try {
                String input = JOptionPane.showInputDialog(null, cMensaje,cTitulo,1);
                numero = Integer.parseInt(input);
                valido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número entero válido.",cError,0);
            }
        } while (!valido);
        return numero;
    }

    public static double pedirDouble(String cMensaje, String cTitulo) {
        double numero = 0;
        boolean valido = false;
        do {
            try {
                String input = JOptionPane.showInputDialog(null, cMensaje,cTitulo,1);
                numero = Double.parseDouble(input);
                valido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número decimal válido.",cError,0);
            }
        } while (!valido);
        return numero;
    }

    public static float pedirFloat(String cMensaje, String cTitulo) {
        float numero = 0;
        boolean valido = false;
        do {
            try {
                String input = JOptionPane.showInputDialog(null, cMensaje,cTitulo,1);
                numero = Float.parseFloat(input);
                valido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número decimal válido.",cError,0);
            }
        } while (!valido);
        return numero;
    }

    public static boolean pedirBoolean(String cTitulo) {
        boolean valor = false;
        boolean valido = false;
        do {
            try {
                String input = JOptionPane.showInputDialog(null, "Ingrese 'true' para si y 'false' para no:",cTitulo,1);
                valor = Boolean.parseBoolean(input);
                valido = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar 'true' o 'false'.",cError,0);
            }
        } while (!valido);
        return valor;
    }

    public static char pedirChar(String cMensaje, String cTitulo) {
        char caracter = '\0';
        boolean valido = false;
        do {
            try {
                String input = JOptionPane.showInputDialog(null, cMensaje ,cTitulo,1);
                if (input.length() != 1) {
                    throw new Exception("Debe ingresar un solo carácter.");
                }
                caracter = input.charAt(0);
                valido = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(),cError,0);
            }
        } while (!valido);
        return caracter;
    }

    public static String pedirString(String cMensaje, String cTitulo) {
        String cadena = "";
        boolean valido = false;
        do {
            try {
                cadena = JOptionPane.showInputDialog(null, cMensaje,cTitulo,1);
                if (cadena == null || cadena.isEmpty()) {
                    throw new Exception("La cadena no puede estar vacía.");
                }
                valido = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(),cError,0);
            }
        } while (!valido);
        return cadena;
    }

}