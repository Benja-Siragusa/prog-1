package unidades.unidad4.autoevaluacion;

import javax.swing.JOptionPane;

public class act1 {

    /*
     * Escribir un programa en Java que luego de cargar un array unidimensional
     * (vector) de
     * n elementos, imprima la cantidad de elementos mayores al promedio.
     */

    public static void main(String[] args) {
        int n, p[], i;
        float total = 0;
        n = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese cuantos elementos tendra el vector: ",
                "solicitando tamaño", 1));
        p = new int[n];
        for (i = 0; i < n; i++) {
            p[i] = Integer.parseInt(
                    JOptionPane.showInputDialog(null, "ingrese un numero al array:", "solicitando numeros", 1));
            total += p[i];
        }
        total = total / n;
        for (i = 0; i < n; i++) {
            if (p[i] > total) {
                JOptionPane.showMessageDialog(null,
                        "el elemento en la posicion " + i + " es " + p[i] + " y es mayor a la media que es " + total,
                        "mayor a media", 1);
            }
        }
    }
}
