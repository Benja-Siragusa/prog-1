package unidad1.actProceso.actividad3;

import javax.swing.JOptionPane;

/*Desarrollar un programa en java que permita el ingreso de la calificación de un alumno en una evaluación y 
muestre el concepto de la misma. Utilice la librería Scanner para el ingreso de datos.
Se supone que la calificación puede ser una letra, en el rango de la ´A´ a la ´E´, con los siguientes conceptos:

‘A’ : ‘Excelente’

‘B’ : ‘Notable’

‘C’: ‘Aprobado’

‘D’ y ‘E’: ‘Suspendido’.

En caso de ingresar una letra fuera del rango. Mostrar Mensaje de error.

Nota: Utilizar la sentencia switch. */

public class act3_2 {
    public static void main(String[] args) {
        try {
            nota(pedirNota());
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public static char pedirNota() {
        String nota = JOptionPane
                .showInputDialog(null, "ingrese su calificacion", "subida de calificaciones",
                        JOptionPane.QUESTION_MESSAGE);

        if (nota == null || nota.isEmpty()) {
            throw new IllegalArgumentException("no introdujo ningun caracter");
        } else if (nota.length() > 1) {
            throw new IllegalArgumentException("introdujo mas de un caracter");
        }
        return nota.charAt(0);
    }

    public static void nota(char n) {
        switch (n) {
            case 'a', 'A':
                JOptionPane.showMessageDialog(null, "su nota es: Excelente", "calificacion", JOptionPane.PLAIN_MESSAGE);
                break;
            case 'b', 'B':
                JOptionPane.showMessageDialog(null, "su nota es: Notable", "calificacion", JOptionPane.PLAIN_MESSAGE);
                break;
            case 'c', 'C':
                JOptionPane.showMessageDialog(null, "su nota es: Aprobado", "calificacion", JOptionPane.PLAIN_MESSAGE);
                break;
            case 'd', 'D', 'e', 'E':
                JOptionPane.showMessageDialog(null, "su nota es: Suspendido", "calificacion",
                        JOptionPane.PLAIN_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(null, "su nota esta fuera de rango", "error", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
}
