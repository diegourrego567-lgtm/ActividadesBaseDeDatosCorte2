import java.util.Scanner;

public class AppTareas {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        GestorTareas gestor = new GestorTareas();

        try {
            gestor.cargar("tareas.csv");
        } catch (Exception e) {
            System.out.println("No hay archivo inicial.");
        }

        int op;

        do {
            System.out.println("\n=== TO-DO LIST ===");
            System.out.println("1 Agregar tarea");
            System.out.println("2 Mostrar tareas");
            System.out.println("3 Completar tarea");
            System.out.println("4 Eliminar completadas");
            System.out.println("5 Ordenar");
            System.out.println("6 Guardar y salir");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Descripcion: ");
                    String desc = sc.nextLine();
                    System.out.print("Fecha (YYYY-MM-DD): ");
                    String fecha = sc.nextLine();
                    System.out.print("Prioridad (ALTA/MEDIA/BAJA): ");
                    Prioridad pr = Prioridad.valueOf(sc.nextLine().toUpperCase());
                    gestor.agregar(new Tarea(desc, fecha, pr));
                    break;

                case 2:
                    gestor.mostrar();
                    break;

                case 3:
                    System.out.print("Numero tarea: ");
                    gestor.completar(sc.nextInt() - 1);
                    break;

                case 4:
                    gestor.eliminarCompletadas();
                    break;

                case 5:
                    gestor.ordenar();
                    break;

            }

        } while (op != 6);

        gestor.guardar("tareas.csv");
        System.out.println("Guardado. Adiós.");
    }
}