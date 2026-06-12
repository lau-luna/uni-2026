public interface PriorityQueue<T extends Comparable<? super T>> {
  public boolean isEmpty();
  public int size();
  public void insert(T x);
  public T max();
  public T removeMax();
  public boolean repOK();
}
