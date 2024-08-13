package unidad1.actProceso;
import java.util.Scanner;

/*El factorial de un número entero se denota de la siguiente manera "n!" y su resultado es n!=n*(n-1)*(n-2)*1. 
Por ejemplo: 5!=5*4*3*2*1 siendo el resultado 120. Se pide desarrollar un programa en Java que lea 
un valor N por teclado y determine su factorial. Utilice ciclo for() y while(). */

public class act1_2 {
    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);
        int i=1,num,factorial;
        System.out.println("digame el numero al que le calcularemos el factorial");
        factorial = num = sc.nextInt();
        /*for (int i=num-1;i>=2;i--){
            factorial*=i;
        }*/
        while (i < num) {
            for (int j = i; j <= i; j++) {
                factorial *= j;
            }
            i++;
        }
        System.out.println("el factorial de "+num+" es "+factorial);
    }
}