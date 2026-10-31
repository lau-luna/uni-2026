package list;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {

    @Test
    public void testGet0() {
        DoublyLinkedList <Integer> list = new DoublyLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(10, list.get(0));
        assertEquals("[10, 20, 30]", list.toString());
    }

    @Test
    public void testGet1() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0);
        list.add(0);
        list.add(0,1);
        list.add(1,2);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    public void testGet2() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0);
        list.add(0);
        list.add(0,1);
        list.add(1,0);
        assertTrue(list.repOK());
    }

    @Test
    public void testAddAtIndexBeginning() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        assertEquals("[10]", list.toString());
    }

    @Test
    public void testAddAtIndexEnd() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 30);
        assertEquals("[10, 30]", list.toString());
    }

    @Test
    public void testAddAtIndexMiddle() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 30);
        list.add(1, 20);
        assertEquals("[10, 20, 30]", list.toString());
    }

    @Test
    public void testAddAtIndexBeginningAgain() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        list.add(0, 5);
        assertEquals("[5, 10, 20, 30]", list.toString());
    }

    @Test
    public void testAddAtIndexEndAgain() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        list.add(3, 40);
        assertEquals("[10, 20, 30, 40]", list.toString());
    }

    @Test
    public void testMuchAdd() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i,i);
        }
        assertEquals("[0, 1, 2, 3, 4]", list.toString());

    }

    @Test
    public void testNeg1() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0, 1);
        list.add(1, 0);
        assertThrows(IndexOutOfBoundsException.class,
                () -> list.remove(2));
    }

    @Test
    public void testRemove1() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(0,1);
        list.add(1,0);
        Integer elem = list.remove(0);
        assertEquals(1, elem);
    }

    @Test
    public void testRemove2() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(0);
        Integer elem = list.remove(0);
        assertEquals(1, list.size());
    }

    @Test
    public void testRemove3() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(0);
        Integer elem = list.remove(0);
        assertEquals(0, list.get(0));
    }

    @Test
    public void testRemove4() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(0);
        Integer elem = list.remove(0);
        assertTrue(list.contains(0));
        assertFalse(list.contains(1));
        assertFalse(list.contains(2));
    }

    @Test
    public void testRemove5() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(0);
        Integer elem = list.remove(0);
        assertTrue(list.repOK());
    }

    @Test
    public void testRemove6() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(0);
        Integer elem = list.remove(0);
        assertEquals("[0]", list.toString());
    }

    @Test
    public void testConcat() {
      DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();
      DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();

      for (int i = 1; i <= 5; i++){
        list1.add(i);
      }

      for (int i = 6; i <= 10; i++){
        list2.add(i);
      }

      DoublyLinkedList<Integer> list3 = list1.concat(list2);

      assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", list3.toString());
    }

    @Test
    public void testReverse() {
      DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();

      for (int i = 1; i <= 5; i++){
        list1.add(i);
      }

      list1.reverse();

      assertEquals("[5, 4, 3, 2, 1]", list1.toString());


      // Even items list
      DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();

      for (int i = 1; i <= 6; i++){
        list2.add(i);
      }

      list2.reverse();

      assertEquals("[6, 5, 4, 3, 2, 1]", list2.toString());
    }


}
