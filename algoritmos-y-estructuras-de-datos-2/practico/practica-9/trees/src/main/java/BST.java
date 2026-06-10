import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Iterator;

public class BST<T extends Comparable<? super T>> {
  private static class Node<T> {
    T key;
    Node<T> left;
    Node<T> right;

    public Node(T key) {
      this.key = key;
    }

    public List<T> inOrder() {
      List<T> list = new ArrayList<>();

      if (left != null) list.addAll(left.inOrder());
      list.add(key);
      if (right != null) list.addAll(right.inOrder());

      return list;
    }
  }
    
  private Node<T> root;
  private int size;

  public BST() {
    root = null;
    size = 0;
  }
  
  public boolean contains(T key) {
    return get(root, key) != null;
  }

  private Node<T> get(Node<T> x, T key) {
    if (x == null)
      return null;

    int cmp = key.compareTo(x.key);
    if (cmp < 0)
      return get(x.left, key);
    else if (cmp > 0)
      return get(x.right, key);

    return x;
  }

  public void add(T key) {
    root = add(root, key);
    size++;
  }

  private Node<T> add(Node<T> x, T key) {
    if (x == null)
      return new Node<T>(key);

    int cmp = key.compareTo(x.key);
    if (cmp < 0)
      x.left = add(x.left, key);
    else
      x.right = add(x.right, key);

    return x;
  }

  public T min() {
    if (isEmpty())
      throw new NoSuchElementException();
    return min(root).key;
  }

  private Node<T> min(Node<T> x) {
    if (x.left == null)
      return x;

    return min(x.left);
  }

  public void removeMin() {
    if (isEmpty())
      throw new NoSuchElementException("Empty tree");

    root = removeMin(root);
    size--;
  }

  private Node<T> removeMin(Node<T> x) {
    if (x.left == null)
      return x.right;
    
    x.left = removeMin(x.left);
    
    return x;
  }

  public boolean remove(T key) {
    if (!contains(key))
      return false;
    
    root = remove(root, key);
    size--;
    return true;
  }

  private Node<T> remove(Node<T> x, T key) {
    int cmp = key.compareTo(x.key);
    if (cmp < 0)
      x.left = remove(x.left, key);
    else if (cmp > 0)
      x.right = remove(x.right, key);
    else {
      if (x.left == null) return x.right;
      if (x.right == null) return x.left;

      x.key = min(x.right).key;
      x.right = removeMin(x.right);
    }

    return x;
  }

  public boolean repOK() {
    return isBST(root, null, null);
  }

  private boolean isBST(Node<T> x, T min, T max) {
    if (x == null)
      return true;

    if (min != null && x.key.compareTo(min) < 0) return false;
    if (max != null && x.key.compareTo(max) > 0) return false;

    return isBST(x.left, min, x.key) &&
           isBST(x.right, x.key, max);
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

  public Iterator<T> iterator() {
    if (root == null)
      return Collections.emptyIterator();

    return root.inOrder().iterator();
  }

  public boolean isEmpty() {
    return size == 0;
  }
}
