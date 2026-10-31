import java.util.ArrayList;
import java.util.List;

public class ArraySet<T> implements Conjunto<T> {
  private List<T> list;

  public ArraySet() {
    this.list = new ArrayList<>();
  }
  
  public ArraySet(List<T> list) {
    this.list = list;
  }

  public List<T> toList() {
    return list;
  }
  

  public int size() {
    return list.size();
  }

  public boolean insert(T elem) {
    if (list.contains(elem))
      return false;

    list.add(elem);
    return true;
  }

  public boolean contains(T elem) {
    return list.contains(elem);
  }

  public Conjunto<T> union(Conjunto<T> set) {
    List<T> newList = new ArrayList<>(list);
    // newList.addAll(set.toList());

    return new ArraySet<>(newList);
  }

  public String toString() {
    String s = "{";

    for (int i = 0; i < list.size() - 1; i++) {
      s += list.get(i);
      s += ", ";
    }
    if (size() > 0)
      s += list.getLast();
    
    s += "}";
    
    return s;
  }

  /**
   * Checks if there are not repeated or null elements inside the set.
   */
  public boolean repOK() {
    for (int i = 0; i < size() - 1; i++) {
      if (list.get(i) == null)
        return false;

      for (int j = i + 1; j < size(); j++) {
        if (list.get(j) == null)
          return false;

        if (list.get(i).equals(list.get(j)))
          return false;
      }
    }

    return true;
  }
}
