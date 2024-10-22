package unidad3.ActProc3;

import javax.swing.JOptionPane;

/*Crear una clase “Mis_calculos” (puede cambiarle el nombre) y que esté almacenada dentro de una carpeta 
“Matemática”. La clase deberá contener métodos estáticos que retornen los valores correspondientes y permitan 
calcular la suma, la diferencia, el producto, el cociente y la potencia de dos números enteros. El producto, 
el cociente y la potencia debe calcularse utilizando ciclos repetitivos. */
public class Calculadora {
    public static void suma() {
        int n1, n2;
        n1=cargarInt("ingrese el primer numero: ","ingresando numero");
        n2=cargarInt("ingrese el segundo numero: ","ingresando numero");
        mostrarInfo(n1+" + "+n2+" = "+(n1+n2), "RESULTADO");
    }

    public static void resta() {
        int n1, n2;
        n1=cargarInt("ingrese el primer numero: ","ingresando numero");
        n2=cargarInt("ingrese el segundo numero: ","ingresando numero");
        mostrarInfo(n1+" - "+n2+" = "+(n1-n2), "RESULTADO");
    }

    public static void producto() {
        int n1, n2, n3=0, i;
        n1=cargarInt("ingrese el primer numero: ","ingresando numero");
        n2=cargarInt("ingrese el segundo numero: ","ingresando numero");
        for (i=0;i<n2;i++){
            n3+=n1;
        }
        mostrarInfo(n1+" x "+n2+" = "+n3, "RESULTADO");
    }

    public static void potencia() {
        int n1, n2, n3, i;
        n1=cargarInt("ingrese la base: ","ingresando numero");
        n2=cargarInt("ingrese el exponente: ","ingresando numero");
        n3=n1;
        for (i=1;i<n2;i++){
            n3*=n1;
        }
        mostrarInfo(n1+" ** "+n2+" = "+n3, "RESULTADO");
    }

    public static void division() {
        int n1, n2, n3,i=0;
        n1=cargarInt("ingrese la base: ","ingresando numero");
        n2=cargarInt("ingrese el exponente: ","ingresando numero");
        n3=n1;
        if (n1<n2){
            mostrarInfo("no se puede dividir por un numero mayor", "ERROR");
        } else{
            while (n3>=n2){
            n3-=n2;
            i++;
        }mostrarInfo(n1+" / "+n2+" = "+i+"\nel resto es: "+n3, "RESULTADO");
        }
    }

    public static int cargarInt(String mensaje, String titulo) {
        int n = 0;
        boolean b = false;
        do {
            try {
                n = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje, titulo, 1));
                b=false;
            } catch (Exception e) {
                mostrarInfo("Debe ingresar un numero", "ERROR");
                b = true;
            }
        } while (b == true);
        return n;
    }

    public static void mostrarInfo(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, 1);
    }

}
