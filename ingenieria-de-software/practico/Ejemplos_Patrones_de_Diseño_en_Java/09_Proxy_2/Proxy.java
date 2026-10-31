// Proxy: mismo arreglo que el RealSubject, pero con pocas posiciones cargadas (caché).
// Si la posición pedida no está cargada, consulta al RealSubject, la guarda y la retorna.
public class Proxy implements Subject {
    private final Integer[] cache = new Integer[RealSubject.TAMANO]; // null = no cargado
    private RealSubject realSubject;                                 

    public Proxy() {
        // Posiciones 1 a 5 cargadas de entrada
        for (int i = 0; i < 5; i++) {
            cache[i] = (i + 1) * 10;
        }
    }

    @Override
    public int request(int posicion) {
        if (posicion < 1 || posicion > RealSubject.TAMANO) {
            throw new IllegalArgumentException("Posición fuera de rango (1.." + RealSubject.TAMANO + "): " + posicion);
        }

        Integer valor = cache[posicion - 1];
        if (valor != null) {
            System.out.println("   [Proxy] Posición " + posicion + " encontrada en el proxy");
            return valor;
        }

        System.out.println("   [Proxy] Posición " + posicion + " NO está en el proxy, se consulta al objeto real");
        if (realSubject == null) {          // se crea recién cuando hace falta
            realSubject = new RealSubject();
        }
        valor = realSubject.request(posicion);   // realSubject->Request()
        cache[posicion - 1] = valor;             // se carga en el proxy
        return valor;
    }
}
