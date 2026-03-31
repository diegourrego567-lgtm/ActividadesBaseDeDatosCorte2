public class NodoCircular {
    Jugador jugador;
    NodoCircular siguiente;

    public NodoCircular(Jugador jugador) {
        this.jugador = jugador;
        this.siguiente = null;
    }
}