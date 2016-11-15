public class Factorial {

  public static void main(String[] args) {

        /*
        *
        * Factorial
        * 0! = 1
        * 2! = 1 * 2
        * 3! = 1 * 2 * 3
        * n! = 1 * 2 * 3 * ... * n = n * (n + 1)
        *
        * (n - 1)! = (n - 1) * (n - 2)
        *
        * */

//        long x = fact(5);

    int n = 5;
    long sum = 1;

    for (int i = 0; i < n; i++) {
      sum = sum * i;
    }

  }


  public static long fact(int n) {

    // base case
    if (n == 0 || n == 1) {
      return 1;
    } else {
      // recursive call
      return n * fact(n - 1);
    }
  }
}
