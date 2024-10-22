package clases.clase_6;

import javax.swing.JOptionPane;

import java.util.Scanner;

public class demoVehiculo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vehiculo v1 = new Vehiculo();
        v1.cargar(sc);
        v1.mostrarVehiculo();       
        JOptionPane.showMessageDialog(null,"Cantidad de vehiculos: " +Vehiculo.getCantidadVehiculos(),"Mensaje",1);

        sc.close();
    }

}
