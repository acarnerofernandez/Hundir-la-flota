/**
        * Clase principal del juego Hundir la Flota.
        * Se encarga de crear el tablero y gestionar los ataques de prueba.
        *
        * @author André Carnero Fernández
        * @version 12.05.2026
 */

public class Juego {

    /**
     * Tablero principal donde se desarrolla la partida.
     */
    private final Tablero tablero;

    /**
     * Constructor del juego.
     * Inicializa el tablero y ejecuta varios ataques de prueba.
     *
     */
    public Juego() {
        tablero = new Tablero();

        // Ataques de prueba
        lanzarAtaque(1, 0);
        lanzarAtaque(1, 0);
        lanzarAtaque(1, 1);
        lanzarAtaque(1, 2);
        lanzarAtaque(1, 3);
        lanzarAtaque(1, 4);
    }

    /**
     * Realiza un ataque sobre una posición concreta del tablero.
     *
     * @param x Coordenada horizontal de la casilla
     * @param y Coordenada vertical de la casilla
     */
    public void lanzarAtaque(int x, int y) {

        // Muestra por pantalla la posición atacada
        System.out.println("Ataque a " + x + "," + y);

        // Obtiene la casilla correspondiente
        Casilla casilla = tablero.casillero[x][y];

        // Ejecuta el disparo y guarda el resultado
        int resultado = casilla.recibirDisparo();

        // Muestra el resultado del ataque
        mostrarResultado(resultado);
    }

    /**
     * Muestra por pantalla el resultado del disparo.
     *
     * Valores posibles:
     * 0 -> Agua
     * 1 -> Tocado
     * 2 -> Hundido
     *
     * @param resultado Resultado devuelto por la casilla
     */
    private void mostrarResultado(int resultado) {

        // Switch expression para interpretar el resultado
        switch (resultado) {

            // No había barco en la casilla
            case 0 -> System.out.println("Agua");

            // Se ha impactado un barco
            case 1 -> System.out.println("Tocado");

            // El barco ha sido destruido completamente
            case 2 -> System.out.println("Hundido");
        }
    }

    /**
     * Método principal del programa.
     * Inicia una nueva partida.
     *
     *
     */
    public static void main(String[] args) {
        new Juego();
    }
}