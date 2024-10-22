package clases.clase_6;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Vehiculo {
    private String marca;
    private String modelo;
    private String color;
    private double consumoCombustible;
    private double velocidadMaxima;
    private static int cantVehiculos = 0;

    /*--------------------------------*/
    /* CONSTRUCTOR SIN ARGUMENTOS */
    /*--------------------------------*/
    public Vehiculo() {
        this.marca = "";
        this.modelo = "";
        this.color = "";
        this.consumoCombustible = 0;
        this.velocidadMaxima = 0;
        Vehiculo.cantVehiculos++;
    }

    /*--------------------------------*/
    /* CONSTRUCTOR CON ARGUMENTOS */
    /*--------------------------------*/
    public Vehiculo(String marca, String modelo, String color, double consumoCombustible, double velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.consumoCombustible = consumoCombustible;
        this.velocidadMaxima = velocidadMaxima;
        Vehiculo.cantVehiculos++;
    }

    /*--------------------------------*/
    /* GETTERS */
    /*--------------------------------*/

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public double getConsumoCombustible() {
        return consumoCombustible;
    }

    public String getMarca() {
        return marca;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public static int getCantidadVehiculos() {
        return cantVehiculos;
    }

    /*--------------------------------*/
    /* SETTERS */
    /*--------------------------------*/
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setConsumoCombustible(double consumoCombustible) {
        this.consumoCombustible = consumoCombustible;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    /*--------------------------------*/
    /* OTROS METODOS */
    /*--------------------------------*/
    public void cargar(Scanner sc) {
        System.out.print("Ingrese la marca del vehículo: ");
        this.marca = sc.nextLine();
        System.out.print("Ingrese el modelo del vehículo: ");
        this.modelo = sc.nextLine();
        System.out.print("Ingrese el color del vehículo: ");
        this.color = sc.nextLine();
        System.out.print("Ingrese la velocidad maxima del vehículo: ");
        this.velocidadMaxima = cargarDouble(sc);
        System.out.print("Ingrese el consumo combustible del vehículo: ");
        this.consumoCombustible = cargarDouble(sc);
    }

    public void mostrarVehiculo() {
        String mensaje = String.format("Marca : %s \n" +
                "Modelo: %s  \n" +
                "Color: %s \n" +
                "Velocidad Maxima: %.2f \n" +
                "Consumo Combustible: %.2f ", this.marca, this.modelo, this.color, this.velocidadMaxima,
                this.consumoCombustible);

        JOptionPane.showMessageDialog(null, mensaje, "Mostrando datos", 1);
    }

    /*--------------------------------*/
    /* CARGAR DOUBLE */
    /*--------------------------------*/
    protected double cargarDouble(Scanner scan) {
        double dato = 0;
        boolean error = false;
        do {
            error = false;
            try {
                dato = Double.parseDouble(scan.nextLine());
            } catch (Exception e) {
                error = true;
                System.out.println("Debe ingresar un valor numerico");
            }
        } while (error);
        return dato;
    }

}
