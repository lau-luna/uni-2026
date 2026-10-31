package ej1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/** Hello world! */
public class App {

  // Dado un conjunto s y un valor n, decidir si existe un subconjunto de s cuya suma sea n.
  /**
   * 1. Calcular todos los subconjuntos del conjunto 2. hacer la suma de los subconjuntos 3. revisar
   * si la suma de alguno de los subconjuntos es igual a n
   */
  public static boolean laSumaDeUnSubconjuntoEs(List<Integer> s, int n) {
    LinkedList<LinkedList<Integer>> subconjuntos = subconjuntos(s);

    LinkedList<Integer> sumas = new LinkedList<>();

    for (LinkedList<Integer> sub : subconjuntos) {
      sumas.add(sumatoriaSubconjunto(sub));
    }

    for (int sum : sumas) if (sum == n) return true;

    return false;
  }

  public static int sumatoriaSubconjunto(LinkedList<Integer> s) {
    if (s.size() == 0) return 0;

    int sum = 0;
    for (int e : s) sum += e;

    return sum;
  }

  // Funcion que devuelve el conjunto de partes de un conjunto
  private static LinkedList<LinkedList<Integer>> subconjuntos(List<Integer> c) {
    LinkedList<LinkedList<Integer>> subconjuntos = new LinkedList<>();
    subconjuntos.add(new LinkedList<>());

    for (int e : c) {
      int size = subconjuntos.size();
      for (int i = 0; i < size; i++) {
        LinkedList<Integer> nuevoSubconjunto = new LinkedList<>(subconjuntos.get(i));
        nuevoSubconjunto.add(e);
        subconjuntos.add(nuevoSubconjunto);
      }
    }

    return subconjuntos;
  }

  public static void main(String[] args) {
    LinkedList<Integer> set = new LinkedList<>(Arrays.asList(1, 2, 3));
    System.out.println(laSumaDeUnSubconjuntoEs(set, 25));
  }
}
