import java.util.Arrays;

public class SelectionSortIterativeTest {

    public static void main(String[] args) {

        double[] list = {10, 1, 5, 6, 2, 4, 7};
        System.out.println(Arrays.toString(list));
        iterativeSelectionSort(list);
        System.out.println(Arrays.toString(list));

    }

    public static void iterativeSelectionSort(double[] list) {

        for (int i = 0; i < list.length - 1; i++) { // For every element in the list
            for (int j = i + 1; j < list.length; j++) { // Find every subsequent element
                if (list[j] < list[i]) { // And if any of those subsequent elements are less then the current element
                    /*swap v*/
                    double temp = list[j]; // Swap their values and continue
                    list[j] = list[i]; // Swapping values
                    list[i] = temp;
                }
            }
        }
    }
}