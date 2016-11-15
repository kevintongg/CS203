package hw6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

  private static final int FIFTY_THOUSAND = 50000;
  private static final int ONE_HUNDRED_THOUSAND = 100000;
  private static final int ONE_HUNDRED_FIFTY_THOUSAND = 150000;
  private static final int TWO_HUNDRED_THOUSAND = 200000;
  private static final int TWO_HUNDRED_FIFTY_THOUSAND = 250000;
  private static final int THREE_HUNDRED_THOUSAND = 300000;
  private static final Random RANDOM = new Random();
  private static String selectionSortTime50, selectionSortTime100, selectionSortTime150, selectionSortTime200, selectionSortTime250, selectionSortTime300;
  private static String insertionSortTime50, insertionSortTime100, insertionSortTime150, insertionSortTime200, insertionSortTime250, insertionSortTime300;
  private static String bubbleSortTime50, bubbleSortTime100, bubbleSortTime150, bubbleSortTime200, bubbleSortTime250, bubbleSortTime300;
  private static String mergeSortTime50, mergeSortTime100, mergeSortTime150, mergeSortTime200, mergeSortTime250, mergeSortTime300;
  private static String quickSortTime50, quickSortTime100, quickSortTime150, quickSortTime200, quickSortTime250, quickSortTime300;
  private static String heapSortTime50, heapSortTime100, heapSortTime150, heapSortTime200, heapSortTime250, heapSortTime300;
  private static String[][] table = new String[7][7];

  public static void main(String[] args) {

    RANDOM.setSeed(System.currentTimeMillis());
    selectionSortArrayCreationAndExecution();
    insertionSortArrayCreationAndExecution();
    bubbleSortArrayCreationAndExecution();
    mergeSortArrayCreationAndExecution();
    quickSortArrayCreationAndExecution();
    heapSortArrayCreationAndExecution();
    table();
  }

  private static void table() {

    makeTable();
    setTable();
    printTable(table);
  }

  private static void makeTable() {

    for (int i = 0; i < table.length; i++) {
      for (int j = 0; j < table[i].length; j++) {
        table[i][j] = " ";
      }
    }
  }

  private static void printTable(String[][] table) {

    // Printing the table
    for (String[] i : table) {
      System.out.println(
          "\t=============================================================================================================================================================================");
      for (String j : i) {
        System.out.print("\t|" + "\t  " + j + "       ");
      }
      System.out.println();
    }
  }

  private static void setTable() {

    table[0][0] = "Array Size";
    table[0][1] = "Selection Sort";
    table[0][2] = "Insertion Sort";
    table[0][3] = "Bubble Sort";
    table[0][4] = "Merge Sort";
    table[0][5] = "Quick Sort";
    table[0][6] = "Heap Sort";
    table[1][0] = "50000     ";
    table[2][0] = "100000     ";
    table[3][0] = "150000     ";
    table[4][0] = "200000     ";
    table[5][0] = "250000     ";
    table[6][0] = "300000     ";

    table[1][1] = selectionSortTime50 + "        ";
    table[2][1] = selectionSortTime100 + "        ";
    table[3][1] = selectionSortTime150 + "        ";
    table[4][1] = selectionSortTime200 + "        ";
    table[5][1] = selectionSortTime250 + "        ";
    table[6][1] = selectionSortTime300 + "        ";

    table[1][2] = insertionSortTime50 + "        ";
    table[2][2] = insertionSortTime100 + "        ";
    table[3][2] = insertionSortTime150 + "        ";
    table[4][2] = insertionSortTime200 + "        ";
    table[5][2] = insertionSortTime250 + "        ";
    table[6][2] = insertionSortTime300 + "        ";

    table[1][3] = bubbleSortTime50 + "       ";
    table[2][3] = bubbleSortTime100 + "       ";
    table[3][3] = bubbleSortTime150 + "       ";
    table[4][3] = bubbleSortTime200 + "       ";
    table[5][3] = bubbleSortTime250 + "       ";
    table[6][3] = bubbleSortTime300 + "       ";

    table[1][4] = mergeSortTime50 + "       ";
    table[2][4] = mergeSortTime100 + "       ";
    table[3][4] = mergeSortTime150 + "       ";
    table[4][4] = mergeSortTime200 + "    ";
    table[5][4] = mergeSortTime250 + "    ";
    table[6][4] = mergeSortTime300 + "    ";

    table[1][5] = quickSortTime50 + "       ";
    table[2][5] = quickSortTime100 + "       ";
    table[3][5] = quickSortTime150 + "       ";
    table[4][5] = quickSortTime200 + "       ";
    table[5][5] = quickSortTime250 + "       ";
    table[6][5] = quickSortTime300 + "       ";

    table[1][6] = heapSortTime50;
    table[2][6] = heapSortTime100;
    table[3][6] = heapSortTime150;
    table[4][6] = heapSortTime200;
    table[5][6] = heapSortTime250;
    table[6][6] = heapSortTime300;
  }

  private static <E extends Comparable<E>> void selectionSort(E[] list) {

    for (int i = 0; i < list.length - 1; i++) {
      int smallest = i;
      for (int j = i + 1; j < list.length; j++) {
        if (list[j].compareTo(list[smallest]) < 0) {
          smallest = j;
        }
      }
      E temp = list[smallest];
      list[smallest] = list[i];
      list[i] = temp;
    }
  }

  private static <E extends Comparable<E>> void insertionSort(E[] list) {

    for (int i = 1; i < list.length; i++) {
            /*
             *
             * Insert list[i] into a sorted sublist list[0..i-1] so
             * that list[0..i] is sorted.
             *
             */
      E currentItem = list[i];
      int j;
      for (j = i - 1; j >= 0 && currentItem.compareTo(list[j]) < 1; j--) {
        list[j + 1] = list[j];
      }
      // Insert the current element into list[k + 1]
      list[j + 1] = currentItem;
    }
  }

  private static <E extends Comparable<E>> void bubbleSort(E[] list) {

    boolean needNextPass = true;

    for (int i = 1; i < list.length && needNextPass; i++) {
      // Array may be sorted already and next pass is not needed
      needNextPass = false;
      // Perform the next pass if needed
      for (int j = 0; j < list.length - i; j++) {
        if (list[j + 1].compareTo(list[j]) < 1) {
          // Swap list[j] with list[j + 1]
          E temp = list[j];
          list[j] = list[j + 1];
          list[j + 1] = temp;

          // Next pass still needed
          needNextPass = true;
        }
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static <E extends Comparable<E>> void mergeSort(E[] list) {

    if (list.length > 1) {
      // Merge first half
      E[] firstHalf = (E[]) new Comparable[list.length / 2];
      System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
      mergeSort(firstHalf);

      // Merge second half
      int secondHalfLength = list.length - list.length / 2;
      E[] secondHalf = (E[]) new Comparable[secondHalfLength];
      System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
      mergeSort(secondHalf);

      // Merge first and second halves into the list
      merge(firstHalf, secondHalf, list);
    }
  }

  private static <E extends Comparable<E>> void merge(E[] list1, E[] list2, E[] temp) {

    int current1 = 0; // Current list1 index
    int current2 = 0; // Current list2 index
    int current3 = 0; // Current temp index

    while (current1 < list1.length && current2 < list2.length) {
      if (list1[current1].compareTo(list2[current2]) < 1) {
        temp[current3++] = list1[current1++];
      } else {
        temp[current3++] = list2[current2++];
      }
    }

    while (current1 < list1.length) {
      temp[current3++] = list1[current1++];
    }

    while (current2 < list2.length) {
      temp[current3++] = list2[current2++];
    }
  }

  private static <E extends Comparable<E>> void quickSort(E[] list) { // sort method
    quickSort(list, 0, list.length - 1);
  }

  private static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) { // helper method

    if (last > first) {
      int pivotIndex = partition(list, first, last);
      quickSort(list, first, pivotIndex - 1); // recursive call
      quickSort(list, pivotIndex + 1, last);
    }
  }

  private static <E extends Comparable<E>> int partition(E[] list, int first, int last) {

    E pivot = list[first]; // Choose first element as pivot
    int low = first + 1; // Index for forward search
    int high = last; // Index for backward search

    while (high > low) {
      // Search forward from left
      while (low <= high && list[low].compareTo(pivot) <= 0) {
        low++;
      }
      // Search backward from right
      while (low <= high && list[high].compareTo(pivot) > 0) {
        high--;
      }
      // Swap two elements in the list
      if (high > low) {
        E temp = list[high];
        list[high] = list[low];
        list[low] = temp;
      }
    }

    while (high > first && list[high].compareTo(pivot) >= 0) {
      high--;
    }

    // Swap pivot with list[high]
    if (pivot.compareTo(list[high]) > 0) {
      list[first] = list[high];
      list[high] = pivot;
      return high;
    } else {
      return first;
    }
  }

  private static <E extends Comparable<E>> void heapSort(E[] list) {

    // Create a heap of whatever data type
    Heap<E> heap = new Heap<>();

    // Add elements to the heap
    for (E i : list) {
      heap.add(i);
    }

    // Remove items from the index
    for (int i = list.length - 1; i >= 0; i--) {
      list[i] = heap.remove();
    }
  }

  private static void selectionSortArrayCreationAndExecution() {

    Integer[] fiftyThousand = new Integer[FIFTY_THOUSAND];
    Integer[] oneHundredThousand = new Integer[ONE_HUNDRED_THOUSAND];
    Integer[] oneHundredFiftyThousand = new Integer[ONE_HUNDRED_FIFTY_THOUSAND];
    Integer[] twoHundredThousand = new Integer[TWO_HUNDRED_THOUSAND];
    Integer[] twoHundredFiftyThousand = new Integer[TWO_HUNDRED_FIFTY_THOUSAND];
    Integer[] threeHundredThousand = new Integer[THREE_HUNDRED_THOUSAND];

    for (int i = 0; i < FIFTY_THOUSAND; i++) {
      fiftyThousand[i] = RANDOM.nextInt(FIFTY_THOUSAND);
    }
    for (int i = 0; i < ONE_HUNDRED_THOUSAND; i++) {
      oneHundredThousand[i] = RANDOM.nextInt(ONE_HUNDRED_THOUSAND);
    }
    for (int i = 0; i < ONE_HUNDRED_FIFTY_THOUSAND; i++) {
      oneHundredFiftyThousand[i] = RANDOM.nextInt(ONE_HUNDRED_FIFTY_THOUSAND);
    }
    for (int i = 0; i < TWO_HUNDRED_THOUSAND; i++) {
      twoHundredThousand[i] = RANDOM.nextInt(TWO_HUNDRED_THOUSAND);
    }
    for (int i = 0; i < TWO_HUNDRED_FIFTY_THOUSAND; i++) {
      twoHundredFiftyThousand[i] = RANDOM.nextInt(TWO_HUNDRED_FIFTY_THOUSAND);
    }
    for (int i = 0; i < THREE_HUNDRED_THOUSAND; i++) {
      threeHundredThousand[i] = RANDOM.nextInt(THREE_HUNDRED_THOUSAND);
    }

    long fiftyThousandStart = System.currentTimeMillis();
    selectionSort(fiftyThousand);
    long fiftyThousandEnd = System.currentTimeMillis();
    long fiftyThousandExecutionTime = fiftyThousandEnd - fiftyThousandStart;
    System.out.println("Selection sort of size 50,000: " + fiftyThousandExecutionTime + "ms");
    selectionSortTime50 = Long.toString(fiftyThousandExecutionTime) + "ms";

    long oneHundredThousandStart = System.currentTimeMillis();
    selectionSort(oneHundredThousand);
    long oneHundredThousandEnd = System.currentTimeMillis();
    long oneHundredThousandExecutionTime = oneHundredThousandEnd - oneHundredThousandStart;
    System.out.println("Selection sort of size 100,000: " + oneHundredThousandExecutionTime + "ms");
    selectionSortTime100 = Long.toString(oneHundredThousandExecutionTime) + "ms";

    long oneHundredFiftyThousandStart = System.currentTimeMillis();
    selectionSort(oneHundredFiftyThousand);
    long oneHundredFiftyThousandEnd = System.currentTimeMillis();
    long oneHundredFiftyThousandExecutionTime = oneHundredFiftyThousandEnd - oneHundredFiftyThousandStart;
    System.out.println("Selection sort of size 150,000: " + oneHundredFiftyThousandExecutionTime + "ms");
    selectionSortTime150 = Long.toString(oneHundredFiftyThousandExecutionTime) + "ms";

    long twoHundredThousandStart = System.currentTimeMillis();
    selectionSort(twoHundredThousand);
    long twoHundredThousandEnd = System.currentTimeMillis();
    long twoHundredThousandExecutionTime = twoHundredThousandEnd - twoHundredThousandStart;
    System.out.println("Selection sort of size 200,000: " + twoHundredThousandExecutionTime + "ms");
    selectionSortTime200 = Long.toString(twoHundredThousandExecutionTime) + "ms";

    long twoHundredFiftyThousandStart = System.currentTimeMillis();
    selectionSort(twoHundredFiftyThousand);
    long twoHundredFiftyThousandEnd = System.currentTimeMillis();
    long twoHundredFiftyThousandExecutionTime = twoHundredFiftyThousandEnd - twoHundredFiftyThousandStart;
    System.out.println("Selection sort of size 250,000: " + twoHundredFiftyThousandExecutionTime + "ms");
    selectionSortTime250 = Long.toString(twoHundredFiftyThousandExecutionTime) + "ms";

    long threeHundredThousandStart = System.currentTimeMillis();
    selectionSort(threeHundredThousand);
    long threeHundredThousandEnd = System.currentTimeMillis();
    long threeHundredThousandExecutionTime = threeHundredThousandEnd - threeHundredThousandStart;
    System.out.println("Selection sort of size 300,000: " + threeHundredThousandExecutionTime + "ms");
    selectionSortTime300 = Long.toString(threeHundredThousandExecutionTime) + "ms";
  }

  private static void insertionSortArrayCreationAndExecution() {

    Integer[] fiftyThousand = new Integer[FIFTY_THOUSAND];
    Integer[] oneHundredThousand = new Integer[ONE_HUNDRED_THOUSAND];
    Integer[] oneHundredFiftyThousand = new Integer[ONE_HUNDRED_FIFTY_THOUSAND];
    Integer[] twoHundredThousand = new Integer[TWO_HUNDRED_THOUSAND];
    Integer[] twoHundredFiftyThousand = new Integer[TWO_HUNDRED_FIFTY_THOUSAND];
    Integer[] threeHundredThousand = new Integer[THREE_HUNDRED_THOUSAND];

    for (int i = 0; i < FIFTY_THOUSAND; i++) {
      fiftyThousand[i] = RANDOM.nextInt(FIFTY_THOUSAND);
    }
    for (int i = 0; i < ONE_HUNDRED_THOUSAND; i++) {
      oneHundredThousand[i] = RANDOM.nextInt(ONE_HUNDRED_THOUSAND);
    }
    for (int i = 0; i < ONE_HUNDRED_FIFTY_THOUSAND; i++) {
      oneHundredFiftyThousand[i] = RANDOM.nextInt(ONE_HUNDRED_FIFTY_THOUSAND);
    }
    for (int i = 0; i < TWO_HUNDRED_THOUSAND; i++) {
      twoHundredThousand[i] = RANDOM.nextInt(TWO_HUNDRED_THOUSAND);
    }
    for (int i = 0; i < TWO_HUNDRED_FIFTY_THOUSAND; i++) {
      twoHundredFiftyThousand[i] = RANDOM.nextInt(TWO_HUNDRED_FIFTY_THOUSAND);
    }
    for (int i = 0; i < THREE_HUNDRED_THOUSAND; i++) {
      threeHundredThousand[i] = RANDOM.nextInt(THREE_HUNDRED_THOUSAND);
    }

    long fiftyThousandStart = System.currentTimeMillis();
    insertionSort(fiftyThousand);
    long fiftyThousandEnd = System.currentTimeMillis();
    long fiftyThousandExecutionTime = fiftyThousandEnd - fiftyThousandStart;
    System.out.println("Insertion sort of size 50,000: " + fiftyThousandExecutionTime + "ms");
    insertionSortTime50 = Long.toString(fiftyThousandExecutionTime) + "ms";

    long oneHundredThousandStart = System.currentTimeMillis();
    insertionSort(oneHundredThousand);
    long oneHundredThousandEnd = System.currentTimeMillis();
    long oneHundredThousandExecutionTime = oneHundredThousandEnd - oneHundredThousandStart;
    System.out.println("Insertion sort of size 100,000: " + oneHundredThousandExecutionTime + "ms");
    insertionSortTime100 = Long.toString(oneHundredThousandExecutionTime) + "ms";

    long oneHundredFiftyThousandStart = System.currentTimeMillis();
    insertionSort(oneHundredFiftyThousand);
    long oneHundredFiftyThousandEnd = System.currentTimeMillis();
    long oneHundredFiftyThousandExecutionTime = oneHundredFiftyThousandEnd - oneHundredFiftyThousandStart;
    System.out.println("Insertion sort of size 150,000: " + oneHundredFiftyThousandExecutionTime + "ms");
    insertionSortTime150 = Long.toString(oneHundredFiftyThousandExecutionTime) + "ms";

    long twoHundredThousandStart = System.currentTimeMillis();
    insertionSort(twoHundredThousand);
    long twoHundredThousandEnd = System.currentTimeMillis();
    long twoHundredThousandExecutionTime = twoHundredThousandEnd - twoHundredThousandStart;
    System.out.println("Insertion sort of size 200,000: " + twoHundredThousandExecutionTime + "ms");
    insertionSortTime200 = Long.toString(twoHundredThousandExecutionTime) + "ms";

    long twoHundredFiftyThousandStart = System.currentTimeMillis();
    insertionSort(twoHundredFiftyThousand);
    long twoHundredFiftyThousandEnd = System.currentTimeMillis();
    long twoHundredFiftyThousandExecutionTime = twoHundredFiftyThousandEnd - twoHundredFiftyThousandStart;
    System.out.println("Insertion sort of size 250,000: " + twoHundredFiftyThousandExecutionTime + "ms");
    insertionSortTime250 = Long.toString(twoHundredFiftyThousandExecutionTime) + "ms";

    long threeHundredThousandStart = System.currentTimeMillis();
    insertionSort(threeHundredThousand);
    long threeHundredThousandEnd = System.currentTimeMillis();
    long threeHundredThousandExecutionTime = threeHundredThousandEnd - threeHundredThousandStart;
    System.out.println("Insertion sort of size 300,000: " + threeHundredThousandExecutionTime + "ms");
    insertionSortTime300 = Long.toString(threeHundredThousandExecutionTime) + "ms";
  }

  private static void bubbleSortArrayCreationAndExecution() {

    Integer[] fiftyThousand = new Integer[FIFTY_THOUSAND];
    Integer[] oneHundredThousand = new Integer[ONE_HUNDRED_THOUSAND];
    Integer[] oneHundredFiftyThousand = new Integer[ONE_HUNDRED_FIFTY_THOUSAND];
    Integer[] twoHundredThousand = new Integer[TWO_HUNDRED_THOUSAND];
    Integer[] twoHundredFiftyThousand = new Integer[TWO_HUNDRED_FIFTY_THOUSAND];
    Integer[] threeHundredThousand = new Integer[THREE_HUNDRED_THOUSAND];

    for (int i = 0; i < FIFTY_THOUSAND; i++) {
      fiftyThousand[i] = RANDOM.nextInt(FIFTY_THOUSAND);
    }
    for (int i = 0; i < ONE_HUNDRED_THOUSAND; i++) {
      oneHundredThousand[i] = RANDOM.nextInt(ONE_HUNDRED_THOUSAND);
    }
    for (int i = 0; i < ONE_HUNDRED_FIFTY_THOUSAND; i++) {
      oneHundredFiftyThousand[i] = RANDOM.nextInt(ONE_HUNDRED_FIFTY_THOUSAND);
    }
    for (int i = 0; i < TWO_HUNDRED_THOUSAND; i++) {
      twoHundredThousand[i] = RANDOM.nextInt(TWO_HUNDRED_THOUSAND);
    }
    for (int i = 0; i < TWO_HUNDRED_FIFTY_THOUSAND; i++) {
      twoHundredFiftyThousand[i] = RANDOM.nextInt(TWO_HUNDRED_FIFTY_THOUSAND);
    }
    for (int i = 0; i < THREE_HUNDRED_THOUSAND; i++) {
      threeHundredThousand[i] = RANDOM.nextInt(THREE_HUNDRED_THOUSAND);
    }

    long fiftyThousandStart = System.currentTimeMillis();
    bubbleSort(fiftyThousand);
    long fiftyThousandEnd = System.currentTimeMillis();
    long fiftyThousandExecutionTime = fiftyThousandEnd - fiftyThousandStart;
    System.out.println("Bubble sort of size 50,000: " + fiftyThousandExecutionTime + "ms");
    bubbleSortTime50 = Long.toString(fiftyThousandExecutionTime) + "ms";

    long oneHundredThousandStart = System.currentTimeMillis();
    bubbleSort(oneHundredThousand);
    long oneHundredThousandEnd = System.currentTimeMillis();
    long oneHundredThousandExecutionTime = oneHundredThousandEnd - oneHundredThousandStart;
    System.out.println("Bubble sort of size 100,000: " + oneHundredThousandExecutionTime + "ms");
    bubbleSortTime100 = Long.toString(oneHundredThousandExecutionTime) + "ms";

    long oneHundredFiftyThousandStart = System.currentTimeMillis();
    bubbleSort(oneHundredFiftyThousand);
    long oneHundredFiftyThousandEnd = System.currentTimeMillis();
    long oneHundredFiftyThousandExecutionTime = oneHundredFiftyThousandEnd - oneHundredFiftyThousandStart;
    System.out.println("Bubble sort of size 150,000: " + oneHundredFiftyThousandExecutionTime + "ms");
    bubbleSortTime150 = Long.toString(oneHundredFiftyThousandExecutionTime) + "ms";

    long twoHundredThousandStart = System.currentTimeMillis();
    bubbleSort(twoHundredThousand);
    long twoHundredThousandEnd = System.currentTimeMillis();
    long twoHundredThousandExecutionTime = twoHundredThousandEnd - twoHundredThousandStart;
    System.out.println("Bubble sort of size 200,000: " + twoHundredThousandExecutionTime + "ms");
    bubbleSortTime200 = Long.toString(twoHundredThousandExecutionTime) + "ms";

    long twoHundredFiftyThousandStart = System.currentTimeMillis();
    bubbleSort(twoHundredFiftyThousand);
    long twoHundredFiftyThousandEnd = System.currentTimeMillis();
    long twoHundredFiftyThousandExecutionTime = twoHundredFiftyThousandEnd - twoHundredFiftyThousandStart;
    System.out.println("Bubble sort of size 250,000: " + twoHundredFiftyThousandExecutionTime + "ms");
    bubbleSortTime250 = Long.toString(twoHundredFiftyThousandExecutionTime) + "ms";

    long threeHundredThousandStart = System.currentTimeMillis();
    bubbleSort(threeHundredThousand);
    long threeHundredThousandEnd = System.currentTimeMillis();
    long threeHundredThousandExecutionTime = threeHundredThousandEnd - threeHundredThousandStart;
    System.out.println("Bubble sort of size 300,000: " + threeHundredThousandExecutionTime + "ms");
    bubbleSortTime300 = Long.toString(threeHundredThousandExecutionTime) + "ms";
  }

  private static void mergeSortArrayCreationAndExecution() {

    Integer[] fiftyThousand = new Integer[FIFTY_THOUSAND];
    Integer[] oneHundredThousand = new Integer[ONE_HUNDRED_THOUSAND];
    Integer[] oneHundredFiftyThousand = new Integer[ONE_HUNDRED_FIFTY_THOUSAND];
    Integer[] twoHundredThousand = new Integer[TWO_HUNDRED_THOUSAND];
    Integer[] twoHundredFiftyThousand = new Integer[TWO_HUNDRED_FIFTY_THOUSAND];
    Integer[] threeHundredThousand = new Integer[THREE_HUNDRED_THOUSAND];

    for (int i = 0; i < FIFTY_THOUSAND; i++) {
      fiftyThousand[i] = RANDOM.nextInt(FIFTY_THOUSAND);
    }
    for (int i = 0; i < ONE_HUNDRED_THOUSAND; i++) {
      oneHundredThousand[i] = RANDOM.nextInt(ONE_HUNDRED_THOUSAND);
    }
    for (int i = 0; i < ONE_HUNDRED_FIFTY_THOUSAND; i++) {
      oneHundredFiftyThousand[i] = RANDOM.nextInt(ONE_HUNDRED_FIFTY_THOUSAND);
    }
    for (int i = 0; i < TWO_HUNDRED_THOUSAND; i++) {
      twoHundredThousand[i] = RANDOM.nextInt(TWO_HUNDRED_THOUSAND);
    }
    for (int i = 0; i < TWO_HUNDRED_FIFTY_THOUSAND; i++) {
      twoHundredFiftyThousand[i] = RANDOM.nextInt(TWO_HUNDRED_FIFTY_THOUSAND);
    }
    for (int i = 0; i < THREE_HUNDRED_THOUSAND; i++) {
      threeHundredThousand[i] = RANDOM.nextInt(THREE_HUNDRED_THOUSAND);
    }

    long fiftyThousandStart = System.currentTimeMillis();
    mergeSort(fiftyThousand);
    long fiftyThousandEnd = System.currentTimeMillis();
    long fiftyThousandExecutionTime = fiftyThousandEnd - fiftyThousandStart;
    System.out.println("Merge sort of size 50,000: " + fiftyThousandExecutionTime + "ms");
    mergeSortTime50 = Long.toString(fiftyThousandExecutionTime) + "ms";

    long oneHundredThousandStart = System.currentTimeMillis();
    mergeSort(oneHundredThousand);
    long oneHundredThousandEnd = System.currentTimeMillis();
    long oneHundredThousandExecutionTime = oneHundredThousandEnd - oneHundredThousandStart;
    System.out.println("Merge sort of size 100,000: " + oneHundredThousandExecutionTime + "ms");
    mergeSortTime100 = Long.toString(oneHundredThousandExecutionTime) + "ms";

    long oneHundredFiftyThousandStart = System.currentTimeMillis();
    mergeSort(oneHundredFiftyThousand);
    long oneHundredFiftyThousandEnd = System.currentTimeMillis();
    long oneHundredFiftyThousandExecutionTime = oneHundredFiftyThousandEnd - oneHundredFiftyThousandStart;
    System.out.println("Merge sort of size 150,000: " + oneHundredFiftyThousandExecutionTime + "ms");
    mergeSortTime150 = Long.toString(oneHundredFiftyThousandExecutionTime) + "ms";

    long twoHundredThousandStart = System.currentTimeMillis();
    mergeSort(twoHundredThousand);
    long twoHundredThousandEnd = System.currentTimeMillis();
    long twoHundredThousandExecutionTime = twoHundredThousandEnd - twoHundredThousandStart;
    System.out.println("Merge sort of size 200,000: " + twoHundredThousandExecutionTime + "ms");
    mergeSortTime200 = Long.toString(twoHundredThousandExecutionTime) + "ms";

    long twoHundredFiftyThousandStart = System.currentTimeMillis();
    mergeSort(twoHundredFiftyThousand);
    long twoHundredFiftyThousandEnd = System.currentTimeMillis();
    long twoHundredFiftyThousandExecutionTime = twoHundredFiftyThousandEnd - twoHundredFiftyThousandStart;
    System.out.println("Merge sort of size 250,000: " + twoHundredFiftyThousandExecutionTime + "ms");
    mergeSortTime250 = Long.toString(twoHundredFiftyThousandExecutionTime) + "ms";

    long threeHundredThousandStart = System.currentTimeMillis();
    mergeSort(threeHundredThousand);
    long threeHundredThousandEnd = System.currentTimeMillis();
    long threeHundredThousandExecutionTime = threeHundredThousandEnd - threeHundredThousandStart;
    System.out.println("Merge sort of size 300,000: " + threeHundredThousandExecutionTime + "ms");
    mergeSortTime300 = Long.toString(threeHundredThousandExecutionTime) + "ms";
  }

  private static void quickSortArrayCreationAndExecution() {

    Integer[] fiftyThousand = new Integer[FIFTY_THOUSAND];
    Integer[] oneHundredThousand = new Integer[ONE_HUNDRED_THOUSAND];
    Integer[] oneHundredFiftyThousand = new Integer[ONE_HUNDRED_FIFTY_THOUSAND];
    Integer[] twoHundredThousand = new Integer[TWO_HUNDRED_THOUSAND];
    Integer[] twoHundredFiftyThousand = new Integer[TWO_HUNDRED_FIFTY_THOUSAND];
    Integer[] threeHundredThousand = new Integer[THREE_HUNDRED_THOUSAND];

    for (int i = 0; i < FIFTY_THOUSAND; i++) {
      fiftyThousand[i] = RANDOM.nextInt(FIFTY_THOUSAND);
    }
    for (int i = 0; i < ONE_HUNDRED_THOUSAND; i++) {
      oneHundredThousand[i] = RANDOM.nextInt(ONE_HUNDRED_THOUSAND);
    }
    for (int i = 0; i < ONE_HUNDRED_FIFTY_THOUSAND; i++) {
      oneHundredFiftyThousand[i] = RANDOM.nextInt(ONE_HUNDRED_FIFTY_THOUSAND);
    }
    for (int i = 0; i < TWO_HUNDRED_THOUSAND; i++) {
      twoHundredThousand[i] = RANDOM.nextInt(TWO_HUNDRED_THOUSAND);
    }
    for (int i = 0; i < TWO_HUNDRED_FIFTY_THOUSAND; i++) {
      twoHundredFiftyThousand[i] = RANDOM.nextInt(TWO_HUNDRED_FIFTY_THOUSAND);
    }
    for (int i = 0; i < THREE_HUNDRED_THOUSAND; i++) {
      threeHundredThousand[i] = RANDOM.nextInt(THREE_HUNDRED_THOUSAND);
    }

    long fiftyThousandStart = System.currentTimeMillis();
    quickSort(fiftyThousand);
    long fiftyThousandEnd = System.currentTimeMillis();
    long fiftyThousandExecutionTime = fiftyThousandEnd - fiftyThousandStart;
    System.out.println("Quick sort of size 50,000: " + fiftyThousandExecutionTime + "ms");
    quickSortTime50 = Long.toString(fiftyThousandExecutionTime) + "ms";

    long oneHundredThousandStart = System.currentTimeMillis();
    quickSort(oneHundredThousand);
    long oneHundredThousandEnd = System.currentTimeMillis();
    long oneHundredThousandExecutionTime = oneHundredThousandEnd - oneHundredThousandStart;
    System.out.println("Quick sort of size 100,000: " + oneHundredThousandExecutionTime + "ms");
    quickSortTime100 = Long.toString(oneHundredThousandExecutionTime) + "ms";

    long oneHundredFiftyThousandStart = System.currentTimeMillis();
    quickSort(oneHundredFiftyThousand);
    long oneHundredFiftyThousandEnd = System.currentTimeMillis();
    long oneHundredFiftyThousandExecutionTime = oneHundredFiftyThousandEnd - oneHundredFiftyThousandStart;
    System.out.println("Quick sort of size 150,000: " + oneHundredFiftyThousandExecutionTime + "ms");
    quickSortTime150 = Long.toString(fiftyThousandExecutionTime) + "ms";

    long twoHundredThousandStart = System.currentTimeMillis();
    quickSort(twoHundredThousand);
    long twoHundredThousandEnd = System.currentTimeMillis();
    long twoHundredThousandExecutionTime = twoHundredThousandEnd - twoHundredThousandStart;
    System.out.println("Quick sort of size 200,000: " + twoHundredThousandExecutionTime + "ms");
    quickSortTime200 = Long.toString(twoHundredThousandExecutionTime) + "ms";

    long twoHundredFiftyThousandStart = System.currentTimeMillis();
    quickSort(twoHundredFiftyThousand);
    long twoHundredFiftyThousandEnd = System.currentTimeMillis();
    long twoHundredFiftyThousandExecutionTime = twoHundredFiftyThousandEnd - twoHundredFiftyThousandStart;
    System.out.println("Quick sort of size 250,000: " + twoHundredFiftyThousandExecutionTime + "ms");
    quickSortTime250 = Long.toString(twoHundredFiftyThousandExecutionTime) + "ms";

    long threeHundredThousandStart = System.currentTimeMillis();
    quickSort(threeHundredThousand);
    long threeHundredThousandEnd = System.currentTimeMillis();
    long threeHundredThousandExecutionTime = threeHundredThousandEnd - threeHundredThousandStart;
    System.out.println("Quick sort of size 300,000: " + threeHundredThousandExecutionTime + "ms");
    quickSortTime300 = Long.toString(threeHundredThousandExecutionTime) + "ms";
  }

  private static void heapSortArrayCreationAndExecution() {

    Integer[] fiftyThousand = new Integer[FIFTY_THOUSAND];
    Integer[] oneHundredThousand = new Integer[ONE_HUNDRED_THOUSAND];
    Integer[] oneHundredFiftyThousand = new Integer[ONE_HUNDRED_FIFTY_THOUSAND];
    Integer[] twoHundredThousand = new Integer[TWO_HUNDRED_THOUSAND];
    Integer[] twoHundredFiftyThousand = new Integer[TWO_HUNDRED_FIFTY_THOUSAND];
    Integer[] threeHundredThousand = new Integer[THREE_HUNDRED_THOUSAND];

    for (int i = 0; i < FIFTY_THOUSAND; i++) {
      fiftyThousand[i] = RANDOM.nextInt(FIFTY_THOUSAND);
    }
    for (int i = 0; i < ONE_HUNDRED_THOUSAND; i++) {
      oneHundredThousand[i] = RANDOM.nextInt(ONE_HUNDRED_THOUSAND);
    }
    for (int i = 0; i < ONE_HUNDRED_FIFTY_THOUSAND; i++) {
      oneHundredFiftyThousand[i] = RANDOM.nextInt(ONE_HUNDRED_FIFTY_THOUSAND);
    }
    for (int i = 0; i < TWO_HUNDRED_THOUSAND; i++) {
      twoHundredThousand[i] = RANDOM.nextInt(TWO_HUNDRED_THOUSAND);
    }
    for (int i = 0; i < TWO_HUNDRED_FIFTY_THOUSAND; i++) {
      twoHundredFiftyThousand[i] = RANDOM.nextInt(TWO_HUNDRED_FIFTY_THOUSAND);
    }
    for (int i = 0; i < THREE_HUNDRED_THOUSAND; i++) {
      threeHundredThousand[i] = RANDOM.nextInt(THREE_HUNDRED_THOUSAND);
    }

    long fiftyThousandStart = System.currentTimeMillis();
    heapSort(fiftyThousand);
    long fiftyThousandEnd = System.currentTimeMillis();
    long fiftyThousandExecutionTime = fiftyThousandEnd - fiftyThousandStart;
    System.out.println("Heap sort of size 50,000: " + fiftyThousandExecutionTime + "ms");
    heapSortTime50 = Long.toString(fiftyThousandExecutionTime) + "ms";

    long oneHundredThousandStart = System.currentTimeMillis();
    heapSort(oneHundredThousand);
    long oneHundredThousandEnd = System.currentTimeMillis();
    long oneHundredThousandExecutionTime = oneHundredThousandEnd - oneHundredThousandStart;
    System.out.println("Heap sort of size 100,000: " + oneHundredThousandExecutionTime + "ms");
    heapSortTime100 = Long.toString(oneHundredThousandExecutionTime) + "ms";

    long oneHundredFiftyThousandStart = System.currentTimeMillis();
    heapSort(oneHundredFiftyThousand);
    long oneHundredFiftyThousandEnd = System.currentTimeMillis();
    long oneHundredFiftyThousandExecutionTime = oneHundredFiftyThousandEnd - oneHundredFiftyThousandStart;
    System.out.println("Heap sort of size 150,000: " + oneHundredFiftyThousandExecutionTime + "ms");
    heapSortTime150 = Long.toString(oneHundredFiftyThousandExecutionTime) + "ms";

    long twoHundredThousandStart = System.currentTimeMillis();
    heapSort(twoHundredThousand);
    long twoHundredThousandEnd = System.currentTimeMillis();
    long twoHundredThousandExecutionTime = twoHundredThousandEnd - twoHundredThousandStart;
    System.out.println("Heap sort of size 200,000: " + twoHundredThousandExecutionTime + "ms");
    heapSortTime200 = Long.toString(twoHundredThousandExecutionTime) + "ms";

    long twoHundredFiftyThousandStart = System.currentTimeMillis();
    heapSort(twoHundredFiftyThousand);
    long twoHundredFiftyThousandEnd = System.currentTimeMillis();
    long twoHundredFiftyThousandExecutionTime = twoHundredFiftyThousandEnd - twoHundredFiftyThousandStart;
    System.out.println("Heap sort of size 250,000: " + twoHundredFiftyThousandExecutionTime + "ms");
    heapSortTime250 = Long.toString(twoHundredFiftyThousandExecutionTime) + "ms";

    long threeHundredThousandStart = System.currentTimeMillis();
    heapSort(threeHundredThousand);
    long threeHundredThousandEnd = System.currentTimeMillis();
    long threeHundredThousandExecutionTime = threeHundredThousandEnd - threeHundredThousandStart;
    System.out.println("Heap sort of size 300,000: " + threeHundredThousandExecutionTime + "ms");
    heapSortTime300 = Long.toString(threeHundredThousandExecutionTime) + "ms";
  }

  private static class Heap<E extends Comparable<E>> {

    private List<E> list = new ArrayList<>();


    /**
     * Create a default heap
     */
    public Heap() {

    }

    /**
     * Create a heap from an array of objects
     */
    public Heap(E[] objects) {

      for (E o : objects) {
        add(o);
      }
    }

    /**
     * Add a new object into the heap
     */
    public void add(E newObject) {

      // Append to the heap
      list.add(newObject);
      // The index of last node
      int currentIndex = list.size() - 1;

      while (currentIndex > 0) {
        int parentIndex = (currentIndex - 1) / 2;
        // Swap if current object is greater than its parent
        if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
          E temp = list.get(currentIndex);
          list.set(currentIndex, list.get(parentIndex));
          list.set(parentIndex, temp);
        } else {
          break;
        }

        currentIndex = parentIndex;
      }
    }

    /**
     * Remove the root from the heap
     */
    public E remove() {

      if (list.size() == 0) {
        return null;
      }

      E removedObject = list.get(0);
      list.set(0, list.get(list.size() - 1));
      list.remove(list.size() - 1);

      int currentIndex = 0;
      while (currentIndex < list.size()) {
        int leftChildIndex = 2 * currentIndex + 1;
        int rightChildIndex = 2 * currentIndex + 2;

        // Find the max between two children
        if (leftChildIndex >= list.size()) {
          // The tree is a heap
          break;
        }
        int maxIndex = leftChildIndex;
        if (rightChildIndex < list.size()) {
          // Compare two children
          if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
            maxIndex = rightChildIndex;
          }
        }

        if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
          E temp = list.get(maxIndex);
          // Swap with larger child
          list.set(maxIndex, list.get(currentIndex));
          list.set(currentIndex, temp);
          currentIndex = maxIndex;
        } else {
          // The tree is a heap
          break;
        }
      }

      return removedObject;
    }

    /**
     * Get the number of nodes in the tree
     */
    public int getSize() {

      return list.size();

    }
  }
}