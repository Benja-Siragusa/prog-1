package unidades.unidad1.actProceso.actividad4;

/*Diseñar un programa en Java que permita al usuario determinar la docena correspondiente a un número 
obtenido en una jugada de ruleta (del 0 al 36) y contar las veces de ocurrencias.
El algoritmo debe ofrecer un menú con las siguientes opciones:

Ingrese un Número (manual): El usuario ingresa un número entre 0 y 36 (Validar que los números 
ingresados estén en ese rango)
Generar un número Aleatorio: Utilizar la librería correspondiente.
Estadísticas: Mostrar las ocurrencias en ese momento de acuerdo a la siguiente tabla
Primera docena: 1 a 12
Segunda docena: 13 a 24
Tercera docena: 25 a 36
Número 0: El número 0 no pertenece a ninguna docena
Salir: Finaliza la ejecución del programa.
El programa debe repetir el menú hasta que el usuario decida salir.
Al finalizar mostrar la estadística final, obtener y mostrar la docena con más ocurrencias.
Requerimientos:

Validar que el número ingresado esté dentro del rango permitido, opciones 1 y 2 (0 a 36).
Mostrar mensajes claros y adecuados al usuario para cada una de las opciones.
Debe Utilizar métodos para cada operatoria. */

import javax.swing.JOptionPane;
import java.util.Random;

public class act4_2 {
    private static int cero = 0;
    private static int primerDocena = 0;
    private static int segundaDocena = 0;
    private static int terceraDocena = 0;

    public static void main(String[] args) {
        int opcion;
        do {
            opcion = menu();
            seleccion(opcion);
            
        } while (opcion != 3);

    }

    public static int menu() {
        Object[] opcion = { "ingrese un numero", "numero aleatorio", "estadisticas", "salir" };
        int seleccion = JOptionPane.showOptionDialog(null, "seleccione una opcion", "menu de ruleta",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcion, opcion[0]);
        return seleccion;
    }
    public static void seleccion(int a){
        switch (a) {
            case 0:
                pedirNum();
                break;
            case 1:
                generarNum();
                break;
            case 2:
                estadisticas();
                break;
            default:
                JOptionPane.showMessageDialog(null, "juego terminado", "OPCION SALIR", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }
    public static void pedirNum() {
        int n = 0;
        try {
            n = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese un numero entre 0 y 36",
                    "ingrese un numero", JOptionPane.INFORMATION_MESSAGE));
            if (n>=0 && n <=36){
                asignarDoc(n);
            }  else {
                JOptionPane.showMessageDialog(null, "el numero que ingreso esta fuera de rango, pruebe de nuevo", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error, debe ingresar solamente numeros, entre el 0 y el 36", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void generarNum() {
        Random random = new Random();
        int num = random.nextInt(37);
        JOptionPane.showMessageDialog(null, "su numero aleatorio generado es: " + num);
        asignarDoc(num);
    }

    public static void asignarDoc(int numero) {
        if (numero == 0) {
            cero++;
            JOptionPane.showMessageDialog(null, "Numero 0.", "docena", JOptionPane.INFORMATION_MESSAGE);
        } else if (numero >= 1 && numero <= 12) {
            primerDocena++;
            JOptionPane.showMessageDialog(null, "El numero " + numero + " pertenece a la primera docena.", "docena",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (numero >= 13 && numero <= 24) {
            segundaDocena++;
            JOptionPane.showMessageDialog(null, "El numero " + numero + " pertenece a la segunda docena.", "docena",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (numero >= 25 && numero <= 36) {
            terceraDocena++;
            JOptionPane.showMessageDialog(null, "El numero " + numero + " pertenece a la tercera docena.", "docena",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void estadisticas() {
        String mensajeEstadisticas = String.format(
                "Primera docena (1-12): %d ocurrencias\n" +
                        "Segunda docena (13-24): %d ocurrencias\n" +
                        "Tercera docena (25-36): %d ocurrencias\n" +
                        "numero 0: %d ocurrencias",
                primerDocena, segundaDocena, terceraDocena, cero);
        JOptionPane.showMessageDialog(null, mensajeEstadisticas, "Estadisticas", JOptionPane.INFORMATION_MESSAGE);
    }
}
