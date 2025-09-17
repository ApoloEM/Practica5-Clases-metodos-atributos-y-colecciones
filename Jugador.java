import java.util.ArrayList;
import java.util.List;

public class Jugador {
	public String nombre;
	private List<Carta> cartas;

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.cartas = new ArrayList<>();
	}

	public void asignarCarta(Carta carta) {
		cartas.add(carta);
	}

	public void deshacerseDeCarta(Carta carta) {
		cartas.remove(carta);
	}

	public List<Carta> getCartas() {
		return cartas;
	}

	public String infoJugador() {
		String resultado = "Jugador: " + nombre + "\nCartas:\n";
		for (Carta carta : cartas) {
			resultado += carta.toString() + "\n";
		}
		return resultado;
	}
}
