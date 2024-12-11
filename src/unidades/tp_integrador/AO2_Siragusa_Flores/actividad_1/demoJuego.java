package unidades.tp_integrador.AO2_Siragusa_Flores.actividad_1;

import java.util.Random;

import unidades.tp_integrador.AO2_Siragusa_Flores.actividad_1.librerias.Egreso;
import unidades.tp_integrador.AO2_Siragusa_Flores.actividad_1.librerias.Ingreso;

import java.time.Duration;
import java.time.Instant;

public class demoJuego {
    public static void main(String[] args) {
        boolean jugarDeNuevo = false;
        do {
            int jugadores, 
            intentoJugadores[], 
            tiempoJugadores[], 
            erroresJugadores[], 
            numeroSecreto, 
            ganador,
            masErrores,
            tiempoSegundos,
            masRapido,
            masLento;
            
            double promErrores;
            String nombreJugador[];
            int cantidadJugadores = Ingreso.pedirEntero("ingrese la cantidad de jugadores", "jugadores");
            nombreJugador = new String[cantidadJugadores];
            intentoJugadores = new int[cantidadJugadores];
            tiempoJugadores = new int[cantidadJugadores];
            erroresJugadores = new int[cantidadJugadores];
            for (int i = 0; i < cantidadJugadores; i++) {
                int numeroJugador, intento = 0;
                Instant inicio = null;
                nombreJugador[i] = Ingreso.pedirString("ingrese su nombre", "nombre");
                numeroSecreto = numeroRandom();
                do {
                    numeroJugador = Ingreso.pedirEntero("intente adivinar el numero entre 1 y 100", "numero");
                    if (inicio == null) inicio = Instant.now();
                    intento++;
                    compararNumero(numeroJugador, numeroSecreto);
                } while (numeroJugador != numeroSecreto);
                Instant fin = Instant.now();
                Duration duracion = Duration.between(inicio, fin);
                tiempoSegundos = (int) duracion.getSeconds();
                intentoJugadores[i] = intento;
                erroresJugadores[i] = (intento - 1);
                tiempoJugadores[i]=tiempoSegundos;
            }

            promErrores = calcularPromedio(erroresJugadores);
            masErrores = calcularMayor(erroresJugadores);
            ganador = calcularMenor(intentoJugadores);
            masLento=calcularMayor(tiempoJugadores);
            masRapido=calcularMenor(tiempoJugadores);

                        // MENU

                        
            Egreso.mostrarMensaje(
                    " - el jugador que hizo menos intentos fue: " + nombreJugador[ganador] + "\n - Que hizo: "
                            + intentoJugadores[ganador] + "\n - El promedio de errores de todos fue de: " + promErrores
                            + "\n - El jugador con mas errores fue: " + nombreJugador[masErrores]
                            + "\n - Su cantidad de errores fue de: " + erroresJugadores[masErrores]+"\n - El jugador mas rapido fue: "+nombreJugador[masRapido]
                            + "\n - Su tiempo fue de: " +tiempoJugadores[masRapido]+" Segundos"
                            + "\n - El jugador mas lento fue: " +nombreJugador[masLento]
                            + "\n - Su tiempo fue de: "+tiempoJugadores[masLento]+" Segundos",
                            "ganador");

            jugarDeNuevo = Ingreso.pedirBoolean("jugar de nuevo?");

        } while (jugarDeNuevo);

    }

    // generar nro random
    public static int numeroRandom() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    // comparar numero
    public static void compararNumero(int n, int m) {
        if (n < m) {
            Egreso.mostrarMensaje("el numero ingresado es muy bajo", "mas pequeño");
        } else if (n > m) {
            Egreso.mostrarMensaje("el numero ingresado es muy alto", "mas grande");
        } else {
            Egreso.mostrarMensaje("Adivino el numero, Felicitaciones!", "Adivino!");
        }
    }

    // calcular el mayor
    public static int calcularMayor(int n[]) {
        int mayor = 0;
        int posicion = 0;
        for (int i = 1; i < n.length; i++) {
            if (mayor < n[i]) {
                mayor = n[i];
                posicion = i;
            }
        }
        return posicion;
    }

    // calcular el menor
    public static int calcularMenor(int n[]) {
        int menor = 0;
        int posicion = 0;
        for (int i = 1; i < n.length; i++) {
            if (menor > n[i]) {
                menor = n[i];
                posicion = i;
            }
        }
        return posicion;
    }

    // calcular el promedio
    public static double calcularPromedio(int n[]) {
        double prom = 0;
        for (int i = 0; i < n.length; i++) {
            prom += n[i];
        }
        return (prom / n.length);
    }

}
