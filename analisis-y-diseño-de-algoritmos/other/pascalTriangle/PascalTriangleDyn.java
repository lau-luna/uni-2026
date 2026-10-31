public class PascalTriangleDyn {
  public static int[][] pascal(int n) {
    int[][] matrix = new int[n][n];

    for (int i = 0; i < n; i++) {
      matrix[i][0] = 1;
      matrix[i][i] = 1;
    }

    for (int i = 2; i < n; i++)
      for (int j = 1; j < i; j++) matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j];

    return matrix;
  }

  public static void printPascalTriangle(int n) {
    if (n <= 0) throw new IllegalArgumentException("n must be positive");

    int[][] matrix = pascal(n);

    String s = "";
    for (int i = 0; i < n; i++) {
      String l = "";
      for (int j = 0; j <= i; j++) l += matrix[i][j] + " ";
      s += l + "\n";
    }

    System.out.println(s);
  }

  public static void main(String[] args) {
    printPascalTriangle(15);
  }
}
