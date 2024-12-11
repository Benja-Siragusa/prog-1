package unidades.unidad5.ActividadAutoevaluacion;

import javax.swing.JOptionPane;

/*1.  Escribir un programa que permita cargar un arreglo unidimensional de N elementos. El programa 
debe permitir el ingreso de un elemento desde el teclado e informar la posición que ocupa en el 
arreglo. En caso contrario, mostrar el mensaje "elemento no encontrado".

Nota : utilizar la búsqueda binaria. */

public class act1 {
    public static void main(String[] args) {
        int[] arreglo;
        int n, busq,res;
        n = pedirInt("cuantos elementos contendra el arreglo: ", "tamaño del arreglo");
        arreglo = new int[n];
        cargarArray(arreglo);
        ordenarArray(arreglo);
        busq=pedirInt("ingrese un elemento para buscarlo de forma bianria, \n(primero se ordenara el array)", "elemento a buscar");
        res=busqBinaria(arreglo, busq);
        if (res==-1){
            JOptionPane.showMessageDialog(null, "el elemento "+busq+" no se encuentra en el arreglo", "elemento no ecnontrado", JOptionPane.WARNING_MESSAGE);
        }else JOptionPane.showMessageDialog(null,"el elemento "+busq+" se encuentra en la posicion "+res+" del arreglo","elemento encontrado", JOptionPane.INFORMATION_MESSAGE);

    }

    public static int pedirInt(String m, String t) {
        int n = 0;
        boolean bandera = false;
        do {
            try {
                n = Integer.parseInt(JOptionPane.showInputDialog(null, m, t, 1));
                bandera = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ingrese un entero", "error", 0);
            }
        } while (!bandera);
        return n;    }

    public static void cargarArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = pedirInt("ingrese un elemento para el array", "cargando elementos");
        }
    }

    public static void ordenarArray(int n[]){
        for (int i = 1; i < n.length; i++) {
            int actual = n[i];
            int j = i - 1;
            /*--------------------------------------------------*/
            /* Desplaza los elementos mayores hacia la derecha */
            /*--------------------------------------------------*/
            while (j >= 0 && n[j] > actual) {
                n[j + 1] = n[j];
                j--;
            }
            /* Inserta el elemento en su posición correcta */
            n[j + 1] = actual;
        }
    }

    public static int busqBinaria(int n[],int elem){
        int inicio = 0;
    int fin = n.length - 1;

    while (inicio <= fin) {
        int medio = inicio + (fin - inicio) / 2; // Calcula el índice medio

        if (n[medio] == elem) {
            return medio; // Valor encontrado, devuelve la posición
        } else if (n[medio] < elem) {
            inicio = medio + 1; // Ignora la mitad izquierda
        } else {
            fin = medio - 1; // Ignora la mitad derecha
        }
    }return -1;
    }
}
