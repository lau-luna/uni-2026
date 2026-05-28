import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
  @Test
  public void testEnqueue() {
    LinkedQueue<Integer> q1 = new LinkedQueue<>();
    assertEquals(0, q1.getSize());
    assertEquals("[]", q1.toString());
    q1.enqueue(1);
    assertEquals(1, q1.getSize());
    assertEquals("[1]", q1.toString());
    q1.enqueue(2);
    assertEquals(2, q1.getSize());
    assertEquals("[1, 2]", q1.toString());
  }

  @Test
  public void testDequeue() {
    LinkedQueue<Integer> q1 = new LinkedQueue<>();
    q1.enqueue(1);
    q1.enqueue(2);
    assertEquals(1, q1.dequeue());
    assertEquals(1, q1.getSize());
    assertEquals("[2]", q1.toString());
    assertEquals(2, q1.dequeue());
    assertEquals(0, q1.getSize());
    assertEquals("[]", q1.toString());
  }
}
