package lab1;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

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
        extraCredit();

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

    public static void selectionSort(double[] list) {

        for (int i = 0; i < list.length; i++) {
            for (int j = i; j < list.length; j++) {
                if (list[j] < list[i]) {
                    double temp = list[j];
                    list[j] = list[i];
                    list[i] = temp;
                }
            }
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

    public static void extraCredit() {

        DecimalFormat decimalFormat = new DecimalFormat("#.#####");
        Scanner sc = new Scanner(System.in);

        double ec1 = Double.parseDouble(decimalFormat.format(extraCredit18_4(10)));
        double ec2 = Double.parseDouble(decimalFormat.format(extraCredit18_5(10)));
        double ec3 = Double.parseDouble(decimalFormat.format(extraCredit18_6(10)));

        System.out.println("Extra Credit 18.4:");
        System.out.println(ec1);
        System.out.println("Extra Credit 18.4:");
        System.out.println(ec2);
        System.out.println("Extra Credit 18.5:");
        System.out.println(ec3);
        System.out.println("Extra Credit 18.10:");
        System.out.println("Please enter a string.");
        String s = sc.next();
        System.out.println("Please enter the character you want to find the number of occurrences for:");
        char c = sc.next().charAt(0);
        System.out.println(extraCredit18_10(s, c));
        System.out.println("Extra Credit 18.11:");
        System.out.println("Please enter a number:");
        long l = sc.nextInt();
        System.out.println(extraCredit18_11(l));

    }

    public static double extraCredit18_4(double n) {

        if (n == 0) {
            return 0;
        } else {
            return (1 / n) + extraCredit18_4(n - 1);
        }
    }

    public static double extraCredit18_5(double n) {

        if (n == 0) {
            return 0;
        } else {
            return (n / ((2 * n) + 1)) + extraCredit18_5(n - 1);
        }
    }

    public static double extraCredit18_6(double n) {

        if (n == 0) {
            return 0;
        } else {
            return (n / (n + 1)) + extraCredit18_6(n - 1);
        }
    }

    public static int extraCredit18_10(String s, char c) {

        int n;
        if (c == s.charAt(0)) {
            n = 1;
        } else {
            n = 0;
        }
        if (s.length() == 1) {
            return n;
        } else {
            return n + extraCredit18_10(s.substring(1), c);
        }
    }

    public static long extraCredit18_11(long n) {

        if (n == 0) {
            return n;
        } else {
            return (n % 10) + extraCredit18_11(n / 10);
        }
    }

    public static int extraCredit18_13(int[] list, int start) {

//        if (start)
        return start;
    }
}
