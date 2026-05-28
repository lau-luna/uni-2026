import java.util.NoSuchElementException;

public class LinkedQueue<T> {
  private SingleNode<T> start;
  private SingleNode<T> end;
  private int size;

  public LinkedQueue() {
    start = null;
    end = null;
    size = 0;
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void enqueue(T item) {
    SingleNode<T> node = new SingleNode<>(item);

    if (isEmpty()) {
      start = node;
      end = node;
    } else {
      end.setNext(node);
      end = node;
    }

    size++;
  }

  public T dequeue() {
    if (isEmpty())
      throw new NoSuchElementException("Empty queue");

    T item = start.getItem();

    if (size == 1) {
      start = null;
      end = null;
    } else {
      start = start.getNext();
    }

    size--;
    return item;
  }

  public T peek() {
    if (isEmpty())
      throw new NoSuchElementException("Empty queue");

    return start.getItem();
  }

  public String toString() {
    String s = "[";
    
    SingleNode<T> node = start;
    while (node != null) {
      s += node.getItem() + (node.getNext() == null ? "" :  ", ");
      node = node.getNext();
    }

    s += "]";

    return s;
  }
}
