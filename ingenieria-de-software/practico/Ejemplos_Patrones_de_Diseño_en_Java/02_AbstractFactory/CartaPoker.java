// ProductoA1
public class CartaPoker extends Carta {

    public CartaPoker(String palo, String valor) {
        super(palo, valor);
    }

    @Override
    public String describir() {
        return "Carta de poker: " + valor + " de " + palo;
    }
}
