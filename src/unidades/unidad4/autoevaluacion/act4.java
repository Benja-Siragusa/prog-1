package unidades.unidad4.autoevaluacion;

import java.util.Arrays;

import javax.swing.JOptionPane;

/*Realice un programa en Java que lea un vector de enteros y a partir de él forme un segundo vector, con los 
mismos datos pero en el orden inverso, mostrar. Obtener a partir del primer vector el promedio y luego mostrar 
solo los enteros que sean mayores que el promedio. Utilizar métodos para las distintas operaciones. */

public class act4 {
    public static void main(String[] args) {
        int[] vector, invertido;
        vector = pedirVector();
        invertido = invertirVector(vector);
        
        String vectorString = Arrays.toString(vector);
        JOptionPane.showMessageDialog(null, "vector: "+vectorString, "vector",1);

        String invertidoString = Arrays.toString(invertido);
        JOptionPane.showMessageDialog(null, "vector: "+invertidoString, "vector invertido",1);

        float b = promedio(vector);
        mayoresPromedio(vector, b);

    }

    public static int[] pedirVector() {
        int m, vector[];
        m = Integer.parseInt(JOptionPane.showInputDialog(null, "cuantos numeros contendra el vector: ", "cantidad", 1));
        vector = new int[m];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = Integer
                    .parseInt(JOptionPane.showInputDialog(null, "ingrese un numero: ", "ingresando numero", 1));
        }
        return vector;
    }

    public static int[] invertirVector(int[] n) {
        int invertido[], a = 0;
        invertido = new int[n.length];
        for (int i = (n.length-1); i >= 0; i--) {
            invertido[a] = n[i];
            a++;
        }
        return invertido;
    }

    public static float promedio(int[] n){
        float b=0;
        for (int i=0;i<n.length;i++){
            b+=n[i];
        }
        return (b/n.length);
    }

    public static void mayoresPromedio(int[] n, float b){
        for (int i=0;i<n.length;i++){
            if(n[i]>b){
                JOptionPane.showMessageDialog(null, "el numero "+n[i]+" en la posicion "+i+" del vector es mayor al promedio del vector que es "+b, "promedio", 1);
            }
        }
    }
}
