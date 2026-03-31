public class ColaFIFO {

    private NodoCola frente;
    private NodoCola fin;

    public boolean estaVacia() {
        return frente == null;
    }

    public void encolar(Cliente c) {
        NodoCola nuevo = new NodoCola(c);

        if (estaVacia()) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public Cliente desencolar() {
        if (estaVacia()) return null;

        Cliente c = frente.cliente;
        frente = frente.siguiente;

        if (frente == null) fin = null;
        return c;
    }

    public Cliente verFrente() {
        if (estaVacia()) return null;
        return frente.cliente;
    }
}