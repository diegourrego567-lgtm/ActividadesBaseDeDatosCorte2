public class ListaCircular {

    private NodoCircular actual;

    public boolean estaVacia() {
        return actual == null;
    }

    // INSERTAR JUGADOR AL CÍRCULO
    public void insertarJugador(Jugador j) {
        NodoCircular nuevo = new NodoCircular(j);

        if (estaVacia()) {
            actual = nuevo;
            actual.siguiente = actual;
            return;
        }

        NodoCircular temp = actual;
        while (temp.siguiente != actual)
            temp = temp.siguiente;

        temp.siguiente = nuevo;
        nuevo.siguiente = actual;
    }

    // AVANZAR TURNO
    public void avanzarTurno() {
        if (actual != null)
            actual = actual.siguiente;
    }

    // ELIMINAR JUGADOR ACTUAL
    public void eliminarActual() {

        if (actual == null) return;

        // Solo queda uno
        if (actual.siguiente == actual) {
            actual = null;
            return;
        }

        // Buscar nodo anterior
        NodoCircular anterior = actual;
        while (anterior.siguiente != actual)
            anterior = anterior.siguiente;

        anterior.siguiente = actual.siguiente;
        actual = actual.siguiente;
    }

    // CONTAR JUGADORES
    public int contarJugadores() {
        if (actual == null) return 0;

        int count = 1;
        NodoCircular temp = actual.siguiente;
        while (temp != actual) {
            count++;
            temp = temp.siguiente;
        }
        return count;
    }

    // MOSTRAR MESA
    public void mostrarJugadores() {
        if (actual == null) return;

        NodoCircular temp = actual;
        System.out.println("\nJugadores en mesa:");
        do {
            System.out.println(temp.jugador.nombre +
                    " (Puntos: " + temp.jugador.puntos + ")");
            temp = temp.siguiente;
        } while (temp != actual);
    }

    public Jugador getActual() {
        return actual.jugador;
    }
}