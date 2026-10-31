/**
 * Leaf: representa un archivo individual, sin hijos. Es la unidad
 * simple del sistema de archivos.
 */
public class Archivo extends Componente {

    private int tamanoKB;

    public Archivo(String nombre, int tamanoKB) {
        super(nombre);
        this.tamanoKB = tamanoKB;
    }

    @Override
    public int getTamanoKB() {
        return tamanoKB;
    }

    @Override
    public void mostrar(int nivel) {
        System.out.println("  ".repeat(nivel) + "- " + nombre + " (" + tamanoKB + " KB)");
    }
}
