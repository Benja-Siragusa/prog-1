package clases.clase_5;

import javax.swing.JOptionPane;

public class CuentaBancaria {
    private static int totalCuentas = 0;
    private String titularCuenta;
    private String numeroCuenta;
    private double saldo;
    private boolean estado;
    private TipoCuentas tipoCuentas;
    private static String NameBanco = "Mi Banco";

    public enum TipoCuentas {
        CAJA_AHORRO, 
        CUENTA_CORRIENTE, 
        CUENTA_SUELDO;
    }

    

    public CuentaBancaria() {
        this.titularCuenta = "";
        this.numeroCuenta = "";
        this.saldo = 0;
        this.estado = false;
        this.tipoCuentas = TipoCuentas.CUENTA_CORRIENTE;
        totalCuentas++;
    }

    public CuentaBancaria(String numeroCuenta, double saldo, TipoCuentas tipoCuentas) {
        this.titularCuenta = "";
        this.estado = true;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.tipoCuentas = tipoCuentas;
        totalCuentas++;
    }

    public CuentaBancaria( String numeroCuenta, TipoCuentas tipoCuentas) {
        this.titularCuenta = "";
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
        this.estado = true;
        this.tipoCuentas = tipoCuentas;
        totalCuentas++;
    }

    //setters

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setTipoCuentas(TipoCuentas tipoCuentas) {
        this.tipoCuentas = tipoCuentas;
    }

    //getters

    public static int getTotalCuentas() {
        return totalCuentas;
    }

    public String getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean getEstado() {
        return estado;
    }

    public TipoCuentas getTipoCuentas() {
        return tipoCuentas;
    }

    @Override
    public String toString() {
        return "CuentaBancaria [titularCuenta=" + titularCuenta + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo
                + ", estado=" + estado + ", tipoCuentas=" + tipoCuentas + "]";
    }

    public void mostrarDatosCuenta() {
        String borde="";
        for(int i= 1; i<30; i++)
            borde += "═";
        String cMensaje = String.format(
                "%s\n DATOS DE LA CUENTA \n%s \nNro de cuenta: %s \nTitular de la Cuenta: %s \nTipo Cuenta: %s \nSaldo: %,.2f \nEstado: %s",
                borde,borde,this.numeroCuenta, this.titularCuenta, this.tipoCuentas, this.saldo, (this.estado ? "Habilitada" : "Deshabilitada"));
        this.mensajesBanco(cMensaje, NameBanco, 1);
    }


    public void depositar(double monto) {
        String cMensaje = "";
        if (this.estado) {
            this.saldo += monto;
            cMensaje = String.format("El depósito se realizó correctamente \nCuenta: %s\nNuevo saldo es de $ %,.2f",
                    this.numeroCuenta, this.saldo);
            this.mensajesBanco(cMensaje, NameBanco, 1);
        } else {
            cMensaje = "La cuenta está inactiva.";
            this.mensajesBanco(cMensaje, NameBanco, 0);
        }
    }
    
    public void retirar(double monto) {
        String cMensaje = "";
        if (this.estado) {
            if (this.saldo >= monto) {
                this.saldo -= monto;
                cMensaje = String.format("Se ha retirado $ %,.2f de la Cuenta %s", monto, this.numeroCuenta);
                this.mensajesBanco(cMensaje, NameBanco, 1);
            } else {
                this.mensajesBanco("Saldo Insuficiente", NameBanco, 0);
            }
        } else {
            this.mensajesBanco("La cuenta está inactiva.", NameBanco, 0);
        }
    }
    
    public void desactivarCuenta() {
        String cMensajeDes = String.format("La Cuenta Nº %s se ha Desactivado", this.numeroCuenta);
        String cMensaje = "";
        if (this.saldo > 0 && this.estado) {
            int respuesta = JOptionPane.showConfirmDialog(null, "Su cuenta posee saldo, desea desactivarla?",
                    NameBanco,JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                this.estado=false;
            } else {
                cMensaje = String.format("La Cuenta Nº %s no ha Desactivada porque tiene saldo $ %,.2f",
                        this.numeroCuenta, this.saldo);
                this.mensajesBanco(cMensaje, NameBanco, 0);
            }
        } else {
            if (this.estado) {
                this.mensajesBanco(cMensajeDes, NameBanco, 0);
            }
        }
    }
    
    public void activarCuenta(){
        if (this.estado){
            this.mensajesBanco("la cuenta ya esta activa", "Activacion denegada", 1);
            }else{
                this.mensajesBanco("hemos habilitado su cuenta, gracias!", "cuenta activada", 1);
            }
    }

    public void cargarCuenta(){
        this.titularCuenta=JOptionPane.showInputDialog(null,"ingrese el nombre que sera titular de la cuenta","cargando nombre",1);
        setNumeroCuenta(JOptionPane.showInputDialog(null,"ingrese el numero de cuenta que desea","cargando numero de cuenta",1));
        setSaldo(Double.parseDouble(JOptionPane.showInputDialog(null,"ingrese el saldo q ingresara a su cuenta","cargando saldo",1)));
        setEstado(true);
        String[] opciones = { "CAJA_AHORRO", "CUENTA_CORRIENTE", "CUENTA_SUELDO" };
            String seleccion = (String) JOptionPane.showInputDialog(null,
                    "Seleccione el tipo de cuenta que desea:",
                    "tipo de cuenta",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);
            TipoCuentas i = CuentaBancaria.TipoCuentas.valueOf(seleccion);
            this.setTipoCuentas(i);
    }

    private void mensajesBanco(String cMensage, String cTitle, int tipoMensaje) {
        JOptionPane.showMessageDialog(null, cMensage, cTitle, tipoMensaje);
    }
}
