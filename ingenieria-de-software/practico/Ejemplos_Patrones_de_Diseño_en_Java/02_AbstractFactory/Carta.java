// ProductoAbstractoA
public abstract class Carta {
    protected String palo;
    protected String valor;

    public Carta(String palo, String valor) {
        this.palo = palo;
        this.valor = valor;
    }

    public abstract String describir();
}
