package queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * CircularQueue is an implementation of Queue using a
 * circular array.
 *
 * Queue represents unbounded, first-in-first-out (FIFO)
 * queue objects of type T.
 * A typical Queue is a sequence [o1, o2,..., on]; we
 * denote this by: this = [o1, o2,..., on].
 *
 * The methods use equals to determine equality of elements.
 */
public class CircularQueue<T> implements Queue<T> {
  protected static final int INIT_CAPACITY = 8;

  protected T[] queue; // queue elements
  protected int size; // number of elements on queue
  protected int first; // index of first element of queue
  protected int last; // index of next available slot

  /**
   * @post Creates an empty queue.
   *       More formally, it satisfies: this = [].
   */
  public CircularQueue() {
    queue = (T[]) new Object[INIT_CAPACITY];
    size = 0;
    first = 0;
    last = 0;
  }

  /**
   * @post Returns true iff the queue contains no elements.
   *       More formally, it satisfies: result = #this = 0.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * @post Returns the number of elements in the queue.
   *       More formally, it satisfies: result = #this.
   */
  public int size() {
    return size;
  }

  /**
   * @pre capacity > size() (throws IllegalArgumentException).
   * @post Resize the underlying array to the given capacity.
   */
  private void resize(int capacity) {
    if (capacity <= size())
      throw new IllegalArgumentException("The new array" +
          "must be larger than the current size: " + size());

    T[] copy = (T[]) new Object[capacity];
    for (int i = 0; i < size; i++) {
      copy[i] = queue[(first + i) % queue.length];
    }
    queue = copy;
    first = 0;
    last = size;
  }

  /**
   * @post Adds element e to the end of the queue.
   *       More formally, it satisfies: this = old(this) ++ [e].
   */
  public void enqueue(T item) {
    if (!isEmpty() && last == first)
      resize(queue.length * 2); // Double the array size

    queue[last] = item;
    last = (last + 1) % queue.length;
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

    T item = queue[first];
    queue[first] = null;
    first = (first + 1) % queue.length;
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
    return queue[last];
  }

  /**
   * @post Returns true if and only if the structure is a
   *       valid queue.
   */
  public boolean repOK() {
    // Checks if first, last & size are on valid ranges {0 <= x < queue.length}
    if (first < 0 || first >= queue.length)
      return false;
    if (last < 0 || last >= queue.length)
      return false;
    if (size < 0 || size > queue.length)
      return false;

    // Checks if there aren't nulls in between the queue.
    int i = 0;
    int count = size;
    while (count > 0) {
      if (queue[i] == null)
        return false;
      i = (i+1) % queue.length;
      count--;
    }
    // if (i != last)
      // return false;

    return true;
  }

  /**
   * @post Returns a string representation of the queue. Implements
   *       the abstraction function. Hence, it represents the queue as a
   *       sequence "[o1, o2,..., on]".
   */
  public String toString() {
    String s = "[";
    for (int i = 0; i < size-1; i++) {
      s += queue[(first + i) % queue.length] + ", ";
    }
    if (!isEmpty())
      s += queue[queue.length-1];
    s += "]";
    
    return s;
  }

  /**
   * @post Returns an iterator for the queue that iterates through
   *       the items in FIFO order.
   */
  public Iterator<T> iterator() {
    return new ArrayIterator<T>(this);
  }

}
