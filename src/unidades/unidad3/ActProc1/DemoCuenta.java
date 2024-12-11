package unidades.unidad3.ActProc1;

import java.util.Scanner;
import java.io.IOException;
import java.util.Locale;

public class DemoCuenta {
    public static void main(String[] args) throws IOException,InterruptedException{
        /* Permite Mostrar siempre el menu despues de cada operacion */
        new ProcessBuilder("cmd", "/c","cls").inheritIO().start().waitFor();

        Scanner data= new Scanner(System.in);
        data.useLocale(Locale.ENGLISH);/* Set del teclado para que el punto sea separador de Decimales */

        String name;
        long nroCuenta;
        double importe;
        /*------------------------*/
        int opcion;
        char bloqueo;
        /*--------------------------------------------------*/
        /* obtenemos los valores de tipo cuenta para cargar */
        /*--------------------------------------------------*/
        TipoCuenta[] tCuenta = TipoCuenta.values();
        /*------------------------ */
        System.out.println("creacion de cuenta");
        System.out.println("------------------");
        System.out.println("Ingrese los datos de la cuenta:");
        System.out.println("\tNombre Cliente:");
        name = data.nextLine();
        System.out.println("\t nº cuenta:");
        nroCuenta=data.nextLong();
        System.out.println("\tTipos de cuenta");
        /*----------------------------------- */
        for(int i=0; i < tCuenta.length; i++){
            System.out.println("\t\t"+(i+1)+"| "+tCuenta[i]);
        }
        System.out.println("\tSeleccionen una Opcion: ");
        opcion = data.nextInt();
        // Convertimos el valor entero en el valor del enum
        TipoCuenta tipoSeleccionado = TipoCuenta.values()[opcion - 1];
        CuentaBancaria cb = new CuentaBancaria(name, nroCuenta, 0, tipoSeleccionado);
        /*---------------------------------- */
        /* menu de opciones  */
        /*---------------------------------- */
        do {
            System.out.println("\n --------------------------------------");
            System.out.println("| Menu de Opciones  |");
            System.out.println(" ----------------------------------------");
            System.out.println(" 1) Mostrar datos cuenta");
            System.out.println(" 2) ingresar dinero ");
            System.out.println(" 3) retirar dinero");
            System.out.println(" 4) bloquear cuenta");
            System.out.println(" 5) desbloquear cuenta \n");
            System.out.println(" selecciones una opcion 0-> salir:");
            opcion = data.nextInt();
            
            new ProcessBuilder("cmd", "/c","cls").inheritIO().start().waitFor();
             switch (opcion) {
                case 0:
                    System.out.println("adios...\n");
                    break;
                case 1:
                cb.mostrarCuenta();
                break;
                case 2:
                if (cb.getEstadoCta()){
                    cb.setDeposito(data);
                }break;
                case 3:
                if (cb.getEstadoCta()){
                    System.out.println("ingrese el importe a retirar: ");
                    importe = data.nextDouble();
                    if (!cb.setRetiro(importe)){
                        System.out.println("no tiene saldo suficiente para retirar!!!");
                    }
                    break;
                }
                case 4:
                    if (!cb.getBloqueoCta()){
                        System.out.println("la cuenta ya se encuentra Bloqueada");
                    } else{
                        System.out.println("¿desea blpquear la cuenta? s/n");
                        bloqueo=(char) System.in.read();
                        if(bloqueo==(char) 'S'||bloqueo==(char) 's'){
                            cb.setBloqueoCta(false);
                            cb.mensExito();
                        }
                    }
                    case 5:
                    if (cb.getBloqueoCta()){
                        System.out.println("la cuenta ya se encuentra habilitada");
                    } else{
                        System.out.println("¿desea blpquear la cuenta? s/n");
                        bloqueo=(char) System.in.read();
                        if(bloqueo==(char) 'S'||bloqueo==(char) 's'){
                            cb.setBloqueoCta(true);
                            cb.mensExito();
                        }
                    }
                default:
                System.out.println("seleccion no valida...");
                    break;
             }
        } while(opcion!=0);
        data.close();
    }
}
