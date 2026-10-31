package stack;

/**
 * A node object is structured with:
 * - 'info' generic field that stores a given element of type T.
 * - 'next' field wich is a reference to another Node object, which they can be
 * used to create a linked list.
 */
public class Node<T> {
  private T info;
  private Node<T> next;

  public Node(T info) {
    if (info == null)
      throw new IllegalArgumentException("info should not be null");

    this.info = info;
    this.next = null;
  }

  public Node(T info, Node<T> next) {
    if (info == null)
      throw new IllegalArgumentException("info should not be null");

    this.info = info;
    this.next = next;
  }

  public void setInfo(T info) {
    if (info == null)
      throw new IllegalArgumentException("info should not be null");

    this.info = info;
  }

  public void setNext(Node<T> next) {
    if (next == null)
      throw new IllegalArgumentException("next should not be null");

    this.next = next;
  }

  public T getInfo() {
    return info;
  }

  public Node<T> getNext() {
    return next;
  }

}
