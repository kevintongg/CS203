public class SelectionSort {

    public static void main(String[] args) {

        double[] list = {10, 1, 5, 6, 2, 4, 7};
        list = new double[7];

        sort(list, 0, 6);

    }

    public static void sort(double[] list, int low, int high) {

        if (high > low) {
            double min = list[low];
            int minIndex = low;

            for (int i = low + 1; i <= high; i++) {
                if (min > list[i]) {
                    min = list[i];
                    minIndex = i;
                }
            }

            // swap elements
            double temp = list[low];
            list[low] = min;
            list[minIndex] = temp;

            for (int i = 0; i < list.length; i++) {
                System.out.println(i);
            }
        } else {
            sort(list, low + 1, high);
        }
    }
}
