// Cliente: solo conoce FabricaJuego, Carta y Ficha (tipos abstractos)
public class Main {

    static void jugar(FabricaJuego fabrica) {
        Carta carta = fabrica.crearCarta();
        Ficha ficha = fabrica.crearFicha();
        System.out.println(carta.describir());
        System.out.println(ficha.describir());
    }

    public static void main(String[] args) {
        System.out.println("=== Mesa de Poker ===");
        jugar(new JuegoPoker());

        System.out.println("\n=== Mesa de juego español ===");
        jugar(new JuegoEspanol());
    }
}
