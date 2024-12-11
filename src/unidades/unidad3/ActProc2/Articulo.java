package unidades.unidad3.ActProc2;

import javax.swing.JOptionPane;

public class Articulo extends Publicacion{
    private Idioma idioma;
    private int numeroPaginas;
    private static int cantidadArticulos=0;

    private enum Idioma{
        ingles,
        español,
        portugues;
    }

    public Articulo(String titulo, String autor, int añoPublicacion, int numeroId, Idioma idioma, int numeroPaginas) {
        super(titulo, autor, añoPublicacion, numeroId);
        this.idioma = idioma;
        this.numeroPaginas = numeroPaginas;
        cantidadArticulos++;
    }

    public Articulo() {
        super();
        this.idioma = Idioma.español;
        this.numeroPaginas = 0;
        cantidadArticulos++;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public static void getCantidadArticulos() {
        JOptionPane.showMessageDialog(null, "la cantidad de articulos es de: "+cantidadArticulos, "cantidad de articulos", 1);
    }

    public void mostrarArticulo(Articulo a){
        mostrarInfo("Titulo: "+a.getTitulo()+"\nAutor: "+a.getAutor()+"\nIdioma: "+getIdioma()+"\nAño de publicacion: "+a.getAñoPublicacion()+"\nCantidad de paginas: "+a.getNumeroPaginas()+"\nId del articulo: "+a.getNumeroId(), "mostrando informacion");
    }

    public void cargarArticulo(Articulo a){
        Publicacion p = new Publicacion();
        cargarPublicacion(p);
        a.setAutor(p.getAutor());
        a.setTitulo(p.getTitulo());
        a.setAñoPublicacion(p.getAñoPublicacion());
        a.setNumeroId(p.getNumeroId());
        a.setIdioma(pedirIdioma());
        a.setNumeroPaginas(cargarInt("ingrese el numero de paginas: ", "cantidad de paginas"));
    }

    public Idioma pedirIdioma(){
        Object[] opcion= {"ingles","español","portugues"};
        int seleccion= JOptionPane.showOptionDialog(null, "que idioma desea?", "idioma", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcion, opcion[0]);
        Idioma idioma = Idioma.values()[seleccion];
        return idioma;
    }

}
