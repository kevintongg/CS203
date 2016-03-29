public class Recursion2 {

    public static void main(String[] args) {


    }

    public static double sum(int n) {

        // base case
        if (n == 1) {
            return 1;
        } else {
            // recursive call
            return (1 / n) + sum(n - 1);
        }
    }
}
