// RealSubject: tiene el arreglo completo (100 elementos) cargado
public class RealSubject implements Subject {
    public static final int TAMANO = 100;
    private final int[] datos = new int[TAMANO];

    public RealSubject() {
        // Simula una carga costosa del arreglo completo
        System.out.println("   [RealSubject] Cargando arreglo completo de " + TAMANO + " elementos...");
        for (int i = 0; i < TAMANO; i++) {
            datos[i] = (i + 1) * 10;   // posición 1 -> 10, posición 2 -> 20, ...
        }
    }

    @Override
    public int request(int posicion) {
        validar(posicion);
        System.out.println("   [RealSubject] Buscando posición " + posicion + " en el arreglo completo");
        return datos[posicion - 1];
    }

    private void validar(int posicion) {
        if (posicion < 1 || posicion > TAMANO) {
            throw new IllegalArgumentException("Posición fuera de rango (1.." + TAMANO + "): " + posicion);
        }
    }
}
