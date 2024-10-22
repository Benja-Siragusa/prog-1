package clases.clase_5;

import javax.swing.JOptionPane;

import clases.clase_5.CuentaBancaria.TipoCuentas;

public class DemoCuentaBancaria {
    public static void main(String[] args) throws InterruptedException {
        CuentaBancaria cb1 = new CuentaBancaria("12356", 25000, TipoCuentas.CAJA_AHORRO );
        System.out.println(cb1.toString());
        cb1.mostrarDatosCuenta();

        cb1.depositar(leerMontoJOP("Depositar"));
        cb1.mostrarDatosCuenta();

        cb1.retirar(leerMontoJOP("Retirar"));
        cb1.mostrarDatosCuenta();

        CuentaBancaria cb2 = new CuentaBancaria("15235", TipoCuentas.CAJA_AHORRO);
        cb2.depositar(leerMontoJOP("Depositar"));
        cb2.mostrarDatosCuenta();

        cb2.desactivarCuenta();
        cb2.mostrarDatosCuenta();

        CuentaBancaria cb3 = new CuentaBancaria();
        cb3.cargarCuenta();
        cb3.mostrarDatosCuenta();

        if (cb1.getSaldo() > cb2.getSaldo() && cb1.getSaldo()>cb3.getSaldo()) {
            JOptionPane.showMessageDialog(null, "La cuenta n° " + cb1.getNumeroCuenta() + " tiene mas fondos ", "cuenta con mas saldo", 1);
        } else if (cb2.getSaldo()>cb3.getSaldo()){
            JOptionPane.showMessageDialog(null, "La cuenta n° " + cb2.getNumeroCuenta() + " tiene mas fondos ", "cuenta con mas saldo", 1);
        } else {
            JOptionPane.showMessageDialog(null, "La cuenta n° " + cb3.getNumeroCuenta() + " tiene mas fondos ", "cuenta con mas saldo", 1);
        }

        JOptionPane.showMessageDialog(null, "cuentas creadas: "+CuentaBancaria.getTotalCuentas(), "total cuentas", 1);
    }

    public static double leerMontoJOP(String mensaje) {
        boolean repetir;
        double valor = 0;
        do {
            repetir = false;
            try {
                valor = Double.parseDouble(JOptionPane.showInputDialog("Introduce el monto a " + mensaje + " $:"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar un valor Double ", "Error!!!", 0);
                repetir = true;
            }
        } while (repetir);
        return valor;
    }
}
