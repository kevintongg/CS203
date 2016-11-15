public class PrimeNumber {

  public static void main(String[] args) {

//        prime();
//        prime2();
    prime3();

  }

  private static void prime() {

    int num = 2;
    while (num <= 100) {
      boolean isPrime = true;
      for (int i = 2; i < 100; i++) {
        if (num % i == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime) {
        System.out.println(num);
      }
      num++;
    }
  }

  private static void prime2() {

    int num = 2;
    while (num <= 100) {
      boolean isPrime = true;
      for (int i = 2; i < (int) Math.sqrt(100); i++) {
        if (num % i == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime) {
        System.out.println(num);
      }
      num++;
    }
  }

  private static void prime3() {

    int num = 2;
    int sqrt = 1;
    while (num <= 100) {
      if (sqrt * sqrt < num) {
        boolean isPrime = true;
        for (int i = 2; i < sqrt; i++) {
          if (num % i == 0) {
            isPrime = false;
            break;
          }
        }

        if (isPrime) {
          System.out.println(num);
        }
        num++;
      }
    }
  }
}
