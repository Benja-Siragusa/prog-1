package unidades.tp_integrador.AO2_Siragusa_Flores.actividad_2;

import unidades.tp_integrador.AO2_Siragusa_Flores.actividad_1.librerias.Egreso;
import unidades.tp_integrador.AO2_Siragusa_Flores.actividad_1.librerias.Ingreso;

public class CursoOnline extends Curso{
    private String plataforma;
    private String horario;
    private double costoConDescuento;

    //CONSTRUCTORES

    public CursoOnline() {
        super();
        this.plataforma = "";
        this.horario = "";

    }

    public CursoOnline(String nombreCurso, int duracion, int matriculaAlumnos, String plataforma, String horario,double costoConDescuento,double costoTotal) {
        super(nombreCurso, duracion, matriculaAlumnos,costoTotal);
        this.plataforma = plataforma;
        this.horario = horario;
        this.costoConDescuento=costoConDescuento;

    }

    //METODOS

    public void cargarOnline(CursoOnline c){
        c.setNombreCurso(Ingreso.pedirString("Ingrese el nombre del curso", "NOMBRE"));
        c.setDuracion(Ingreso.pedirEntero("ingrese la duracion en horas del curso", "DURACION"));
        c.setMatriculaAlumnos(Ingreso.pedirEntero("ingrese la cantidad de alumnos", "ALUMNOS"));
        c.setCosteConDescuento(getCostoPorEstudiante()-(getCostoPorEstudiante()*0.15));
        c.setHorario(Ingreso.pedirString("de que hora a que hora es el curso", "HORARIO"));
        c.setPlataforma(Ingreso.pedirString("ingrese la plataforma del curso", "PLATAFORMA"));
        c.setCostoTotal(this.getCosteConDescuento()*this.getMatriculaAlumnos());
    }

    @Override
    public void mostrarCurso(Curso c) {
        String mensaje = "Nombre: " + this.getNombreCurso() + "\nDuración: " + this.getDuracion()
                + " horas\nMatrícula de alumnos: " + this.getMatriculaAlumnos() + "\nCosto por estudiante: $"
                + this.getCosteConDescuento() + "\nHorario: " + this.getHorario() + "\nPlataforma: "
                + this.getPlataforma()+"\nRecaudado x este curso: $"+this.getCostoTotal();
        Egreso.mostrarMensaje(mensaje, "Información del Curso");
    }

    //GETTERS

    public String getPlataforma() {
        return plataforma;
    }
    public String getHorario() {
        return horario;
    }
        public double getCosteConDescuento(){
        return costoConDescuento; 
    }

    //SETTERS

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public void setCosteConDescuento(double costoConDescuento){
        this.costoConDescuento=costoConDescuento;
    }   
}
