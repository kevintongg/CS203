import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        double[] list = {10, 1, 5, 6, 2, 4, 7};

        sort(list, 0, 6);
        System.out.println(Arrays.toString(list));

    }

    public static void sort(double[] list, int low, int high) {

        if (high > low) { // Make sure there are still elements to recursiveSelectionSort
            // Find the smallest number and its index in list[low .. high]
            double min = list[low]; // The item you are currently on
            int minIndex = low;
            for (int i = low + 1; i <= high; i++) { // Find the the first smallest number in the set
                if (min > list[i]) {
                    min = list[i];
                    minIndex = i;
                }
            }

            // swap elements
            double temp = list[low]; // Make a copy of the smallest element found so far
            list[low] = min;  // Swap the smallest element with the one we are currently sorting
            list[minIndex] = temp;

            sort(list, low + 1, high);
        }
    }
}
