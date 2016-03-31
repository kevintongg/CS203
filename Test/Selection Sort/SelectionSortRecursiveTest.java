import java.util.Arrays;

public class SelectionSortRecursiveTest {

    public static void main(String[] args) {

        double[] list = {10, 1, 5, 6, 2, 4, 7};
        System.out.println(Arrays.toString(list));
        recursiveSelectionSort(list, 0);
        System.out.println(Arrays.toString(list));

    }

    public static void recursiveSelectionSort(double[] list, int start) {

        if (start == list.length) { // Have we sorted all the elements
            return;
        }
        double currentValue = list[start]; // Make a copy of our value
        for (int i = start; i < list.length; i++) {
            if (list[i] < currentValue) { // Find the next smallest value
                list[start] = list[i]; // Swap values at the indexes
                list[i] = currentValue;
                recursiveSelectionSort(list, start + 1); // Start sorting from the next point; might be able to get away with using i instead of start
                return;
            }
        }

    }
}
