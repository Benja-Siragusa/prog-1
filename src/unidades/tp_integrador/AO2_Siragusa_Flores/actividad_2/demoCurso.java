package unidades.tp_integrador.AO2_Siragusa_Flores.actividad_2;

import javax.swing.JOptionPane;

import unidades.tp_integrador.AO2_Siragusa_Flores.actividad_1.librerias.Egreso;
import unidades.tp_integrador.AO2_Siragusa_Flores.actividad_1.librerias.Ingreso;

public class demoCurso {

    public static void main(String[] args) {
        /*declaramos variables e iniciamos el menu interactivo, la variable contador nos sirve para llevar 
        cuenta de los cursos creados y que no haya errores de busqueda u ordenamiento cuando recorra 
        el array si tiene componentes vacios*/

        int opcion, contador = 0;
        Curso[] listadoCurso = new Curso[40];

        /*creamos un menu interactivo para ingresar, mostrar, buscar o ver el total recaudado */
        do {
            opcion = mostrarMenu();
            switch (opcion) {
                case 0:
                    registrarCurso(listadoCurso, contador);

                    /*luego de agregar un array, siempre lo ordenara y sumara +1 al contador */
                    contador++;
                    ordenarCurso(listadoCurso,contador);
                    break;
                case 1:
                    mostrarCursosAr(listadoCurso);
                    break;
                case 2:

                    /*pedimos el nombre del curso q se quiere buscar, despues con un metodo lo buscamos */

                    String nombre = Ingreso.pedirString("ingrese el nombre del curso a buscar", "ingrese nombre");
                    buscarCurso(listadoCurso, nombre,contador);
                    break;
                case 3:
                    /*con un metodo calculamos el total recaudado por todos los cursos, ya en cada curso se muestra 
                     * cuanto recaudo cada uno, multiplicando el costo x estudiante por la cantidad de los mismos
                     */
                    calcularTotalRecaudado(listadoCurso,contador);
                    break;
                default:
                    break;
            }
        } while (opcion != 4); // opción para salir
    }

    /*menu interactivo */
    public static int mostrarMenu() {
        String[] opciones = {
                "Registrar un curso",
                "Mostrar todos los cursos",
                "Buscar un curso",
                "Calcular total recaudado",
                "Salir"
        };

        return JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menú de Gestión de Cursos",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
    }

    /* menu para elegir que opcion de curso decide registrar, luego de registrar, automaticamente lo muestra y se agrega al array */

    public static void registrarCurso(Curso cursoA[], int n) {
        String[] opciones = {
                "Curso Presencial",
                "Curso Online",
                "Curso Híbrido"
        };
        int tipoCurso = JOptionPane.showOptionDialog(null, "Seleccione el tipo de curso a registrar", "Registrar Curso",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        switch (tipoCurso) {
            case 0: // Curso Presencial, se carga, se muestra y se agrega al array
                CursoPresencial cursoPresencial = new CursoPresencial();
                cursoPresencial.cargarPresencial(cursoPresencial);
                cursoPresencial.mostrarCurso(cursoPresencial);
                cursoA[n] = cursoPresencial;
                break;
            case 1: // Curso Online, se carga, se muestra y se agrega al array
                CursoOnline cursoOnline = new CursoOnline();
                cursoOnline.cargarOnline(cursoOnline);
                cursoOnline.mostrarCurso(cursoOnline);
                cursoA[n] = cursoOnline;
                break;
            case 2: // Curso Híbrido, se carga, se muestra y se agrega al array
                CursoHibrido cursoHibrido = new CursoHibrido();
                cursoHibrido.cargarHibrido(cursoHibrido);
                cursoHibrido.mostrarCurso(cursoHibrido);
                cursoA[n] = cursoHibrido;
                break;
            default:
                break;
        }
    }
    
    /*muestra curso x curso, ya ordenados por matricula (cantidad de estudiantes) */
    public static void mostrarCursosAr(Curso[] c) {
        try {
            for (int i = 0; i < c.length; i++) {
                c[i].mostrarCurso(c[i]);
            }
        } catch (Exception e) {
        }

    }

    /*busca un curso, cuando lo encuentra lo muestra, si no se encuentra muestra un mensaje */
    public static void buscarCurso(Curso[] c, String s,int cont) {
        boolean bandera=false;
            for (int i = 0; i < cont; i++) {
                if (s.equals(c[i].getNombreCurso())) {
                    c[i].mostrarCurso(c[i]);
                    bandera=true;
                } 
            }if(!bandera)
                    Egreso.mostrarAdvertencia("el nombre indicado \"" + s + "\" no pertenece a ningun curso listado",
                            "curso no encontr5ado");
        }


    /*ordena el curso por metodo burbuja */
    public static void ordenarCurso(Curso c[], int cantidadElementos) {
        for (int paso = 0; paso < cantidadElementos; paso++) {
            for (int j = 0; j < cantidadElementos - paso - 1; j++) {
                if (c[j].getMatriculaAlumnos() > c[j + 1].getMatriculaAlumnos()) {
                    Curso temp = c[j];
                    c[j] = c[j + 1];
                    c[j + 1] = temp;
                }
            }
        }
    }

    /*calcula el total recaudado x todos los cursos*/
    public static void calcularTotalRecaudado(Curso c[], int cantidadElementos) {
        int total=0;
        for (int paso = 0; paso < cantidadElementos; paso++) {
            total+=c[paso].getCostoTotal();
        }Egreso.mostrarMensaje("el total recaudado x todos los cursos es de: $"+total, "recaudado");
    }
}