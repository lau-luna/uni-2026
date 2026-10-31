// ProductoB2
public class FichaEspanola extends Ficha {
    private String material;

    public FichaEspanola(int valor, String material) {
        super(valor);
        this.material = material;
    }

    @Override
    public String describir() {
        return "Ficha de " + material + " (estilo tradicional) de valor " + valor;
    }
}
