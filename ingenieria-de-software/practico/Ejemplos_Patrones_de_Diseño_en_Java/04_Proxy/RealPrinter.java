/**
 * RealSubject: contiene la lógica de negocio real (y "pesada") de
 * impresión.
 */
public class RealPrinter implements Printer {

    private String model;

    public RealPrinter(String model) {
        this.model = model;
        System.out.println("Inicializando impresora real (" + model + ")...");
    }

    @Override
    public void print(String document) {
        System.out.println("[" + model + "] Imprimiendo: " + document);
    }
}
