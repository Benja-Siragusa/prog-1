package unidades.tp_integrador.AO2_Siragusa_Flores.actividad_2;

import javax.swing.JOptionPane;

import unidades.tp_integrador.AO2_Siragusa_Flores.actividad_1.librerias.Egreso;
import unidades.tp_integrador.AO2_Siragusa_Flores.actividad_1.librerias.Ingreso;

public class Curso {
    private String nombreCurso;
    private int duracion;
    private int matriculaAlumnos;
    private static double costoPorEstudiante = 1000;
    private double costoTotal;
    // CONSTRUCTORES

    public Curso() {
        this.nombreCurso = "";
        this.duracion = 0;
        this.matriculaAlumnos = 0;
        this.costoTotal=0;
    }

    public Curso(String nombreCurso, int duracion, int matriculaAlumnos,double costoTotal) {
        this.nombreCurso = nombreCurso;
        this.duracion = duracion;
        this.matriculaAlumnos = matriculaAlumnos;
        this.costoTotal=costoTotal;
    }

    // METODOS

    public void cargarCurso(Curso c) {
        c.setNombreCurso(Ingreso.pedirString("Ingrese el nombre del curso", "NOMBRE"));
        c.setDuracion(Ingreso.pedirEntero("ingrese la duracion en horas del curso", "DURACION"));
        c.setMatriculaAlumnos(Ingreso.pedirEntero("ingrese la cantidad de alumnos", "ALUMNOS"));
        c.setCostoTotal(this.getCostoPorEstudiante()*this.getMatriculaAlumnos());
    }
    
    public void mostrarCurso(Curso c) {
        String mensaje = "Nombre: " + this.getNombreCurso() + "\nDuración: " + this.getDuracion()
                + " horas\nMatrícula de alumnos: " + this.getMatriculaAlumnos() + "\nCosto por estudiante: $"
                + this.getCostoPorEstudiante();
        Egreso.mostrarMensaje(mensaje, "Información del Curso");
    }

    // GETTERS

    public String getNombreCurso() {
        return nombreCurso;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getMatriculaAlumnos() {
        return matriculaAlumnos;
    }

    public double getCostoPorEstudiante() {
        return costoPorEstudiante;
    }

    public double getCostoTotal(){
        return costoTotal;
    }


    // SETTERS

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setMatriculaAlumnos(int matriculaAlumnos) {
        this.matriculaAlumnos = matriculaAlumnos;
    }

    public void setCostoPorEstudiante(double n){
        costoPorEstudiante=n;
    }

    public void setCostoTotal(double costoTotal){
        this.costoTotal=costoTotal;
    }

}
