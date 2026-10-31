import java.util.List;
/**
 * This interface represents a logical mathematical Set.
 * A set does not contains repeated elements.
 */
public interface Conjunto<T> { 
  /**
   * Inserts an element into the set if is not there yet.
   * @return true if the element was inserted succesfully.
   * @return false if the element was in the set already.
   */
  public boolean insert(T elem);

  /**
   * Checks if the given 'elem' is in the Set.
   */
  public boolean contains(T elem);

  /**
   * Returns a new Conjunto representing the union of both sets,
   * Formally: this ++ set
   */
  public Conjunto<T> union(Conjunto<T> set);

  public List<T> toList();
  
  /**
   * Abstraction function.
   */
  public String toString();

  /**
   * Representation invariant.
   */
  public boolean repOK();
}
