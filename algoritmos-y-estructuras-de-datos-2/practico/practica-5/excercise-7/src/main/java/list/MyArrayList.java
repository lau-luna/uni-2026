package list;

import java.util.Iterator;

/**
 * Write a description of class MyArrayList here.
 * 
 */
public class MyArrayList<T> implements List<T> {
  // array of items
  protected T[] array;
  // initial capacity of underlying resizing array
  protected static final int INIT_CAPACITY = 10;
  protected int size;

  /**
   * Constructor for objects of class MyArrayList with specific size.
   * More formally, it satisfies: this = []
   */
  public MyArrayList(int size) {
    if (size <= 0) {
      throw new IllegalArgumentException("colection size mast be positive");
    }
    array = (T[]) new Object[size];
    size = 0;
  }

  /**
   * Constructor for objects of class MyArrayList with initial capacity of 10.
   * More formally, it satisfies: this = []
   */
  public MyArrayList() {
    array = (T[]) new Object[INIT_CAPACITY];
    size = 0;
  }

  /**
   * @post Returns the number of elements in the list.
   *       More formally, it satisfies: result = #this.
   */
  public int size() {
    return size;
  }

  /**
   * @post Returns true iff the list contains no elements.
   *       More formally, it satisfies: result = #this = 0.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * @post Returns true iff the list contains element e.
   *       More formally, it satisfies:
   *       result = exists o | o in this && e.equals(o).
   */
  public boolean contains(T e) {
    int i = 0;
    boolean found = false;
    while (i < size && !found) {
      found = e.equals(array[i]);
      i++;
    }
    return found;
  }

  /**
   * @pre capacity > size() (throws IllegalArgumentException).
   * @post Resize the underlying array to the given capacity.
   */
  private void resize(int capacity) {
    if (capacity <= size())
      throw new IllegalArgumentException("The new array" +
          "must be larger than the current size: " + size());

    T[] copy = (T[]) new Object[capacity];
    for (int i = 0; i < size; i++) {
      copy[i] = array[i];
    }
    array = copy;
  }

  /**
   * @post Appends element e to the end of this list.
   *       Doubles the size of the array each time
   *       size == array.length.
   *       More formally, it satisfies: this = old(this) ++ [e].
   */
  public void add(T e) {
    if (size == array.length)
      resize(array.length * 2);

    array[size++] = e;
  }

  /**
   * @post Removes the first occurrence of e from this list.
   *       If e is not in the list it does not modify the list.
   *       Returns true iff e is removed (result = e in old(list)).
   */
  public boolean remove(T e) {
    if (isEmpty())
      return false;

    for (int i = 0; i < array.length; i++)
      if (array[i].equals(e)) {
        remove(i);
        size--;
        return true;
      }

    return false;
  }

  /**
   * @post Removes all of the elements from the list,
   *       More formally, it satisfies: #this = 0.
   */
  public void clear() {
    for (int i = 0; i < size; i++) {
      array[i] = null;
    }
    size = 0;
  }

  /**
   * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
   * @post Returns the element at position index in the list,
   *       More formally, it satisfies: result = this[index].
   */
  public T get(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();

    return array[index];
  }

  /**
   * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
   * @post Replaces the element at position index with e, and returns
   *       the element that was replaced.
   *       More formally, it satisfies:
   *       this[index].equals(e) && #this = #old(this) &&
   *       result.equals(old(this)[index]).
   */
  public T set(int index, T e) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();

    T item = array[index];
    array[index] = e;
    return item;
  }

  /**
   * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
   * @post Inserts the element at position index with e.
   *       More formally, it satisfies:
   *       this[index].equals(e) && #this = #old(this) +1.
   */
  public void add(int index, T e) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();

    if (index == size - 1)
      resize(array.length * 2);

    // Shift the part after the index one position to the right
    T prev = array[index];

    for (int i = index; i < array.length; i++) {
      T aux = array[i];
      array[i] = prev;
      prev = aux;
    }

    array[index] = e;

    size++;
  }

  /**
   * @pre 0 <= index < size() (throws an IndexOutOfBoundsException)
   * @post Removes the element at position index.
   *       More formally, it satisfies:
   *       result = old(this)[index] && #this = #old(this) -1.
   */
  public T remove(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException();

    T item = array[index];

    // The first half stays the same
    // The second half shifts one position to the left.
    for (int i = index + 1; i < array.length; i++)
      array[i - 1] = array[i];

    array[array.length - 1] = null;

    size--;

    return item;
  }

  /**
   * @post Returns the index of the first occurrence of e
   *       in the list, or -1 if this list does not contain e.
   *       More formally, it satisfies:
   *       result = -1 -> !(e in this) &&
   *       result != -1 -> this[result].equals(e).
   */
  public int indexOf(T e) {
    if (isEmpty())
      return -1;

    for (int i = 0; i < array.length; i++)
      if (array[i] == e)
        return i;

    return -1;
  }

  /**
   * @post Retorna la longitud del arreglo usado para implementar la
   *       lista.
   *       //ATENCIÓN: Este método es SOLO con el propósito de test de la clase.
   *       No debe ser invocado desde otras partes del sistema que no sean
   *       estrictamente para validaciones experimentales.
   */
  protected int getArraySize() {
    return array.length;
  }

  /**
   * @post Returns an iterator for the list that iterates through
   *       the items in forward order.
   */
  public Iterator<T> iterator() {
    return new ArrayListIterator<T>(this);
  }

  /**
   * @post Returns a string representation of the stack. Implements
   *       the abstraction function. Hence, it represents the stack as a
   *       sequence "[o1, o2,..., on]".
   */
  public String toString() {
    String res = "[";
    for (int i = 0; i < size; i++) {
      res += array[i].toString();
      if (i < size - 1)
        res += ", ";
    }
    res += "]";
    return res;
  }

  /**
   * @post Returns true if and only if list is a
   *       valid MyArrayList.
   */
  public boolean repOK() {
    if (size < 0 || size > array.length)
      return false;
    // The stack does not store null as an element
    for (int i = 0; i < size; i++) {
      if (array[i] == null)
        return false;
    }
    // All elements starting from size are null
    for (int i = size; i < array.length; i++) {
      if (array[i] != null)
        return false;
    }

    return true;
  }

}
