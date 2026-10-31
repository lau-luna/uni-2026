import java.util.Arrays;
import java.util.NoSuchElementException;

public class HeapPriorityQueue<T extends Comparable<? super T>> implements PriorityQueue<T> {
  private int size;
  private static final int INIT_CAPACITY = 8;
  private T[] heap;

  @SuppressWarnings("unchecked")
  public HeapPriorityQueue() {
    size = 0;
    heap = (T[]) new Comparable[INIT_CAPACITY + 1];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  /// Heap methods
  private int parent(int k) {
    return k / 2;
  }

  private int left(int k) {
    return k * 2;
  }

  private int right(int k) {
    return k * 2 + 1;
  }

  private void exchange(Comparable[] arr, int i, int j) {
    Comparable val = arr[i];
    arr[i] = arr[j];
    arr[j] = val;
  }

  private boolean less(Comparable[] a, int i, int j) {
    return a[i].compareTo(a[j]) < 0;
  }

  @SuppressWarnings("unchecked")
  private void resize(int newSize) {
    T[] newArr = (T[]) new Comparable[newSize];

    for (int i = 1; i <= size; i++)
      newArr[i] = heap[i];

    heap = newArr;
  }

  private void swim(int k) {
    while (k > 1 && less(heap, parent(k), k)) {
      exchange(heap, parent(k), k);
      k = parent(k);
    }
  }

  private void sink(Comparable[] a, int k, int N) {
    while (left(k) <= N) {
      int largerChild = left(k);

      if (right(k) <= N && less(a, left(k), right(k)))
        largerChild = right(k);

      if (less(a, largerChild, k))
        break;

      exchange(a, k, largerChild);
      k = largerChild;
    }
  }

  public void insert(T x) {
    if (size == heap.length - 1)
      resize(2 * heap.length);

    size++;
    heap[size] = x;
    swim(size);
  }

  public T max() {
    return heap[1];
  }

  public T removeMax() {
    if (isEmpty())
      throw new NoSuchElementException("Empty queue");

    T max = max();
    exchange(heap, 1, size);
    heap[size] = null;
    size--;
    sink(heap, 1, size);

    return max;
  }

  public boolean repOK() {
    if (heap[0] != null)
      return false;

    for (int i = 1; i <= size; i++)
      if (heap[i] == null)
        return false;

    for (int i = size + 1; i < heap.length; i++)
      if (heap[i] != null)
        return false;

    return isMaxHeapOrdered(1);
  }

  private boolean isMaxHeapOrdered(int k) {
    if (k > size)
      return true;

    int left = left(k);
    int right = right(k);

    if (left <= size && less(heap, k, left))
      return false;

    if (right <= size && less(heap, k, right))
      return false;

    return isMaxHeapOrdered(left) && isMaxHeapOrdered(right);
  }

  private Comparable[] sortHeapArray() {
    Comparable[] a = Arrays.copyOfRange(heap, 0, size + 1);
    int N = size;

    while (N > 1) {
      exchange(a, 1, N);
      N--;
      sink(a, 1, N);
    }

    return a;
  }

  public String toString() {
    Comparable[] sorted = sortHeapArray();
    String s = "[";

    for (int i = 1; i < sorted.length; i++) {
      s += sorted[i].toString();
      s += i < sorted.length - 1 ? ", " : "";
    }

    s += "]";

    return s;
  }

  public void heapSort(Comparable[] a) {
    int N = a.length-1;

    for (int i = N/2; i >= 1; i--)
      sink(a, i, N);
    
    while (N > 1) {
      exchange(a, 1, N);
      N--;
      sink(a, 1, N);
    }
  }
}
