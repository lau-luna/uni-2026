import java.util.NoSuchElementException;

public class ArrMaxHeap<T extends Comparable<? super T>> implements MaxHeap<T> {
  private int size;
  private static final int INIT_CAPACITY = 8;
  private T[] arr;

  @SuppressWarnings("unchecked")
  public ArrMaxHeap() {
    size = 0;
    arr = (T[]) new Comparable[INIT_CAPACITY + 1];
  }

  private int parent(int n) {
    return n / 2;
  }

  private int left(int n) {
    return n * 2;
  }

  private int right(int n) {
    return n * 2 + 1;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void insert(T x) {
    if (size == arr.length - 1)
      resize(2 * arr.length);

    size++;
    arr[size] = x;
    swim(size);
  }

  @SuppressWarnings("unchecked")
  private void resize(int newLength) {
    T[] newArr = (T[]) new Comparable[newLength];

    for (int i = 1; i <= size; i++)
      newArr[i] = arr[i];

    arr = newArr;
  }

  private void swim(int k) {
    while (k > 1 && less(parent(k), k)) {
      exchange(arr, k, parent(k));
      k = parent(k);
    }
  }

  public T max() {
    if (isEmpty())
      throw new NoSuchElementException("Empty heap");

    return arr[1];
  }

  public T removeMax() {
    if (isEmpty())
      throw new NoSuchElementException("Empty heap");

    T max = arr[1];

    exchange(arr, 1, size);
    arr[size] = null;
    size--;

    // sink the root to restore the heap invariant
    sink(1);

    return max;
  }

  private void sink(int k) {
    while (left(k) <= size) {
      // left child as larger child
      int largerChild = left(k);
      // if righChild exists and is > leftChild, prefer it
      if (right(k) <= size && less(left(k), right(k)))
        largerChild = right(k);

      if (!less(k, largerChild))
        break;

      exchange(arr, k, largerChild);
      k = largerChild;
    }
  }

  private void exchange(T[] arr, int n, int m) {
    T value = arr[n];
    arr[n] = arr[m];
    arr[m] = value;
  }

  public boolean repOK() {
    if (arr[0] != null)
      return false;

    for (int i = 1; i < size; i++)
      if (arr[i] == null)
        return false;

    for (int i = size; i < arr.length; i++)
      if (arr[i] != null)
        return false;

    return isMaxHeapOrdered(1);
  }

  private boolean isMaxHeapOrdered(int n) {
    if (n > size)
      return true;

    int left = left(n);
    int right = right(n);

    if (left <= size && less(n, left))
      return false;
    if (right <= size && less(n, right))
      return false;

    return isMaxHeapOrdered(left) && isMaxHeapOrdered(right);
  }

  private boolean less(int n, int m) {
    return arr[n].compareTo(arr[m]) < 0;
  }


}
