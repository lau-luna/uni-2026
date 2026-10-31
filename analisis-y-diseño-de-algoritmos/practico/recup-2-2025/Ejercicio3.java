import java.util.HashMap;
import java.util.Map;

public class Ejercicio3 {
  public record Pair(int n, int k) {}
  ;

  private static Map<Pair, Integer> cache = new HashMap<>();

  public static int permMemo(int n, int k) {
    if (!cache.containsKey(new Pair(n, k))) {
      if (k == 0 || k == n) {
        cache.put(new Pair(n, k), 1);
      } else if (k == 1) {
        cache.put(new Pair(n, k), n);
      } else {
        cache.put(new Pair(n, k), permMemo(n - 1, k) + k * permMemo(n - 1, k - 1));
      }
    }
    return cache.get(new Pair(n, k));
  }

  public static void main(String[] args) {
    System.out.println(permMemo(5, 3));
  }
}
