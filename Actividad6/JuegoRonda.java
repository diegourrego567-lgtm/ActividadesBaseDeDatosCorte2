import java.util.Random;

public class JuegoRonda {

    public static void main(String[] args) {

        ListaCircular mesa = new ListaCircular();
        Random rand = new Random();

        // Crear jugadores
        mesa.insertarJugador(new Jugador("Ana"));
        mesa.insertarJugador(new Jugador("Luis"));
        mesa.insertarJugador(new Jugador("Carlos"));
        mesa.insertarJugador(new Jugador("Maria"));
        mesa.insertarJugador(new Jugador("Pedro"));

        System.out.println("=== INICIO DEL JUEGO ===");

        while (mesa.contarJugadores() > 1) {

            mesa.mostrarJugadores();

            Jugador turno = mesa.getActual();
            int evento = rand.nextInt(100);

            // 60% gana puntos
            if (evento < 60) {
                int puntos = rand.nextInt(5) + 1;
                turno.puntos += puntos;
                System.out.println("\n" + turno.nombre +
                        " gana " + puntos + " puntos!");
            }
            // 40% eliminado
            else {
                System.out.println("\n" + turno.nombre + " ha sido ELIMINADO!");
                mesa.eliminarActual();
                continue;
            }

            mesa.avanzarTurno();
        }

        System.out.println("\n🏆 GANADOR: " +
                mesa.getActual().nombre);
    }
}