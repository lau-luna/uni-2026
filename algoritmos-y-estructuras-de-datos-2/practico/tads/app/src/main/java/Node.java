public class Node<T> {
  private Node<T> prev;
  private Node<T> next;
  private T item;

  public Node(T item) {
    prev = null;
    next = null;
    this.item = item;
  }

  public void setItem(T item) {
    this.item = item;
  }

  public void setPrev(Node<T> node) {
    prev = node;
  }

  public void setNext(Node<T> node) {
    next = node;
  }

  public T getItem() {
    return item;
  }

  public Node<T> getPrev() {
    return prev;
  }

  public Node<T> getNext() {
    return next;
  }
}
