package clases.clase_4;
import java.util.Scanner;

public class Circulo {
    /*------------------------ */
    /* ATRIBUTOS DE LA CLASE */
    /*------------------------ */
    public double radio;
    public String colorBorde;
    public String colorFondo;

    /*----------------- */
    /* CONSTRUCTORES */
    /*------------------*/
    /* SIN ARGUMENTOS */
    /*------------------*/
    public Circulo() {
        this.radio = 0;
        this.colorBorde = "";
        this.colorFondo = "";
    }

    /*---------------------*/
    /* CON ARGUMENTOS */
    /*--------------------*/
    public Circulo(double r, String cb, String cf) {
        this.radio = r;
        this.colorBorde = cb;
        this.colorFondo = cf;
    }

    /*----------------------------------- */
    /* Muestra los atributos del Objeto */
    /*----------------------------------- */
    public String toString() {
        return "Circulo: \nradio=" + radio + "\ncolorBorde=" + colorBorde + "\ncolorFondo=" + colorFondo;
    }

    public void mostraDatos(){
            System.out.println("/*Datos del Círculo */");
            System.out.println("El radio es : " + this.radio);
            System.out.println("El color de borde es : " + this.colorBorde);
            System.out.println("El color de fondo es : " + this.colorFondo);
    }

    public double calculaPerimetro(){
        double perim;
        perim =  2 * Math.PI * this.radio;
        return perim;
    }

    public double calcularArea(){
        double area;
        area = Math.PI * Math.pow(this.radio,2);
        return area;
    }

    
    /*-------------------------------------------*/
    /* PROGRAMA PRINCIPAL */
    /*-------------------------------------------*/
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Circulo c1 = new Circulo();
        System.out.println(c1.toString());

        Circulo c2 = new Circulo(10,"Rojo","negro");
        System.out.println(c2.toString());      
        c2.mostraDatos(); 
        System.out.println("El perímetro es: " + c2.calculaPerimetro());
        
        /*Ingresamos datos por teclado   */

        System.out.print("\nIngrese radio: ");
        double radio = Double.parseDouble(scan.nextLine());
        System.out.print("Ingrese el color del borde: ");
        String colorBorde = scan.nextLine();
        System.out.print("Ingrese el color del fondo: ");
        String colorFondo = scan.nextLine();

        Circulo c3 = new Circulo(radio, colorBorde, colorFondo);
        c3.mostraDatos();
        System.out.println("El perímetro es: " + c3.calculaPerimetro());
        
        
        System.out.println("El area es: " + c3.calcularArea());

        scan.close();

    }

}
