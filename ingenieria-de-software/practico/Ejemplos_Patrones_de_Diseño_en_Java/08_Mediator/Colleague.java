/**
 * Colleague: define la estructura común de los participantes. Posee
 * una referencia a su Mediator para delegarle las comunicaciones.
 */
public abstract class Colleague {

    protected Mediator mediator;
    protected String nombre;

    public Colleague(Mediator mediator, String nombre) {
        this.mediator = mediator;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void send(String mensaje) {
        mediator.send(mensaje, this);
    }

    public abstract void notify(String mensaje);
}
