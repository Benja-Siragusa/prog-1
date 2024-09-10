package unidad1.actIntegradora;


/*Una empresa gastronómica proporciona un bono mensual a sus trabajadores, el cual puede ser por su antigüedad 
(multiplicada por 500) o bien por el monto de su sueldo (el que sea mayor), de la siguiente forma:
    Cuando la antigüedad es mayor a 2 años, pero menor a 5, se otorga 20 % de su sueldo; cuando es de 5 años 
    más, 30 %. Ahora bien, el bono por concepto de sueldo, si éste es menor a $1000, se da 25 % de éste, 
    cuando éste es mayor a $1000, pero menor o igual a $3500, se otorga 15% de su sueldo, para más de $3500. 10%. 
    Escribir un programa en Java que permita calcular los dos tipos de bono de acuerdo a lo estipulado.

Utilizar JOptionPane para el ingreso de datos y salida por pantalla. */

import javax.swing.JOptionPane;

public class actInt1 {
    public static void main(String[] args) {
        int respuesta;
        Double sueldo = 0.0, antiguedad = 0.0, bonoMayor = 0.0;
        do {

            try {
                sueldo = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese sueldo :", "SUELDO",
                        JOptionPane.INFORMATION_MESSAGE));

                antiguedad = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese antigüedad :", "ANTIGUEDAD",
                        JOptionPane.INFORMATION_MESSAGE));

                if (sueldo < 0 || antiguedad < 0) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Error in el ingreso de datos. Vuelva a ingresarlo.",
                            "Error de entrada",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        null,
                        "Error in el ingreso de datos.",
                        "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
            if (bonoAntig(sueldo, antiguedad) > bonoSueldo(sueldo))
                bonoMayor = bonoAntig(sueldo, antiguedad);
            else
                bonoMayor = bonoSueldo(sueldo);
            JOptionPane.showMessageDialog(null, "El bono por sueldo es de: " + bonoSueldo(sueldo) + "$\n"
                    + "El bono por antigüedad es de: " + bonoAntig(sueldo, antiguedad) + "$\n"
                    + "a usted le corresponde el bono mayor, que es de: " + bonoMayor + "$\n"
                    + "Su sueldo con el bono seria de: " + (bonoMayor + sueldo) + "$");

            respuesta = JOptionPane.showConfirmDialog(null, "quiere repetir la consulta?",
                    "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);

        } while (respuesta == JOptionPane.YES_OPTION);
    }

    private static Double bonoSueldo(Double sueldo) {
        if (sueldo <= 1000) {
            return sueldo * .25;
        } else if (sueldo > 1000 && sueldo <= 3500) {
            return sueldo * .15;
        } else if (sueldo > 3500) {
            return sueldo * .10;
        }
        return 0.0;
    }

    private static Double bonoAntig(Double sueldo, Double antiguedad) {

        Double totalAntiguedad = antiguedad * 500;
        double max = Math.max(sueldo, totalAntiguedad);

        if (antiguedad > 2 && antiguedad <= 5) {
            return max * .20;
        } else if (antiguedad > 5) {
            return max * .30;
        }
        return 0.0;
    }

}
