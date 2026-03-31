public class NodoDoble {
    EstadoDocumento estado;
    NodoDoble anterior;
    NodoDoble siguiente;

    public NodoDoble(EstadoDocumento estado) {
        this.estado = estado;
        this.anterior = null;
        this.siguiente = null;
    }
}