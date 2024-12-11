package unidades.unidad5;

import javax.swing.JOptionPane;

/*Escribir un programa que  permita cargar dos arreglos unidimensionales de  'n' elementos cada uno. 
El primero contendrá el DNI de n personas y el segundo los nombres correspondientes. Se pide 
desarrollar los métodos necesarios que permitan la carga de los arreglos. El programa debe mostrar 
el nombre de una persona ingresando su  DNI por teclado. Si la misma no se encuentra en el arreglo, 
emitir un menaje indicándolo expresamente. */

public class act2 {
    public static void main(String[] args) {
        int aDni[], n;
        String aNombres[];
        n = pedirInt("ingrese la cantidad de personas: ", "cantidad de personas");
        aDni = new int[n];
        aNombres = new String[n];
        for (int i = 0; i < n; i++) {
            cargarArrayString(aNombres, i);
            cargarArrayInt(aDni, i, aNombres);
        }
        validarDni(aDni, aNombres);
    }

    public static int pedirInt(String m, String t) {
        return (Integer.parseInt(JOptionPane.showInputDialog(null, m, t, 1)));
    }

    public static String pedirString(String m, String t) {
        return (JOptionPane.showInputDialog(null, m, t, 1));
    }

    public static void cargarArrayInt(int[] aInt, int n, String[] a) {
        aInt[n] = pedirInt("ingrese el DNI de " + a[n], "DNI");

    }

    public static void cargarArrayString(String[] aString, int n) {
        aString[n] = pedirString("ingrese su nombre: ", "NOMBRE");
    }

    public static void validarDni(int[] aDni, String[] aNombres) {
        boolean bandera, validacion;
        do {
            int dni = pedirInt("ingrese el DNI para validar: ", "pidiendo DNI");
            bandera = false;
            validacion = false;
            for (int i = 0; i < aDni.length; i++) {
                if (dni == aDni[i]) {
                    JOptionPane.showMessageDialog(null, "el DNI " + aDni[i] + " es de: " + aNombres[i], null, 1);
                    validacion = true;
                }
            }
            if (validacion == false) {
                JOptionPane.showMessageDialog(null, "El DNI " + dni + " no se encuentra en nuestro registro.",
                        "SIN VALIDACION", 1);
            }
            int n = pedirInt("ingrese 1 si desea validar otro DNI, cualquier otro numero si no", "");
            if (n == 1)
                bandera = true;
            else
                bandera = false;
        } while (bandera);

    }

}
