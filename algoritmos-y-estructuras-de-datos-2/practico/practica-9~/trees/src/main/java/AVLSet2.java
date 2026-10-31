import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class AVLSet2<T extends Comparable<? super T>> implements SortedSet<T> {
  private class Node {
    private Node left;
    private Node right;
    private T item;
    private int height;

    public Node(T item, int height) {
      left = null;
      right = null;
      this.item = item;
      this.height = height;
    }
  }

  private Node root;
  private int size;

  public AVLSet2() {
    root = null;
    size = 0;
  }

  private int height (Node x) {
    if (x == null)
      return 0;

    return x.height;
  }

  private void updateHeight(Node x) {
    x.height = 1 + Math.max(height(x.left), height(x.right));
  }

  public int size() {
    return size;
  }

  public boolean contains(T item) {
    return get(root, item) != null;
  }

  private Node get(Node x, T item) {
    if (x == null)
      return null;

    int cmp = item.compareTo(x.item);
    if (cmp < 0)
      return get(x.left, item);
    else if (cmp > 0)
      return get(x.right, item);
    else
      return x;
  }

  private Node rotateLeft(Node x) {
    Node y = x.right;
    x.right = y.left;
    updateHeight(x);
    updateHeight(y);
    return y;
  }

  private Node rotateRight(Node x) {
    Node y = x.left;
    x.left = y.right;
    y.right = x;
    updateHeight(x);
    updateHeight(y);
    return y;
  }

  private int balanceFactor(Node x) {
    return height(x.left) - height(x.right);
  }
  
  private Node balance(Node x) {
    int balance = balanceFactor(x);

    // LL case ->R rotation
    if (balance > 1 && balanceFactor(x.left) > 0)
      return rotateRight(x);

    // RR case -> L rotation
    if (balance < -1 && balanceFactor(x.right) < 0)
      return rotateLeft(x);

    // LR case ->LR rotation
    if (balance > 1 && balanceFactor(x.left) >= 0) {
      x.left = rotateLeft(x.left);
      return rotateRight(x);
    }

    // RL case -> RL rotation
    if (balance < -1 && balanceFactor(x.right) <= 0) {
      x.right = rotateRight(x);
      return rotateLeft(x);
    }

    return x;
  }

  public boolean add(T item) {
    if (contains(item))
      return false;
    
    root = add(root, item);
    size++;
    return true;
  }
  
  private Node add(Node x, T item) {
    if (x == null)
      return new Node(item, 1);

    int cmp = item.compareTo(x.item);
    if (cmp < 0) 
      x.left = add(x.left, item);
    if (cmp > 0)
      x.right = add(x.right, item);

    updateHeight(x);
    return balance(x);
  }

  public T min() {
    if (isEmpty())
      throw new NoSuchElementException("empty set");

    return min(root).item;
  }

  private Node min(Node x) {
    if (x.left == null)
      return x;

    return min(x.left);
  }

  public void removeMin() {
    if (isEmpty())
      throw new NoSuchElementException("empty set");
    
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

  public boolean isEmpty() {
    return size == 0;
  }

  public List<T> inOrder() {
    if (isEmpty())
      return Collections.emptyList();

    return inOrder(root);
  }

  private List<T> inOrder(Node x) {
    List<T> list = new LinkedList<>();
    
    if (x.left != null) list.addAll(inOrder(x.left));
    list.add(x.item);
    if (x.right != null) list.addAll(inOrder(x.right));

    return list;
  }

  public Iterator<T> iterator() {
    if (isEmpty())
      return Collections.emptyIterator();

    return inOrder().iterator();
  }

  public String toString() {
    List<T> elems = inOrder();
    String s = "{";

    for (int i = 0; i < elems.size(); i++) {
      s += elems.get(i).toString();
      s += i < elems.size() - 1 ? ", " : "";
    }

    s += "}";

    return s;
  }

}
