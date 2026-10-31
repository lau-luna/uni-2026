package list;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * The test class MyArrayList.
 */
public class MyArrayListTest
{
    
      
    @Test
    public void test0()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(0);
        assertEquals(2, list.size());
    }
    
    @Test
    public void test1()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(0);
        assertEquals(1, list.get(0));
        assertEquals(0, list.get(1));
    }
    
    @Test
    public void test2()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(0);
        assertTrue(list.contains(0));
        assertTrue(list.contains(1));
        assertFalse(list.contains(2));
    }
    
    @Test
    public void test3()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(0);
        assertTrue(list.repOK());
    }
    
    @Test
    public void test4()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(0);
        assertEquals("[1, 0]", list.toString()); 
    }
       
    @Test
    public void test5()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(0);
        assertThrows(IndexOutOfBoundsException.class, 
            () -> list.get(2));
    }
    
    @Test
    public void test6()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(0);
        assertThrows(IndexOutOfBoundsException.class, 
            () -> list.remove(2));
    }   
    
    @Test
    public void test7()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(0);
        Integer elem = list.remove(0);
        assertEquals(1, elem);
    }
    
    @Test
    public void test8()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(0);
        Integer elem = list.remove(0);
        assertEquals(1, list.size());
    }
    
    @Test
    public void test9()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(0);
        Integer elem = list.remove(0);
        assertEquals(0, list.get(0));
    }
    
    @Test
    public void test10()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(0);
        Integer elem = list.remove(0);
        assertTrue(list.contains(0));
        assertFalse(list.contains(1));
        assertFalse(list.contains(2));
    }
    
    @Test
    public void test11()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(0);
        Integer elem = list.remove(0);
        assertTrue(list.repOK()); 
    }
    
    @Test
    public void test12()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(0);
        Integer elem = list.remove(0);
        assertEquals("[0]", list.toString()); 
    }
    
    @Test
    public void test20()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        assertEquals(10, MyArrayList.INIT_CAPACITY);
    }
    
    @Test
    public void test21()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        assertEquals(10, list.getArraySize());
    }
    
    @Test
    public void test22()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        assertEquals(20, list.getArraySize());
    }
    
    @Test
    public void test23()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        assertEquals(11, list.size());
    }

    
    @Test
    public void test24()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(0);
        assertEquals(1, list.get(0));
        assertEquals(0, list.get(1));
    }
    
    @Test
    public void test25()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(0);
        assertTrue(list.contains(0));
        assertTrue(list.contains(1));
        assertFalse(list.contains(2));
    }
    
    @Test
    public void test26()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(0);
        assertTrue(list.repOK());
    }
    
    @Test
    public void test27()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(0);
        assertEquals("[1, 0, 1, 0, 1, 0, 1, 0, 0]", list.toString()); 
    }

    @Test
    public void test28()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>(8);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(0);
        assertEquals(16, list.getArraySize());
    }

    @Test
    public void test29()
    {
        MyArrayList<Integer> list = new MyArrayList<Integer>(8);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(0);
        assertEquals(9, list.size());
    }

}

