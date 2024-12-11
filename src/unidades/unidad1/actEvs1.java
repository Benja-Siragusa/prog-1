package unidades.unidad1;

import javax.swing.JOptionPane;

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

    public static void main(String[] args) {
        int opcion = 0;
        do {
            try {
                opcion = menu();
                seleccion(opcion);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error en el ingreso de datos", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 6);
    }

    public static int menu() {
        Object[] opcion = { "circulo", "triangulo", "rectangulo", "cuadrado", "heptagono", "octogono", "salir" };
        int seleccion = JOptionPane.showOptionDialog(null,
                "\t╔═════════════════════════╗\n\t║        Seleccione la opcion        ║\n\t╚═════════════════════════╝", "MENU",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcion, opcion[0]);
        return seleccion;
    }

    public static void seleccion(int a) {
        switch (a) {
            case 0:
                calcularCirculo();
                break;
            case 1:
                menuTriangulo();
                break;
            case 2:
                calcularRectangulo();
                break;
            case 3:
                calcularFiguras(4);
                break;
            case 4:
                calcularFiguras(7);
                break;
            case 5:
                calcularFiguras(8);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Hasta luego!", "OPCION SALIR", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }

    /*----------------------------------------- */
    /* Calcula Perim Area Círculo */
    /*----------------------------------------- */
    public static void calcularCirculo() {

        double radio = Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese el radio del circulo",
                "OPCION CIRCULO", JOptionPane.INFORMATION_MESSAGE));
        double perimetro = 2 * Math.PI * radio;
        double superficie = Math.PI * Math.pow(radio, 2);
        JOptionPane.showMessageDialog(null, "Perimetro del circulo: " + perimetro + "\nArea del circulo: " + superficie,
                "RESULTADO", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void menuTriangulo() {
        Object[] opcion = { "equilátero", "isóseles", "escaleno", };
        int seleccion = JOptionPane.showOptionDialog(null,
                "\t╔═════════════════════════╗\n\t║   Seleccione triángulo  ║\n\t╚═════════════════════════╝",
                "MENU TRIANGULO",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcion, opcion[0]);
        switch (seleccion) {
            case 0:
                int lado = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la medida de los lado",
                        "PEDIR LADO", JOptionPane.INFORMATION_MESSAGE));
                JOptionPane.showMessageDialog(null,
                        "Perimetro del triangulo: " + (lado*3) + "\nArea del triangulo: "
                                + calcAreaPolReg(lado, 3),
                        "INFORMACION TRIANGULO EQU", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 1:
                int lado1 = Integer
                        .parseInt(JOptionPane.showInputDialog(null, "ingrese la medida del lado igual del triangulo",
                                "PEDIR LADO IGUAL", JOptionPane.INFORMATION_MESSAGE));
                int lado2 = Integer
                        .parseInt(JOptionPane.showInputDialog(null, "ingrese la medida del lado desigual del triangulo",
                                "PEDIR LADO DESIGUAL", JOptionPane.INFORMATION_MESSAGE));
                if (comprobaion(lado1, lado1, lado2)) {
                    double perimTria = calcPerimTriIsc(lado1, lado2);
                    JOptionPane.showMessageDialog(null,
                            "Perimetro del triangulo: " + perimTria + "\nArea del triangulo: "
                                    + calcAreaTriangulos(lado1, lado1, lado2, perimTria),
                            "INFORMACION TRIANGULO ISC", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Triangulo imposible de realizar", "INFORMACION TRIANGULO ISC",
                            JOptionPane.ERROR_MESSAGE);

                }
                break;
            case 2:
                int lado1e = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "ingrese la medida del lado 1 del triangulo", "PEDIR LADO 1", JOptionPane.INFORMATION_MESSAGE));
                int lado2e = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "ingrese la medida del lado 2 del triangulo", "PEDIR LADO 2", JOptionPane.INFORMATION_MESSAGE));
                int lado3e = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "ingrese la medida del lado 3 del triangulo", "PEDIR LADO 3", JOptionPane.INFORMATION_MESSAGE));

                if (comprobaion(lado1e, lado2e, lado3e)) {
                    double perimTria = calcPerimTriEsc(lado1e, lado2e, lado3e);
                    JOptionPane.showMessageDialog(null,
                            "Perimetro del triangulo: " + perimTria + "\nArea del triangulo: "
                                    + calcAreaTriangulos(lado1e, lado2e, lado3e, perimTria),
                            "INFORMACION TRIANGULO ESC", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Triangulo imposible de realizar", "INFORMACION TRIANGULO ISC",
                            JOptionPane.ERROR_MESSAGE);

                }
                break;
        }
    }

    /*----------------------------------------- */
    /* Calcula Perim y Area Rectangulo */
    /*----------------------------------------- */
    public static void calcularRectangulo() {
        int l2 = Integer.parseInt(JOptionPane.showInputDialog(null,
                "ingrese la medida del lado 1 del rectangulo", "PEDIR LADO 1", JOptionPane.INFORMATION_MESSAGE));
        int l1 = Integer.parseInt(JOptionPane.showInputDialog(null,
                "ingrese la medida del lado 2 del rectangulo", "PEDIR LADO 2", JOptionPane.INFORMATION_MESSAGE));
        JOptionPane.showMessageDialog(null,
                "Perimetro del rectangulo: " + (2 * (l1 + l2)) + "\nArea del rectangulo: "
                        + (l1 * l2),
                "INFORMACION TRIANGULO ESC", JOptionPane.INFORMATION_MESSAGE);
    }

    /*----------------------------------------- */
    /* Calcula Perim y Area Poligonos */
    /*----------------------------------------- */
    public static void calcularFiguras(int a) {
        int lado = Integer.parseInt(JOptionPane.showInputDialog(null,
                "ingrese la medida del lado", "PEDIR LADO", JOptionPane.INFORMATION_MESSAGE));
        JOptionPane.showMessageDialog(null,
                "Perimetro de la figura: " + (lado * a) + "\nArea dela figura: "
                        + calcAreaPolReg(lado, a),
                "INFORMACION TRIANGULO ESC", JOptionPane.INFORMATION_MESSAGE);
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