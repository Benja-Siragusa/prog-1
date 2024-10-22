package unidad2;

import javax.swing.JOptionPane;

public class Rectangulo {
    public double largo;
    public double ancho;
    public String colorFondo;

    // constructores
    // sin argumentos
    public Rectangulo() {
        this.largo = 0;
        this.ancho = 0;
        this.colorFondo = "rojo";
    }

    // con argumentos
    public Rectangulo(double l, double a) {
        this.largo = l;
        this.ancho = a;
        this.colorFondo = "rojo";
    }

    // cargar datos
    public Rectangulo cargarDatosRectangulo() {
        this.largo = Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese el largo del rectangulo",
                "pedir largo metodo", JOptionPane.INFORMATION_MESSAGE));
        this.ancho = Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese el ancho del rectangulo",
                "pedir ancho metodo", JOptionPane.INFORMATION_MESSAGE));
        return this;
    }

    // calcular area
    public double calcularArea() {
        return (this.ancho * this.largo);
    }

    // calcular radio
    public double calcularPerimetro() {
        return ((this.ancho * 2) + (this.largo * 2));
    }

    // mostrar datos
    public void mostrarDatos() {
        JOptionPane.showMessageDialog(null,
                "ancho del rectangulo: " + this.ancho + "\nlargo del rectangulo: " + this.largo
                        + "\ncolor de fondo del rectangulo: " + this.colorFondo,
                "mostrar datos metodo", JOptionPane.INFORMATION_MESSAGE);
    }

    //modificar fondo
    public Rectangulo modificarColorFondo() {
        this.colorFondo = JOptionPane.showInputDialog(null, "ingrese el nuevo color del rectangulo", "modificar color",
                JOptionPane.INFORMATION_MESSAGE);
        return this;
    }

    public static void main(String[] args) {

        // primer rectnagulo
        JOptionPane.showMessageDialog(null, "vamos con el primer rectangulo", "RECTANGULO NR1",
                JOptionPane.INFORMATION_MESSAGE);
        Rectangulo r1 = new Rectangulo();
        r1.mostrarDatos();
        JOptionPane.showMessageDialog(null,
                "el area es: " + r1.calcularArea() + "\nel perimetro es: " + r1.calcularPerimetro(),
                "perimetro y radio", JOptionPane.DEFAULT_OPTION);

        // segundo rectnagulo
        try {
            JOptionPane.showMessageDialog(null, "vamos con el segundo rectangulo", "RECTANGULO NR2",
                    JOptionPane.INFORMATION_MESSAGE);
            double a = Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese el ancho del rectangulo",
                    "pedir ancho", JOptionPane.INFORMATION_MESSAGE));
            double l = Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese el largo del rectangulo",
                    "pedir largo", JOptionPane.INFORMATION_MESSAGE));
            Rectangulo r2 = new Rectangulo(l, a);
            r2.mostrarDatos();
            JOptionPane.showMessageDialog(null,
                    "el area es: " + r2.calcularArea() + "\nel perimetro es: " + r2.calcularPerimetro(),
                    "perimetro y radio", JOptionPane.DEFAULT_OPTION);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro en el ingreso de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        // tercer rectnagulo
        try {
            JOptionPane.showMessageDialog(null, "vamos con el tercer rectangulo", "RECTANGULO NR3",
                    JOptionPane.INFORMATION_MESSAGE);
            Rectangulo r3 = new Rectangulo();
            r3.cargarDatosRectangulo();
            r3.modificarColorFondo();
            r3.mostrarDatos();
            JOptionPane.showMessageDialog(null,
                    "el area es: " + r3.calcularArea() + "\nel perimetro es: " + r3.calcularPerimetro(),
                    "perimetro y radio", JOptionPane.DEFAULT_OPTION);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro en el ingreso de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
}
