import java.util.NoSuchElementException;
import java.util.Arrays;

public class HeapPriorityQueue2<T extends Comparable<? super T>> implements PriorityQueue<T> {
  private int size;
  private T[] heap;
  private static final int INIT_CAPACITY = 8;

  public HeapPriorityQueue2() {
    size = 0;
    heap = (T[]) new Comparable[INIT_CAPACITY + 1];
  }
  
  private int parent(int k) { return k/2; }
  private int left(int k) { return k*2; }
  private int right(int k) { return k*2 +1; }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  private void exchange(Comparable[] arr, int i, int j) {
    Comparable aux = arr[i];
    arr[i] = arr[j];
    arr[j] = aux;
  }

  private boolean less(Comparable a, Comparable b) {
    return a.compareTo(b) < 0;
  }

  private void swim(int k) {
    while (k > 1 && less(heap[parent(k)], heap[k])) {
      exchange(heap, parent(k), k);
      k = parent(k);
    }
  }

  private void sink(Comparable[] A, int k, int N) {
    while (left(k) <= N) {
      int largerChild = left(k);

      if (right(k) <= N && less(A[left(k)], A[right(k)]))
        largerChild = right(k);

      if (less(A[largerChild], A[k]))
        break;

      exchange(A, largerChild, k);
      k = largerChild;
    }
  }

  private void resize(int newSize) {
    T[] newArr = (T[]) new Comparable[newSize];

    for (int i = 0; i < heap.length; i++)
      newArr[i] = heap[i];

    heap = newArr;
  }
  
  public void insert(T x) {
    if (size == heap.length - 1)
      resize(2 * heap.length);

    heap[++size] = x;
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
    sink(heap, 1, size);

    return max;
  }
  
  public boolean repOK() {
    if (heap[0] != null)
      return false;

    for (int i = 1; i <= size; i++)
      if (heap[i] == null)
        return false;

    for (int i = size+1; i < heap.length; i++)
      if(heap[i] != null)
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

  public Comparable[] sortHeapArray() {
    Comparable[] sorted = Arrays.copyOfRange(heap, 0, size+1);
    
    int N = size;
    while (N > 1) {
      exchange(sorted, 1, N--);
      sink(sorted, 1, N);
    }

    return sorted;
  }

  public String toString() {
    Comparable[] arr = sortHeapArray();
    String s = "[";

    for (int i = 1; i <= size; i++) {
      s += arr[i].toString();
      s += i < arr.length - 1 ? ", " : "";
    }
    
    s += "]";

    return s;
  }

  public void heapSort(Comparable[] arr) {
    int N = arr.length - 1;

    for (int i = N/2; i >= 1; i--)
      sink(arr, i, N);

    while (N > 1) {
      exchange(arr, 1, N--);
      sink(arr, 1, N);
    }
  }
} 
