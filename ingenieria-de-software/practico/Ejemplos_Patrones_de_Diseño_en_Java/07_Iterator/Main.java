/**
 * Client: recorre la MISMA colección (ListaNumeros) con dos
 * iteradores distintos, cada uno con su propia lógica de recorrido y
 * su propio estado (cursor), sin que uno interfiera con el otro.
 */
public class Main {
    public static void main(String[] args) {
        ListaNumeros lista = new ListaNumeros();
        for (int n = 1; n <= 41; n++) {
            lista.agregar(n);
        }

        Iterator pares = lista.createIteradorPares();
        Iterator impares = lista.createIteradorImpares();

        System.out.print("Números pares:   ");
        for (pares.first(); !pares.isDone(); pares.next()) {
            System.out.print(pares.currentItem() + " ");
        }
        System.out.println();

        System.out.print("Números impares: ");
        for (impares.first(); !impares.isDone(); impares.next()) {
            System.out.print(impares.currentItem() + " ");
        }
        System.out.println();

      
    }
}
