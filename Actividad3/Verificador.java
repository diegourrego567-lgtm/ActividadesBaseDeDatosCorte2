import java.util.Scanner;

public class Verificador {

    // ===== IMPLEMENTACIÓN MANUAL DE PILA =====
    static class Pila {
        private ElementoPila cima;

        public boolean estaVacia() {
            return cima == null;
        }

        public void push(String simbolo, int linea, int columna) {
            ElementoPila nuevo = new ElementoPila(simbolo, linea, columna);
            nuevo.siguiente = cima;
            cima = nuevo;
        }

        public ElementoPila pop() throws Exception {
            if (estaVacia())
                throw new Exception("Intento de desapilar con pila vacía");

            ElementoPila aux = cima;
            cima = cima.siguiente;
            return aux;
        }

        public ElementoPila peek() {
            return cima;
        }
    }

    // ===== MÉTODOS AUXILIARES =====
    static boolean esApertura(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    static boolean esCierre(char c) {
        return c == ')' || c == '}' || c == ']';
    }

    static boolean coincide(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
               (apertura == '{' && cierre == '}') ||
               (apertura == '[' && cierre == ']');
    }

    // ===== VERIFICADOR PRINCIPAL =====
    static void verificarTexto(String texto) {
        Pila pila = new Pila();
        int linea = 1, columna = 0;

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            columna++;

            if (c == '\n') {
                linea++;
                columna = 0;
                continue;
            }

            if (esApertura(c)) {
                pila.push(String.valueOf(c), linea, columna);
            }
            else if (esCierre(c)) {
                try {
                    ElementoPila apertura = pila.pop();
                    if (!coincide(apertura.simbolo.charAt(0), c)) {
                        System.out.println("Error de jerarquía en línea " + linea +
                                ", columna " + columna +
                                ". Se esperaba cierre para " + apertura.simbolo);
                        return;
                    }
                } catch (Exception e) {
                    System.out.println("Cierre sin apertura en línea " + linea +
                            ", columna " + columna);
                    return;
                }
            }
        }

        // Si quedan elementos sin cerrar
        if (!pila.estaVacia()) {
            ElementoPila restante = pila.peek();
            System.out.println("Apertura sin cierre: " + restante.simbolo +
                    " en línea " + restante.linea +
                    ", columna " + restante.columna);
        } else {
            System.out.println("✔ Texto correctamente balanceado.");
        }
    }

    // ===== MAIN =====
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el texto a verificar (finalice con una línea vacía):");

        StringBuilder texto = new StringBuilder();
        while (true) {
            String linea = sc.nextLine();
            if (linea.isEmpty()) break;
            texto.append(linea).append("\n");
        }

        verificarTexto(texto.toString());
    }
}