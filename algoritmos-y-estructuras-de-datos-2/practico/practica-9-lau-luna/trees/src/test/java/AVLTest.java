import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AVLTest {

  @Test
  public void test1() {
    AVLTree<Integer> tree = new AVLTree<>();
    tree.add(4);
    tree.add(3);
    tree.add(2);
    assertEquals(2, tree.height());
    assertEquals("{2, 3, 4}", tree.toString());

    tree.remove(3);
    assertEquals(2, tree.height());
    assertEquals("{2, 4}", tree.toString());

    tree.remove(4);
    assertEquals(1, tree.height());
    assertEquals("{2}", tree.toString());

    tree.remove(2);
    assertEquals(0, tree.height());
    assertEquals("{}", tree.toString());
  }
}
