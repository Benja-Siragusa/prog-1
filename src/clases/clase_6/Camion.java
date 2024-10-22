package clases.clase_6;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Camion extends Vehiculo {
    private double tara;
    private double pesoCarga;
    private String numeroEjes;

    public Camion(String marca, String modelo, String color, double consumoCombustible, double velocidadMaxima,
            double tara, double pesoCarga, String numeroEjes) {

        super(marca, modelo, color, consumoCombustible, velocidadMaxima); // reutiliza el constructor padre
        this.tara = tara;
        this.pesoCarga = pesoCarga;
        this.numeroEjes = numeroEjes;
    }

    public Camion() {
        super();
        this.tara = 0;
        this.pesoCarga = 0;
        this.numeroEjes = "2";
    }

    public void cargar(Scanner sc) {
        super.cargar(sc); // reutiliza el metodo padre
        System.out.print("Cargue tara: ");
        this.tara = super.cargarDouble(sc);
        System.out.print("Cargue peso: ");
        this.pesoCarga = super.cargarDouble(sc);
        System.out.print("Cargue número de ejes: ");
        this.numeroEjes = sc.nextLine();
    }

    public void mostrar() {
        String mensaje = String.format("Marca : %s \n" +
                "Modelo: %s  \n" +
                "Color: %s \n" +
                "Velocidad Maxima: %.2f \n" +
                "Consumo Combustible: %.2f \n" +
                "Tara: %f \n" +
                "Peso: %s  \n" +
                "Número de ejes: %s \n", super.getMarca(), super.getModelo(), super.getColor(),
                super.getVelocidadMaxima(),
                super.getConsumoCombustible(), this.tara, this.pesoCarga, this.numeroEjes);

        JOptionPane.showMessageDialog(null, mensaje, "Mostrando datos", JOptionPane.INFORMATION_MESSAGE);
    }
}
