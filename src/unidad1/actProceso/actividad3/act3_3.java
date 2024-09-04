package unidad1.actProceso.actividad3;

import javax.swing.JOptionPane;
/*	Crear un programa en Java que permita ingresar un Número por teclado, convierta y muestre un valor 
ingresado en metros a Km, centímetros y milímetros. Utilice Menú de tal forma que puedan consultarse las 
distintas opciones:
    - Mostrar valor ingresado en metros.
    - Convertir a Kilómetros (Km)
    - Convertir a centímetros (cm)
    - Convertir a milímetros (mm)
    - salir
Utilice la librería JOptionPane. */


public class act3_3 {
    public static void main(String[] args) {
        try {
            double n = pedirNumero();
            menu(opcion(), n);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "el programa solo acepta numeros", "error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void menu(int n, double a) {
        switch (n) {
            case 0:
                JOptionPane.showMessageDialog(null, "la medida ingresada es de " + a + "m", "medida en metros",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            case 1:
                JOptionPane.showMessageDialog(null,
                        "la medida en metros ingresada convertida a kilometros es de " + a / 1000 + "km",
                        "medida en kilometros", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(null,
                        "la medida en metros ingresada convertida a centimetros es de " + a * 100 + "cm",
                        "medida en centimetros", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(null,
                        "la medida en metros ingresada convertida a milimetros es de " + a * 1000 + "mm",
                        "medida en centimetros", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 4:
                break;
        }
    }

    public static int opcion() {
        Object[] options = { "metros", "convertir a km", "convertir a cm", "convertir a mm", "salir" };
        int seleccion = JOptionPane.showOptionDialog(null, "seleccione una opcion", "opciones", 0,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        return seleccion;
    }

    public static double pedirNumero() {

        double numero = Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese una medida en metros",
                "pedir medida", JOptionPane.QUESTION_MESSAGE));

        return numero;

    }
}
