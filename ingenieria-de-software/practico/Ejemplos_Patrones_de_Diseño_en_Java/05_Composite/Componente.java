/**
 * Component: clase abstracta que contiene métodos, atributos y
 * relaciones comunes a los elementos simples (Archivo) y compuestos
 * (Carpeta) del sistema de archivos.
 */
public abstract class Componente {

    protected String nombre;

    public Componente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Tamaño en KB. En un Archivo es su propio peso; en una Carpeta es
    // la suma recursiva del tamaño de todo su contenido.
    public abstract int getTamanoKB();

    public abstract void mostrar(int nivel);

    // Operaciones propias de la estructura compuesta: por defecto no
    // están soportadas por las hojas (Archivo).
    public void add(Componente c) {
        throw new UnsupportedOperationException("Un archivo no puede contener elementos");
    }

    public void remove(Componente c) {
        throw new UnsupportedOperationException("Un archivo no puede contener elementos");
    }

    public Componente getChild(int i) {
        throw new UnsupportedOperationException("Un archivo no tiene hijos");
    }
}
