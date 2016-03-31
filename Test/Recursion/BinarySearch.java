public class BinarySearch {

    public static void main(String[] args) {

        double list[] = {7, 9, 10, 15, 20, 25};

        System.out.println(binarySearch(list, 15));
    }

    public static int binarySearch(double[] list, double key) {
        return binarySearch(list, key, 0, list.length);
    }

    public static int binarySearch(double[] list, double key, int low, int high) {

        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (key < list[mid]) {
            return binarySearch(list, key, low, mid - 1);
        } else if (key == list[mid]) {
            return mid;
        } else {
            return binarySearch(list, key, mid + 1, high);
        }
    }
}
