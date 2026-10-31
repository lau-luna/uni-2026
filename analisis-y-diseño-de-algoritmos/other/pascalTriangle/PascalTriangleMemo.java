import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PascalTriangleMemo {
  public record Pair(int x, int y) {}

  public static Map<Pair, Integer> cache = new HashMap<>();

  /**
   * @param row is a certain row of the Pascal triangle.
   * @param pos is the index of a number of a {@code row} goes from {@value [0..n-1]}
   */
  public static int pascal(int row, int pos) {
    if (row <= 0) throw new IllegalArgumentException("row must be > 0");
    if (row == 1) return 1;
    if (pos < 0) return 0;
    if (pos == 0 || pos == row - 1) return 1;

    // Cache handling
    if (!cache.containsKey(new Pair(row, pos)))
      cache.put(new Pair(row, pos), pascal(row - 1, pos - 1) + pascal(row - 1, pos));

    return cache.get(new Pair(row, pos));
  }

  public static List<Integer> row(int r) {
    List<Integer> row = new LinkedList<>();
    // generate each element for the row
    for (int i = 0; i < r; i++) row.add(pascal(r, i));
    return row;
  }

  /**
   * @param r is the number of the last row
   */
  public static List<List<Integer>> pascalTriangle(int r) {
    List<List<Integer>> rows = new LinkedList<>();
    // generate each row
    for (int i = 0; i <= r; i++) rows.add(row(i));

    return rows;
  }

  public static void printPascalTriangle(List<List<Integer>> pascalTriangle) {
    String s = "";
    for (int i = 0; i < pascalTriangle.size(); i++) {
      String l = "";
      for (int j = 0; j < pascalTriangle.get(i).size(); j++)
        l += pascalTriangle.get(i).get(j) + " ";
      s += l + "\n";
    }
    System.out.println(s);
  }

  public static void main(String[] args) {
    printPascalTriangle(pascalTriangle(100));
  }
}
