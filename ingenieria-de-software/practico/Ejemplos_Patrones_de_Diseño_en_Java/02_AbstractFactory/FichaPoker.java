// ProductoB1
public class FichaPoker extends Ficha {
    private String color;

    public FichaPoker(int valor, String color) {
        super(valor);
        this.color = color;
    }

    @Override
    public String describir() {
        return "Ficha de poker " + color + " de valor " + valor;
    }
}
