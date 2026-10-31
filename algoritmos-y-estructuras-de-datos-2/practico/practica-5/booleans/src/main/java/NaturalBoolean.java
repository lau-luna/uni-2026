/**
 * This implementation uses natual numbers to represent boolean values
 * (True/False)
 * Odd numbers represent TRUE, as 1 is used to represent true,
 * Even numbers represent FALSE, as 0 is used to represent false,
 *
 * WE COUNT ZERO AS NATURAL!
 */
public class NaturalBoolean implements Booleano {
  protected int number;

  public NaturalBoolean(int number) {
    if (number < 0)
      throw new IllegalArgumentException("The number must be a natural number.");

    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  @Override
  public boolean isTrue() {
    return number % 2 != 0;
  }

  @Override
  public Booleano negate() {
    return new NaturalBoolean(number + 1);
  }

  @Override
  public Booleano disjunction(Booleano b) {
    int p = number % 2;
    int q = b.isTrue() ? 1 : 0;

    return new NaturalBoolean(Math.max(p, q));
  }

  @Override
  public Booleano implicate(Booleano b) {
    int p = number % 2;
    int q = b.isTrue() ? 1 : 0;

    return new NaturalBoolean(Math.max(1 - p, q));
  }

  /**
   * Abstraction function.
   */
  public String toString() {
    return number % 2 == 0 ? "False" : "True";
  }

}
