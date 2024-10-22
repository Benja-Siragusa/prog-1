package unidad3.ActProc2;

import javax.swing.JOptionPane;

public class demoPublicacion {
    public static void main(String[] args) {
        int opcion1, opcion2, opcion3;
        do {
            opcion1 = mostrarMenu1();
            switch (opcion1) {
                case 0: // carggar un objeto
                    opcion2 = mostrarMenu2();
                        switch (opcion2) {
                            case 0: // una publicacion
                                Publicacion p = new Publicacion();
                                p.cargarPublicacion(p);
                                p.mostrarPublicacion();
                                break;
                            case 1: // un libro
                                Libro l = new Libro();
                                l.cargarLibro(l);
                                l.mostrarLibro(l);
                                break;
                            case 2: // una revista
                                Revista r = new Revista();
                                r.cargarRevista(r);
                                r.mostrarRevista(r);
                                break;
                            case 3: // un articulo
                                Articulo a = new Articulo();
                                a.cargarArticulo(a);
                                a.mostrarArticulo(a);
                                break;
                        }
                    break;
                case 1: // ver cantidades de objetos
                    opcion3 = mostrarMenuCantidad();
                        switch (opcion3) {
                            case 0:// libro
                                Libro.getCantidadLibros();
                                break;
                            case 1:// revista
                                Revista.getCantidadRevistas();
                                break;
                            case 2:// articulo
                                Articulo.getCantidadArticulos();
                                break;
                        }
                    break;
                default:
                    break;
            }
        } while (opcion1 != 2);
    }

    public static int mostrarMenu1() {
        String[] opciones = {
                "cargar un objeto", // 0
                "ver cantidad de un objeto", // 1
                "salir"// 2
        };

        return JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menú Interactivo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
    }

    public static int mostrarMenu2() { // metodo para cargra un objeto
        String[] opciones = {
                "una publicacion", // 0
                "un libro", // 1
                "una revista", // 2
                "un articulo", // 3
                "salir"// 4
        };

        return JOptionPane.showOptionDialog(null, "que desea cargar: ", "Cargando un objeto",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
    }

    public static int mostrarMenuCantidad() { // metodo para ver cantidades de objetos
        String[] opciones = {
                "libros", // 0
                "revista", // 1
                "articulo", // 2
                "salir"// 3
        };

        return JOptionPane.showOptionDialog(null, "De que articulo desea ver que cantidad hay;", "Menú de cantidades",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
    }
}