import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteAggregate: contiene la colección real de datos (una lista de
 * enteros). En vez de un único createIterator(), expone dos "factory
 * methods" que devuelven iteradores distintos sobre la MISMA
 * colección: uno para pares y otro para impares.
 */
public class ListaNumeros {

    private List<Integer> numeros = new ArrayList<>();

    public void agregar(int n) {
        numeros.add(n);
    }

    public List<Integer> getNumeros() {
        return numeros;
    }

    public Iterator createIteradorPares() {
        return new IteradorPares(this);
    }

    public Iterator createIteradorImpares() {
        return new IteradorImpares(this);
    }
}
