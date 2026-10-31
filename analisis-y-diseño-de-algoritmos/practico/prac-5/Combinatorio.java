public class Combinatorio {
  public static long comb(int n, int m) {
    if (n < 0)
      throw new IllegalArgumentException();
    if (m > n)
      return 0;
    if (m == 0 || n == m)
      return 1;

    long[][] M = new long[n+1][m+1];


    for (int i = 0; i <= n; i++) {
      M[i][0] = 1;
      if (i <= m)
        M[i][i] = 1;
    }

    for (int i = 2; i <= n; i++)
      for (int j = 1; j < i && j <= m; j++)
        M[i][j] = M[i-1][j-1] + M[i-1][j];

    // for (int i = 0; i < M.length; i++) {
    //   for (int j = 0; j < M[i].length; j++) {
    //     System.out.print(M[i][j] + " ");
    //   }
    //   System.out.println();
    // }

    return M[n][m];
  }
  public static void main(String[] args) {
    System.out.println(comb(50, 25));
  }
}
