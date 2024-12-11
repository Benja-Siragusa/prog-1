package unidades.unidad5;

import javax.swing.JOptionPane;

/*Escribir un programa que  permita  de cargar dos arreglos unidimensionales de  'n' elementos cada uno. 
El primero contendrá la descripción de 'n' artículos y el segundo sus precios unitarios. Se pide desarrollar 
los métodos necesarios que permitan la carga de los arreglos y,  la muestra de la descripción y el 
precio unitario de cada artículo; ordenados por este ultimo; en forma ascendente.   */

public class act1 {
    public static void main(String[] args) {
        int aPrecio[], n;
        String aDescripcion[];
        n=pedirInt("ingrese la cantidad de articulos: ","cantidad de articulos");
        aPrecio=new int[n];
        aDescripcion= new String[n];
        cargarArrays( aPrecio, aDescripcion);
        ordenarVectores(aPrecio, aDescripcion);
        mostrarVectores(aPrecio, aDescripcion);
    }

    public static int pedirInt(String m, String t){
        return(Integer.parseInt(JOptionPane.showInputDialog(null,m,t,1)));
    }

    public static String pedirString(String m, String t){
        return(JOptionPane.showInputDialog(null,m,t,1));
    }

    public static void cargarArrays(int[] aInt, String[] aString){
        for (int i =0;i<aInt.length;i++){
            aString[i]=pedirString("ingrese la descripcion del articulo: ", "cargando articulo");
            aInt[i]=pedirInt("ingrese el precio unitario del articulo: "+aString[i], "cargando precio");
        }
    }

    public static void ordenarVectores(int vectorInt[], String[] vectorString) {
        int n;
        String s;
        for (int i = 0; i < vectorInt.length - 1; i++) {
            for (int j = i + 1; j < vectorInt.length; j++) {
                if (vectorInt[i] > vectorInt[j]) {

                    n = vectorInt[i];
                    vectorInt[i] = vectorInt[j];
                    vectorInt[j] = n;
                    
                    s = vectorString[i];
                    vectorString[i] = vectorString[j];
                    vectorString[j] = s;
                }
            }
        }
    }

    public static void mostrarVectores(int[] vectorInt,String[] vectorString){
        StringBuilder data = new StringBuilder("Precio de cada articulo: ");
        for (int i=0;i<vectorInt.length;i++){
            data.append("\n - "+vectorString[i]+": "+vectorInt[i]+"$");
        }JOptionPane.showMessageDialog(null, data, "precios",JOptionPane.NO_OPTION);
    }

}
