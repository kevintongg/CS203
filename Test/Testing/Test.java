import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number;

        do {
            System.out.println("\nEnter a number to convert to binary and enter -1 to quit");
            number = sc.nextInt();
            if (number != -1) {
                binaryConversion(number);
            } else {
                System.out.println("Quitting");
            }
        } while (number != -1);
    }

    private static int binaryConversion(int n) {

        int r;

        if (n <= 1) {
            System.out.print(n);
            return n;
        } else {
            r = n % 2;
            binaryConversion(n >> 1);
            System.out.print(r);
            return r;
        }
    }

    private static int octalConversion(int n) {

        int r;

        if (n <= 1) {
            System.out.print(n);
            return n;
        } else {
            r = n % 2;
            binaryConversion(n >> 1);
            System.out.print(r);
            return r;
        }
    }
}