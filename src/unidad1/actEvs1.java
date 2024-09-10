package unidad1;

import java.io.IOException;
import java.util.Scanner;

public class actEvs1 {
    /*
     * Escribir un programa que permita calcular el perímetro y la superficie de
     * distintas figuras geométricas
     * (Círculos, triángulos (ojo), rectángulos, cuadrados, heptagono y octógono)
     * mediante procedimientos.
     * Crear un menú que permita seleccionar la figura y de acuerdo a la selección
     * llamar a los procedimientos
     * para el calculo correspondiente.
     * Para los métodos deben utilizar distintos tipos de retorno void, float,
     * double, según corresponda al llamado del método.
     */

    public static void main(String[] args) throws IOException, InterruptedException {
        int option = -1, opcionT = -1;
        double lado1, lado2,lado3, lado;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); /*  */
                System.out.println("╔═════════════════════════╗"); /* 201 ╔ 205 ═ 200 ╚ 187╗ 186 ║ 188 ╝ */
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
                    System.out.println("Seleccionado Triangulo");
                    System.out.println("╔═════════════════════════╗"); /* 201 ╔ 205 ═ 200 ╚ 187╗ 186 ║ 188 ╝ */
                    System.out.println("║   Seleccione triángulo  ║");
                    System.out.println("╚═════════════════════════╝");
                    System.out.println("\t1.equilátero");
                    System.out.println("\t2.isósceles");
                    System.out.println("\t3.escaleno");
                    opcionT = Integer.parseInt(sc.nextLine());
                    switch (opcionT) {
                        case 1:
                            System.out.println("Equilatero");
                            System.out.println("Ingrese el lado del triangulo: ");
                            lado1 = Double.parseDouble(sc.nextLine());
                            System.out.printf("El perimetro del triangulo es: %.2f%n", calcPerimPolReg(lado1, 3));
                            System.out.printf("La superficie del triangulo es: %.2f%n", calcAreaPolReg(lado1, 3));
                            break;
                        case 2:
                            System.out.println("Isósceles");
                            System.out.print("Ingrese el lado Igual del triangulo: ");
                            lado1 = Double.parseDouble(sc.nextLine());
                            System.out.print("Ingrese el lado desigual del triangulo: ");
                            lado2 = Double.parseDouble(sc.nextLine());
                            if (comprobaion(lado1, lado1, lado2)) {
                                double perimTria = calcPerimTriIsc(lado1, lado2);
                                System.out.printf("El perimetro del triangulo es: %.2f%n", perimTria);
                                System.out.printf("La superficie del triangulo es: %.2f%n",
                                        calcAreaTriangulos(lado1, lado1, lado2, perimTria));
                                break;
                            } else {
                                System.out.println("el triangulo es imposible de realizar");
                                break;
                            }

                        case 3:
                            System.out.println("Escaleno");
                            System.out.print("Ingrese el lado 1 del triangulo: ");
                            lado1 = Double.parseDouble(sc.nextLine());
                            System.out.print("Ingrese el lado 2 del triangulo: ");
                            lado2 = Double.parseDouble(sc.nextLine());
                            System.out.print("Ingrese el lado 3 del triangulo: ");
                            lado3 = Double.parseDouble(sc.nextLine());
                            if (comprobaion(lado1, lado2, lado3)) {
                                double perimTria = calcPerimTriEsc(lado1, lado2, lado3);
                                System.out.printf("El perimetro del triangulo es: %.2f%n", perimTria);
                                System.out.printf("La superficie del triangulo es: %.2f%n",
                                        calcAreaTriangulos(lado1, lado2, lado3, perimTria));
                                break;
                            } else {
                                System.out.println("el triangulo es imposible de realizar");
                                break;}

                        default:
                            System.out.println("Error de selección");
                            break;
                    }
                    break;

                case 3:
                    System.out.println("Seleccionado Rectángulo");
                    System.out.println("Ingrese lado 1: ");
                    lado1 = Double.parseDouble(sc.nextLine());
                    System.out.println("Ingrese lado 2: ");
                    lado2 = Double.parseDouble(sc.nextLine());
                    System.out.printf("El perímetro del rectángulo es: %.2f%n", calcularPerimetro(lado1, lado2));
                    System.out.printf("La superficie del rectángulo es: %.2f%n", calcularSuperficie(lado1, lado2));
                    break;

