import java.util.ArrayList;
import java.util.List;

/**
 * Composite: representa una carpeta, que puede contener tanto
 * Archivos como otras Carpetas. add() agrega un elemento, remove() lo
 * quita y getChild() permite recuperar un elemento hijo por índice.
 * getTamanoKB() suma recursivamente el tamaño de todo su contenido.
 */
public class Carpeta extends Componente {

    private List<Componente> hijos = new ArrayList<>();

    public Carpeta(String nombre) {
        super(nombre);
    }

    @Override
    public void add(Componente c) {
        hijos.add(c);
    }

    @Override
    public void remove(Componente c) {
        hijos.remove(c);
    }

    @Override
    public Componente getChild(int i) {
        return hijos.get(i);
    }

    @Override
    public int getTamanoKB() {
        int total = 0;
        for (Componente hijo : hijos) {
            total += hijo.getTamanoKB();
        }
        return total;
    }

    @Override
    public void mostrar(int nivel) {
        System.out.println("  ".repeat(nivel) + "+ " + nombre + "/  (" + getTamanoKB() + " KB)");
        for (Componente hijo : hijos) {
            hijo.mostrar(nivel + 1);
        }
    }
}
