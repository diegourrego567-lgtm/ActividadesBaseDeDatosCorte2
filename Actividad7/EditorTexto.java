import java.util.Scanner;

public class EditorTexto {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Historial historial = new Historial();

        System.out.println("=== Editor de Texto ===");
        System.out.println("Comandos:");
        System.out.println("guardar -> guarda nuevo texto");
        System.out.println("undo -> deshacer");
        System.out.println("redo -> rehacer");
        System.out.println("mostrar -> ver texto actual");
        System.out.println("salir");

        while (true) {

            System.out.print("\n> ");
            String comando = sc.nextLine();

            switch (comando) {

                case "guardar":
                    System.out.println("Escribe el nuevo texto:");
                    String texto = sc.nextLine();
                    historial.agregarEstado(texto);
                    break;

                case "undo":
                    historial.undo();
                    break;

                case "redo":
                    historial.redo();
                    break;

                case "mostrar":
                    System.out.println("Texto actual:");
                    System.out.println(historial.obtenerTextoActual());
                    break;

                case "salir":
                    System.out.println("Fin del editor.");
                    return;

                default:
                    System.out.println("Comando inválido.");
            }
        }
    }
}