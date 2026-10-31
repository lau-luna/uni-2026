package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An Iterator implementation for Circularlist
 */
public class ArrayListIterator<T> implements Iterator<T> {

    private MyArrayList<T> list;

    /**
     * @post Creates an iterator for list
     */
    public ArrayListIterator(MyArrayList<T> list) {
        this.list = list;
    }
    private int i = 0;

    /**
     * @post Returns true if and only if the iteration has more elements.
     */
    public boolean hasNext() {
        return i < list.size;
    }

    /**
     * @pre hasNext() (throws NoSuchElementException).
     * @post Returns the next element in the iteration.
     */
    public T next() {
        if (!hasNext())
            throw new NoSuchElementException();

        T item = list.get(i);
        i++;
        return item;
    }
}
