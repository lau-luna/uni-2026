/**
 * Iterator: define el contrato de navegación estándar para acceder y
 * recorrer los elementos de manera secuencial.
 */
public abstract class Iterator {
    abstract void first();
    abstract void next();
    abstract boolean isDone();
    abstract int currentItem();
}
