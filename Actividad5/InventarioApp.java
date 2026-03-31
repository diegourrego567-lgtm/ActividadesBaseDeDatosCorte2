import java.util.Scanner;

public class InventarioApp {

    public static void main(String[] args) throws Exception {

        ListaSimple inventario = new ListaSimple();
        Scanner sc = new Scanner(System.in);

        // Cargar archivo si existe
        try {
            inventario.cargarArchivo("inventario.csv");
        } catch (Exception e) {
            System.out.println("No existe archivo inicial.");
        }

        int opcion;

        do {
            System.out.println("\n===== MENU INVENTARIO =====");
            System.out.println("1. Agregar producto");
            System.out.println("2. Buscar por ID");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Mostrar inventario");
            System.out.println("5. Ordenar por ID");
            System.out.println("6. Guardar y salir");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();

                    inventario.insertarFinal(
                        new Producto(id, nombre, cantidad, precio));
                    break;

                case 2:
                    System.out.print("ID a buscar: ");
                    Producto p = inventario.buscarPorId(sc.nextInt());
                    if (p != null)
                        System.out.println("Encontrado: " + p.nombre);
                    else
                        System.out.println("No existe.");
                    break;

                case 3:
                    System.out.print("ID a eliminar: ");
                    inventario.eliminarPorId(sc.nextInt());
                    break;

                case 4:
                    inventario.mostrar();
                    break;

                case 5:
                    inventario.ordenarPorId();
                    System.out.println("Ordenado.");
                    break;

            }

        } while (opcion != 6);

        inventario.guardarArchivo("inventario.csv");
        System.out.println("Datos guardados. Fin del programa.");
    }
}