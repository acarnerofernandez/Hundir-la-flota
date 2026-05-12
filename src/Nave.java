/**
 * Representa una nave del juego Hundir la Flota.
 * Cada nave tiene un nombre, un tipo y una cantidad de vidas.
 *
 * @author André Carnero Fernández
 * @version 12.05.2026
 */
public class Nave {

    /**
     * Nombre identificativo de la nave.
     */
    private final String nombre;

    /**
     * Tipo de nave (portaaviones, submarino, destructor, etc.).
     */
    private final String tipo;

    /**
     * Cantidad de vidas restantes de la nave.
     * Cada disparo recibido reduce una vida.
     */
    private int vida;

    /**
     * Indica si la nave ha sido hundida.
     */
    private boolean hundido;

    /**
     * Constructor de la nave.
     *
     * @param nombre Nombre de la nave
     * @param tipo Tipo de nave
     * @param vida Cantidad inicial de vidas
     */
    public Nave(String nombre, String tipo, int vida) {

        this.nombre = nombre;
        this.tipo = tipo;
        this.vida = vida;

        // Inicialmente la nave no está hundida
        this.hundido = false;
    }

    /**
     * Gestiona el disparo recibido por la nave.
     *
     * Posibles resultados:
     * 1 -> Tocado
     * 2 -> Hundido
     *
     * @return Resultado del disparo
     */
    public int recibirDisparo() {

        // Si la nave ya estaba hundida
        if (hundido) {
            return 2; // HUNDIDO
        }

        // Reduce una vida por el impacto
        vida--;

        // Comprueba si la nave se ha quedado sin vidas
        if (vida <= 0) {

            hundido = true;

            // Mensaje indicando que la nave fue destruida
            System.out.println(nombre + " hundido");

            return 2; // HUNDIDO

        } else {

            // Mensaje indicando daño parcial
            System.out.println(
                    nombre +
                            " tocado. Vida restante: " +
                            vida
            );

            return 1; // TOCADO
        }
    }

    /**
     * Devuelve el nombre de la nave.
     *
     * @return Nombre de la nave
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el tipo de nave.
     *
     * @return Tipo de nave
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Devuelve las vidas restantes de la nave.
     *
     * @return Vidas restantes
     */
    public int getVida() {
        return vida;
    }
}