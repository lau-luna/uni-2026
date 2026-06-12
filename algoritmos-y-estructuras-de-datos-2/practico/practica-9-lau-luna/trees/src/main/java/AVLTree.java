// Accepts duplicates, it places them on the right tree

import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;

public class AVLTree<T extends Comparable<? super T>> {
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

  public AVLTree() {
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

  private Node balance(Node x) {
    int balance = balanceFactor(x);
    // LL case -> R balance
    if (balance > 1 && balanceFactor(x.left) >= 0)
      return rotateRight(x);

    // RR case -> L balance
    if (balance < -1 && balanceFactor(x.right) <= 0)
      return rotateLeft(x);

    // LR case -> LR balance
    if (balance > 1 && balanceFactor(x.left) < 0) {
      x.left = rotateLeft(x.left);
      return rotateRight(x);
    }

    // RL case ->RL balance
    if (balance < -1 && balanceFactor(x.right) > 0) {
      x.right = rotateRight(x.right);
      return rotateLeft(x);
    }
    
    // Already balanced
    return x;
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

  public void add(T key) {
    root = add(root, key);
    size++;
  }

  private Node add(Node x, T key) {
    if (x == null)
      return new Node(key, 1);

    int cmp = key.compareTo(x.key);
    if (cmp < 0)
      x.left = add(x.left, key);
    else
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

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean repOK() {
    return isBST(root, null, null) && isAVL(root);
  }

  public boolean isBST(Node x, T min, T max) {
    if (x == null)
      return true;

    if (min != null && x.key.compareTo(min) < 0) return false;
    if (max != null && x.key.compareTo(max) > 0) return false;

    return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
  }

  public boolean isAVL(Node x) {
    if (x == null)
      return true;

    int balance = balanceFactor(x);
    if (balance < -1 || balance > 1)
      return false;
    
    return isAVL(x.left) && isAVL(x.right);
  }

  public String toString() {
    List<T> list = root.inOrder();
    String s = "{";

    for (int i = 0; i < list.size(); i++) {
      s += list.get(i).toString();
      s += i < list.size() - 1 ? ", " : "";
    }

    s += "}";

    return s;
  }
}
