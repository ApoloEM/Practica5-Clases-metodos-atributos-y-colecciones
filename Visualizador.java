import java.util.List;

public class Visualizador {

    public static void cartaGrafica(Posicion p) {
        Square cartaGrafica = new Square();
        cartaGrafica.changeColor("white");
        int defaultX = 310;
        int defaultY = 120;
        cartaGrafica.moveHorizontal(p.getX() - defaultX);
        cartaGrafica.moveVertical(p.getY() - defaultY);
        cartaGrafica.makeVisible();
    }

    public static void cartaTexto(Carta c, Posicion p) {
        String color;
        String simboloFigura;

        if (c.getFigura() == Carta.Figura.CORAZON || c.getFigura() == Carta.Figura.DIAMANTE) {
            color = "red";
        } else {
            color = "black";
        }

        switch (c.getFigura()) {
            case CORAZON:  simboloFigura = "♥"; break;
            case DIAMANTE: simboloFigura = "♦"; break;
            case ESPADA:   simboloFigura = "♠"; break;
            case TREBOL:   simboloFigura = "♣"; break;
            default:       simboloFigura = "?"; break;
        }

        Canvas canvas = Canvas.getCanvas();
        String valorTexto = c.getValorTexto();
        canvas.drawString(valorTexto, p.getX() + 5, p.getY() + 15, color, 14);
        canvas.drawString(simboloFigura, p.getX() + 18, p.getY() + 60, color, 36);
    }

    public static void mazoGrafico() {
        Square cuerpoCarta = new Square();
        cuerpoCarta.changeColor("white");
        
        int centroX = 1100 / 2 - 30;
        int centroY = 700 / 2 - 45;
        
        int defaultX = 310;
        int defaultY = 120;
        cuerpoCarta.moveHorizontal(centroX - defaultX);
        cuerpoCarta.moveVertical(centroY - defaultY);
        cuerpoCarta.makeVisible();

        Square reverso = new Square();
        reverso.changeColor("red");
        reverso.changeSize(40, 70);
        
        int reversoX = centroX + 10;
        int reversoY = centroY + 10;

        reverso.moveHorizontal(reversoX - defaultX);
        reverso.moveVertical(reversoY - defaultY);
        reverso.makeVisible();
    }

    public static void mazoTexto() {
        int centroX = 1100 / 2 - 35;
        int centroY = 700 / 2 - 45;
        int fontSize = 18;
        Canvas.getCanvas().drawString("Mazo", centroX + 15, centroY - 10, "white", fontSize);
    }

    public static void manoDeJugadorGrafica(Jugador jugador, int posicionDelJugador) {
        List<Carta> mano = jugador.getCartas();
        int xInicial = 0, yInicial = 0;
        int xOffset = 0, yOffset = 0;
        
        switch (posicionDelJugador) {
            case 0: xInicial = 300; yInicial = 550; xOffset = 70; yOffset = 0; break;
            case 1: xInicial = 50; yInicial = 20; xOffset = 0; yOffset = 95; break;
            case 2: xInicial = 300; yInicial = 50; xOffset = 70; yOffset = 0; break;
            case 3: xInicial = 990; yInicial = 20; xOffset = 0; yOffset = 95; break;
        }
        for (int i = 0; i < mano.size(); i++) {
            Posicion p = new Posicion(xInicial + i * xOffset, yInicial + i * yOffset);
            cartaGrafica(p);
        }
    }

    public static void manoDeJugadorTexto(Jugador jugador, int posicionDelJugador) {
        List<Carta> mano = jugador.getCartas();
        int xInicial = 0, yInicial = 0;
        int xOffset = 0, yOffset = 0;
        switch (posicionDelJugador) {
            case 0: xInicial = 300; yInicial = 550; xOffset = 70; yOffset = 0; break;
            case 1: xInicial = 50; yInicial = 20; xOffset = 0; yOffset = 95; break;
            case 2: xInicial = 300; yInicial = 50; xOffset = 70; yOffset = 0; break;
            case 3: xInicial = 990; yInicial = 20; xOffset = 0; yOffset = 95; break;
        }
        for (int i = 0; i < mano.size(); i++) {
            Carta c = mano.get(i);
            Posicion p = new Posicion(xInicial + i * xOffset, yInicial + i * yOffset);
            cartaTexto(c, p);
        }
    }

    public static void nombreJugador(Jugador jugador, int posicionDelJugador) {
        String nombre = jugador.nombre;
        Canvas canvas = Canvas.getCanvas();
        int fontSize = 16;

        switch (posicionDelJugador) {
            case 0: //Abajo
                canvas.drawString(nombre, 530, 670, "white", fontSize);
                break;
            case 1: //Izquierda
                canvas.drawRotatedString(nombre, 30, 380, -90, "white", fontSize);
                break;
            case 2: //Arriba
                canvas.drawString(nombre, 530, 30, "white", fontSize);
                break;
            case 3: //Derecha
                canvas.drawRotatedString(nombre, 1070, 310, 90, "white", fontSize);
                break;
        }
    }
}