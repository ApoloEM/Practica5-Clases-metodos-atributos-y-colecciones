import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Juego {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Ingrese el número de jugadores: ");
		int numJugadores = sc.nextInt();
		sc.nextLine();

		System.out.print("Ingrese el número de cartas por jugador: ");
		int cartasPorJugador = sc.nextInt();
		sc.nextLine();

		// Validar que haya suficientes cartas para repartir
		if (numJugadores * cartasPorJugador > 52) {
			System.out.println("No hay suficientes cartas para repartir a todos los jugadores.");
			sc.close();
			return;
		}

		List<Jugador> jugadores = new ArrayList<>();
		for (int i = 1; i <= numJugadores; i++) {
			System.out.print("Nombre del jugador " + i + ": ");
			String nombre = sc.nextLine();
			jugadores.add(new Jugador(nombre));
		}

		Mazo mazo = new Mazo();
		mazo.barajar();

		// Repartir las cartas a los jugadores
		List<List<Carta>> manos = mazo.repartir(jugadores.size(), cartasPorJugador);
		for (int i = 0; i < jugadores.size(); i++) {
			for (Carta carta : manos.get(i)) {
				jugadores.get(i).asignarCarta(carta);
			}
		}

		System.out.println("\n--- Estado de los jugadores ---");
		for (Jugador jugador : jugadores) {
			System.out.println(jugador.infoJugador());
		}

		System.out.println("Cartas restantes en el mazo: " + mazo.cartasRestantes());

		// Regresar una carta al mazo (ejemplo: la primera carta del primer jugador)
		if (!jugadores.get(0).getCartas().isEmpty()) {
			Carta cartaDevuelta = jugadores.get(0).getCartas().get(0);
			jugadores.get(0).deshacerseDeCarta(cartaDevuelta);
			mazo.agregarCarta(cartaDevuelta);
			System.out.println("\nSe regresó la carta " + cartaDevuelta + " al mazo.");
		}

		System.out.println("Cartas restantes en el mazo: " + mazo.cartasRestantes());

		sc.close();
	}
}
