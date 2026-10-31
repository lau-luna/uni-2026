import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ParenthesisTest {
  @Test
  public void isBalancedTest() {
    Parenthesis parenthesis = new Parenthesis();
    assertTrue(parenthesis.isBalanced("[()][()()]()"));
    assertTrue(parenthesis.isBalanced("[[()()]]()"));
    assertTrue(parenthesis.isBalanced("()()()"));
    assertTrue(parenthesis.isBalanced("[]"));
    assertFalse(parenthesis.isBalanced("[(])"));
    assertFalse(parenthesis.isBalanced(")"));
    assertFalse(parenthesis.isBalanced("("));
    assertFalse(parenthesis.isBalanced("["));
    assertFalse(parenthesis.isBalanced("]"));
    assertFalse(parenthesis.isBalanced("([)"));
  }
}
