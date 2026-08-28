import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class BSTSet3<T extends Comparable<? super T>> implements SortedSet<T> {
  private class Node {
    private Node left;
    private Node right;
    private T item;

    public Node(T item) {
      left = null;
      right = null;
      this.item = item;
    }
  }
  private Node root;
  private int size;

  public BSTSet3() {
    root = null;
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean add(T item) {
    if (contains(item))
      return false;
    
    root = add(root, item);
    size++;
    return true;
  }

  private Node add(Node n, T item) {
    if (n == null)
      return new Node(item);

    int cmp = item.compareTo(n.item);
    if (cmp < 0)
      n.left = add(n.left, item);
    if (cmp > 0)
      n.right = add(n.right, item);

    return n;
  }

  public boolean contains(T item) {
    return contains(root, item) != null;
  }

  private Node contains(Node n, T item) {
    if (n == null)
      return null;
    
    int cmp = item.compareTo(n.item);
    if (cmp < 0)
      return contains(n.left, item);
    else if (cmp > 0)
      return contains(n.right, item);
    else
      return n;
  }

  public void removeMin() {
    if (isEmpty())
      throw new NoSuchElementException("empty set");
    
    root = removeMin(root);
    size--;
  }

  private Node removeMin(Node n) {
    if (n.left == null)
      return n.right;

    n.left = removeMin(n.left);
    return n;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public List<T> inOrder() {
    if (root == null)
      return Collections.emptyList();

    return inOrder(root);
  }

  private List<T> inOrder(Node n) {
    List<T> list = new LinkedList<>();

    if (n.left != null) list.addAll(inOrder(n.left));
    list.add(n.item);
    if (n.right != null) list.addAll(inOrder(n.right));

    return list;
  }
  
  public Iterator<T> iterator() {
    if (root == null)
      return Collections.emptyIterator();

    return inOrder(root).iterator();
  }

  public String toString() {
    List<T> list = inOrder(root);
    String s = "{";

    for (int i = 0; i < size; i++) {
      s += list.get(i).toString();
      s += i < size-1 ? ", " : "";
    }
    
    s += "}";

    return s;
  }

}
