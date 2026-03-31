import java.io.*;

public class ListaSimple {

    private Nodo cabeza;

    // INSERTAR AL INICIO
    public void insertarInicio(Producto p) {
        Nodo nuevo = new Nodo(p);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    // INSERTAR AL FINAL
    public void insertarFinal(Producto p) {
        Nodo nuevo = new Nodo(p);

        if (cabeza == null) {
            cabeza = nuevo;
            return;
        }

        Nodo aux = cabeza;
        while (aux.siguiente != null)
            aux = aux.siguiente;

        aux.siguiente = nuevo;
    }

    // BUSCAR POR ID
    public Producto buscarPorId(int id) {
        Nodo aux = cabeza;
        while (aux != null) {
            if (aux.producto.id == id)
                return aux.producto;
            aux = aux.siguiente;
        }
        return null;
    }

    // BUSCAR POR NOMBRE
    public Producto buscarPorNombre(String nombre) {
        Nodo aux = cabeza;
        while (aux != null) {
            if (aux.producto.nombre.equalsIgnoreCase(nombre))
                return aux.producto;
            aux = aux.siguiente;
        }
        return null;
    }

    // ELIMINAR POR ID
    public void eliminarPorId(int id) {
        if (cabeza == null) return;

        if (cabeza.producto.id == id) {
            cabeza = cabeza.siguiente;
            return;
        }

        Nodo aux = cabeza;
        while (aux.siguiente != null) {
            if (aux.siguiente.producto.id == id) {
                aux.siguiente = aux.siguiente.siguiente;
                return;
            }
            aux = aux.siguiente;
        }
    }

    // MOSTRAR INVENTARIO
    public void mostrar() {
        Nodo aux = cabeza;
        System.out.println("\n=== INVENTARIO ===");
        while (aux != null) {
            Producto p = aux.producto;
            System.out.println(p.id + " | " + p.nombre +
                    " | Cantidad: " + p.cantidad +
                    " | $" + p.precio);
            aux = aux.siguiente;
        }
    }

    // 🔵 ORDENAR POR ID (BUBBLE SORT ENLAZADO)
    public void ordenarPorId() {
        if (cabeza == null) return;

        boolean cambio;
        do {
            cambio = false;
            Nodo actual = cabeza;

            while (actual.siguiente != null) {
                if (actual.producto.id > actual.siguiente.producto.id) {
                    Producto temp = actual.producto;
                    actual.producto = actual.siguiente.producto;
                    actual.siguiente.producto = temp;
                    cambio = true;
                }
                actual = actual.siguiente;
            }
        } while (cambio);
    }

    // 🔵 GUARDAR CSV
    public void guardarArchivo(String nombreArchivo) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo));
        Nodo aux = cabeza;
        while (aux != null) {
            bw.write(aux.producto.toCSV());
            bw.newLine();
            aux = aux.siguiente;
        }
        bw.close();
    }

    // 🔵 CARGAR CSV
    public void cargarArchivo(String nombreArchivo) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            Producto p = new Producto(
                    Integer.parseInt(datos[0]),
                    datos[1],
                    Integer.parseInt(datos[2]),
                    Double.parseDouble(datos[3])
            );
            insertarFinal(p);
        }
        br.close();
    }
}