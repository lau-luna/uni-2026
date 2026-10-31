/**
 * Creator: una única fábrica cuyo método de creación (crearTriangulo)
 * recibe los tres lados como parámetro y decide, según esos valores,
 * qué ConcreteProduct instanciar. El cliente nunca hace "new
 * TrianguloXxx()" directamente: sólo le pide a la fábrica un
 * triángulo y ella resuelve internamente cuál construir.
 */
public class FabricaTriangulos extends FabricaTrianguloAbstracta {

    public Triangulo crearTriangulo(int lado1, int lado2, int lado3) {
        validar(lado1, lado2, lado3);
    
        if (lado1 == lado2 && lado2 == lado3) {
            return new TrianguloEquilatero(lado1, lado2, lado3);
        } else if (lado1 == lado2 || lado2 == lado3 || lado1 == lado3) {
            return new TrianguloIsosceles(lado1, lado2, lado3);
        } else {
            return new TrianguloEscaleno(lado1, lado2, lado3);
        }
    }

    private void validar(int lado1, int lado2, int lado3) {
        if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
            throw new IllegalArgumentException("Los lados deben ser positivos");
        }
        boolean desigualdadTriangular = lado1 + lado2 > lado3
                && lado1 + lado3 > lado2
                && lado2 + lado3 > lado1;
        if (!desigualdadTriangular) {
            throw new IllegalArgumentException(
                    "Las medidas " + lado1 + ", " + lado2 + ", " + lado3
                            + " no forman un triángulo válido");
        }
    }
}
