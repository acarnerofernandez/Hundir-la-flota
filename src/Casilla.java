public class Casilla {
    private final Object contenido; // Nave o "agua"
    private boolean disparada = false;

    public Casilla(Object contenido) {
        this.contenido = contenido;
    }

    public int recibirDisparo() {
        if (disparada) {
            if (contenido instanceof Nave nave) {
                System.out.println("Casilla ya disparada con " + nave.getNombre() +
                        ", tipo " + nave.getTipo() + ", con " + nave.getVida() + " vidas");
            } else {
                System.out.println("Casilla ya disparada es de agua");
            }
            return contenido instanceof Nave ? 1 : 0;
        }

        disparada = true;

        if (contenido.equals("agua")) {
            return 0; // AGUA
        } else if (contenido instanceof Nave nave) {
            return nave.recibirDisparo();
        }

        return 0;
    }
}