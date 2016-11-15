public class FibonacciSequence {

  public static void main(String[] args) {

        /*
        *
        * f(0) = 1
        * f(1) = 1
        * f(2) = f(0) + f(1) = 2
        * f(3) = f(2) + f(1) = 2 + 1 = 3
        * ...
        * f(n) = f(n - 1) + f(n -2)
        *
        * */

    long x = fibonacci(20);
    System.out.println(x);

  }

  public static long fibonacci(int n) {

    // base case
    if (n == 0 || n == 1) {
      return 1;
    } else {
      // recursive call
      return fibonacci(n - 1) + fibonacci(n - 2);
    }
  }
}
