import java.util.List;
import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Iterator;

class Node<T> {
  T data;
  Node<T> left;
  Node<T> right;

  public Node(T data) {
    this.data = data;
  }

  public List<T> inOrder() {
    List<T> list = new LinkedList<>();

    if (left != null)
      list.addAll(left.inOrder());
    list.add(data);
    if (right != null)
      list.addAll(right.inOrder());

    return list;
  }
}

public class BSTSet<T extends Comparable<? super T>> implements SortedSet<T> {
  private Node<T> root;
  private int size;

  public BSTSet() {
    root = null;
    size = 0;
  }

  public int size() {
    return this.size;
  }

  public boolean contains(T key) {
    return contains(root, key) != null;
  }

  private Node<T> contains(Node<T> x, T key) {
    if (x == null)
      return null;

    int cmp = key.compareTo(x.data);
    if (cmp < 0)
      return contains(x.left, key);
    else if (cmp > 0)
      return contains(x.right, key);
    else
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

  public boolean isEmpty() {
    return size == 0;
  }

  public Iterator<T> iterator() {
    if (root == null)
      return Collections.emptyIterator();

    return root.inOrder().iterator();
  }

  public String toString() {
    List<T> elems = root.inOrder();
    String s = "{";

    for (int i = 0; i < elems.size(); i++) {
      s += elems.get(i).toString();
      s += i < elems.size() - 1 ? ", " : "";
    }

    s += "}";

    return s;
  }

}
