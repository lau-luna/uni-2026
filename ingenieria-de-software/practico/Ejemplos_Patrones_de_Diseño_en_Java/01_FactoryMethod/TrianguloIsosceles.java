/** ConcreteProduct: exactamente dos lados son iguales. */
public class TrianguloIsosceles extends Triangulo {
    public TrianguloIsosceles(int lado1, int lado2, int lado3) {
        super(lado1, lado2, lado3);
    }

    @Override
    public String getTipo() {
        return "isósceles";
    }
}
