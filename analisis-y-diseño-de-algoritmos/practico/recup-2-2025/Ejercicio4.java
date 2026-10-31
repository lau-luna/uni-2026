import java.util.HashMap;
import java.util.Map;

public class Ejercicio4 {
  private static Map<Integer, Long> cache = new HashMap<>();

  public static long parens(int n) {
    if (n <= 1) return 1L;

    long res = 0;
    for (int i = 0; i < n; i++) res += parens(i) * parens(n - i - 1);
    return res;
  }

  public static long parensMemo(int n) {
    if (!cache.containsKey(n)) {
      if (n <= 1) {
        cache.put(n, 1L);
      } else {
        long res = 0;
        for (int i = 0; i < n; i++) res += parensMemo(i) * parensMemo(n - i - 1);
        cache.put(n, res);
      }
    }
    return cache.get(n);
  }

  public static void main(String[] args) {
    System.out.println(parens(3));
    System.out.println(parensMemo(3));
  }
}
