/** 
 * Clase IteradorPares que implementa el patrón de diseño Iterator.
 * Permite iterar sobre una lista de números y obtener solo los números pares.
 */
public class IteradorPares extends Iterator {

    private ListaNumeros aggregate;
    private int current;

    public IteradorPares(ListaNumeros aggregate) {
        this.aggregate = aggregate;
        this.current = 0;
    }

    private boolean esValido(int indice) {
        return aggregate.getNumeros().get(indice) % 2 == 0;
    }

    @Override
    public void first() {
        current = 0;
        while (!isDone() && !esValido(current)) {
            current++;
        }
    }

    @Override
    public void next() {
        current++;
        while (!isDone() && !esValido(current)) {
            current++;
        }
    }

    @Override
    public boolean isDone() {
        return current >= aggregate.getNumeros().size();
    }

    @Override
    public int currentItem() {
        return aggregate.getNumeros().get(current);
    }
}
