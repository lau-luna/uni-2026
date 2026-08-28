import java.util.NoSuchElementException;

public class HeapPriorityQueue3<T extends Comparable<? super T>> implements PriorityQueue<T> {
  private T[] heap;
  private int size;
  private static final int INIT_CAPACITY = 8;

  public HeapPriorityQueue3() {
    heap = (T[]) new Comparable[INIT_CAPACITY];
    size = 0;
  }

  private int left(int k) { return k * 2; }
  private int right(int k) { return k * 2 + 1; }
  private int parent(int k) { return k / 2; }

  private void resize(int newSize) {
    if (newSize <= 0)
      throw new IllegalArgumentException("newSize must be a positive number.");

    T[] newArray = (T[]) new Comparable[newSize];

    for (int i = 0; i < heap.length; i++)
      newArray[i] = heap[i];

    heap = newArray;
  }

  private boolean less(Comparable a, Comparable b) {
    return a.compareTo(b) < 0;
  }

  private void exchange(Comparable[] arr, int i, int j) {
    Comparable aux = arr[i];
    arr[i] = arr[j];
    arr[j] = aux;
  }

  private void swim(int k) {
    while (k > 1 && less(heap[parent(k)], heap[k])) {
      exchange(heap, parent(k), k);
      k = parent(k);
    }
  }

  private void sink(int k) {
    while (left(k) <= size) {
      int largerChild = left(k);

      if (right(k) <= size && less(heap[left(k)], heap[right(k)]))
        largerChild = right(k);

      if (less(heap[largerChild], heap[k]))
        break;

      exchange(heap, k, largerChild);
      k = largerChild;
    }
  }

  public void insert(T elem) {
    if (size == heap.length - 1)
      resize(heap.length*2);

    heap[++size] = elem;
    swim(size);
  }

  public T max() {
    if (isEmpty())
      throw new NoSuchElementException("Empty queue");
    
    return heap[1];
  }

  public T removeMax() {
    if (isEmpty())
      throw new NoSuchElementException("Empty queue");

    T max = heap[1];
    exchange(heap, 1, size);
    heap[size--] = null;
    sink(1);

    return max;
  }

  public boolean repOK() {
    if (heap[0] != null)
      return false;

    for (int i = 1; i <= size; i++)
      if (heap[i] == null)
        return false;

    for (int i = size+1; i < heap.length; i++)
      if (heap[i] != null)
        return false;

    return isMaxHeapOrdered(1);
  }

  private boolean isMaxHeapOrdered(int k) {
    if (k > size)
      return true;

    if (left(k) <= size && less(heap[k], heap[left(k)]))
      return false;
    if (right(k) <= size && less(heap[k], heap[right(k)]))
      return false;

    return isMaxHeapOrdered(left(k)) && isMaxHeapOrdered(right(k));
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public String toString() {
    String s = "[";
    
    for (int i = size; i >= 1; i--) {
      s += heap[i].toString();
      s += i > 1 ? ", " : "";
    }
    s += "]";

    return s;
  }
}
