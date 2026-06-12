import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrMaxHeapTest {
  @Test
  public void test1() {
    MaxHeap<Integer> heap = new ArrMaxHeap<>();
    
    heap.insert(3);
    heap.insert(2);
    heap.insert(10);
    heap.insert(-3);

    assertEquals(10, heap.max());
    assertEquals(10, heap.removeMax());
    assertEquals(3, heap.max());
  }
}
