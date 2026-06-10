
/**
 * BST
 * hi < r < hd
 */

import java.util.NoSuchElementException;
import java.util.List;

public class BinarySearchTree<T extends Comparable<? super T>> {
  private TreeNode<T> root;
  private int size;

  private BinarySearchTree() {
    root = null;
    size = 0;
  }

  public TreeNode<T> getRoot() {
    return root;
  }

  public boolean contains(T key) {
    return get(root, key) != null;
  }

  private TreeNode<T> get(TreeNode<T> node, T key) {
    if (node == null)
      return null;

    int cmp = key.compareTo(node.data);
    if (cmp < 0)
      return get(node.left, key);
    else if (cmp > 0)
      return get(node.right, key);
    else
      return node;
  }

  public boolean add(T key) {
    root = add(root, key);
    size++;
    return true;
  }

  private TreeNode<T> add(TreeNode<T> node, T key) {
    if (node == null)
      return new TreeNode<T>(key);

    int cmp = key.compareTo(node.data);
    if (cmp < 0)
      node.left = add(node.left, key);
    else if (cmp > 0)
      node.right = add(node.right, key);

    return node;
  }

  public T min() {
    if (isEmpty())
      throw new NoSuchElementException("Empty tree");
    return min(root).data;
  }

  private TreeNode<T> min(TreeNode<T> node) {
    if (node.left == null)
      return node;
    else
      return min(node.left);
  }

  public T max() {
    if (isEmpty())
      throw new NoSuchElementException("Empty tree");
    return max(root).data;
  }

  private TreeNode<T> max(TreeNode<T> node) {
    if (node.right == null)
      return node;
    else
      return max(node.right);
  }

  public void removeMin() {
    if (isEmpty())
      throw new NoSuchElementException("Empty Tree");
    root = removeMin(root);
    size--;
  }

  private TreeNode<T> removeMin(TreeNode<T> node) {
    if (node.left == null)
      return node.right;
    node.left = removeMin(node.left);

    return node;
  }

  public boolean remove(T key) {
    if (!contains(key))
      return false;
    root = remove(root, key);
    size--;
    return true;
  }

  private TreeNode<T> remove(TreeNode<T> node, T key) {
    int cmp = key.compareTo(node.data);
    if (cmp < 0)
      return node.left = remove(node.left, key);
    else if (cmp > 0)
      return node.right = remove(node.right, key);
    else
      node.data = min(node.right).data;
      node.right = removeMin(node.right);

    return node;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public String toString() {
    String s = "{";
    boolean first = true;

    List<T> elems = root.inOrder();

    for (T elem : elems) {
      s += elem.toString();
      s += first ? ", " : "";
      first = false;
    }

    s += "}";

    return s;
  }

  public boolean repOK() {
    return isBST(root, null, null);
  }

  public boolean isBST(TreeNode<T> node, T min, T max) {
    if (node == null)
      return true;

    if (min != null && node.data.compareTo(min) < 0)
      return false;
    if (max != null && node.data.compareTo(max) > 0)
      return false;

    return isBST(node.left, min, node.data) && isBST(node.right, node.data, max);
  }
}
