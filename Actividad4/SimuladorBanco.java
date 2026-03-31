import java.util.PriorityQueue;
import java.util.Random;

public class SimuladorBanco {

    public static void main(String[] args) {

        ColaFIFO colaNormal = new ColaFIFO();
        PriorityQueue<Cliente> colaUrgente =
                new PriorityQueue<>(new ComparadorPrioridad());

        Random rand = new Random();

        int tiempoTotal = 50;
        int clientesAtendidos = 0;
        int tiempoEsperaTotal = 0;
        int reloj = 0;
        int contadorClientes = 1;

        System.out.println("==== INICIO SIMULACIÓN BANCO ====\n");

        while (reloj < tiempoTotal) {

            // 🔹 Llegada aleatoria de clientes
            if (rand.nextBoolean()) {
                String tipo = rand.nextInt(100) < 30 ? "URGENTE" : "NORMAL";
                int tiempoAtencion = rand.nextInt(4) + 2;

                Cliente nuevo = new Cliente(
                        "C" + contadorClientes++, tipo, reloj, tiempoAtencion);

                if (tipo.equals("URGENTE")) {
                    colaUrgente.add(nuevo);
                    System.out.println("Llega cliente URGENTE: " + nuevo.id);
                } else {
                    colaNormal.encolar(nuevo);
                    System.out.println("Llega cliente NORMAL: " + nuevo.id);
                }
            }

            // 🔹 Atención en ventanilla (prioridad primero)
            Cliente atendido = null;

            if (!colaUrgente.isEmpty()) {
                atendido = colaUrgente.poll();
            } else if (!colaNormal.estaVacia()) {
                atendido = colaNormal.desencolar();
            }

            if (atendido != null) {
                int espera = reloj - atendido.llegada;
                tiempoEsperaTotal += espera;
                clientesAtendidos++;

                System.out.println("Atendiendo " + atendido.id +
                        " (" + atendido.tipo + ") - Esperó: " + espera);
            }

            reloj++;
        }

        // 🔹 Estadísticas finales
        System.out.println("\n==== FIN SIMULACIÓN ====");
        System.out.println("Clientes atendidos: " + clientesAtendidos);

        if (clientesAtendidos > 0) {
            System.out.println("Tiempo promedio de espera: "
                    + (tiempoEsperaTotal / clientesAtendidos));
        }
    }
}