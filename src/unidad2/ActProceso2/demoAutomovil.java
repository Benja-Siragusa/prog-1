package unidad2.ActProceso2;
//Benjamin Nicolas Siragusa Arbeloa.

import javax.swing.JOptionPane;

public class demoAutomovil {
    public static void main(String[] args) {
        // OBJETO 1(CONSTRUCTOR SIN PARAMETROS)
        JOptionPane.showMessageDialog(
                null, "auto numero 1", "numero auto de auto", 1);
        Automovil auto1 = new Automovil();
        auto1.impormirDetalles();
        auto1.cargarDatos();
        auto1.impormirDetalles();

        // OBJETO 2(CONSTRUCTOR SOBRECARGADO)
        JOptionPane.showMessageDialog(null, "auto numero 2", "numero auto de auto", 1);
        Automovil auto2 = new Automovil("toyota", "corolla", Automovil.Combustible.DIESEL);
        auto2.impormirDetalles();
        auto2.setMarca("renault");
        auto2.setModelo("clio");
        auto2.setPrecio(2000);
        JOptionPane.showMessageDialog(null, "la marca ahora es "+auto2.getMarca(), "nueva marca", 1);
        auto2.impormirDetalles();
        double velocidad2=Double.parseDouble(JOptionPane.showInputDialog(null,"ingrese a cuanto va el vehiculo: ","preguntar velocidad",1));
        double incremento2=Double.parseDouble(JOptionPane.showInputDialog(null,"ingrese cuanto desea acelerar: ","preguntar velocidad",1));
        auto2.acelerar(velocidad2, incremento2);
        JOptionPane.showMessageDialog(null, "cantidad de automoviles:" + Automovil.getCantidadAutos(),
                "cantidad de automoviles", 1);
        // OBJETO 3(CONSTRUCTOR CON TODOS LOS PARAMETROS)
        JOptionPane.showMessageDialog(null, "auto numero 3", "numero auto de auto", 1);
        Automovil auto3 = new Automovil("Peugeot", "408", Automovil.Combustible.GASOLINA, 600000., 180., false);
        auto3.impormirDetalles();
        double velocidad3=Double.parseDouble(JOptionPane.showInputDialog(null,"ingrese a cuanto va el vehiculo: ","preguntar velocidad",1));
        double decremento3=Double.parseDouble(JOptionPane.showInputDialog(null,"ingrese cuantos km/h quiere frenar ","preguntar velocidad",1));
        auto2.frenar(velocidad3, decremento3);
        JOptionPane.showMessageDialog(null, "cantidad de automoviles:" + Automovil.getCantidadAutos(),
                "cantidad de automoviles", 1);

        Automovil autoMayorPrecio = auto1.getPrecio() > auto2.getPrecio() && auto1.getPrecio() > auto3.getPrecio()
                ? auto1
                : (auto2.getPrecio() > auto3.getPrecio() ? auto2 : auto3);
        JOptionPane.showMessageDialog(null, "Automóvil de mayor precio: " + autoMayorPrecio.getMarca() + " - Precio: $"
                + autoMayorPrecio.getPrecio());
    }
}
