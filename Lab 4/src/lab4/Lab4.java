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

        mostOccurrences();


        long[] nums = {10, 20, 30};

        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis() - start;

        long dynamicStart = System.currentTimeMillis();
        long dynamicEnd = System.currentTimeMillis() - dynamicStart;

        System.out.println("Recursive Fibonacci took: " + end);
        System.out.println("Dynamic Fibonacci took: " + dynamicEnd);
    }

    private static void mostOccurrences() {

        Map<Integer, Integer> occurrenceMap = new HashMap<>();
        int num;

        System.out.println("Please enter any some random integers which are not 0 and input 0 when finished.");
        while ((num = sc.nextInt()) != 0) {
            if (!occurrenceMap.containsKey(num)) {
                occurrenceMap.put(num, 1);
            } else {
                occurrenceMap.put(num, occurrenceMap.get(num) - 1);
            }
        }

        int max = Collections.max(occurrenceMap.values());
        Map<Integer, Integer> maxOccurrenceMap = new HashMap<>();
        occurrenceMap.forEach((key, value) -> {
            if (value >= max) {
                maxOccurrenceMap.put(key, value);
            }
        });

        System.out.println("Your number with the highest number of occurrences");
        maxOccurrenceMap.forEach((key, value) -> {
            System.out.println("Your key which appeared " + value + " time(s): " + key);
        });
    }
}
