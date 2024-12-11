package unidades.unidad3.ActProc2;

import javax.swing.JOptionPane;

public class Revista extends Publicacion{
    private Mes mesPublicacion;
    private String pais;
    private Categoria categoria;
    private static int cantidadRevistas=0;

    private enum Categoria{
        Deportes,
        Tecnologia,
        Literatura;
    }

    private enum Mes{
        enero, febrero, marzo, abril, mayo, junio, julio, agosto, septiembre, octubre, noviembre, diciembre
    }

    public Revista() {
        super();
        this.mesPublicacion = Mes.enero;
        this.pais = "";
        this.categoria = Categoria.Literatura;
        cantidadRevistas++;
    } 

    public Revista(String titulo, String autor, int añoPublicacion, int numeroId, Mes mesPublicacion, String pais,
            Categoria categoria) {
        super(titulo, autor, añoPublicacion, numeroId);
        this.mesPublicacion = mesPublicacion;
        this.pais = pais;
        this.categoria = categoria;
        cantidadRevistas++;
    }

    public Mes getMesPublicacion() {
        return mesPublicacion;
    }

    public void setMesPublicacion(Mes mesPublicacion) {
        this.mesPublicacion = mesPublicacion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public static void getCantidadRevistas() {
        JOptionPane.showMessageDialog(null, "la cantidad de revistas es de: "+cantidadRevistas, "cantidad de revistas", 1);
    }

    public void mostrarRevista(Revista l){
        mostrarInfo("Titulo: "+l.getTitulo()+"\nAutor: "+l.getAutor()+"\nCategoria: "+l.getCategoria()+"\nAño de publicacion: "+l.getAñoPublicacion()+"\nMes de publicacion"+l.getMesPublicacion()+"\nPais de origen: "+l.getPais()+"\nnumeroId: "+l.getNumeroId(),"Informacion");
    }
    
    public void cargarRevista(Revista r){
        Publicacion p = new Publicacion();
        cargarPublicacion(p);
        r.setAutor(p.getAutor());
        r.setTitulo(p.getTitulo());
        r.setAñoPublicacion(p.getAñoPublicacion());
        r.setNumeroId(p.getNumeroId());
        r.setMesPublicacion(pedirMes());
        r.setCategoria(pedirCategoria());
        r.setPais(cargarString("ingrese el pais de donde es la revista", "pais"));
    }
    
    public Categoria pedirCategoria(){
        Object[] opcion= {"deportes","tecnologia","literatura"};
        int seleccion= JOptionPane.showOptionDialog(null, "que categoria es la revista:", "categoria", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcion, opcion[0]);
        Categoria categoria = Categoria.values()[seleccion];
        return categoria;
    }

    public Mes pedirMes(){
        Object[] opcion= {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
        int seleccion= JOptionPane.showOptionDialog(null, "de que mes es la revista:", "mes", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcion, opcion[0]);
        Mes mes = Mes.values()[seleccion];
        return mes;
    }
}


