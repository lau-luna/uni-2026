import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class AVLSet<T extends Comparable<? super T>> implements SortedSet<T> {
  private class Node {
    private T key;
    private int height;
    private Node left;
    private Node right;

    public Node(T key, int height) {
      this.key = key;
      this.height = height;
    }

    public List<T> inOrder() {
      List<T> list = new ArrayList<>();

      if (left != null) list.addAll(left.inOrder());
      list.add(key);
      if (right != null) list.addAll(right.inOrder());

      return list;
    }
  }

  private Node root;
  private int size;

  public AVLSet() {
    root = null;
    size = 0;
  }

  public int height() {
    return height(root);
  }

  private int height(Node x) {
    if (x == null)
      return 0;

    return x.height;
  }

  private void updateHeight(Node x) {
    x.height = 1 + Math.max(height(x.left), height(x.right));
  }

  private int balanceFactor(Node x) {
    return height(x.left) - height(x.right);
  }

  private Node rotateRight(Node x) {
    Node y = x.left;
    x.left = y.right;
    y.right = x;
    updateHeight(x);
    updateHeight(y);
    return y;
  }

  private Node rotateLeft(Node x) {
    Node y = x.right;
    x.right = y.left;
    y.left = x;
    updateHeight(x);
    updateHeight(y);
    return y;
  }

  private Node balance(Node x) {
    int balance = balanceFactor(x);

    // LL case: R rot.
    if (balance > 1 && balanceFactor(x.left) > 0)
      return rotateRight(x);

    // RR case: L rot.
    if (balance < -1 && balanceFactor(x.right) < 0)
      return rotateLeft(x);

    // LR case: LR rot.
    if (balance > 1 && balanceFactor(x.left) <= 0) {
      x.left = rotateLeft(x.left);
      return rotateRight(x);
    }

    // RL case: RL rot.
    if (balance < -1 && balanceFactor(x.right) >= 0) {
      x.right = rotateRight(x.right);
      return rotateLeft(x);
    }
    
    // already balanced
    return x;
  }

  public boolean add(T key) {
    if (contains(key))
      return false;
  
    root = add(root, key);
    size++;
    return true;
  }
  private Node add(Node x, T key) {
    if (x == null)
      return new Node(key, 1);
    
    int cmp = key.compareTo(x.key);
    if (cmp < 0)
      x.left = add(x.left, key);
    else if (cmp > 0)
      x.right = add(x.right, key);

    updateHeight(x);
    return balance(x);
  }

  public boolean contains(T key) {
    return get(root, key) != null;
  }

  private Node get(Node x, T key) {
    if (x == null)
      return null;

    int cmp = key.compareTo(x.key);
    if (cmp < 0)
      return get(x.left, key);
    else if (cmp > 0)
      return get(x.right, key);
    else
      return x;
  }

  public T min() {
    if (isEmpty())
      throw new NoSuchElementException("Empty Tree");

    return min(root).key;
  }

  private Node min(Node x) {
    if (x.left == null)
      return x;

    return min(x.left);
  }

  public void removeMin() {
    if (isEmpty())
      throw new NoSuchElementException("Empty Tree");

    root = removeMin(root);
    size--;
  } 

  private Node removeMin(Node x) {
    if (x.left == null)
      return x.right;

    x.left = removeMin(x.left);
    updateHeight(x);
    return balance(x);
  }

  public int size() {
    return size;
  }

  public Iterator<T> iterator() {
    if (root == null)
      return Collections.emptyIterator();

    return root.inOrder().iterator();
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public String toString() {
    List<T> list = root == null ? Collections.emptyList() : root.inOrder();
    String s = "{";

    for (int i = 0; i < list.size(); i++) {
      s += list.get(i).toString();
      s += i < list.size() - 1 ? ", " : "";
    }

    s += "}";
    return s;
  }
}
