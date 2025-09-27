public class Carta {
    private int valor;
    private Figura figura;

    public enum Figura {
        ESPADA, CORAZON, TREBOL, DIAMANTE;
    }

    public Carta(int valor, Figura figura) {
        this.valor = valor;
        this.figura = figura;
    }

    public int getValor() {
        return valor;
    }

    public Figura getFigura() {
        return figura;
    }

    /**
     * Obtiene la representación en texto del valor de la carta (A, 2-10, J, Q, K)
     */
    public String getValorTexto() {
        switch (valor) {
            case 1: return "A";
            case 11: return "J";
            case 12: return "Q";
            case 13: return "K";
            default: return String.valueOf(valor);
        }
    }

    @Override
    public String toString() {
        return getValorTexto() + " " + figura.name();
    }
}