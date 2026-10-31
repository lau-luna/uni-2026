/** Cliente: arma el grupo (mediador) y hace que los colegas se comuniquen entre sí. */
public class Main {
    public static void main(String[] args) {
        ConcreteMediator grupo = new ConcreteMediator();

        Colleague juan = new ConcreteColleague(grupo, "Juan");
        Colleague maria = new ConcreteColleague(grupo, "María");
        Colleague pedro = new ConcreteColleague(grupo, "Pedro");

        grupo.agregarColega(juan);
        grupo.agregarColega(maria);
        grupo.agregarColega(pedro);

        juan.send("¿A qué hora nos juntamos?");
        maria.send("A las 20hs me queda bien");
        pedro.send("¡Dale, de acuerdo!");
    }
}
