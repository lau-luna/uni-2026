// FabricaConcreta1
public class JuegoPoker extends FabricaJuego {

    @Override
    public Carta crearCarta() {
        return new CartaPoker("Picas", "As");
    }

    @Override
    public Ficha crearFicha() {
        return new FichaPoker(100, "negra");
    }
}
