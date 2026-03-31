public class Cliente {
    String id;
    String tipo; // "NORMAL" o "URGENTE"
    int llegada;
    int tiempoAtencion;

    public Cliente(String id, String tipo, int llegada, int tiempoAtencion) {
        this.id = id;
        this.tipo = tipo;
        this.llegada = llegada;
        this.tiempoAtencion = tiempoAtencion;
    }
}