/**
 * Representa el tablero principal del juego Hundir la Flota.
 * Contiene las casillas, las naves y la lógica de colocación.
 *
 * @author André Carnero Fernández
 * @version 12.05.2026
 * */
public class Tablero {

    /**
     * Constante que representa agua.
     */
    public static final int AGUA = 0;

    /**
     * Constante que representa una nave tocada.
     */
    public static final int TOCADO = 1;

    /**
     * Constante que representa una nave hundida.
     */
    public static final int HUNDIDO = 2;

    /**
     * Matriz de casillas que forma el tablero.
     */
    public final Casilla[][] casillero;

    /**
     * Constructor por defecto.
     * Crea un tablero de tamaño 10x10.
     */
    public Tablero() {
        this(10);
    }

    /**
     * Constructor del tablero.
     *
     * @param tamanho Tamaño del tablero cuadrado
     */
    public Tablero(int tamanho) {

        // Inicializa la matriz de casillas
        casillero = new Casilla[tamanho][tamanho];

        // =========================
        // CREACIÓN DE NAVES
        // =========================

        // Portaaviones
        Nave por1 = new Nave("pipi", "portaaviones", 5);

        // Fragatas
        Nave fra1 = new Nave("toto", "fragata", 3);
        Nave fra2 = new Nave("pata", "fragata", 3);
        Nave fra3 = new Nave("potete", "fragata", 3);

        // Submarinos
        Nave sub1 = new Nave("U-47", "submarino", 1);
        Nave sub2 = new Nave("U-96", "submarino", 1);
        Nave sub3 = new Nave("U-505", "submarino", 1);
        Nave sub4 = new Nave("U-534", "submarino", 1);

        // =========================
        // INICIALIZAR EL TABLERO
        // =========================

        // Todas las casillas comienzan como agua
        for (int i = 0; i < tamanho; i++) {

            for (int j = 0; j < tamanho; j++) {

                casillero[i][j] = new Casilla("agua");
            }
        }

        // =========================
        // COLOCACIÓN DE NAVES
        // =========================

        // Colocar portaaviones
        colocarNaveHorizontal(por1, 1, 0, 5);

        // Colocar fragatas
        colocarNaveHorizontal(fra1, 3, 0, 3);
        colocarNaveHorizontal(fra2, 5, 0, 3);
        colocarNaveHorizontal(fra3, 7, 0, 3);

        // Colocar submarinos individuales
        casillero[4][4] = new Casilla(sub1);
        casillero[7][5] = new Casilla(sub3);
        casillero[9][4] = new Casilla(sub4);
        casillero[9][9] = new Casilla(sub2);
    }

    /**
     * Coloca una nave horizontalmente en el tablero.
     *
     * @param nave Nave que se va a colocar
     * @param fila Fila inicial
     * @param columna Columna inicial
     * @param longitud Número de casillas que ocupará la nave
     */
    private void colocarNaveHorizontal(
            Nave nave,
            int fila,
            int columna,
            int longitud
    ) {

        // Recorre la longitud de la nave
        for (int i = 0; i < longitud; i++) {

            // Inserta la misma nave en varias casillas consecutivas
            casillero[fila][columna + i] = new Casilla(nave);
        }
    }
}