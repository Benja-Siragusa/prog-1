package clase_2;

import java.io.IOException;
import java.util.Scanner;

/*Escribir un programa que permita calcular el perímetro y la superficie de distintas figuras geométricas 
(Círculos, triángulos (ojo), rectángulos, cuadrados, heptagono y octógono) mediante procedimientos. 
Crear un menú que permita seleccionar la figura y de acuerdo a la selección llamar a los procedimientos 
para el calculo correspondiente. 
Para los métodos deben utilizar distintos tipos de retorno void, float, double, según corresponda al llamado del método.    */
public class ao1 {

    public static void main(String[] args) throws IOException, InterruptedException {
        int option = -1;
        double lado1, lado2;
        Scanner sc = new Scanner(System.in
        );
        do {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); /*  */
                System.out.println("╔═════════════════════════╗");
                System.out.println("║   Seleccione la opcion  ║");
                System.out.println("╚═════════════════════════╝");
                System.out.println("\t1.circulo");
                System.out.println("\t2.triangulo");
                System.out.println("\t3.rectangulo");
                System.out.println("\t4.cuadrado");
                System.out.println("\t5.heptagono");
                System.out.println("\t6.octogono");
                System.out.println("\t0.salir");

                option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Error de Ingreso de datos");
            }
            switch (option) {
                case 1:
                    System.out.println("Seleccionado Circulo");

                    calcularCirculo(sc);
                    break;

                case 2:

                    System.out.println("Seleccionado 2");
                    break;

                case 3:
                    System.out.println("Seleccionado Rectángulo");
                    System.out.println("Ingrese lado 1: ");
                    lado1 = Double.parseDouble(sc.nextLine());
                    System.out.println("Ingrese lado 2: ");
                    lado2 = Double.parseDouble(sc.nextLine());
                    System.out.printf("El perímetro del rectángulo es: %.2f%n" , calcularPerimetro(lado1, lado2));
                    System.out.printf("La superficie del rectángulo es: %.2f%n" , calcularSuperficie(lado1, lado2));

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
            if (option != 0) {
                System.out.print("\nPresione una tecla para continuar...");
                sc.nextLine();
            }

        } while (option != 0);

        sc.close();
    }

    public static void calcularCirculo(Scanner ext) {
        System.out.print("Ingrese el radio del círculo: ");

        double radio = Double.parseDouble(ext.nextLine());
        double perimetro = 2 * Math.PI * radio;
        double superficie = Math.PI * Math.pow(radio, 2);

        System.out.printf("Perímetro del círculo: %.2f%n ", perimetro);
        System.out.printf("Superficie del círculo: %.2f%n", superficie);
    }

    public static double ingreseLado(Scanner sc) {
        System.err.println("Ingrese lado del triangulo");
        return Double.parseDouble(sc.nextLine());
    }

    public static void calcularTriangulo() {

    }

    public static Double calcularPerimetro(double L1, double L2) {
        return (double) 2*(L1 + L2);
    }
    
    public static Double calcularSuperficie(double L1, double L2){
        return (double) L1 * L2;
    }

    public static void calcularHeptagono(Scanner scanner) {
        System.out.print("Ingrese el lado del heptágono: ");
        double lado = scanner.nextDouble();
        System.out.print("Ingrese el apotema del heptágono: ");
        double apotema = scanner.nextDouble();

        double perimetro = 7 * lado;
        double superficie = (perimetro * apotema) / 2;

        System.out.println("Perímetro del heptágono: " + perimetro);
        System.out.println("Superficie del heptágono: " + superficie);
    }

}
