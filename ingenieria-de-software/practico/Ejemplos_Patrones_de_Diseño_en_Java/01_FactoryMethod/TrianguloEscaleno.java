/** ConcreteProduct: los tres lados son distintos. */
public class TrianguloEscaleno extends Triangulo {
    public TrianguloEscaleno(int lado1, int lado2, int lado3) {
        super(lado1, lado2, lado3);
    }

    @Override
    public String getTipo() {
        return "escaleno";
    }
}
