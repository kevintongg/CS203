import java.util.Arrays;

public class SelectionSortRecursiveTest {

  public static void main(String[] args) {

    double[] list = {10, 1, 5, 6, 2, 4, 7};
    System.out.println(Arrays.toString(list));
    recursiveSelectionSort(list, 0);
    System.out.println(Arrays.toString(list));

  }

  public static void recursiveSelectionSort(double[] list, int start) {

    if (start == list.length) { // Are all the elements sorted?
      return;
    }
    int smallest = start;
    for (int i = smallest + 1; i < list.length; i++) { // Start after the start value
      if (list[smallest] > list[i]) { // Find the smallest integer
        smallest = i;
      }
    }

    double temp = list[smallest]; // Swap
    list[smallest] = list[start];
    list[start] = temp;

    recursiveSelectionSort(list, start + 1); /// Move on
  }
}
