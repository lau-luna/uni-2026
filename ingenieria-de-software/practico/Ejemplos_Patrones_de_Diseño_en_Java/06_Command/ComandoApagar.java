/**
 * ConcreteCommand: apaga la lámpara.
 *
 * Igual criterio que ComandoEncender: guarda el estado previo para
 * poder restaurarlo con precisión.
 */
public class ComandoApagar implements Command {

    private Lampara receiver;
    private boolean estabaEncendidaAntes;

    public ComandoApagar(Lampara receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        estabaEncendidaAntes = receiver.isEncendida();
        receiver.apagar();
    }

    @Override
    public void undo() {
        if (estabaEncendidaAntes) {
            receiver.encender();
        }
    }
}
