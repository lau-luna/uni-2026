package queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Queue represents unbounded, first-in-first-out (FIFO)
 * queue objects of type T.
 *
 * A typical Queue is a sequence [o1, o2,..., on]; we
 * denote this by: this = [o1, o2,..., on].
 *
 * The methods use equals to determine equality of elements.
 */
public class LinkedQueue<T> implements Queue<T> {
  protected Node<T> first;
  protected Node<T> last;
  private int size;

  public LinkedQueue() {
    first = null;
    last = null;
    size = 0;
  }

  /**
   * @post Returns the number of elements in the queue.
   *       More formally, it satisfies: result = #this.
   */
  public int size() {
    return size;
  }

  /**
   * @post Returns true iff the queue contains no elements.
   *       More formally, it satisfies: result = #this = 0.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * @post Adds element e to the end of the queue.
   *       More formally, it satisfies: this = old(this) ++ [e].
   */
  public void enqueue(T e) {
    Node<T> newNode = new Node<>(e, null);

    if (isEmpty()) {
      first = newNode;
      last = newNode;
    } else {
      last.setNext(newNode);
      last = last.getNext();
    }

    size++;
  }

  /**
   * @pre !isEmpty() (throws NoSuchElementException)
   * @post Removes and returns the item at the beggining of the queue.
   *       More formally, it satisfies:
   *       let old(this) = [e] ++ s1 |
   *       this = s1 && result = e.
   */
  public T dequeue() {
    if (isEmpty())
      throw new NoSuchElementException();

    T item = first.getInfo();
    first = first.getNext();

    size--;

    return item;
  }

  /**
   * @pre !isEmpty() (throws NoSuchElementException)
   * @post Returns the item at the beggining of the queue.
   *       More formally, it satisfies:
   *       let this = [e] ++ s1 | result = e.
   */
  public T peek() {
    return last.getInfo();
  }

  /**
   * @post Returns an iterator for the queue that iterates through
   *       the items in FIFO order.
   */
  public Iterator<T> iterator() {
    return new LinkedIterator<T>(this);
  }

  /**
   * @post Returns true if and only if the structure is a
   *       valid queue.
   */
  public boolean repOK() {
    // Checks if the quantity of nodes is the same as the size.
    int nodeCounter = 0;
    
    if (!isEmpty()) {
      nodeCounter = 1;
      Node<T> actualNode = first;
      for (int i = 0; i < size-1; i++) {
        nodeCounter++;
        actualNode = actualNode.getNext();
      }
    } 

    return nodeCounter == size;
  }

  /**
   * @post Returns a string representation of the queue. Implements
   *       the abstraction function. Hence, it represents the queue as a
   *       sequence "[o1, o2,..., on]".
   */
  public String toString() {
    String s = "[";

    Node<T> actualNode = first;

    for (int i = 0; i < size - 1; i++) {
      s += actualNode.getInfo() + ", ";
      actualNode = actualNode.getNext();
    }

    if (!isEmpty()) {
      s += actualNode.getInfo();
    }

    s += "]";

    return s;
  }

}
