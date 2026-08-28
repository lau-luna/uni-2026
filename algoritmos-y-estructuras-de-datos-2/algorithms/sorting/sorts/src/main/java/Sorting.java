import java.util.Arrays;

public class Sorting {
  public static void quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  private static void quickSort(int[] arr, int p, int r) {
    if (p >= r)
      return;

    int i = p-1;
    for (int j = p; j < r; j++)
      if (arr[j] < arr[r])
        exchange(arr, ++i, j);

    int q = i + 1;
    exchange(arr, q, r);
    quickSort(arr, p, q-1);
    quickSort(arr, q+1, r);
  }

  public static int[] mergeSort(int[] arr) {
    if (arr.length < 2)
      return arr;

    int m = arr.length / 2;
    int[] left = mergeSort(Arrays.copyOfRange(arr, 0, m));
    int[] right = mergeSort(Arrays.copyOfRange(arr, m, arr.length));

    return merge(left, right);
  }

  private static int[] merge(int[] left, int[] right) {
    int[] merged = new int[left.length + right.length];
    
    int i = 0, j = 0, k = 0;
    while (i < left.length && j < right.length)
      merged[k++] = left[i] < right[j] ? left[i++] : right[j++];

    while (i < left.length)
      merged[k++] = left[i++];
    while (j < right.length)
      merged[k++] = right[j++];

    return merged;
  }

  public static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length-1; i++) {
      for (int j = arr.length-1; j >= i + 1; j--) {
        if (arr[j] < arr[j-1])
          exchange(arr, j, j-1);
      }
    }
  }

  public static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length-1; i++) {
      int min = i;

      for (int j = i + 1; j < arr.length; j++)
        if (arr[j] < arr[min])
          min = j;

      exchange(arr, i, min);
    }
  }

  public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int key = arr[i];
      int j = i-1;
      while (j >= 0 && arr[j] > key) {
        arr[j+1] = arr[j];
        j--;
      }
      arr[j+1] = key;
    }
  }
  
  // k is the range [0..k]
  public static int[] countingSort(int[] arr, int k) {
    int[] count = new int[k+1];
    int[] sorted = new int[arr.length];

    // count
    for (int i = 0; i < arr.length; i++)
      count[arr[i]]++;

    for (int i = 1; i < count.length; i++)
      count[i] = count[i] + count[i-1];

    for (int i = 0; i < arr.length; i++)
      sorted[--count[arr[i]]] = arr[i];

    return sorted;
  }

  private static void exchange(int[] arr, int i, int j) {
    int aux = arr[i];
    arr[i] = arr[j];
    arr[j] = aux;
  }

}
