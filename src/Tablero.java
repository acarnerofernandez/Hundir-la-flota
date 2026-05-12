public class Tablero {

    public static final int AGUA = 0;
    public static final int TOCADO = 1;
    public static final int HUNDIDO = 2;

    public final Casilla[][] casillero;

    public Tablero() {
        this(10);
    }

    public Tablero(int tamanho) {
        casillero = new Casilla[tamanho][tamanho];

        // Crear naves
        Nave por1 = new Nave("pipi", "portaaviones", 5);
        Nave fra1 = new Nave("toto", "fragata", 3);
        Nave fra2 = new Nave("pata", "fragata", 3);
        Nave fra3 = new Nave("potete", "fragata", 3);
        Nave sub1 = new Nave("U-47", "submarino", 1);
        Nave sub2 = new Nave("U-96", "submarino", 1);
        Nave sub3 = new Nave("U-505", "submarino", 1);
        Nave sub4 = new Nave("U-534", "submarino", 1);

        // Inicializar todo como agua
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                casillero[i][j] = new Casilla("agua");
            }
        }

        // Colocar naves
        colocarNaveHorizontal(por1, 1, 0, 5);
        colocarNaveHorizontal(fra1, 3, 0, 3);
        colocarNaveHorizontal(fra2, 5, 0, 3);
        colocarNaveHorizontal(fra3, 7, 0, 3);

        casillero[4][4] = new Casilla(sub1);
        casillero[7][5] = new Casilla(sub3);
        casillero[9][4] = new Casilla(sub4);
        casillero[9][9] = new Casilla(sub2);
    }

    private void colocarNaveHorizontal(Nave nave, int fila, int columna, int longitud) {
        for (int i = 0; i < longitud; i++) {
            casillero[fila][columna + i] = new Casilla(nave);
        }
    }
}