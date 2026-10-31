package queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIterator<T> implements Iterator<T> {
  private LinkedQueue<T> queue;
  private Node<T> currentNode;
  private int i = 0;

  public LinkedIterator(LinkedQueue<T> queue) {
    this.queue = queue;
    currentNode = queue.first;
  }

  public boolean hasNext() {
    return i < queue.size(); 
  }

  public T next() {
    if (!hasNext())
      throw new NoSuchElementException();
    
   if (currentNode == null)
        currentNode = queue.first;

    T item = currentNode.getInfo();
    currentNode = currentNode.getNext();
    i++;
    return item;
  }
}
