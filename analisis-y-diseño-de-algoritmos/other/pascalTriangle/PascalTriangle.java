public class PascalTriangle {
  public static int[] pascal(int[] arr) {
    if (arr.length == 1) {
      System.out.println("1");
      return new int[] {1};
    }

    int[] prevLvl = pascal(new int[arr.length - 1]);

    arr[0] = 1;
    arr[arr.length - 1] = 1;

    for (int i = 1; i < arr.length - 1; i++)
      arr[i] = getPosition(prevLvl, i - 1) + getPosition(prevLvl, i);

    // Print array for each level
    for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
    System.out.println();

    return arr;
  }

  public static int getPosition(int[] arr, int i) {
    if (i < 0 || i >= arr.length) return 0;

    return arr[i];
  }

  public static void printPascalTriangle(int n) {
    pascal(new int[n]);
  }

  public static void main(String[] args) {
    printPascalTriangle(10);
  }
}
