package unidades.unidad1.actProceso.actividad1;
import java.util.Scanner;

/*El factorial de un número entero se denota de la siguiente manera "n!" y su resultado es n!=n*(n-1)*(n-2)*1. 
Por ejemplo: 5!=5*4*3*2*1 siendo el resultado 120. Se pide desarrollar un programa en Java que lea 
un valor N por teclado y determine su factorial. Utilice ciclo for() y while(). */

public class act1_2 {
    public static void main(String[] ar) {
        int n=numero();
        System.out.println(factorial(n));
    }
    public static int numero(){
        Scanner sc = new Scanner(System.in);
        System.out.print("digame el numero al que le calcularemos el factorial: ");
        return(sc.nextInt());
    }
    public static int factorial(int num){
        int  i=1, factorial=num;
        while (i<num){
            for (int j = i; j <= i; j++) {
                factorial *= j;
            }
            i++;
        }
        return factorial;
    }
}