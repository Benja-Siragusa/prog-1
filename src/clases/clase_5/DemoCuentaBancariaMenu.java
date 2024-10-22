package clases.clase_5;

import javax.swing.JOptionPane;

public class DemoCuentaBancariaMenu {

    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria();

        cuenta.cargarCuenta();

        int opcion;
        do {
            opcion = mostrarMenu();
            switch (opcion) {
                case 0:
                    cuenta.mostrarDatosCuenta();
                    break;
                case 1:
                    cuenta.depositar(Double.parseDouble(
                            JOptionPane.showInputDialog(null, "Ingrese el monto a depositar", "inresando", 1)));
                    break;
                case 2:
                    cuenta.retirar(Double.parseDouble(
                            JOptionPane.showInputDialog(null, "Ingrese el monto a retirar", "retirando", 1)));
                    break;
                case 3:
                    cuenta.activarCuenta();
                    break;
                case 4:
                    cuenta.desactivarCuenta();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (opcion != 6);
    }

    public static int mostrarMenu() {
        String[] opciones = {
                "Mostrar datos de la cuenta",
                "Depositar dinero",
                "Retirar dinero",
                "Activar cuenta",
                "Desactivar cuenta",
                "Salir"
        };

        return JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menú Cuenta Bancaria",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
    }

}
