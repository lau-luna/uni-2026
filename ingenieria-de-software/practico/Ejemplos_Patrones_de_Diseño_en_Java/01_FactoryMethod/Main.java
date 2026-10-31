/**
 * Client: le pide triángulos a la fábrica pasando sólo las medidas de
 * los lados. No conoce ni le importa cuál subclase concreta de
 * Triangulo termina recibiendo.
 */
public class Main {
    public static void main(String[] args) {
        FabricaTriangulos fabrica = new FabricaTriangulos();

        Triangulo t1 = fabrica.crearTriangulo(5, 5, 5);
        Triangulo t2 = fabrica.crearTriangulo(5, 5, 8);
        Triangulo t3 = fabrica.crearTriangulo(3, 4, 5);

        t1.mostrar();
        t2.mostrar();
        t3.mostrar();

        System.out.println();
        System.out.println("Intentando crear un triángulo inválido (1, 100, 100)...");
        try {
            fabrica.crearTriangulo(1, 100, 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
