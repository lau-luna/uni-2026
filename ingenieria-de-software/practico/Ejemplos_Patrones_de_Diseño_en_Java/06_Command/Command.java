/**
 * Command: interfaz que define el contrato común (execute/undo) de
 * forma polimórfica.
 */
public interface Command {
    void execute();
    void undo();
}
