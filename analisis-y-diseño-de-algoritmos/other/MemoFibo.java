import java.util.HashMap;
import java.util.Map;

public class MemoFibo {

  private static Map<Long, Long> cache = new HashMap<>();

  public static long memoFibo(long n) {
    if (n < 0) throw new IllegalArgumentException("undefined for nonnegative integers");
    if (!cache.containsKey(n)) {
      if (n == 0) {
        cache.put(n, 0L);
      } else if (n == 1) {
        cache.put(n, 1L);
      } else {
        cache.put(n, memoFibo(n - 1) + memoFibo(n - 2));
      }
    }
    return cache.get(n);
  }

  public static int fib(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fib(n - 1) + fib(n - 2);
  }

  public static void main(String[] args) {
    long start = System.nanoTime();

    System.out.println(memoFibo(3));

    double end = (System.nanoTime() - start) / 1_000_000.0;
    System.out.println("Time: " + end + "ms");
  }
}
