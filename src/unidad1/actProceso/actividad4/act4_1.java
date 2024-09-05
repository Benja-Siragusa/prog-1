package unidad1.actProceso.actividad4;

/* Escriba un Programa en Java que permita determinar qué cantidad de dinero hay en una 
caja registradora, considerando que se tienen monedas de diez, cinco 
y un peso, y billetes de cien, doscientos y quinientos pesos.*/

import javax.swing.JOptionPane;

public class act4_1 {
    public static void main(String[] args) {
        try {
            int b500 = billetes500(), b200 = billetes200(), b100 = billetes100(), m10 = monedas10(), m5 = monedas5(),
                    m1 = monedas1();
            JOptionPane.showMessageDialog(null,
                    "usted tiene:\n\t" + b500 + " billetes de 500$, total de: " + (b500 * 500) + "$\n\t" + b200
                            + " billetes de 200$, total de: " + (b200 * 200) + "$\n\t" + b100
                            + " billetes de 100$, total de: " + (b100 * 100) + "$\n\t" + m10
                            + " monedas de 10$, total de: " + (m10 * 10) + "$\n\t" + m5 + " monedas de 5$, total de: "
                            + (m5 * 5) + "$\n\t" + m1 + " monedas de 1$, total de: " + m1 + "$\n\ttotal de caja: "
                            + (b500 * 500 + b200 * 200 + b100 * 100 + m10 * 10 + m5 * 5 + m1) + "$",
                    "TOTAL DE CAJA", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "debe ingresar la cantidad de billetes y monedas en valores numericos",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static int billetes500() {
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la cantidad de billetes de 500 que tenga",
                "billetes 500", JOptionPane.QUESTION_MESSAGE));
        return n;
    }

    public static int billetes200() {
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la cantidad de billetes de 200 que tenga",
                "billetes 200", JOptionPane.QUESTION_MESSAGE));
        return n;
    }

    public static int billetes100() {
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la cantidad de billetes de 100 que tenga",
                "billetes 100", JOptionPane.QUESTION_MESSAGE));
        return n;
    }

    public static int monedas10() {
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la cantidad de monedas de 10 que tenga",
                "monedas 10", JOptionPane.QUESTION_MESSAGE));
        return n;
    }

    public static int monedas5() {
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la cantidad de monedas de 5 que tenga",
                "monedas 5", JOptionPane.QUESTION_MESSAGE));
        return n;
    }

    public static int monedas1() {
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese la cantidad de monedas de 1 que tenga",
                "monedas 1", JOptionPane.QUESTION_MESSAGE));
        return n;
    }
}