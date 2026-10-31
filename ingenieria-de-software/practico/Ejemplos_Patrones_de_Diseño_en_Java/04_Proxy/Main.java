/** Client: consume el servicio únicamente a través de la interfaz Printer */
public class Main {
    public static void main(String[] args) {
        Printer printerAdmin = new ProxyPrinter("HP LaserJet", "ADMIN");
        Printer printerGuest = new ProxyPrinter("HP LaserJet", "GUEST");

        System.out.println("--- Intento con usuario ADMIN ---");
        printerAdmin.print("Informe-2026.pdf");

        System.out.println("--- Intento con usuario GUEST ---");
        printerGuest.print("Informe-2026.pdf");
    }
}
