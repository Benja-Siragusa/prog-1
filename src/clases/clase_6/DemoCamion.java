package clases.clase_6;
import java.util.Scanner;

public class DemoCamion {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Camion c1 = new Camion();
        c1.cargar(sc);
        c1.mostrar();
        sc.close();
    }
}
