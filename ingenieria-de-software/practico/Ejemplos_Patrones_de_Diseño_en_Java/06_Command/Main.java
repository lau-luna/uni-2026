/**
 * Client: arma los comandos con su receiver y los entrega al Invoker.
 *
 * OJO: este Main usa el comando real de 1 minuto, así que tarda ~1
 * minuto en terminar. Para probar rápido, ver Main de la versión de
 * test (ComandoEncenderPor1Minuto con el constructor de paquete).
 */
public class Main {
    public static void main(String[] args) {
        Lampara lampara = new Lampara();
        Invoker invoker = new Invoker();

        System.out.println("--- Encender ---");
        invoker.storeCommand(new ComandoEncender(lampara));

        System.out.println("--- Deshacer último comando (Encender) ---");
        invoker.undoLast();

        System.out.println("--- Apagar ---");
        invoker.storeCommand(new ComandoApagar(lampara));

        System.out.println("--- Deshacer último comando (Apagar) ---");
        invoker.undoLast();

        System.out.println("--- Encender por 1 minuto ---");
        invoker.storeCommand(new ComandoEncenderPor1Minuto(lampara));

        System.out.println("--- Deshacer último comando (Encender por 1 minuto) ---");
        invoker.undoLast();
    }
}
