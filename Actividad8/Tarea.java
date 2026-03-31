public class Tarea {
    String descripcion;
    String fechaVencimiento;
    Prioridad prioridad;
    boolean completada;

    public Tarea(String descripcion, String fechaVencimiento, Prioridad prioridad) {
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.prioridad = prioridad;
        this.completada = false;
    }

    public String toCSV() {
        return descripcion + "," + fechaVencimiento + "," + prioridad + "," + completada;
    }
}