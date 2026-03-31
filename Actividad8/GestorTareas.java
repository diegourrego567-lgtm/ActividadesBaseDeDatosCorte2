import java.io.*;
import java.util.*;

public class GestorTareas {

    LinkedList<Tarea> tareas = new LinkedList<>();

    public void agregar(Tarea t) {
        tareas.addLast(t);
    }

    public void mostrar() {
        int i = 1;
        for (Tarea t : tareas) {
            System.out.println(i++ + ". " + t.descripcion +
                    " | " + t.prioridad +
                    " | " + t.fechaVencimiento +
                    " | " + (t.completada ? "✔" : "Pendiente"));
        }
    }

    public void completar(int index) {
        if (index >= 0 && index < tareas.size())
            tareas.get(index).completada = true;
    }

    public void eliminarCompletadas() {
        tareas.removeIf(t -> t.completada);
    }

    public void ordenar() {
        Collections.sort(tareas, new ComparadorTareas());
    }

    // GUARDAR CSV
    public void guardar(String archivo) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
        for (Tarea t : tareas) {
            bw.write(t.toCSV());
            bw.newLine();
        }
        bw.close();
    }

    // CARGAR CSV
    public void cargar(String archivo) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] d = linea.split(",");
            Tarea t = new Tarea(d[0], d[1], Prioridad.valueOf(d[2]));
            t.completada = Boolean.parseBoolean(d[3]);
            tareas.add(t);
        }
        br.close();
    }
}