// Client: solo conoce la interfaz Subject
public class Main {

    static void pedir(Subject subject, int posicion) {
        System.out.println("Cliente pide posición " + posicion);
        try {
            int valor = subject.request(posicion);
            System.out.println("-> Valor recibido: " + valor + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println("-> Error: " + e.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        Subject subject = new Proxy();

        pedir(subject, 3);    // está en el proxy
        pedir(subject, 50);   // no está: el proxy crea el real, lo busca, lo carga y lo retorna
        pedir(subject, 50);   // ahora ya está en el proxy
        pedir(subject, 100);  // no está: usa el real ya creado
        pedir(subject, 101);  // fuera de rango
    }
}
