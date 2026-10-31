/**
 * ConcreteCommand: enciende la lámpara.
 *
 * ¿Qué guarda en "state"? El estado PREVIO del receiver (si estaba
 * encendida o apagada antes de ejecutar el comando). No se asume que
 * "undo" siempre vaya a apagar: si por algún motivo la lámpara ya
 * estaba encendida antes (p. ej. porque otro comando la encendió),
 * deshacer este comando no debería apagarla.
 */
public class ComandoEncender implements Command {

    private Lampara receiver;
    private boolean estabaEncendidaAntes;

    public ComandoEncender(Lampara receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        estabaEncendidaAntes = receiver.isEncendida();
        receiver.encender();
    }

    @Override
    public void undo() {
        if (!estabaEncendidaAntes) {
            receiver.apagar();
        }
        // Si ya estaba encendida antes de ejecutar, no hay nada que revertir.
    }
}
