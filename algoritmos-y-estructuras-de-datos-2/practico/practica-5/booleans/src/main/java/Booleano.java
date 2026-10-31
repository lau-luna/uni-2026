public interface Booleano {
  /**
   * Makes a logic negation using the invoked object as φ  
   * ¬φ
   *
   * Truth table:
   * +---+----+
   * | φ | ¬φ |   
   * +---+----+
   * | T |  T |
   * | T |  F |   
   * +---+----+ 
   * */
  public Booleano negate();
  
  /**
   * Makes a logic disjunction using the invoked object as φ  and the argument as ψ
   * φ ∨ ψ
   *
   * Truth table:
   * +----+---+-------+
   * | φ  | ψ | φ ∨ ψ |
   * +----+---+-------+
   * | T  | T |   T   |
   * | T  | F |   T   |
   * | F  | T |   T   |
   * | F  | F |   F   |
   * +----+---+-------+
  */
  public Booleano disjunction(Booleano b);
  
  /**
   * Makes a logic implication using the invoked object as φ  and the argument as ψ
   * φ ⇒ ψ
   *
   * Truth table:
   * +----+---+-------+
   * | φ  | ψ | φ ⇒ ψ |
   * +----+---+-------+
   * | T  | T |   T   |
   * | T  | F |   F   |
   * | F  | T |   T   |
   * | F  | F |   T   |
   * +----+---+-------+
  */
  public Booleano implicate(Booleano b);

  boolean isTrue();
}
