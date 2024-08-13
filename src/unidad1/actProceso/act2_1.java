package unidad1.actProceso;

import java.util.Scanner;

/*Diseñar un programa en Java que permita leer desde teclado la información sobre el nombre, altura, edad, y sexo 
(‘F’/’M’) de los participantes de un curso. Después que se haya ingresado la información de un participante, 
para continuar con la carga el programa debe preguntar si sedea continuar o no. En caso de la respuesta negativa 
(lectura finalizada) determine y muestre:
 - Promedio de altura de las mujeres.
 - Promedio de altura de los varones.
 - Promedio de edad de los participantes.
 - Nombre, edad y sexo de la persona más joven. */

public class act2_1 {
    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);
        char sexo;
        int altura, edad;
        float cantTotalAltM, cantTotalEdad, cantTotalAltH;
        String nombre;
        do{
            System.out.println("Ingresa tu nombre, edad y sexo(M/F), separados por espacios:");

            System.out.println("desea ingresar datos de otro participante? s para si n para no");
            cent=sc.next
        } while();
    }
    public static float promed(int a,int b){
        return a/b;
    }
}