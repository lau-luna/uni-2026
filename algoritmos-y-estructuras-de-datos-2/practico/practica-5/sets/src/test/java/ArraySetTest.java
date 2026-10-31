
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ArraySetTest {
  @Test
  public void toStringTest() {
    ArraySet<Integer> set = new ArraySet<>();
    assertEquals("{}", set.toString());

    set.insert(1);
    assertEquals("{1}", set.toString());

    set.insert(2);

    assertEquals("{1, 2}", set.toString());

    set.insert(3);
    assertEquals("{1, 2, 3}", set.toString());

    assertTrue(set.repOK());
  }

  @Test
  public void insertTest() {
    ArraySet<Integer> set = new ArraySet<>();

    assertTrue(set.insert(1));
    assertTrue(set.insert(2));
    assertTrue(set.insert(3));

    assertFalse(set.insert(2));

    assertEquals("{1, 2, 3}", set.toString());

    assertTrue(set.repOK());
  }

  @Test
  public void containsTest() {
    ArraySet<Integer> set = new ArraySet<>();

    assertTrue(set.insert(1));
    assertTrue(set.insert(2));
    assertTrue(set.insert(3));

    assertTrue(set.contains(3));
    assertFalse(set.contains(-1));

    assertTrue(set.repOK());
  }
  
  @Test
  public void unionTest() {
    ArraySet<Integer> set = new ArraySet<>();

    set.insert(1);
    set.insert(2);
    set.insert(3);

    ArraySet<Integer> set2 = new ArraySet<>();
    set2.insert(4);
    set2.insert(5);
    set2.insert(6);

    assertEquals("{1, 2, 3, 4, 5, 6}", set.union(set2).toString());


    assertTrue(set.repOK());
  }
}
