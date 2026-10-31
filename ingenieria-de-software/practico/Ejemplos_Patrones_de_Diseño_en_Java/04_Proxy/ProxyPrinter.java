/**
 * Proxy: controla el acceso a RealPrinter. En este ejemplo aplica dos
 * responsabilidades típicas del patrón:
 *  - Inicialización diferida (lazy init): RealPrinter recién se crea
 *    cuando realmente se necesita imprimir.
 *  - Control de acceso: sólo los usuarios con rol "ADMIN" pueden
 *    imprimir.
 */
public class ProxyPrinter implements Printer {

    private RealPrinter realPrinter;
    private String model;
    private String userRole;

    public ProxyPrinter(String model, String userRole) {
        this.model = model;
        this.userRole = userRole;
    }

    @Override
    public void print(String document) {
        if (userRole.equals("ADMIN")) {
            if (realPrinter == null) {
                realPrinter = new RealPrinter(model);
            }
            realPrinter.print(document);
        } else {
            System.out.println("Acceso denegado: el usuario '" + userRole
                    + "' no tiene permisos para imprimir.");
        }
    }
}
