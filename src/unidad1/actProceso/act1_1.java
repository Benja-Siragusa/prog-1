package unidad1.actProceso;

import java.util.Scanner;

/*Escribir un programa en Java que permita ingresar 10 enteros positivos por teclado (validar que sea positivo), 
determine y muestre un mensaje «Correcto» si el numero N es múltiplo de 5 y se encuentra entre los 25 primeros 
números decimales. Al finalizar mostrar la cantidad de Enteros que cumplen la condición y su promedio. 
Utilice el ciclo más apropiado. */

public class act1_1 {
    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);
        int num, cant=0;
        float promedio=0;
        for (int i = 0; i < 10; i++) {
            do {
                System.out.println("ingrese un entero positivo: ");
                num = sc.nextInt();
            } while (num <= 0);
            if (num%5==0 && num<25){
                System.out.println("correcto");
                cant++;
                promedio+=num;
            }
        }
        System.out.println("La cantidad de enteros que cumplen la condicion es de: "+cant+"\nSu promedio es de: "+promedio/cant);
    }
}