package unidades.unidad4.autoevaluacion;

import javax.swing.JOptionPane;

/*Escribir un programa en Java que permita cargar una matriz de NxM elementos enteros.
Obtener y mostrar los elementos mayores y su posición del promedio de la fila J ingresada por teclado. */

public class act2 {
    public static void main(String[] args) {
        int  numero, n, m, matriz[][];
        float media[];
        n = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la cantidad de filas", "pidiendo filas", 1));
        m = Integer
                .parseInt(JOptionPane.showInputDialog(null, "ingrese la cantidad de columnas", "pidiendo columnas", 1));
        matriz = new int[n][m];
        media = new float[n];
        for (int i = 0; i < n; i++) {
            float promedio=0;
            for (int e = 0; e < m; e++) {
                numero = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "ingrese un numero a la posisicion " + (i + 1) + "," + (e + 1) + " a la matriz:",
                        "ingresando valores", 1));
                promedio += numero;
                matriz[i][e] = numero;
            }
            media[i] = (promedio / m); 
        }
        for (int i=0;i<n;i++){
            JOptionPane.showMessageDialog(null, "el promedio de la fila "+(i+1)+" es "+media[i], "promedio", 1);
            for (int e=0;e<m;e++){
                if (matriz[i][e]>media[i]){
                    JOptionPane.showMessageDialog(null,"el numero en la fila "+(i+1)+", columna "+(e+1)+" es "+matriz[i][e]+" y supera la media de su fila que es "+media[i], "supera la media", 1);
                }else{
                    JOptionPane.showMessageDialog(null,"el numero en la fila "+(i+1)+", columna "+(e+1)+" es "+matriz[i][e]+" y no supera la media de su fila que es "+media[i], "no supera la media", 1);
                }
            }
        }
    }
}
