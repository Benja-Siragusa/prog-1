package unidad1.actIntegradora;

import javax.swing.JOptionPane;
/*Escribir un programa en Java que permita leer desde teclado números hasta que la suma de los mismos llegue a 1000.
Mientras tanto se debe obtener y mostrar al finalizar:
    - La cantidad de números múltiplos de 6.
    - La suma de los números que se encuentran entre el 1 y el 10 (incluidos).
    - El Mayor y el Menor de los números ingresados y su posición de ingreso.
Puede utilizar Scanner u JOptionPane para el ingreso de datos por teclado. */

public class actInt2 {
    public static void main(String[] args) {
        int n, cuenta = 0, cuentaTotal = 0, mayor = 0, menor = 0, posMayor = 0, posMenor = 0, cantMultiplo = 0,
                cantEntre1y10 = 0;
        do {try {
        
            n = pedirNumero();
            cuenta++;
            if (cuenta == 1) {
                menor = n;
                mayor = n;
                posMenor = posMayor = cuenta;
            } else if (menor > n) {
                menor = n;
                posMenor = cuenta;
            } else if (mayor < n) {
                mayor = n;
                posMayor = cuenta;
            }

            if (multiplo(n,6))
                cantMultiplo++;
            if (entre1y10(n))
                cantEntre1y10+=n;
            cuentaTotal += n;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error en el ingreso de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            // TODO: handle exception
        }
            

        } while (cuentaTotal < 1000);
        JOptionPane.showMessageDialog(null,
                " - la suma total fue de: " + cuentaTotal + "\n - la cantidad de numeros ingresados fue de: " + cuenta
                        + "\n - la cantidad de numeros multiplos de 6 es de: " + cantMultiplo
                        + "\n - la suma de los numeros entre 0 y 10 es de: " + cantEntre1y10
                        + "\n - el mayor numero ingresado fue el " + mayor + " ingresado en la posicion " + posMayor
                        + "\n - el menor numero ingresado fue el " + menor + " ingresado en la posicion " + posMenor, "RESULTADOS",JOptionPane.INFORMATION_MESSAGE);
    }

    public static int pedirNumero() {
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese un numero: ", "pedir numero",JOptionPane.INFORMATION_MESSAGE));
        return n;
    }

    public static boolean multiplo(int a,int b) {
        if (a % b == 0)
            return true;
        else
            return false;
    }

    public static boolean entre1y10(int a) {
        if (a >= 0 && a <= 10)
            return true;
        else
            return false;
    }
}
