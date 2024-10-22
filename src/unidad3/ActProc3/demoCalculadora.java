package unidad3.ActProc3;

import javax.swing.JOptionPane;

public class demoCalculadora {
    public static void main(String[] args) {
        int opcion;

        do {
            opcion = mostrarMenu1();
            switch (opcion) {
                case 0:
                    Calculadora.suma();
                    break;
                case 1:
                    Calculadora.resta();
                    break;
                case 2:
                    Calculadora.producto();
                    break;
                case 3:
                    Calculadora.division();
                    break;
                case 4:
                    Calculadora.potencia();
                    break;

                default:
                    break;
            }
        } while (opcion != 5);
    }

    public static int mostrarMenu1() {
        String[] opciones = {
                "suma", // 0
                "resta", // 1
                "multiplicacion", // 2
                "division", // 3
                "potenciacion", // 4
                "salir"// 5
        };

        return JOptionPane.showOptionDialog(null, "Seleccione una operacion para realizar con 2 numeros", "CALCULADORA",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
    }
}
