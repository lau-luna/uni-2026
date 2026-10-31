import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;


public class HeapPriorityQueueTest {
  @Test
  public void test1() {
    HeapPriorityQueue3<Integer> heap = new HeapPriorityQueue3<>();
    
    heap.insert(3);
    heap.insert(2);
    heap.insert(10);
    heap.insert(-3);

    assertEquals(10, heap.max());
    assertEquals(10, heap.removeMax());
    assertEquals(3, heap.max());

    assertEquals("[-3, 2, 3]", heap.toString());

    assertTrue(heap.repOK());

    Integer[] nums = {null, 5, 2, -2, 4, 1};
    Integer[] expected = {null, -2, 1, 2, 4, 5};
    // heap.heapSort(nums);
    //assertTrue(Arrays.equals(expected, nums));
  }
}
