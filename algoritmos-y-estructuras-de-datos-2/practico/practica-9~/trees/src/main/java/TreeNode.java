import java.util.List;
import java.util.LinkedList;

public class TreeNode<T> {
  T data;
  TreeNode<T> left;
  TreeNode<T> right;

  public TreeNode(T data) {
    this.data = data;
  }

  public List<T> preOrder() {
    List<T> result = new LinkedList<>();

    result.add(data); // raiz
    if (left != null)
      result.addAll(left.preOrder()); // hi
    if (right != null)
      result.addAll(right.preOrder()); // hd

    return result;
  }

  public List<T> inOrder() {
    List<T> result = new LinkedList<>();

    if (left != null)
      result.addAll(left.inOrder()); // hi
    result.add(data); // raiz
    if (right != null)
      result.addAll(right.inOrder()); // hd

    return result;
  }

  public List<T> postOrder() {
    List<T> result = new LinkedList<>();

    if (left != null)
      result.addAll(left.postOrder()); // hi
    if (right != null)
      result.addAll(right.postOrder()); // hd
    result.add(data); // raiz

    return result;
  }
}
