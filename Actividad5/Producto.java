public class Producto {
    int id;
    String nombre;
    int cantidad;
    double precio;

    public Producto(int id, String nombre, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String toCSV() {
        return id + "," + nombre + "," + cantidad + "," + precio;
    }
}