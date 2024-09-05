package clases.clase_1;
import java.util.*;

public class ejemploos{
    public static void main (String[] ar){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número: ");
        int number = scanner.nextInt();

        // Aquí se consume el carácter de nueva línea después de ingresar el número
        scanner.nextLine(); // Esto limpia el buffer del carácter de nueva línea

        System.out.print("Ingrese un texto: ");
        String text = scanner.nextLine(); // Lee la cadena de texto correctamente

        System.out.println("Número ingresado: " + number);
        System.out.println("Texto ingresado: " + text);

        scanner.close();
    }
}