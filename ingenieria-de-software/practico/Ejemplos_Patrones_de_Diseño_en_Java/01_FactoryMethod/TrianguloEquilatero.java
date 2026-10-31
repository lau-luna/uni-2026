/** ConcreteProduct: los tres lados son iguales. */
public class TrianguloEquilatero extends Triangulo {
    public TrianguloEquilatero(int lado1, int lado2, int lado3) {
        super(lado1, lado2, lado3);
    }

    @Override
    public String getTipo() {
        return "equilátero";
    }
}
