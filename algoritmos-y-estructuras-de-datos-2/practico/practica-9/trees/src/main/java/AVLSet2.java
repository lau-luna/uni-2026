import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class AVLSet2<T extends Comparable<? super T>> implements SortedSet<T> {
  private class Node {
    private int height;
    private Node left;
    private Node right;
    private T key;

    public Node(T key, int height) {
      this.key = key;
      this.height = height;
    }
  }
  
  private Node root;
  private int size;

  public AVLSet2() {
    root = null;
    size = 0;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
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

  private Node rotateLeft(Node x) {
    Node y = x.right;
    x.right = y.left;
    y.left = x;
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

  private Node balance(Node x) {
    int balance = balanceFactor(x);
    
    // LL case ->R rot.
    if (balance > 1 && balanceFactor(x.left) > 0)
      return rotateRight(x);

    // RR case ->L rot.
    if (balance < -1 && balanceFactor(x.right) < 0)
      return rotateLeft(x);

    // LR case ->LR rot;
    if (balance > 1 && balanceFactor(x.left) <= 0) {
      x.left = rotateLeft(x.left);
      return rotateRight(x);
    }

    // RL case ->RL rot.
    if (balance < -1 && balanceFactor(x.right) >= 0) {
      x.right = rotateRight(x.right);
      return rotateLeft(x);
    }

    // already balanced
    return x;
  } 

  public T min() {
    if (isEmpty())
      throw new NoSuchElementException("Empty tree");

    return min(root).key;
  }

  private Node min(Node x) {
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

  private Node removeMin(Node x) {
    if (x.left == null)
      return x.right;

    x.left = removeMin(x.left);
    updateHeight(x);
    return balance(x);
  }

  public boolean remove(T key) {
    if (!contains(key))
      return false;
    
    root = remove(root, key);
    size--;
    return true;
  }

  private Node remove(Node x, T key) {
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
    
    updateHeight(x);
    return balance(x);
  }

  public List<T> inOrder() {
    if (root == null)
      return Collections.emptyList();
    
    return inOrder(root);
  }

  private List<T> inOrder(Node x) {
    List<T> list = new LinkedList<>();
    
    if (x.left != null) list.addAll(inOrder(x.left)); 
    list.add(x.key);
    if (x.right != null) list.addAll(inOrder(x.right));

    return list;
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

  public Iterator<T> iterator() {
    if (root == null)
      return Collections.emptyIterator();

    return inOrder(root).iterator();
  }
}
