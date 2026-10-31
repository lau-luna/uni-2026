/** Cliente: siempre obtiene la misma instancia a través de getInstancia() */
public class Main {
    public static void main(String[] args) {
        ObjetoSingleton s1 = ObjetoSingleton.getInstancia();
        s1.incrementar();

        ObjetoSingleton s2 = ObjetoSingleton.getInstancia();
        s2.incrementar();
        s2.incrementar();

        System.out.println("s1 == s2 ? " + (s1 == s2));
        System.out.println("Contador final (compartido): " + s1.getContador());
    }
}
