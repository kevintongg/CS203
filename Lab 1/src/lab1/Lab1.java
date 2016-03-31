package lab1;

import java.util.Arrays;

public class Lab1 {

    public static void main(String[] args) {

        /*
        *
        * Extra Credit
        * 18.4
        * 18.5
        * 18.6
        * 18.10
        * 18.11
        *
        * */

        double[] list = {1, 23, 4, 7, 11, 10, 13, 19, 3, 94};
        double ec1 = extraCredit18_4(10);

        System.out.println("1.0 First reverse display:");
        reverseDisplay1(5);
        System.out.println("1.1 Second reverse display:");
        reverseDisplay2(123450);
        System.out.println("\n2. Reverse string:");
        reverseStringDisplay("!niveK si eman ym ,olleH");
        System.out.println("Selection Sort:");
        selectionSort(list);
        System.out.println(Arrays.toString(list));
        int x = binarySearch(list, 23);
        System.out.println("Binary Search:");
        System.out.println("The index of our key is " + x + ".");
        System.out.println("Extra Credit 18.4");
        System.out.println(ec1);

    }

    public static double extraCredit18_4(double n) {

        if (n == 0) {
            return 0;
        } else {
            return (1 / n) + extraCredit18_4(n - 1);
        }
    }

    public static int binarySearch(double[] list, int key) {

        int low = 0;
        int high = list.length - 1;

        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid]) {
                high = mid - 1;
            } else if (key == list[mid]) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void selectionSort(double[] list) {

        for (int i = 0; i < list.length - 1; i++) {
            double currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                while (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    public static void reverseDisplay1(int value) {

        if (value == 0) {
            System.out.println(0);
        } else {
            System.out.println(value);
            reverseDisplay1(value - 1);
        }
    }

    public static void reverseDisplay2(int value) {

        if (value <= 0) {
        } else {
            System.out.print(value % 10);
            reverseDisplay2(value / 10);
        }
    }

    public static void reverseStringDisplay(String value) {

        int i = value.length() - 1;

        if (i <= 0) {
            System.out.println(value.charAt(0));
        } else {
            System.out.print(value.charAt(i));
            reverseStringDisplay(value.substring(0, i));
        }


    }
}
