public interface MaxHeap<T extends Comparable<? super T>> {
  public void insert(T x);

  public T max();

  public T removeMax();

  public boolean isEmpty();

  public int size();
}
