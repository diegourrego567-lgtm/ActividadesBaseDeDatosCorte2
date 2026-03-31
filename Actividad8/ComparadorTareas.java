import java.util.Comparator;

public class ComparadorTareas implements Comparator<Tarea> {
    @Override
    public int compare(Tarea a, Tarea b) {

        // Primero prioridad (ALTA > MEDIA > BAJA)
        int cmpPrioridad = a.prioridad.compareTo(b.prioridad);
        if (cmpPrioridad != 0)
            return cmpPrioridad;

        // Luego fecha (texto YYYY-MM-DD ordena bien)
        return a.fechaVencimiento.compareTo(b.fechaVencimiento);
    }
}