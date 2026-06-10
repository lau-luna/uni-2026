import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Iterator;



public class BSTSet2<T extends Comparable<? super T>> implements SortedSet<T> {
  private static class Node<T> {
    T data;
    Node<T> left;
    Node<T> right;

    public Node(T data) {
      this.data = data;
    }

    public List<T> inOrder() {
      List<T> list = new ArrayList<>();

      if (left != null) list.addAll(left.inOrder());
      list.add(data);
      if (right != null) list.addAll(right.inOrder());

      return list;
    }
  }

  private Node<T> root;
  private int size;

  public BSTSet2() {
    root = null;
    size = 0;
  }

  public boolean isEmpty() { return size == 0; }

  public boolean contains(T key) {
    return get(root, key) != null;
  }

  private Node<T> get(Node<T> x, T key) {
    if (x == null)
      return null;

    int cmp = key.compareTo(x.data);
    if (cmp < 0)
      return get(x.left, key);
    if (cmp > 0)
      return get(x.right, key);

    return x; 
  }

  public boolean add(T key) {
    if (contains(key))
      return false;

    root = add(root, key);
    size++;
    return true;
  }
  
  private Node<T> add(Node<T> x, T key) {
    if (x == null)
      return new Node<T>(key);

    int cmp = key.compareTo(x.data);
    if (cmp < 0)
      x.left = add(x.left, key);
    else if (cmp > 0)
      x.right = add(x.right, key);

    return x;
  }

  public void removeMin() {
    if (isEmpty())
      throw new NoSuchElementException("Empty Tree");

    root = removeMin(root);
    size--;
  }

  private Node<T> removeMin(Node<T> x) {
    if (x.left == null)
      return x.right;

    x.left = removeMin(x.left);

    return x;
  }

  public String toString() {
    List<T> elems = root.inOrder();
    String s = "{";

    for (int i = 0; i < elems.size(); i++) {
      s += elems.get(i);
      s += i < elems.size()-1 ? ", " : "";
    }

    s += "}";

    return s;
  }

  public Iterator<T> iterator() {
    return root.inOrder().iterator();
  }

  public int size() {
    return size;
  }
}
