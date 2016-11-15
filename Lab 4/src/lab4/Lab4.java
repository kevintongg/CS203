package lab4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lab4 {

  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {

    /**
     *
     * 1)
     * Problem Definition: Write a program that reads an unspecified number of integers
     * and finds the one that has the most occurrences. The input ends when the input is 0.
     * For example, if you entered 2 3 4 3 42 3 4 3 3 0. the number 3 occurred most often.
     * If not one but several numbers have the most occurrences, all of them should be reported.
     *
     * */


    int choice;
    do {
      System.out.println("Enter 1 to find the most occurrences of integers entered.");
      System.out.println("Enter 2 to start the Fibonacci Number recursively and dynamically.");
      System.out.println("Enter 0 to quit.");
      while (!sc.hasNextInt()) {
        System.out.println("Invalid input!");
        System.out.println("Enter 1 to find the most occurrences of integers entered.");
        System.out.println("Enter 2 to start the Fibonacci Number recursively and dynamically.");
        System.out.println("Enter 0 to quit.");
      }
      choice = sc.nextInt();
      switch (choice) {
        case 1:
          mostOccurrences();
          break;
        case 2:
          long[] longs = {10, 20, 40};
          long start;
          long end;

          long dynamicStart;
          long dynamicEnd;

          for (int i = 0; i < longs.length; i++) {
            start = System.currentTimeMillis();
            recursiveFib(longs[i]);
            end = System.currentTimeMillis() - start;

            dynamicStart = System.currentTimeMillis();
            dynamicFib(longs[i]);
            dynamicEnd = System.currentTimeMillis() - dynamicStart;

            System.out.println("Recursive Fibonacci of " + longs[i] + " took: " + end + " milliseconds.");
            System.out.println();
            System.out.println("Dynamic Fibonacci of " + longs[i] + " took: " + dynamicEnd + " milliseconds.");
            System.out.println();
          }
          break;

      }
      if (choice < 0 || choice > 2) {
        System.out.println("Invalid input!");
        System.out.println("Enter 1 to find the most occurrences of integers entered.");
        System.out.println("Enter 2 to start the Fibonacci Number recursively and dynamically");
        System.out.println("Enter 0 to quit.");
      }
    } while (choice != 0);


  }

  private static void mostOccurrences() {

    Map<Integer, Integer> occurrenceMap = new HashMap<>();
    int num;

    System.out.println("Please enter any some random integers which are not 0 and input 0 when finished.");
    while ((num = sc.nextInt()) != 0) {
      if (!occurrenceMap.containsKey(num))
        occurrenceMap.put(num, 1);
      else
        occurrenceMap.put(num, occurrenceMap.get(num) + 1);
    }


    int max = Collections.max(occurrenceMap.values());
    Map<Integer, Integer> maxOccurrenceMap = new HashMap<>();
    occurrenceMap.forEach((key, value) -> {
      if (value >= max)
        maxOccurrenceMap.put(key, value);
    });

    System.out.println("Your number with the highest number of occurrences");
    maxOccurrenceMap.forEach((key, value) -> {
      System.out.println("Your key which appeared " + value + " time(s): " + key);
    });
  }

  private static long recursiveFib(long n) {

    if (n == 0 || n == 1) {
      return 1;
    } else {
      return recursiveFib(n - 1) + recursiveFib(n - 2);
    }
  }

  private static long dynamicFib(long n) {

    long f0 = 0;
    long f1 = 1;
    long f2 = 1;

    if (n == 0) {
      return f0;
    } else if (n == 1) {
      return f1;
    } else if (n == 2) {
      return f2;
    }

    for (int i = 3; i <= n; i++) {
      f0 = f1;
      f1 = f2;
      f2 = f0 + f1;
    }

    return f2;
  }
}
