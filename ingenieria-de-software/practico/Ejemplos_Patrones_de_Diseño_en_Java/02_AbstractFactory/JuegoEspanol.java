// FabricaConcreta2
public class JuegoEspanol extends FabricaJuego {

    @Override
    public Carta crearCarta() {
        return new CartaEspanola("Oros", "Rey");
    }

    @Override
    public Ficha crearFicha() {
        return new FichaEspanola(5, "madera");
    }
}
