import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteMediator: implementa la lógica de coordinación. Mantiene las
 * referencias a los colegas concretos (el "grupo") y redistribuye las
 * notificaciones entre ellos cuando alguno envía un mensaje.
 */
public class ConcreteMediator implements Mediator {

    private List<Colleague> colegas = new ArrayList<>();

    public void agregarColega(Colleague colega) {
        colegas.add(colega);
    }

    @Override
    public void send(String mensaje, Colleague remitente) {
        for (Colleague colega : colegas) {
            if (colega != remitente) {
                colega.notify(remitente.getNombre() + ": " + mensaje);
            }
        }
    }
}
