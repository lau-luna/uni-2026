import java.util.Arrays;

public class Ejercicio1 {
  public static int minmumBoxes(float[] weights, float boxCapacity) {
    if (boxCapacity == 0 || weights.length == 0)
      return 0;
    float[] sortedWeights = Arrays.copyOf(weights, weights.length);
    Arrays.sort(sortedWeights);
    return minBoxes(sortedWeights, boxCapacity);
  }

  /**
   * @pre weights must be sorted in increasing order
   */
  public static int minBoxes(float[] weights, float boxCapacity) {
    int boxes = 1;
    float currentWeight = 0;

    for (int i = 0; i < weights.length; i++) {
      if (currentWeight + weights[i] <= boxCapacity) {
        currentWeight += weights[i];
      } else {
        boxes++;
        currentWeight = weights[i];
      }
    }
    return boxes;
  }

  public static void main(String[] args) {
    float boxCapacity = 20;
    float[] weights = {6f, 4f, 2f, 1f, 7f, 10f, 15f, 12f, 16f};

    System.out.println(minmumBoxes(weights, boxCapacity));
    System.out.println(Arrays.toString(weights));
  }
}
