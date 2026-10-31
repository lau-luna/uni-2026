/**
 * ConcreteCommand: enciende la lámpara, espera 1 minuto mostrando un
 * mensaje, y luego la apaga automáticamente.
 *
 * "state" vuelve a guardar el estado PREVIO (antes de ejecutar). Como
 * execute() es sincrónico (bloquea hasta terminar la espera), cuando
 * undo() se invoca el comando ya terminó y la lámpara ya quedó
 * apagada por sí sola; undo() simplemente restaura lo que había antes
 * de arrancar toda la secuencia (por ejemplo, si ya estaba encendida
 * antes de ejecutar este comando, undo la vuelve a encender).
 */
public class ComandoEncenderPor1Minuto implements Command {


    private Lampara receiver;
    private boolean estabaEncendidaAntes;

    public ComandoEncenderPor1Minuto(Lampara receiver) {
        this.receiver=receiver;
    }

    @Override
    public void execute() {
        estabaEncendidaAntes = receiver.isEncendida();
        receiver.encender();
        System.out.println("Esperando 1 minuto...");
       
        receiver.apagar();
    }

    @Override
    public void undo() {
        if (estabaEncendidaAntes) {
            receiver.encender();
        }
        // Si antes estaba apagada, no hace falta hacer nada: ya quedó apagada.
    }
}
