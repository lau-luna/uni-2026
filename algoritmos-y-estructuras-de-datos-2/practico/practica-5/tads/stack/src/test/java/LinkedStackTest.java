import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import jdk.jfr.Timestamp;
import stack.LinkedStack;

public class LinkedStackTest {
  @Test
  public void testToString() {
    LinkedStack<Integer> stack = new LinkedStack<>();

    assertEquals("[]", stack.toString());

    stack.push(1);
    stack.push(2);
    assertEquals("[1, 2]", stack.toString());

    stack.pop();
    assertEquals("[1]", stack.toString());

    stack.pop();
    assertEquals("[]", stack.toString());
  }

  @Test
  public void testPush() {
    LinkedStack<Integer> stack = new LinkedStack<>();

    stack.push(1);
    stack.push(2);
    stack.push(3);
    assertEquals("[1, 2, 3]", stack.toString());

    stack.push(4);
    assertEquals("[1, 2, 3, 4]", stack.toString());
  }

  @Test
  public void testPop() {
    LinkedStack<Integer> stack = new LinkedStack<>();

    stack.push(1);
    stack.push(2);
    stack.push(3);
    assertEquals("[1, 2, 3]", stack.toString());

    assertEquals(3, stack.pop());
    assertEquals("[1, 2]", stack.toString());
  }

  @Test
  public void testTop() {
    LinkedStack<Integer> stack = new LinkedStack<>();

    stack.push(1);
    stack.push(2);
    stack.push(3);
    assertEquals("[1, 2, 3]", stack.toString());

    assertEquals(3, stack.top());
    assertEquals("[1, 2, 3]", stack.toString());
  }

  @Test
  public void testSize() {
    LinkedStack<Integer> stack = new LinkedStack<>();

    assertEquals(0, stack.size());

    stack.push(1);
    stack.push(2);
    stack.push(3);
    assertEquals("[1, 2, 3]", stack.toString());

    assertEquals(3, stack.size());
  }

  @Test
  public void testIsEmpty() {
    LinkedStack<Integer> stack = new LinkedStack<>();

    assertTrue(stack.isEmpty());

    stack.push(1);
    
    assertFalse(stack.isEmpty());
  }


  // Negative tests
  @Test
  public void negativeTestPop() {
    LinkedStack<Integer> stack = new LinkedStack<>();

    stack.push(1);
    assertEquals("[1]", stack.toString());

    assertEquals(1, stack.pop());
    assertEquals("[]", stack.toString());

    assertThrows(NoSuchElementException.class, () ->stack.pop());
  }

  @Test
  public void negativeTestTop() {
    LinkedStack<Integer> stack = new LinkedStack<>();

    stack.push(1);
    assertEquals("[1]", stack.toString());

    assertEquals(1, stack.pop());
    assertEquals("[]", stack.toString());

    assertThrows(NoSuchElementException.class, () ->stack.top());
  }
}
