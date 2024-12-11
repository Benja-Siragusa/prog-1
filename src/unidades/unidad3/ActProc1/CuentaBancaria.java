package unidades.unidad3.ActProc1;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CuentaBancaria {

    /* ------------------------------ */
    /* Propiedades de la clase Cuenta */
    /* ------------------------------ */

    private double saldoCuenta;
    private String nombreTitular;
    private long numeroDeCuenta;
    private TipoCuenta tipoCuenta;
    private String cfechaUMov;
    private boolean habilitada;
    DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd/MM/yyy hh:mm");

    /* ------------------------------ */
    /* Constructor de la clase */
    /* CuentaBancaria */
    /* ------------------------------ */
    // public CuentaBancaria(String nombreDelTitular, long nrocta, double
    // saldoDeCuenta) {
    public CuentaBancaria(String nombreDelTitular, long nroCta, double saldoDeCuenta, TipoCuenta tCuenta) {
        this.nombreTitular = nombreDelTitular;
        this.saldoCuenta = saldoDeCuenta;
        this.numeroDeCuenta = nroCta;
        this.tipoCuenta = tCuenta;
        this.habilitada = true;
        this.cfechaUMov = "";
    }

    /* ------------------------------ */
    /* Setters */
    /* ------------------------------ */
    /* Setter para aumentar el saldo */
    /*-hacer un depósito- */
    /* ------------------------------ */

    public void setDeposito(Scanner data) throws IOException {
        char resp = 'N';
        double importe;
        do {
            System.out.print("Ingrese el importe a depositar: ");
            importe = data.nextDouble();
            if (importe <= 0) {
                System.out.println("El importe debe ser superior a cero Pesos");
                System.out.print("¿Desea Ingresar otro Importe? s/n ");
                resp = (char) System.in.read();
            } else {
                saldoCuenta = saldoCuenta + importe;
                this.cfechaUMov = fecha.format(LocalDateTime.now());
                this.mensExito();
            }
        } while (importe <= 0 && (resp == (char) 'S' || resp == (char) 's'));
    }

    /* ------------------------------ */
    /* Setter para disminuir el saldo */
    /* -Retira Dinero- */
    /* ------------------------------ */

    public boolean setRetiro(double importe) {
        if (this.saldoCuenta == 0 || this.saldoCuenta < importe) {
            return false;
        }
        if (importe <= 0)
            System.out.println("El importe debe ser superior a cero Pesos");
        else {
            saldoCuenta = saldoCuenta - importe;
            this.cfechaUMov = fecha.format(LocalDateTime.now());
            this.mensExito();
        }
        return true;
    }

    /* ------------------------------ */
    /* get tipocuenta */
    /* ------------------------------ */

    public TipoCuenta GetTipoCuenta() {
        return tipoCuenta;
    }

    /* ------------------------------ */
    /* set tipoCuenta */
    /* ------------------------------ */

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    /* ------------------------------ */
    /* Setter para Bloquear Cuenta */
    /* ------------------------------ */

    public void setBloqueoCta(boolean estado) {
        this.habilitada = estado;
    }

    /* ------------------------------ */
    /* Getters */
    /* ------------------------------ */
    /* getter para mostrar el saldo */
    /* ------------------------------ */
    public Double getSaldoCuenta() {
        return saldoCuenta;
    }

    public boolean getBloqueoCta() {
        return this.habilitada;
    }

    /* ------------------------------ */
    /* Datos de la Cuenta */
    /* ------------------------------ */
    public String toString() {
        return "xxxx";
    }

    public void mostrarCuenta() {
        System.out.println("Datos de la Cuenta");
        System.out.println("-------------");
        System.out.println("Titular: " + this.nombreTitular);
        System.out.printf("Nro Cuenta: " + "=%06d %n", this.numeroDeCuenta);
        /* Salida del Nro de Cuenta con formato */
        System.out.println("Tipo Cuenta: " + this.tipoCuenta);
        System.out.printf("Saldo: " + " = %.2f %n", this.saldoCuenta);
        /* Salida de Saldo con formato */
        String estado = this.habilitada ? "Habilitada" : "Bloqueada";
        /* Instruciión IF anidada */
        System.out.println("Estado: " + estado);
        System.out.println("Ultimo Movimiento: " + this.cfechaUMov);
    }

    public void mensExito() {
        System.out.println("Operación realizada Exitosamente!!!");
    }

    public boolean getEstadoCta() {
        if (!this.habilitada)
            System.out.println("No se puede realizar la operación\nLa cuenta se encuentra Bloqueada!!!");
        return this.habilitada;
    }
}