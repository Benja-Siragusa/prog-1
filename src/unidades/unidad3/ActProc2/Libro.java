package unidades.unidad3.ActProc2;

import javax.swing.JOptionPane;

public class Libro extends Publicacion{
    private int cantidadEjemplares;
    private String editorial;
    private static int cantidadLibros=0;

    public Libro() {
        super();
        this.cantidadEjemplares = 0;
        this.editorial = "";
        cantidadLibros++;
    }

    public Libro(String titulo, String autor, int añoPublicacion, int numeroId, int cantidadEjemplares,
            String editorial) {
        super(titulo, autor, añoPublicacion, numeroId);
        this.cantidadEjemplares = cantidadEjemplares;
        this.editorial = editorial;
        cantidadLibros++;

    }

    public int getCantidadEjemplares() {
        return cantidadEjemplares;
    }

    public void setCantidadEjemplares(int cantidadEjemplares) {
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public static void getCantidadLibros(){
        JOptionPane.showMessageDialog(null, "la cantidad de libros es de: "+cantidadLibros, "cantidad de libros", 1);
    }
    
    public void cargarLibro(Libro l){
        Publicacion p= new Publicacion();
        cargarPublicacion(p);
        l.setCantidadEjemplares(cantidadEjemplares=cargarInt("ingrese la cantidad de ejemplares: ", "cantidad de ejemplares"));
        l.setEditorial(editorial=cargarString("ingrese la editorial: ", "editorial"));
        l.setAutor(p.getAutor());
        l.setTitulo(p.getTitulo());
        l.setAñoPublicacion(p.getAñoPublicacion());
        l.setNumeroId(p.getNumeroId());
    }

    public void mostrarLibro(Libro l){
        mostrarInfo("Titulo: "+l.getTitulo()+"\nAutor: "+l.getAutor()+"\nAño de publicacion: "+l.getAñoPublicacion()+"\nEditorial: "+l.getEditorial()+"\nCantidad de ejemplares: "+l.getCantidadEjemplares()+"\nnumeroId: "+l.getNumeroId(),"Informacion");
    }
}
