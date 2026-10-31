import java.util.ArrayList;
import java.util.List;

/**
 * Invoker: dispara la ejecución (storeCommand -> execute) y almacena
 * el historial de comandos ejecutados en +history.
 */
public class Invoker {

    private List<Command> history = new ArrayList<>();

    public void storeCommand(Command command) {
        command.execute();
        history.add(command);
    }

    public void undoLast() {
        if (!history.isEmpty()) {
            Command last = history.remove(history.size() - 1);
            last.undo();
        }
    }
}
