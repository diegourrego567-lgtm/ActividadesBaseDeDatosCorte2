public class Historial {

    private NodoDoble cabeza;
    private NodoDoble actual;

    public String obtenerTextoActual() {
        if (actual == null) return "";
        return actual.estado.contenido;
    }

    // AGREGAR NUEVO ESTADO (GUARDAR)
    public void agregarEstado(String texto) {
        NodoDoble nuevo = new NodoDoble(new EstadoDocumento(texto));

        // Si es el primer estado
        if (cabeza == null) {
            cabeza = actual = nuevo;
            return;
        }

        // 🔴 TRUNCAR FUTURO (muy importante)
        if (actual.siguiente != null) {
            actual.siguiente.anterior = null;
            actual.siguiente = null;
        }

        actual.siguiente = nuevo;
        nuevo.anterior = actual;
        actual = nuevo;
    }

    // DESHACER
    public void undo() {
        if (actual != null && actual.anterior != null) {
            actual = actual.anterior;
        } else {
            System.out.println("No hay más undo.");
        }
    }

    // REHACER
    public void redo() {
        if (actual != null && actual.siguiente != null) {
            actual = actual.siguiente;
        } else {
            System.out.println("No hay más redo.");
        }
    }
}