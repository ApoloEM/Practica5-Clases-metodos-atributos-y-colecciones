import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Juego {

    public static void main(String[] args) {
        
		//Configuración inicial
        final int NUM_JUGADORES = 4;
        final int CARTAS_POR_JUGADOR = 7;

        Scanner scanner = new Scanner(System.in);
        List<Jugador> jugadores = new ArrayList<>();

        System.out.println("--- Ingresa los nombres de los jugadores ---");
        for (int i = 0; i < NUM_JUGADORES; i++) {
            System.out.print("Nombre del Jugador " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            jugadores.add(new Jugador(nombre));
        }
        scanner.close();
        
        Mazo mazo = new Mazo();
        mazo.barajar();

		//Repartimos las cartas
        List<List<Carta>> manos = mazo.repartir(NUM_JUGADORES, CARTAS_POR_JUGADOR);
        for (int i = 0; i < jugadores.size(); i++) {
            for (Carta carta : manos.get(i)) {
                jugadores.get(i).asignarCarta(carta);
            }
        }

		//Dibujamos
        //DIBUJAR TODAS LAS FORMAS
        for (int i = 0; i < jugadores.size(); i++) {
            Visualizador.manoDeJugadorGrafica(jugadores.get(i), i);
        }
        if (mazo.cartasRestantes() > 0) {
            Visualizador.mazoGrafico();
        }
        
        //DIBUJAR TODO EL TEXTO ENCIMA
        for (int i = 0; i < jugadores.size(); i++) {
            Visualizador.manoDeJugadorTexto(jugadores.get(i), i);
        }
        for (int i = 0; i < jugadores.size(); i++) {
            Visualizador.nombreJugador(jugadores.get(i), i);
        }
        if (mazo.cartasRestantes() > 0) {
            Visualizador.mazoTexto();
        }

        // Imprimimos en consola para verificar
        System.out.println("Tablero de juego visualizado.");
        System.out.println("Cartas restantes en el mazo: " + mazo.cartasRestantes());
    }
}