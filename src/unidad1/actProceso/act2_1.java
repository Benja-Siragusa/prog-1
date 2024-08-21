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
        char sexo, cent;
        int altura, alturaMenor=0, edad, edadMenor = 0, cantTotal = 0, cantF = 0, cantM = 0;
        float alturaFem = 0, promedioEdad = 0, alturaMasc = 0;
        String nombre, nombreMenor="s";
        do {
            System.out.println("Ingresa tu nombre:");
            nombre = sc.nextLine();
            System.out.println("Ingresa tu edad:");
            edad = sc.nextInt();
            System.out.println("Ingresa tu altura:");
            altura = sc.nextInt();
            System.out.println("Ingresa tu sexo (F/M):");
            sexo = sc.next().charAt(0);
            sc.nextLine();

            cantTotal++;
            promedioEdad += edad;
            if (edadMenor==0){
                edadMenor=edad;
                nombreMenor=nombre;
                alturaMenor=altura;
            } else if (edadMenor>edad) {
                edadMenor=edad;
                nombreMenor=nombre;
                alturaMenor=altura;
            }
            if (sexo == 'F') {
                cantF++;
                alturaFem += altura;
            } else if (sexo == 'M') {
                cantM++;
                alturaMasc += altura;
            }

            System.out.println("desea ingresar datos de otro participante? s para si n para no");
            cent = sc.next().charAt(0);
            sc.nextLine();
        } while (cent == 's');
        System.out.println("\tel promedio de altura de las mujeres es de " +

                promed(alturaFem, cantF)
                + "\n\tel promedio de altura de los varones es de " + promed(alturaMasc, cantM)
                + "\n\tel promedio de edad de los participantes es de " + promed(promedioEdad, cantTotal)
                + "\n\tla persona mas joven se llama " + nombreMenor + " tiene " + edadMenor + " años y mide "
                + alturaMenor + "cm.");
    }
    public static int entero(){
        Scanner sc = new Scanner(System.in);
        System.out.println();
        return(sc.nextInt());
    }
    public static float promed(float a, int b) {
        if(b==0){
            return 0;
        }else{
        return a / b;}
    }
}