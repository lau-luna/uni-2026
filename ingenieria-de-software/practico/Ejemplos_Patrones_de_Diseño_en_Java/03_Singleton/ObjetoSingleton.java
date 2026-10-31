/**
 * Singleton: garantiza que la clase tenga una única instancia y
 * proporciona un punto de acceso global a ella.
 *
 * - instancia: atributo privado y estático de tipo ObjetoSingleton.
 * - ObjetoSingleton(): constructor privado (nadie fuera de la clase
 *   puede instanciarla con "new").
 * - getInstancia(): método público que retorna la única instancia
 *   existente, creándola la primera vez que se solicita.
 */
public class ObjetoSingleton {

    private static ObjetoSingleton instancia;
    private int contador;

    // Constructor privado
    private ObjetoSingleton() {
        contador = 0;
        System.out.println("Se creó la única instancia de ObjetoSingleton");
    }

    public static ObjetoSingleton getInstancia() {
        if (instancia == null) {
            instancia = new ObjetoSingleton();
        }
        return instancia;
    }

    public void incrementar() {
        contador++;
    }

    public int getContador() {
        return contador;
    }
}
