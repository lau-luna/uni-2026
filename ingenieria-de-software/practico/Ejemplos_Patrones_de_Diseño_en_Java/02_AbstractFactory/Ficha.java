// ProductoAbstractoB
public abstract class Ficha {
    protected int valor;

    public Ficha(int valor) {
        this.valor = valor;
    }

    public abstract String describir();
}
