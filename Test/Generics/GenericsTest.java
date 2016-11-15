import java.util.ArrayList;
import java.util.List;

public class GenericsTest<E> {

  public static void main(String[] args) {

    List<String> list = new ArrayList<>();

  }

  public static <E extends Comparable<E>> void sort(E[] list) {

    for (int i = 0; i < list.length; i++) {
      list[i].compareTo(list[i + 1]);
//            if (list[i] > list[i+1]) {
//
//            }
    }
  }
}
