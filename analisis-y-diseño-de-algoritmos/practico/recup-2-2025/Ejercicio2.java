public class Ejercicio2 {
  public static int maxGanancia(int[] costos, int[] ganancias, int T) {
    if (T == 0) return 0;

    int[][] M = new int[costos.length + 1][T + 1];

    for (int i = 0; i < M.length; i++) M[i][0] = 0;
    for (int j = 1; j <= T; j++) M[0][j] = 0;

    for (int i = 1; i < M.length; i++)
      for (int j = 1; j <= T; j++) {
        if (costos[i - 1] <= j) {
          int ganTomo = ganancias[i - 1] + M[i - 1][j - costos[i - 1]];
          int ganNoTomo = M[i - 1][j];
          M[i][j] = Math.max(ganTomo, ganNoTomo);
        } else {
          M[i][j] = M[i - 1][j];
        }
      }

    return M[M.length - 1][T];
  }

  public static void main(String[] args) {
    int[] costos = {3, 5, 1, 1, 4};
    int[] ganancias = {30, 20, 20, 20, 15};

    System.out.println(maxGanancia(costos, ganancias, 5));
  }
}
