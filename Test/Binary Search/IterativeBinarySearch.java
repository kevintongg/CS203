public class IterativeBinarySearch {

    public static void main(String[] args) {

        int[] list = {1, 2, 3, 4, 5, 11};

        System.out.println((int) iterativeBinarySearch(list, 11));

    }

    public static double iterativeBinarySearch(int[] list, int key) {

        int mid = list.length / 2;
        while (mid > 0 && mid < list.length) {
            if (list[mid] == key) {
                return mid;
            } else if (list[mid] < key) {
                mid = list.length - ((list.length - (mid - 1)) / 2);
            } else {
                mid = list.length - ((list.length - (mid + 1)) / 2);
            }
        }
        return -1;
    }
}
