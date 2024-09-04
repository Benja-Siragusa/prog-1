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
    }

    public static void menu(int n) {
        switch (n) {
            case 1:
                
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;

            default:
                break;
        }
    }

    public static int opcion() {
        Object[] options = { "metros", "convertir a km", "convertir a cm", "convertir a mm", "salir" };
        int seleccion = JOptionPane.showOptionDialog(null, "seleccione una opvion", "opciones", 0,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        return seleccion;
    }

    public static int pedirNumero() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese su calificacion",
                "subida de calificaciones", JOptionPane.QUESTION_MESSAGE));
        return numero;
    }
}
