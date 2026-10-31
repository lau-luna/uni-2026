package stack;

import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * An implementation of the Stack interface using a Linked list which uses Node.
 * This uses a linked list in only one way (right)
 * Because of this, is more efficient to use the first element of the list as
 * the top of the stack.
 * This does not have a fixed MAX size for the stack.
 */
public class LinkedStack<T> implements Stack<T> {
  private Node<T> first;
  private int size;

  /**
   * When creating a new Stack, it starts with:
   * - size = 0
   * - the reference first pointing to null.
   */
  public LinkedStack() {
    first = null;
    size = 0;
  }

  /**
   * @post Adds element e to the top of the stack.
   *       More formally, it satisfies: this = old(this) ++ [e].
   */
  @Override
  public void push(T e) {
    Node<T> newNode = new Node<T>(e, first);
    first = newNode;
    size++;
  }

  /**
   * @pre !isEmpty() (throws NoSuchElementException)
   * @post Removes and returns the item at the top of the stack.
   *       More formally, it satisfies:
   *       let old(this) = s1 ++ [e] |
   *       this = s1 && result = e.
   */
  @Override
  public T pop() {
    if (isEmpty())
      throw new NoSuchElementException();

    T info = first.getInfo();
    first = first.getNext();

    size--;

    return info;
  }

  /**
   * Also known as peek()
   * 
   * @pre !isEmpty() (throws NoSuchElementException)
   * @post Returns the item at the top of the stack.
   *       More formally, it satisfies:
   *       let this = s1 ++ [e] | result = e.
   */
  @Override
  public T top() {
    if (isEmpty())
      throw new NoSuchElementException();

    return first.getInfo();
  }

  /**
   * @post Returns the number of elements in the stack.
   *       More formally, it satisfies: result = #this.
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * @post Returns true if the stack contains no elements.
   *       More formally, it satisfies: result = (this = []).
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * @post Returns an iterator for the stack that iterates through
   *       the items in LIFO order.
   */
  @Override
  public Iterator<T> iterator() {
    return null;
  }

  /**
   * Representation invariant
   * - The stack does not store null as an element.
   * @post Devuelve true si y solo si la estructura es una
   *       pila válida.
   */
  @Override
  public boolean repOK() {
    Node<T> actualNode = first;

    for (int i = 0; i < size; i++) {
      if (actualNode == null)
        return false;

      actualNode = actualNode.getNext();
    }

    return true;
  }

  /**
   * Abstraction function
   * 
   * @post Returns a string representation of the stack. Implements
   *       the abstraction function. Hence, it represents the stack as a
   *       sequence "[o1, o2,..., on]".
   */
  @Override
  public String toString() {
    if (isEmpty())
      return "[]";

    String s = "]";

    Node<T> actualNode = first;
    s = actualNode.getInfo() + s;

    while (actualNode.getNext() != null) {
      actualNode = actualNode.getNext();
      s = actualNode.getInfo() + ", " + s;
    }

    s = "[" + s;

    return s;
  }
}
