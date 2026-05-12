public class Nave {
    private final String nombre;
    private final String tipo;
    private int vida;
    private boolean hundido;

    public Nave(String nombre, String tipo, int vida) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.vida = vida;
        this.hundido = false;
    }

    public int recibirDisparo() {
        if (hundido) {
            return 2; // HUNDIDO
        }

        vida--;

        if (vida <= 0) {
            hundido = true;
            System.out.println(nombre + " hundido");
            return 2; // HUNDIDO
        } else {
            System.out.println(nombre + " tocado. Vida restante: " + vida);
            return 1; // TOCADO
        }
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getVida() { return vida; }
}