package clases.clase_2;

import java.io.IOException;
import java.util.Scanner;

/*Escribir un programa que permita calcular el perímetro y la superficie de distintas figuras geométricas 
(Círculos, triángulos (ojo), rectángulos, cuadrados, heptagono y octógono) mediante procedimientos. 
Crear un menú que permita seleccionar la figura y de acuerdo a la selección llamar a los procedimientos 
para el calculo correspondiente. 
Para los métodos deben utilizar distintos tipos de retorno void, float, double, según corresponda al llamado del método.    */
public class menu {

    public static void main(String[] args) throws IOException, InterruptedException {
        int option = 1;
        Scanner sc = new Scanner(System.in);
        do {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("╔═════════════════════════╗");
            System.out.println("║   Seleccione la opcion  ║");
            System.out.println("╚═════════════════════════╝");
            System.out.println("1.circulo");
            System.out.println("2.triangulo");
            System.out.println("3.rectangulo");
            System.out.println("4.cuadrado");
            System.out.println("5.heptagono");
            System.out.println("6.octogono");
            System.out.println("0.salir");

            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    System.out.println("Seleccionado 1");

                    break;
                case 2:
                    System.out.println("Seleccionado 2");
                    break;

                case 3:
                    System.out.println("Seleccionado 3");
                    break;

                case 4:
                    System.out.println("Seleccionado 4");
                    break;

                case 5:
                    System.out.println("Seleccionado 5");
                    break;
                case 6:
                    System.out.println("Seleccionado 6");
                    break;
                case 0:
                    System.out.println("Hasta luego");
                    break;

                default:
                    System.out.println("Ingrese una opción válida.");
                    break;
            }
            System.out.print("Presione una tecla para continuar...");
            sc.nextLine();

        } while (option != 0);

        sc.close();
    }

}

