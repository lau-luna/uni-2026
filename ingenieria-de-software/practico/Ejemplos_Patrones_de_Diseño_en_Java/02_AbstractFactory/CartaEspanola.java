// ProductoA2
public class CartaEspanola extends Carta {

    public CartaEspanola(String palo, String valor) {
        super(palo, valor);
    }

    @Override
    public String describir() {
        return "Carta española: " + valor + " de " + palo;
    }
}
