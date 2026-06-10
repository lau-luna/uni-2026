import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test class BSTSetTest.
 */
public class AVLSetTest
{
   
  @Test
  public void test1()
  {
        SortedSet<Integer> set = new AVLSet<Integer>();
        set.add(0);
        set.add(3);
        set.add(1);
        set.add(-1);    
        assertEquals(4, set.size());
        assertEquals(set.contains(0), true);
        assertEquals(set.contains(-2), false);        
        assertEquals(set.contains(3), true);        
        assertEquals(set.contains(1), true);
        assertEquals(set.contains(-1), true);
    }
    
    
    @Test
    public void test2()
    {
        SortedSet<Integer> set = new AVLSet<Integer>();
        assertThrows(NoSuchElementException.class, 
          ()-> set.removeMin());
    }
    
    // Test corregido
    @Test
    public void test3()
    {
        SortedSet<Integer> set = new AVLSet<Integer>();
        set.add(0);
        set.add(-2);
        set.removeMin();
        set.add(4);
        assertEquals(set.contains(0), true);
        assertEquals(set.contains(-2), false);
        assertEquals(true, set.contains(4));
        assertEquals(2, set.size());
        assertEquals("{0, 4}", set.toString());
    }

}
