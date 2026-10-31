/**
 * Cliente: arma un árbol de carpetas y archivos, y opera sobre él de
 * forma uniforme a través de la clase abstracta Componente, sin
 * necesidad de distinguir en el código si cada elemento es un archivo
 * o una carpeta.
 */
public class Main {
    public static void main(String[] args) {
        Carpeta raiz = new Carpeta("proyecto");

        Archivo readme = new Archivo("README.md", 2);
        raiz.add(readme);

        Carpeta src = new Carpeta("src");
        src.add(new Archivo("Main.java", 5));
        src.add(new Archivo("Utils.java", 3));
        raiz.add(src);

        Carpeta docs = new Carpeta("docs");
        docs.add(new Archivo("manual.pdf", 120));

        Carpeta imagenes = new Carpeta("imagenes");
        imagenes.add(new Archivo("logo.png", 45));
        imagenes.add(new Archivo("diagrama.png", 80));
        docs.add(imagenes);

        raiz.add(docs);

        System.out.println("Árbol completo:");
        raiz.mostrar(0);

        System.out.println();
        System.out.println("Tamaño total de '" + raiz.getNombre() + "': "
                + raiz.getTamanoKB() + " KB");

        System.out.println();
        System.out.println("Segundo elemento de la raíz (getChild(1)): "
                + raiz.getChild(1).getNombre());

        System.out.println();
        System.out.println("Eliminando README.md de la raíz...");
        raiz.remove(readme);
        raiz.mostrar(0);
        System.out.println("Tamaño total luego de eliminar: " + raiz.getTamanoKB() + " KB");
    }
}
