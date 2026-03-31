import java.util.Comparator;

public class ComparadorPrioridad implements Comparator<Cliente> {
    @Override
    public int compare(Cliente a, Cliente b) {

        // URGENTES tienen prioridad
        if (!a.tipo.equals(b.tipo)) {
            return a.tipo.equals("URGENTE") ? -1 : 1;
        }

        // Si son del mismo tipo -> llega primero el que llegó antes
        return Integer.compare(a.llegada, b.llegada);
    }
}