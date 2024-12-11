package unidades.tp_integrador.AO2_Siragusa_Flores.actividad_2;

import unidades.tp_integrador.AO2_Siragusa_Flores.actividad_1.librerias.Egreso;
import unidades.tp_integrador.AO2_Siragusa_Flores.actividad_1.librerias.Ingreso;

public class CursoPresencial extends Curso {
    private String horario;
    private String ubicacion;

    // CONSTRUCTORES

    public CursoPresencial() {
        super();
        this.horario = "";
        this.ubicacion = "";
    }

    public CursoPresencial(String nombreCurso, int duracion, int matriculaAlumnos,
            String horario, String ubicacion,double costoTotal) {
        super(nombreCurso, duracion, matriculaAlumnos, costoTotal);
        this.horario = horario;
        this.ubicacion = ubicacion;
    }

    // METODOS

    public void cargarPresencial(CursoPresencial c) {
        c.setNombreCurso(Ingreso.pedirString("Ingrese el nombre del curso", "NOMBRE"));
        c.setDuracion(Ingreso.pedirEntero("ingrese la duracion en horas del curso", "DURACION"));
        c.setMatriculaAlumnos(Ingreso.pedirEntero("ingrese la cantidad de alumnos", "ALUMNOS"));
        c.setHorario(Ingreso.pedirString("de que hora a que hora es el curso", "HORARIO"));
        c.setUbicacion(Ingreso.pedirString("ingrese la ubicacion del curso", "UBICACION"));
        c.setCostoPorEstudiante(getCostoPorEstudiante());
        c.setCostoTotal(this.getCostoPorEstudiante()*this.getMatriculaAlumnos());
    }

    @Override
    public void mostrarCurso(Curso c) {
        String mensaje = "Nombre: " + this.getNombreCurso() + "\nDuración: " + this.getDuracion()
                + " horas\nMatrícula de alumnos: " + this.getMatriculaAlumnos() + "\nCosto por estudiante: $"
                + this.getCostoPorEstudiante() + "\nHorario: " + this.getHorario() + "\nUbicacion: "
                + this.getUbicacion()+"\nRecaudado x este curso: $"+this.getCostoTotal();
        Egreso.mostrarMensaje(mensaje, "Información del Curso");
    }

    // SETTERS

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    // GETTERS

    public String getHorario() {
        return horario;
    }

    public String getUbicacion() {
        return ubicacion;
    }
}
