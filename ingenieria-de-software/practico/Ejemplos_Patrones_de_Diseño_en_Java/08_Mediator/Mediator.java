/**
 * Mediator: define la comunicación centralizada declarando el método
 * de notificación que utilizarán los colegas para enviarse mensajes
 * de forma indirecta.
 */
public interface Mediator {
    void send(String mensaje, Colleague remitente);
}
