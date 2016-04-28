package lab5;

public class Lab5<E> {

    public static void main(String[] args) {

        // Test
        Integer[] integers = {23, 3, 94, 2, 11, 9};
        Double[] doubles = {23.3, 3.3, 94.4, 2.2, 11.1, 9.9};
        // for merge sort E[] myTest = (E[]) new Comparable[];

        insertionSort((integers));
    }

    public static <E extends Comparable<E>> void insertionSort(E[] list) {

        for (int i = 0; i < list.length; i++) {
            E current = list[i];
            int j;
            for (j = i; j >= 0 && list[i].compareTo(current) < 1; j++) {
                list[j + 1] = list[j];
            }
            list[j + 1] = current;
        }
    }
}
