package unidad2.ActProceso2;
//Benjamin Nicolas Siragusa Arbeloa.

import javax.swing.JOptionPane;

public class Automovil {

    // ATRIBUTOS
    private String marca;
    private String modelo;
    private Combustible tipoCombustible;
    private double precio;
    private static int cantidadAutos = 0;
    private double velocidadMaxima;
    private boolean importado;

    public enum Combustible {
        GASOLINA, DIESEL, ELECTRICO
    }

    // CONSTRUCTORES
    // SIN PARAMETROS
    public Automovil() {
        this.marca = "Volkswagen";
        this.modelo = "Golf";
        this.tipoCombustible = Combustible.GASOLINA;
        this.precio = 20000;
        cantidadAutos++;
        this.velocidadMaxima = 180;
        this.importado = false;
    }

    // SOBRECARGADO
    public Automovil(String marca, String modelo, Combustible combustible) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipoCombustible = combustible;
        this.precio = 15000;
        cantidadAutos++;
        this.velocidadMaxima = 180;
        this.importado = false;
    }

    // CON TODOS LOS PARAMETROS
    public Automovil(String marca, String modelo, Combustible combustible, double precio,
            double velocidadMaxima, boolean importado) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipoCombustible = combustible;
        this.precio = precio > 500000 ? 500000 : precio; // Limitar el precio cantidadAutos++;
        this.velocidadMaxima = velocidadMaxima;
        this.importado = importado;
        cantidadAutos++;
    }

    // METODOS

    public void cargarDatos() {
        try {
            String marca = JOptionPane.showInputDialog(null, "Ingrese la marca del vehiculo", "ingresando marca",
                    JOptionPane.INFORMATION_MESSAGE);
            this.setMarca(marca);
            String modelo = JOptionPane.showInputDialog(null, "Ingrese el modelo del vehiculo", "ingresando modelo",
                    JOptionPane.INFORMATION_MESSAGE);
            this.setModelo(modelo);
            String[] opciones = { "GASOLINA", "DIESEL", "ELECTRICO" };
            String seleccion = (String) JOptionPane.showInputDialog(null,
                    "Seleccione el tipo de combustible:",
                    "Carga de Combustible",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);
            Combustible combustible = Automovil.Combustible.valueOf(seleccion);
            this.setTipoCombustible(combustible);
            Double precio = Double.parseDouble(
                    JOptionPane.showInputDialog(null, "Ingrese el precio del vehiculo", "ingresando precio",
                            JOptionPane.INFORMATION_MESSAGE));
            this.setPrecio(this.precio = precio > 500000 ? 500000 : precio);
            Double velocidadMaxima = Double.parseDouble(
                    JOptionPane.showInputDialog(null, "Ingrese la velocidad maxima", "ingresando velocidad maxima",
                            JOptionPane.INFORMATION_MESSAGE));
            this.setVelocidadMaxima(velocidadMaxima);
            String importadoStr = JOptionPane.showInputDialog(null, "es importado el vehiculo? (si o no)",
                    "ingresando importado", JOptionPane.INFORMATION_MESSAGE);
            Boolean importado = false;
            switch (importadoStr) {
                case "si":
                case "SI":
                case "Si":
                    importado = true;
                    break;
                case "no":
                case "NO":
                case "No":
                    importado = false;
                    break;
            }
            this.setImportado(importado);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingrese un número válido para el precio o la velocidad máxima.",
                    "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Valor inválido",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Para obtener más detalles en la consola
        }

    }

    public void impormirDetalles() {
        JOptionPane.showMessageDialog(null,
                "marca: " + this.marca + "\nmodelo: " + this.modelo + "\ncombustible tipo: " + this.tipoCombustible
                        + "\npercio: " + this.precio + "$\nvelocidad maxima: " + this.velocidadMaxima
                        + "kmph\nimportado: " + this.importado,
                "imprimir detalles", JOptionPane.INFORMATION_MESSAGE);
    }

    public static int getCantidadAutos() {
        return cantidadAutos;
    }

    public void acelerar(double velocidad, double incremento) {
        try {
            if (incremento < 0) {
                JOptionPane.showMessageDialog(null, "sebe ingresar un valor positivo", "acelerar",
                        JOptionPane.ERROR_MESSAGE);
                        
            }
            else if (incremento > this.velocidadMaxima) {
                JOptionPane.showMessageDialog(null, "velocidad incrementada a " + this.velocidadMaxima + "kmph",
                        "acelerar", JOptionPane.INFORMATION_MESSAGE);
            }
            else if ((incremento+velocidad) > this.velocidadMaxima) {
                JOptionPane.showMessageDialog(null, "velocidad incrementada a " + this.velocidadMaxima + "kmph", "acelerar",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "velocidad incrementada a " + (velocidad+incremento) + "kmph", "acelerar",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "debe ingresar valores numericos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void frenar(double velocidad, double decremento) {
        if (velocidad>velocidadMaxima) {
            JOptionPane.showMessageDialog(null, "la velocidad no puede ser mayor a la maxima permitida", "frenar",
                        JOptionPane.ERROR_MESSAGE);
        }
    else if(decremento<0){
        JOptionPane.showMessageDialog(null, "la velocidad no puede ser negativa", "frenar",
                        JOptionPane.ERROR_MESSAGE);
    }else if (velocidad < decremento) {
            JOptionPane.showMessageDialog(null, "la velocidad resultante no puede ser negativa", "frenar",
                        JOptionPane.ERROR_MESSAGE);
        } else if (velocidad - decremento < 0){
            JOptionPane.showMessageDialog(null, "la velocidad resultante no puede ser negativa", "frenar",
                        JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "la velocidad se redujo a "+(velocidad-decremento), "frenar",
            JOptionPane.INFORMATION_MESSAGE);}
    }

    // setters y getters

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setTipoCombustible(Combustible combustible) {
        this.tipoCombustible = combustible;
    }

    public Combustible getCombustible() {
        return tipoCombustible;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setVelocidadMaxima(double velocidad) {
        this.velocidadMaxima = velocidad;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setImportado(boolean i) {
        this.importado = i;
    }

    public boolean getImportado() {
        return importado;
    }

}