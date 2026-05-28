import java.util.EmptyStackException;

public class LinkedStack<T> {
  private SingleNode<T> start;
  private int size;

  public LinkedStack() {
    start = null;
    size = 0;
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void push(T item) {
    SingleNode<T> node = new SingleNode<>(item);
    if (isEmpty()) {
      start = node;
    } else {
      node.setNext(start);
      start = node;
    }
    size++;
  }

  public T pop() {
    if (isEmpty())
      throw new EmptyStackException();

    T item = start.getItem();
    if (size == 1) {
      start = null;
    } else {
      start = start.getNext();
    }

    size--;
    return item;
  }

  public String toString() {
    if (start == null)
      return "[]";

    String s = start.getItem() + "]";
    SingleNode<T> current = start.getNext();
    while (current != null) {
      s = current.getItem() + ", " + s;
      current = current.getNext();
    }
    return "[" + s;
  }
}
