import java.util.ArrayList;
import java.util.List;

public class Test {

    /*
    *
    * public static void recursiveSelectionSort(int[] list, int start) {
      if (start >= list.length - 1) {
       return;
      }
    *
    * */

    /*
    *
    * int min = start;
      for (int index = start + 1; index < list.length; index++) {
       if (list[index] < list[min]) {
        min = index;
       }
      }
      int temp = list[start];
      list[start] = list[min];
      list[min] = temp;
      recursiveSelectionSort(list, start + 1);
    }
    *
    * */

    /*
      public static void main(String[] args) {
      int[] hello = { 47, 22, 37, 5, 19};
      recursiveSelectionSort(hello, 0);
      for (int i = 0; i < hello.length; i++) {
       System.out.print(hello[i] + " ");
      }
    }

    * */

    List<Double> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(factorial(3));
    }

    public static int factorial(int n) {
        int factorial = n;
        for (int i = 1; i < n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