                case 4:
                    System.out.println("Seleccionado Cuadrado");
                    System.out.print("Ingrese el lado del Cuadrado: ");
                    lado = Double.parseDouble(sc.nextLine());
                    System.out.printf("El perímetro del Cuadrado de lado: %.2f es: %.2f%n", lado,
                            calcPerimPolReg(lado, 4));
                    System.out.printf("La superficie del cuadrado es: %.2f%n", calcAreaPolReg(lado, 4));
                    break;

                case 5:
                    System.out.println("Seleccionado Heptágono");
                    System.out.print("Ingrese el lado del Heptágono: ");
                    lado = Double.parseDouble(sc.nextLine());
                    System.out.printf("El perímetro del Heptágono de lado: %.2f es: %.2f%n", lado,
                            calcPerimPolReg(lado, 7));
                    System.out.printf("La superficie del Heptágono es: %.2f%n", calcAreaPolReg(lado, 7));
                    break;

                case 6:
                    System.out.println("Seleccionado Octógono");
                    System.out.print("Ingrese el lado del Octógono: ");
                    lado = Double.parseDouble(sc.nextLine());
                    System.out.printf("El perímetro del Octógono de lado: %.2f es: %.2f%n", lado,
                            calcPerimPolReg(lado, 8));
                    System.out.printf("La superficie del Octógono es: %.2f%n", calcAreaPolReg(lado, 8));
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

    /*----------------------------------------- */
    /* Calcula Perim Area Círculo */
    /*----------------------------------------- */
    public static void calcularCirculo(Scanner ext) {
        System.out.print("Ingrese el radio del círculo: ");

        double radio = Double.parseDouble(ext.nextLine());
        double perimetro = 2 * Math.PI * radio;
        double superficie = Math.PI * Math.pow(radio, 2);

        System.out.printf("Perímetro del círculo: %.2f%n ", perimetro);
        System.out.printf("Superficie del círculo: %.2f%n", superficie);
    }

    /*----------------------------------------- */
    /* Calcula Perim Rectangulo */
    /*----------------------------------------- */
    public static Double calcularPerimetro(double L1, double L2) {
        return (double) 2 * (L1 + L2);
    }

    /*----------------------------------------- */
    /* Calcula Area Rectangulo */
    /*----------------------------------------- */
    public static Double calcularSuperficie(double L1, double L2) {
        return (double) L1 * L2;
    }

    /*----------------------------------------- */
    /* Calcula Perimetro Poligono Regular */
    /*----------------------------------------- */
    public static double calcPerimPolReg(double lado, int nlados) { /* */
        double perimetro = nlados * lado;
        return perimetro;
    }

    /*----------------------------------------- */
    /* Calcula Area Poligono Regular */
    /*----------------------------------------- */
    public static Double calcAreaPolReg(double lado, int nlados) {
        return (double) (nlados * Math.pow(lado, 2)) / (4 * Math.tan(Math.PI / nlados));
    }

    /*----------------------------------------- */
    /* Calcula Perimetro Triangulo Isc */
    /*----------------------------------------- */
    public static Double calcPerimTriIsc(double lado1, double lado2) {
        return (lado1 * 2) + lado2;
    }

    /*----------------------------------------- */
    /* Calcula Perimetro Triangulo Isc */
    /*----------------------------------------- */
    public static Double calcPerimTriEsc(double lado1, double lado2, double lado3) {
        return lado1 + lado2 + lado3;
    }

    /*----------------------------------------- */
    /* Calcula Area Triangulos */
    /*----------------------------------------- */
    public static Double calcAreaTriangulos(double lado1, double lado2, double lado3, double perim) {
        double s = perim / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    /*----------------------------------------- */
    /* Comprobando que el triangulo sea posible */
    /*----------------------------------------- */
    public static boolean comprobaion(double a, double b, double c) {
        if (a + b > c & a + c > b & b + c > a)
            return true;
        else
            return false;
    }
}
