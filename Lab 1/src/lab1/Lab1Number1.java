package lab1;

public class Lab1Number1 {

    public static void main(String[] args) {

        System.out.println("1.0 First reverse display:");
        reverseDisplay1(5);
        System.out.println("1.1 Second reverse display:");
        reverseDisplay2(123450);

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

    public static void reverseDisplay(String value) {

        //implement body

    }
}
