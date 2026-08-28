import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class SortingTest {
  @Test
  public void testQuickSort() {
    int[] arr = { 1, -3, 4, 0, 10, 5 };
    int[] ordered = { -3, 0, 1, 4, 5, 10 };

    Sorting.quickSort(arr);
    System.out.println(Arrays.toString(arr));

    assertTrue(Arrays.equals(ordered, arr));
  }

  @Test
  public void testMergeSort() {
    int[] arr = { 1, -3, 4, 0, 10, 5 };
    int[] ordered = { -3, 0, 1, 4, 5, 10 };

    arr = Sorting.mergeSort(arr);
    System.out.println(Arrays.toString(arr));

    assertTrue(Arrays.equals(ordered, arr));

  }

  @Test
  public void testbubbleSort() {
    int[] arr = { 1, -3, 4, 0, 10, 5 };
    int[] ordered = { -3, 0, 1, 4, 5, 10 };

    int[] arr2 = { 1, 2, 3 };
    int[] ordered2 = { 1, 2, 3 };

    int[] arr3 = { 3, 2, 1 };

    Sorting.bubbleSort(arr);
    Sorting.bubbleSort(arr2);
    Sorting.bubbleSort(arr3);

    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(arr2));
    System.out.println(Arrays.toString(arr3));
    assertTrue(Arrays.equals(ordered, arr));
    assertTrue(Arrays.equals(ordered2, arr2));
    assertTrue(Arrays.equals(ordered2, arr3));
  }

  @Test
  public void testSelectionSort() {
    int[] arr = { 1, -3, 4, 0, 10, 5 };
    int[] ordered = { -3, 0, 1, 4, 5, 10 };

    int[] arr2 = { 1, 2, 3 };
    int[] ordered2 = { 1, 2, 3 };

    int[] arr3 = { 3, 2, 1 };

    Sorting.selectionSort(arr);
    Sorting.selectionSort(arr2);
    Sorting.selectionSort(arr3);

    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(arr2));
    System.out.println(Arrays.toString(arr3));
    assertTrue(Arrays.equals(ordered, arr));
    assertTrue(Arrays.equals(ordered2, arr2));
    assertTrue(Arrays.equals(ordered2, arr3));
  }

  @Test
  public void testInsertionSort() {
    int[] arr = { 1, -3, 4, 0, 10, 5 };
    int[] ordered = { -3, 0, 1, 4, 5, 10 };

    int[] arr2 = { 1, 2, 3 };
    int[] ordered2 = { 1, 2, 3 };

    int[] arr3 = { 3, 2, 1 };

    Sorting.insertionSort(arr);
    Sorting.insertionSort(arr2);
    Sorting.insertionSort(arr3);

    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(arr2));
    System.out.println(Arrays.toString(arr3));
    assertTrue(Arrays.equals(ordered, arr));
    assertTrue(Arrays.equals(ordered2, arr2));
    assertTrue(Arrays.equals(ordered2, arr3));
  }
  
  @Test
  public void testCountingSort() {
    int[] arr = { 1, 4, 0, 1, 2, 5 };
    int[] ordered = { 0, 1, 1, 2, 4, 5 };

    int[] arr2 = { 1, 2, 3 };
    int[] ordered2 = { 1, 2, 3 };

    int[] arr3 = { 3, 2, 1 };


    //System.out.println(Arrays.toString(arr));
    //System.out.println(Arrays.toString(arr2));
    //System.out.println(Arrays.toString(arr3));
    assertTrue(Arrays.equals(ordered, Sorting.countingSort(arr, 5)));
    assertTrue(Arrays.equals(ordered2, Sorting.countingSort(arr2, 3)));
    assertTrue(Arrays.equals(ordered2, Sorting.countingSort(arr3, 3)));
  }
}
