package unidad2;

import javax.swing.JOptionPane;

/*Crear una clase llamada Circulo que tenga las siguientes características:
Atributos:
    radio
    color fondo
Métodos:
    Constructor sin argumentos.
    Constructor con argumentos.
    cargaDatosCirculo(),
    calcularArea()
    calcularPerimetro()
    mostarDatos().
Desde un programa principal (main) instancie 3 objetos de la clase Círculo.
Para todos los objetos
    Mostrar datos.
    Calcular Área y Mostrar.
    Calcular Perímetro y Mostrar.
Objeto 1:
    Utilizar constructor sin Argumentos.
Objeto 2:
    Utilizar constructor con Argumentos,
    Cargar los datos desde el Programa principal.
Objeto 3:
    Cargar los datos desde el método de la clase.
Utilice la librería JOptionPane o Scanner. */

public class Circulo {

    // atributos
    public double radio;
    public String colorFondo;

    // constructores
    // sin argumentos
    public Circulo() {
        this.radio = 0;
        this.colorFondo = "";
    }

    // con argumentos
    public Circulo(double r, String cf) {
        this.radio = r;
        this.colorFondo = cf;
    }

    // cargar datos
    public Circulo cargarDatosCirculo() {
        this.radio = Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese el radio del circulo",
                "pedir radio metodo", JOptionPane.INFORMATION_MESSAGE));
        this.colorFondo = JOptionPane.showInputDialog(null, "ingrese el color de fondo del circulo",
                "pedir color fondo metodo", JOptionPane.INFORMATION_MESSAGE);

        return this;
    }

    // calcular area
    public double calcularArea() {
        return (Math.PI * (Math.pow(this.radio, 2)));
    }

    // calcular perimetro
    public double calculaPerimetro() {
        return (2 * Math.PI * this.radio);
    }

    // mostrar datos
    public void mostraDatos() {
        JOptionPane.showMessageDialog(null,
                "radio del circulo: " + this.radio + "\ncolor del fondo del circulo: " + this.colorFondo,
                "mostrar datos", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {

        // primer circulo
        JOptionPane.showMessageDialog(null, "vamos con el primer ciruclo", "CIRCULO NR1",
                JOptionPane.INFORMATION_MESSAGE);
        Circulo c1 = new Circulo();
        c1.mostraDatos();
        JOptionPane.showMessageDialog(null,
                "el area es: " + c1.calcularArea() + "\nel perimetro es: " + c1.calculaPerimetro(), "perimetro y radio",
                JOptionPane.DEFAULT_OPTION);

        // segundo circulo
        JOptionPane.showMessageDialog(null, "vamos con el segundo ciruclo", "CIRCULO NR2",
                JOptionPane.INFORMATION_MESSAGE);
        try {
            double r = Double
                    .parseDouble(JOptionPane.showInputDialog(null, "digame el radio del circulo", "pedir radio",
                            JOptionPane.INFORMATION_MESSAGE));
            String cf = JOptionPane.showInputDialog(null, "digame el color de fondo del circulo",
                    "pedir color de fondo",
                    JOptionPane.INFORMATION_MESSAGE);
            Circulo c2 = new Circulo(r, cf);
            c2.mostraDatos();
            JOptionPane.showMessageDialog(null,
                    "el area es: " + c2.calcularArea() + "\nel perimetro es: " + c2.calculaPerimetro(),
                    "perimetro y radio",
                    JOptionPane.DEFAULT_OPTION);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro en el ingreso de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        // tercer circulo
        try {
            JOptionPane.showMessageDialog(null, "vamos con el tercer ciruclo", "CIRCULO NR3",
                    JOptionPane.INFORMATION_MESSAGE);
            Circulo c3 = new Circulo();
            c3.cargarDatosCirculo();
            c3.mostraDatos();
            JOptionPane.showMessageDialog(null,
                    "el area es: " + c3.calcularArea() + "\nel perimetro es: " + c3.calculaPerimetro(),
                    "perimetro y radio",
                    JOptionPane.DEFAULT_OPTION);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro en el ingreso de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }
}
