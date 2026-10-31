import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NaturalBooleanTest {
  @Test
  public void testToString() {
    NaturalBoolean f = new NaturalBoolean(4);
    assertEquals("False", f.toString());

    NaturalBoolean t = new NaturalBoolean(3);
    assertEquals("True", t.toString());
  }
  @Test
  public void testBoolean() {
    NaturalBoolean f = new NaturalBoolean(4);
    assertFalse(f.isTrue());

    NaturalBoolean t = new NaturalBoolean(3);
    assertTrue(t.isTrue());
  }

  @Test
  public void testNegation() {
    NaturalBoolean f = new NaturalBoolean(4);

    assertTrue(f.negate().isTrue());
    assertFalse(f.negate().negate().isTrue());
  }

  @Test
  public void testDisjunction() {
    NaturalBoolean f = new NaturalBoolean(4);
    NaturalBoolean t = new NaturalBoolean(3);
    
    assertTrue(t.disjunction(t).isTrue());
    assertTrue(t.disjunction(f).isTrue());
    assertTrue(f.disjunction(t).isTrue());
    assertFalse(f.disjunction(f).isTrue());
  }

  @Test
  public void testImplication() {
    NaturalBoolean f = new NaturalBoolean(4);
    NaturalBoolean t = new NaturalBoolean(3);
    
    assertTrue(t.implicate(t).isTrue());
    assertFalse(t.implicate(f).isTrue());
    assertTrue(f.implicate(t).isTrue());
    assertTrue(f.implicate(f).isTrue());
  }
}
