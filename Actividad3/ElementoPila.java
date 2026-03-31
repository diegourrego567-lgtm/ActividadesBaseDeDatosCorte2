public class ElementoPila {
    String simbolo;
    int linea;
    int columna;
    ElementoPila siguiente;

    public ElementoPila(String simbolo, int linea, int columna) {
        this.simbolo = simbolo;
        this.linea = linea;
        this.columna = columna;
        this.siguiente = null;
    }
}