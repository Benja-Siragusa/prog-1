package unidades.unidad3.ActProc2;

import javax.swing.JOptionPane;

public class Publicacion {
    private String titulo;
    private String autor;
    private int añoPublicacion;
    private int numeroId;

    public Publicacion() {
        this.titulo = "";
        this.autor = "";
        this.añoPublicacion = 0;
        this.numeroId = 0;
    }

    public Publicacion(String titulo, String autor, int añoPublicacion, int numeroId) {
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.numeroId = numeroId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public int getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(int numeroId) {
        this.numeroId = numeroId;
    }

    public void cargarPublicacion(Publicacion p) {
        p.setTitulo(cargarString("ingrese el titulo", "pidiendo titulo"));
        p.setAutor(autor = cargarString("ingrese el autor", "ingresadno autor"));
        p.setAñoPublicacion(añoPublicacion = cargarInt("ingrese el año de publicacion", "cargando año"));
        p.setNumeroId(numeroId = cargarInt("ingrese el ID", "cargando ID"));
    }

    public void mostrarPublicacion() {
        mostrarInfo("Titulo: " + this.titulo + "\nAutor: " + this.autor + "\nAño de publicacion: " + añoPublicacion
                + "\nnumeroId: " + this.numeroId, "Informacion");
    }

    /* metodos para mostrar datos y cargarlos por JOptionPane */
    public void mostrarInfo(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, 1);
    }

    public String cargarString(String mensaje, String titulo) {
        return (JOptionPane.showInputDialog(null, mensaje, titulo, 1));
    }

    public int cargarInt(String mensaje, String titulo) {
        return (Integer.parseInt(JOptionPane.showInputDialog(null, mensaje, titulo, 1)));
    }
}
