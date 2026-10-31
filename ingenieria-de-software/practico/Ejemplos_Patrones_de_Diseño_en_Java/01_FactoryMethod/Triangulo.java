/**
 * Product: clase abstracta común a todos los triángulos. Guarda las
 * medidas de los tres lados y declara el método que cada tipo
 * concreto debe implementar para identificarse.
 */
public abstract class Triangulo {

    protected int lado1;
    protected int lado2;
    protected int lado3;

    public Triangulo(int lado1, int lado2, int lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public abstract String getTipo();

    public void mostrar() {
        System.out.println("Soy un triángulo " + getTipo()
                + " de lados " + lado1 + ", " + lado2 + ", " + lado3);
    }
}
