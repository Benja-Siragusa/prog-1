package unidades.unidad5.ActividadAutoevaluacion;

import javax.swing.JOptionPane;

/*2. Una empresa comercializa hasta 100 productos, cada uno de los cuales tiene  las siguientes características:
                            código : ENTERO
                            nombre : CADENA DE CARACTERES
                            precio : NUMERO REAL
Desarrolle un programa con los métodos  necesarios; para  que admita las siguientes opciones:
            1. Ingreso de datos en 3 arreglos unidimensionales de hasta 100 productos.
            2. Ordenamiento de los productos por sus códigos.
            3. Búsqueda lineal de un producto por su código.
            4. Búsqueda binaria de un producto por su código.
            5. Producto con mayor precio ;
            6. Salida del programa. */

public class act2 {
    public static void main(String[] args) {

        int codigo[], n, busqLineal, busqBin, elem, mayor;
        String nombre[];
        double precio[];
        n = cantPruductos();
        codigo = new int[n];
        nombre = new String[n];
        precio = new double[n];

        cargarProductos(codigo, nombre, precio);
        ordenarProductos(codigo, nombre, precio);

        busqLineal = pedirEntero("ingrese un producto por su codigo para buscarlo de forma lineal", "busqueda lineal");
        busquedaLineal(busqLineal, codigo, nombre, precio);

        busqBin = pedirEntero("ingrese un producto por su codigo para buscarlo de forma binaria", "busqueda binaria");
        elem = busquedaBinaria(codigo, busqBin);
        if (elem == -1) {
            JOptionPane.showMessageDialog(null, "no hay un producto con el codigo " + busqBin, "Elemento no encontrado",
                    JOptionPane.WARNING_MESSAGE);
        } else
            JOptionPane.showMessageDialog(null, "el elemento con el codigo " + busqBin + ", es el:\n - " + nombre[elem]
                    + " su precio es de: $" + precio[elem], "producto encontrado", JOptionPane.INFORMATION_MESSAGE);

        mayor = mayorPrecio(precio);
        JOptionPane
                .showMessageDialog(
                        null, "el elemento con el mayor precio es: \nel " + nombre[mayor] + ", su codigo es "
                                + codigo[mayor] + " y su precio es de $" + precio[mayor],
                        "producto con mayor precio", JOptionPane.INFORMATION_MESSAGE);

    }

    public static int cantPruductos() {
        int n = 0;
        do {
            n = pedirEntero("ingrese cuantos productos desea cargar, el limite son 100", "pidiendo cantidad");
        } while (n > 100 || n <= 0);
        return n;
    }

    public static void cargarProductos(int codigo[], String nombre[], double precio[]) {

        for (int i = 0; i < codigo.length; i++) {
            nombre[i] = pedirString("ingrese el nombre del producto", "pidiendo el nombre");
            codigo[i] = pedirEntero("ingrese el codigo del producto: " + nombre[i], "pidiendo codigo");
            precio[i] = pedirDouble("ingrese el precio del producto: " + nombre[i], "pidiendo precio");
        }
    }

    public static void ordenarProductos(int codigo[], String nombre[], double precio[]) {
        for (int i = 1; i < codigo.length; i++) {
            int actualCodigo = codigo[i];
            String actualNombre = nombre[i];
            double actualprecio = precio[i];
            int j = i - 1;

            while (j >= 0 && codigo[j] > actualCodigo) {
                codigo[j + 1] = codigo[j];
                nombre[j + 1] = nombre[j];
                precio[j + 1] = precio[j];
                j--;
            }

            codigo[j + 1] = actualCodigo;
            nombre[j + 1] = actualNombre;
            precio[j + 1] = actualprecio;
        }
    }

    public static int pedirEntero(String mens, String titulo) {
        int n = 0;
        boolean bandera = false;
        do {
            try {
                n = Integer.parseInt(JOptionPane.showInputDialog(null, mens, titulo, 1));
                bandera = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ingrese un entero", "error", 0);
            }
        } while (!bandera);
        return n;
    }

    public static double pedirDouble(String mens, String titulo) {
        double n = 0;
        boolean bandera = false;
        do {
            try {
                n = Double.parseDouble(JOptionPane.showInputDialog(null, mens, titulo, 1));
                bandera = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ingrese un entero", "error", 0);
            }
        } while (!bandera);
        return n;
    }

    public static String pedirString(String mens, String titulo) {
        return JOptionPane.showInputDialog(null, mens, titulo, 1);
    }

    public static void busquedaLineal(int elemento, int codigo[], String nombre[], double precio[]) {
        boolean bandera = false;
        for (int i = 0; i < codigo.length; i++) {
            if (codigo[i] == elemento) {
                JOptionPane.showMessageDialog(null, "el elemento con el codigo " + elemento + ", es el:\n - "
                        + nombre[i] + " su precio es de: $" + precio[i], "producto encontrado",
                        JOptionPane.INFORMATION_MESSAGE);
                bandera = true;
                break;
            }
        }
        if (!bandera) {
            JOptionPane.showMessageDialog(null, "no hay un producto con el codigo " + elemento,
                    "Elemento no encontrado", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static int busquedaBinaria(int codigo[], int cod) {
        int inicio = 0;
        int fin = codigo.length - 1;
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (codigo[medio] == cod) {
                return medio;
            } else if (codigo[medio] < cod) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }

    public static int mayorPrecio(double precio[]) {
        int pos = -1;
        double mayor = -1;
        for (int i = 0; i < precio.length; i++) {
            if (precio[i] > mayor) {
                mayor = precio[i];
                pos = i;
            }
        }
        return pos;
    }
}
