/**
 * @author Andtré Carnero Fernández
 * @version 12.05.2026
 *
 * Representa una casilla del tablero del juego.
 * Cada casilla puede contener agua o una nave.
 */
public class Casilla {

    /**
     * Contenido almacenado en la casilla.
     * Puede ser:
     * - Un objeto Nave
     * - El texto "agua"
     */
    private final Object contenido;

    /**
     * Indica si la casilla ya ha sido atacada anteriormente.
     */
    private boolean disparada = false;

    /**
     * Constructor de la casilla.
     *
     * @param contenido Elemento que contendrá la casilla
     */
    public Casilla(Object contenido) {
        this.contenido = contenido;
    }

    /**
     * Gestiona el disparo recibido en la casilla.
     *
     * Posibles resultados:
     * 0 -> Agua
     * 1 -> Tocado
     * 2 -> Hundido
     *
     * @return Resultado del disparo
     */
    public int recibirDisparo() {

        // Comprueba si la casilla ya fue atacada anteriormente
        if (disparada) {

            // Si contiene una nave, muestra información de la misma
            if (contenido instanceof Nave nave) {

                System.out.println(
                        "Casilla ya disparada con " +
                                nave.getNombre() +
                                ", tipo " +
                                nave.getTipo() +
                                ", con " +
                                nave.getVida() +
                                " vidas"
                );

            } else {

                // Si no hay nave, es agua
                System.out.println("Casilla ya disparada es de agua");
            }

            // Devuelve el estado correspondiente
            return contenido instanceof Nave ? 1 : 0;
        }

        // Marca la casilla como disparada
        disparada = true;

        // Comprueba si la casilla contiene agua
        if (contenido.equals("agua")) {

            return 0; // AGUA

            // Comprueba si contiene una nave
        } else if (contenido instanceof Nave nave) {

            // Delega el disparo a la nave
            return nave.recibirDisparo();
        }

        // Valor por defecto
        return 0;
    }
}