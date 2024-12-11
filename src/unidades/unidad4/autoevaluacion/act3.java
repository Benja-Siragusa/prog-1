package unidades.unidad4.autoevaluacion;

import javax.swing.JOptionPane;

/*Escribir un programa que permita cargar dos arreglos unidimensionales (vectores) de n elementos cada uno, el 
primero conteniendo el legajo y el segundo la nota de cada alumno. Se quiere saber que alumnos tienen 
una nota mayor al número K ingresado desde el teclado. */

public class act3 {
    public static void main(String[] args) {
        int[] legajo, nota;
        int i, k, n, cantidad=0;
        n = Integer.parseInt(
                JOptionPane.showInputDialog(null, "ingrese la cantidad de alumnos que hay: ", "cantidad alumnos", 1));
        k = Integer.parseInt(
                JOptionPane.showInputDialog(null, "ingrese la nota minima para aprobar: ", "nota minima", 1));
        legajo = new int[n];
        nota = new int[n];
        for (i = 0; i < n; i++) {
            legajo[i]= Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese el numero de legajo del alumno: ","numero legajo ",1));
            nota[i]= Integer.parseInt(JOptionPane.showInputDialog(null,"ingrese la nota del alumno: ","nota",1));
            if (nota[i]>k){
                JOptionPane.showMessageDialog(null, "el alumno esta aprobado", "aprobado", 1);
                cantidad++;
            } else{
                JOptionPane.showMessageDialog(null, "el alumno esta reprobado", "reprobado", 1);
            }
        }
        JOptionPane.showMessageDialog(null, "la cantidad de alumnos aprobados es de "+cantidad+" alumnos de un total de "+legajo.length+" alumnos", "cantidad aprobados", 1);
    }
}
