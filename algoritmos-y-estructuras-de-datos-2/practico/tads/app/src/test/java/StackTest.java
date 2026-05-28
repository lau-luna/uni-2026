import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
  @Test
  public void testPush() {
    LinkedStack<Integer> q1 = new LinkedStack<>();
    assertEquals(0, q1.getSize());
    assertEquals("[]", q1.toString());
    q1.push(1);
    assertEquals(1, q1.getSize());
    assertEquals("[1]", q1.toString());
    q1.push(2);
    assertEquals(2, q1.getSize());
    assertEquals("[1, 2]", q1.toString());
  }

  @Test
  public void testPop() {
    LinkedStack<Integer> q1 = new LinkedStack<>();
    q1.push(1);
    q1.push(2);
    q1.push(3);
    assertEquals(3, q1.pop());
    assertEquals(2, q1.getSize());
    assertEquals("[1, 2]", q1.toString());
    assertEquals(2, q1.pop());
    assertEquals(1, q1.getSize());
    assertEquals("[1]", q1.toString());
    assertEquals(1, q1.pop());
    assertEquals(0, q1.getSize());
    assertEquals("[]", q1.toString());
  }
}
