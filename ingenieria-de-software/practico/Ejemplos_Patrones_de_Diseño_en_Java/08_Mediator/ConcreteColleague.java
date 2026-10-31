/**
 * ConcreteColleague: implementa su lógica particular. No se comunica
 * de forma directa con los demás colegas; cada vez que necesita
 * enviar un mensaje, invoca a su Mediator.
 */
public class ConcreteColleague extends Colleague {

    public ConcreteColleague(Mediator mediator, String nombre) {
        super(mediator, nombre);
    }

    @Override
    public void notify(String mensaje) {
        System.out.println(nombre + " recibió: " + mensaje);
    }
}
