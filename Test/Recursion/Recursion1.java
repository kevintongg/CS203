public class Recursion1 {

  public static void main(String[] args) {

    long x = sum(1);
    System.out.println(x);


  }

  public static long sum(int n) {

    // base case
    if (n == 1) {
      return 1;
    } else {
      // recursive call
      return n + sum(n - 1);
    }
  }
}
