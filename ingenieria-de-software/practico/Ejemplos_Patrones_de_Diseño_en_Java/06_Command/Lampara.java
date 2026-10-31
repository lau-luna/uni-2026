/**
 * Receiver: ejecuta la lógica de negocio real. Tiene un único estado
 * observable (encendida / apagada).
 */
public class Lampara {

    private boolean encendida = false;

    public void encender() {
        encendida = true;
        System.out.println("Lámpara ENCENDIDA");
    }

    public void apagar() {
        encendida = false;
        System.out.println("Lámpara APAGADA");
    }

    public boolean isEncendida() {
        return encendida;
    }
}
