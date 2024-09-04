package unidad1.actProceso.actividad2;

import java.util.Random;

/*Escribir un programa en Java que permita generar números enteros en forma aleatoria entre [0 y 200] hasta 
que la sumatoria de los mismos sea mayor a 500. Al finalizar determinar y mostrar:
- La cantidad de números nulos (0) leídos.
- La sumatoria de los números que se encuentran entre el 10 y el 100 (incluidos).
- El promedio de los números menores a 150.
- El número mayor generado y su posición de generación.
* Los números aleatorios se generan con la clase Math. Ó Ramdom.  */

public class act2_2 {
    public static void main(String[] ar) {
        Random random = new Random();
        int num,cantNulos=0,total=0,sumatoria=0, mayor=0, posicionMayor=0, contadorPromedio=0,contador=0;
        float promedio=0;
        do{
            num = numeroAleatorio(random);
            if (num==0) cantNulos++;
            if (num>=10 && num<=100) sumatoria+=num;
            if (num<150){
                promedio+=num;
                contadorPromedio++;
            }
            contador++;
            if(mayor<num){
                posicionMayor=contador;
                mayor=num;
            }
            total+=num;
        }while (total<=500);
        System.out.println("\tla cantidad de nulos leidos es de: "+cantNulos+"\n\tla sumatoria de los números que se encuentran entre el 10 y el 100 (incluidos) es de: "+sumatoria+"\n\tEl promedio de los números menores a 150 es de: "+promedio/contadorPromedio+"\n\tEl mayor numero generado fue el "+mayor+" su posicion de generacion es "+posicionMayor);
    }
    public static int numeroAleatorio(Random random){
        return random.nextInt(201);
    }
}