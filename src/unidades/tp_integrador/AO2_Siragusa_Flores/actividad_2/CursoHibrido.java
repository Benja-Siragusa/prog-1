package unidades.tp_integrador.AO2_Siragusa_Flores.actividad_2;

import unidades.tp_integrador.AO2_Siragusa_Flores.actividad_1.librerias.Egreso;
import unidades.tp_integrador.AO2_Siragusa_Flores.actividad_1.librerias.Ingreso;

public class CursoHibrido extends Curso{
    private String ubicacion;
    private String plataforma;
    private String horario;
    private double costoConDescuento;

    //CONSTRUCTORES

    public CursoHibrido() {
        super();
        this.plataforma = "";
        this.ubicacion="";
        this.horario = "";
        this.costoConDescuento=0;
    }

    public CursoHibrido(String nombreCurso, int duracion, int matriculaAlumnos, String plataforma, String horario,String ubicacion,double costoConDescuento,double costoTotal) {
        super(nombreCurso, duracion, matriculaAlumnos, costoTotal);
        this.plataforma = plataforma;
        this.horario = horario;
        this.ubicacion=ubicacion;
        this.costoConDescuento=costoConDescuento;
    }

    //METODOS

    public void cargarHibrido(CursoHibrido c){
        c.setNombreCurso(Ingreso.pedirString("Ingrese el nombre del curso", "NOMBRE"));
        c.setDuracion(Ingreso.pedirEntero("ingrese la duracion en horas del curso", "DURACION"));
        c.setMatriculaAlumnos(Ingreso.pedirEntero("ingrese la cantidad de alumnos", "ALUMNOS"));
        c.setCosteConDescuento(calcularCostoConDescuento(this.getMatriculaAlumnos()));
        c.setHorario(Ingreso.pedirString("de que hora a que hora es el curso", "HORARIO"));
        c.setPlataforma(Ingreso.pedirString("ingrese la plataforma del curso", "PLATAFORMA"));
        c.setUbicacion(Ingreso.pedirString("ingrese la ubicacion del curso", "UBICACION"));
        c.setCostoTotal(this.getCosteConDescuento()*this.getMatriculaAlumnos());
    }

    private double calcularCostoConDescuento(int matriculaAlumnos) {
        double costo = getCostoPorEstudiante(); 
        if (matriculaAlumnos > 40) {
            return costo - (costo * 0.2); 
        } else if (matriculaAlumnos > 20) {
            return costo - (costo * 0.1);  
        } else {
            return costo;
        }
    }


    @Override
    public void mostrarCurso(Curso c) {
        String mensaje = "Nombre: " + this.getNombreCurso() + "\nDuración: " + this.getDuracion()
                + " horas\nMatrícula de alumnos: " + this.getMatriculaAlumnos() + "\nCosto por estudiante: $"
                + this.getCosteConDescuento() + "\nHorario: " + this.getHorario() + "\nUbicacion: "
                + this.getUbicacion()+"\nPlataforma: "+this.getPlataforma()+"\nRecaudado x este curso: $"+this.getCostoTotal();
        Egreso.mostrarMensaje(mensaje, "Información del Curso");
    }

    //GETTERS

    public String getUbicacion() {
        return ubicacion;
    }
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

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
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