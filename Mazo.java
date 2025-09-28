import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {
    private List<Carta> cartas;
    private List<Carta> cartasNoRepartidas;

    public Mazo() {
        restablecer();
    }

    public void restablecer() {
        cartas = new ArrayList<>();
        for (Carta.Figura figura : Carta.Figura.values()) {
            for (int valor = 1; valor <= 13; valor++) {
                cartas.add(new Carta(valor, figura));
            }
        }
        cartasNoRepartidas = new ArrayList<>(cartas);
    }

    public void barajar() {
        Collections.shuffle(cartasNoRepartidas);
    }

    public List<List<Carta>> repartir(int numJugadores, int cartasPorJugador) {
        List<List<Carta>> manos = new ArrayList<>();
        for (int i = 0; i < numJugadores; i++) {
            List<Carta> mano = new ArrayList<>();
            for (int j = 0; j < cartasPorJugador && !cartasNoRepartidas.isEmpty(); j++) {
                mano.add(quitarCarta());
            }
            manos.add(mano);
        }
        return manos;
    }

    public void agregarCarta(Carta carta) {
        cartasNoRepartidas.add(carta);
    }

    public Carta quitarCarta() {
        if (!cartasNoRepartidas.isEmpty()) {
            return cartasNoRepartidas.remove(0);
        }
        return null;
    }

    public int cartasRestantes() {
        return cartasNoRepartidas.size();
    }
}
