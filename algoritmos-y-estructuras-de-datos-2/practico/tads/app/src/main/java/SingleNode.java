public class SingleNode<T> {
  private SingleNode<T> next;
  private T item;

  public SingleNode(T item) {
    next = null;
    this.item = item;
  }

  public void setItem(T item) {
    this.item = item;
  }

  public void setNext(SingleNode<T> node) {
    next = node;
  }

  public T getItem() {
    return item;
  }

  public SingleNode<T> getNext() {
    return next;
  }
}
