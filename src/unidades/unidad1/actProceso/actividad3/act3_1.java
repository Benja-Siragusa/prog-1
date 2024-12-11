package unidades.unidad1.actProceso.actividad3;

import javax.swing.JOptionPane;

/*Desarrolle un programa en java que realice la sumatoria de los números enteros múltiplos de 5, 
comprendidos entre el 1 y el 100, es decir, 5 + 10 + 15 +…. + 100. El programa deberá imprimir los números 
en cuestión y finalmente su sumatoria. Utilizar ciclos do–while y for. */

public class act3_1 {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,
                "la suma de todos los numeros multiplos de 5 entre 1 y 100 es de " + bucleF(), "con bucle for",
                JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,
                "la suma de todos los numeros multiplos de 5 entre 1 y 100 es de " + bucleDW(), "con bucle do-while",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static int bucleDW() {
        int i = 0, cont = 0;
        System.out.println("numero multiplos de 5 con bucle do while");
        try {
            do {
                cont++;
                if (cont % 5 == 0) {
                    i += cont;
                    System.out.println(cont);
                }
            } while (cont <= 100);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ocurrio un error en el bucle do-while", "error de bucle",
                    JOptionPane.ERROR_MESSAGE);
        }
        return i;
    }

    public static int bucleF() {
        int i = 0;
        System.out.println("numero multiplos de 5 con bucle for");
        try {
            for (int n = 1; n <= 100; n++) {
                if (n % 5 == 0)
                    i += n;
                System.out.println(n);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ocurrio un error en el bucle for", "error de bucle",
                    JOptionPane.ERROR_MESSAGE);
        }
        return i;
    }
}
