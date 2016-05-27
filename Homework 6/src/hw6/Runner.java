package hw6;

import java.util.Random;

public class Runner {

    private static final int FIFTY_THOUSAND = 50000;
    private static final int ONE_HUNDRED_THOUSAND = 100000;
    private static final int ONE_HUNDRED_FIFTY_THOUSAND = 150000;
    private static final int TWO_HUNDRED_THOUSAND = 200000;
    private static final int TWO_HUNDRED_FIFTY_THOUSAND = 250000;
    private static final int THREE_HUNDRED_THOUSAND = 300000;
    private static Random random = new Random();

    public static void main(String[] args) {

        random.setSeed(System.currentTimeMillis());
        selectionSortArrayCreationAndExecution();
        insertionSortArrayCreationAndExecution();
        bubbleSortArrayCreationAndExecution();
        mergeSortArrayCreationAndExecution();
        quickSortArrayCreationAndExecution();
        heapSortArrayCreationAndExecution();
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
            /**
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
            while (low <= high && pivot.compareTo(list[low]) < 0) {
                low++;
            }
            // Search backward from right
            while (low <= high && pivot.compareTo(list[high]) > 0) {
                high--;
            }
            // Swap two elements in the list
            if (high > low) {
                E temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && pivot.compareTo(list[high]) >= 0) {
            high--;
        }

        // Swap pivot with list[high]
        if (list[high].compareTo(pivot) > 0) {
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
        for (int i = 0; i < list.length; i++) {
            heap.add(list[i]);
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
            fiftyThousand[i] = random.nextInt(FIFTY_THOUSAND);
        }
        for (int i = 0; i < ONE_HUNDRED_THOUSAND; i++) {
            oneHundredThousand[i] = random.nextInt(ONE_HUNDRED_THOUSAND);
        }
        for (int i = 0; i < ONE_HUNDRED_FIFTY_THOUSAND; i++) {
            oneHundredFiftyThousand[i] = random.nextInt(ONE_HUNDRED_FIFTY_THOUSAND);
        }
        for (int i = 0; i < TWO_HUNDRED_THOUSAND; i++) {
            twoHundredThousand[i] = random.nextInt(TWO_HUNDRED_THOUSAND);
        }
        for (int i = 0; i < TWO_HUNDRED_FIFTY_THOUSAND; i++) {
            twoHundredFiftyThousand[i] = random.nextInt(TWO_HUNDRED_FIFTY_THOUSAND);
        }
        for (int i = 0; i < THREE_HUNDRED_THOUSAND; i++) {
            threeHundredThousand[i] = random.nextInt(THREE_HUNDRED_THOUSAND);
        }

        long fiftyThousandStart = System.currentTimeMillis();
        selectionSort(fiftyThousand);
        long fiftyThousandEnd = System.currentTimeMillis();
        long fiftyThousandExecutionTime = fiftyThousandEnd - fiftyThousandStart;
        System.out.println("Selection sort of 50,000: " + fiftyThousandExecutionTime);

        long oneHundredThousandStart = System.currentTimeMillis();
        selectionSort(oneHundredThousand);
        long oneHundredThousandEnd = System.currentTimeMillis();
        long oneHundredThousandExecutionTime = oneHundredThousandEnd - oneHundredThousandStart;
        System.out.println("Selection sort of 100,000: " + oneHundredThousandExecutionTime);

        long oneHundredFiftyThousandStart = System.currentTimeMillis();
        selectionSort(oneHundredFiftyThousand);
        long oneHundredFiftyThousandEnd = System.currentTimeMillis();
        long oneHundredFiftyThousandExecutionTime = oneHundredFiftyThousandEnd - oneHundredFiftyThousandStart;
        System.out.println("Selection sort of 150,000: " + oneHundredFiftyThousandExecutionTime);

        long twoHundredThousandStart = System.currentTimeMillis();
        selectionSort(twoHundredThousand);
        long twoHundredThousandEnd = System.currentTimeMillis();
        long twoHundredThousandExecutionTime = twoHundredThousandEnd - twoHundredThousandStart;
        System.out.println("Selection sort of 200,000: " + twoHundredThousandExecutionTime);

        long twoHundredFiftyThousandStart = System.currentTimeMillis();
        selectionSort(twoHundredFiftyThousand);
        long twoHundredFiftyThousandEnd = System.currentTimeMillis();
        long twoHundredFiftyThousandExecutionTime = twoHundredFiftyThousandEnd - twoHundredFiftyThousandStart;
        System.out.println("Selection sort of size 250,000: " + twoHundredFiftyThousandExecutionTime);

        long threeHundredThousandStart = System.currentTimeMillis();
        selectionSort(threeHundredThousand);
        long threeHundredThousandEnd = System.currentTimeMillis();
        long threeHundredThousandExecutionTime = threeHundredThousandEnd - threeHundredThousandStart;
        System.out.println("Selection sort of size 300,000: " + threeHundredThousandExecutionTime);
    }

    private static void insertionSortArrayCreationAndExecution() {

        Integer[] fiftyThousand = new Integer[FIFTY_THOUSAND];
        Integer[] oneHundredThousand = new Integer[ONE_HUNDRED_THOUSAND];
        Integer[] oneHundredFiftyThousand = new Integer[ONE_HUNDRED_FIFTY_THOUSAND];
        Integer[] twoHundredThousand = new Integer[TWO_HUNDRED_THOUSAND];
        Integer[] twoHundredFiftyThousand = new Integer[TWO_HUNDRED_FIFTY_THOUSAND];
        Integer[] threeHundredThousand = new Integer[THREE_HUNDRED_THOUSAND];

        for (int i = 0; i < FIFTY_THOUSAND; i++) {
            fiftyThousand[i] = random.nextInt(FIFTY_THOUSAND);
        }
        for (int i = 0; i < ONE_HUNDRED_THOUSAND; i++) {
            oneHundredThousand[i] = random.nextInt(ONE_HUNDRED_THOUSAND);
        }
        for (int i = 0; i < ONE_HUNDRED_FIFTY_THOUSAND; i++) {
            oneHundredFiftyThousand[i] = random.nextInt(ONE_HUNDRED_FIFTY_THOUSAND);
        }
        for (int i = 0; i < TWO_HUNDRED_THOUSAND; i++) {
            twoHundredThousand[i] = random.nextInt(TWO_HUNDRED_THOUSAND);
        }
        for (int i = 0; i < TWO_HUNDRED_FIFTY_THOUSAND; i++) {
            twoHundredFiftyThousand[i] = random.nextInt(TWO_HUNDRED_FIFTY_THOUSAND);
        }
        for (int i = 0; i < THREE_HUNDRED_THOUSAND; i++) {
            threeHundredThousand[i] = random.nextInt(THREE_HUNDRED_THOUSAND);
        }

        long fiftyThousandStart = System.currentTimeMillis();
        insertionSort(fiftyThousand);
        long fiftyThousandEnd = System.currentTimeMillis();
        long fiftyThousandExecutionTime = fiftyThousandEnd - fiftyThousandStart;
        System.out.println("Insertion sort of size 50,000: " + fiftyThousandExecutionTime);

        long oneHundredThousandStart = System.currentTimeMillis();
        insertionSort(oneHundredThousand);
        long oneHundredThousandEnd = System.currentTimeMillis();
        long oneHundredThousandExecutionTime = oneHundredThousandEnd - oneHundredThousandStart;
        System.out.println("Insertion sort of size 100,000: " + oneHundredThousandExecutionTime);

        long oneHundredFiftyThousandStart = System.currentTimeMillis();
        insertionSort(oneHundredFiftyThousand);
        long oneHundredFiftyThousandEnd = System.currentTimeMillis();
        long oneHundredFiftyThousandExecutionTime = oneHundredFiftyThousandEnd - oneHundredFiftyThousandStart;
        System.out.println("Insertion sort of size 150,000: " + oneHundredFiftyThousandExecutionTime);

        long twoHundredThousandStart = System.currentTimeMillis();
        insertionSort(twoHundredThousand);
        long twoHundredThousandEnd = System.currentTimeMillis();
        long twoHundredThousandExecutionTime = twoHundredThousandEnd - twoHundredThousandStart;
        System.out.println("Insertion sort of size 200,000: " + twoHundredThousandExecutionTime);

        long twoHundredFiftyThousandStart = System.currentTimeMillis();
        insertionSort(twoHundredFiftyThousand);
        long twoHundredFiftyThousandEnd = System.currentTimeMillis();
        long twoHundredFiftyThousandExecutionTime = twoHundredFiftyThousandEnd - twoHundredFiftyThousandStart;
        System.out.println("Insertion sort of size 250,000: " + twoHundredFiftyThousandExecutionTime);

        long threeHundredThousandStart = System.currentTimeMillis();
        insertionSort(threeHundredThousand);
        long threeHundredThousandEnd = System.currentTimeMillis();
        long threeHundredThousandExecutionTime = threeHundredThousandEnd - threeHundredThousandStart;
        System.out.println("Insertion sort of size 300,000: " + threeHundredThousandExecutionTime);
    }

    private static void bubbleSortArrayCreationAndExecution() {

        Integer[] fiftyThousand = new Integer[FIFTY_THOUSAND];
        Integer[] oneHundredThousand = new Integer[ONE_HUNDRED_THOUSAND];
        Integer[] oneHundredFiftyThousand = new Integer[ONE_HUNDRED_FIFTY_THOUSAND];
        Integer[] twoHundredThousand = new Integer[TWO_HUNDRED_THOUSAND];
        Integer[] twoHundredFiftyThousand = new Integer[TWO_HUNDRED_FIFTY_THOUSAND];
        Integer[] threeHundredThousand = new Integer[THREE_HUNDRED_THOUSAND];

        for (int i = 0; i < FIFTY_THOUSAND; i++) {
            fiftyThousand[i] = random.nextInt(FIFTY_THOUSAND);
        }
        for (int i = 0; i < ONE_HUNDRED_THOUSAND; i++) {
            oneHundredThousand[i] = random.nextInt(ONE_HUNDRED_THOUSAND);
        }
        for (int i = 0; i < ONE_HUNDRED_FIFTY_THOUSAND; i++) {
            oneHundredFiftyThousand[i] = random.nextInt(ONE_HUNDRED_FIFTY_THOUSAND);
        }
        for (int i = 0; i < TWO_HUNDRED_THOUSAND; i++) {
            twoHundredThousand[i] = random.nextInt(TWO_HUNDRED_THOUSAND);
        }
        for (int i = 0; i < TWO_HUNDRED_FIFTY_THOUSAND; i++) {
            twoHundredFiftyThousand[i] = random.nextInt(TWO_HUNDRED_FIFTY_THOUSAND);
        }
        for (int i = 0; i < THREE_HUNDRED_THOUSAND; i++) {
            threeHundredThousand[i] = random.nextInt(THREE_HUNDRED_THOUSAND);
        }

        long fiftyThousandStart = System.currentTimeMillis();
        bubbleSort(fiftyThousand);
        long fiftyThousandEnd = System.currentTimeMillis();
        long fiftyThousandExecutionTime = fiftyThousandEnd - fiftyThousandStart;
        System.out.println("Bubble sort of size 50,000: " + fiftyThousandExecutionTime);

        long oneHundredThousandStart = System.currentTimeMillis();
        bubbleSort(oneHundredThousand);
        long oneHundredThousandEnd = System.currentTimeMillis();
        long oneHundredThousandExecutionTime = oneHundredThousandEnd - oneHundredThousandStart;
        System.out.println("Bubble sort of size 100,000: " + oneHundredThousandExecutionTime);

        long oneHundredFiftyThousandStart = System.currentTimeMillis();
        bubbleSort(oneHundredFiftyThousand);
        long oneHundredFiftyThousandEnd = System.currentTimeMillis();
        long oneHundredFiftyThousandExecutionTime = oneHundredFiftyThousandEnd - oneHundredFiftyThousandStart;
        System.out.println("Bubble sort of size 150,000: " + oneHundredFiftyThousandExecutionTime);

        long twoHundredThousandStart = System.currentTimeMillis();
        bubbleSort(twoHundredThousand);
        long twoHundredThousandEnd = System.currentTimeMillis();
        long twoHundredThousandExecutionTime = twoHundredThousandEnd - twoHundredThousandStart;
        System.out.println("Bubble sort of size 200,000: " + twoHundredThousandExecutionTime);

        long twoHundredFiftyThousandStart = System.currentTimeMillis();
        bubbleSort(twoHundredFiftyThousand);
        long twoHundredFiftyThousandEnd = System.currentTimeMillis();
        long twoHundredFiftyThousandExecutionTime = twoHundredFiftyThousandEnd - twoHundredFiftyThousandStart;
        System.out.println("Bubble sort of size 250,000: " + twoHundredFiftyThousandExecutionTime);

        long threeHundredThousandStart = System.currentTimeMillis();
        bubbleSort(threeHundredThousand);
        long threeHundredThousandEnd = System.currentTimeMillis();
        long threeHundredThousandExecutionTime = threeHundredThousandEnd - threeHundredThousandStart;
        System.out.println("Bubble sort of size 300,000: " + threeHundredThousandExecutionTime);
    }

    private static void mergeSortArrayCreationAndExecution() {

        Integer[] fiftyThousand = new Integer[FIFTY_THOUSAND];
        Integer[] oneHundredThousand = new Integer[ONE_HUNDRED_THOUSAND];
        Integer[] oneHundredFiftyThousand = new Integer[ONE_HUNDRED_FIFTY_THOUSAND];
        Integer[] twoHundredThousand = new Integer[TWO_HUNDRED_THOUSAND];
        Integer[] twoHundredFiftyThousand = new Integer[TWO_HUNDRED_FIFTY_THOUSAND];
        Integer[] threeHundredThousand = new Integer[THREE_HUNDRED_THOUSAND];

        for (int i = 0; i < FIFTY_THOUSAND; i++) {
            fiftyThousand[i] = random.nextInt(FIFTY_THOUSAND);
        }
        for (int i = 0; i < ONE_HUNDRED_THOUSAND; i++) {
            oneHundredThousand[i] = random.nextInt(ONE_HUNDRED_THOUSAND);
        }
        for (int i = 0; i < ONE_HUNDRED_FIFTY_THOUSAND; i++) {
            oneHundredFiftyThousand[i] = random.nextInt(ONE_HUNDRED_FIFTY_THOUSAND);
        }
        for (int i = 0; i < TWO_HUNDRED_THOUSAND; i++) {
            twoHundredThousand[i] = random.nextInt(TWO_HUNDRED_THOUSAND);
        }
        for (int i = 0; i < TWO_HUNDRED_FIFTY_THOUSAND; i++) {
            twoHundredFiftyThousand[i] = random.nextInt(TWO_HUNDRED_FIFTY_THOUSAND);
        }
        for (int i = 0; i < THREE_HUNDRED_THOUSAND; i++) {
            threeHundredThousand[i] = random.nextInt(THREE_HUNDRED_THOUSAND);
        }

        long fiftyThousandStart = System.currentTimeMillis();
        mergeSort(fiftyThousand);
        long fiftyThousandEnd = System.currentTimeMillis();
        long fiftyThousandExecutionTime = fiftyThousandEnd - fiftyThousandStart;
        System.out.println("Merge sort of size 50,000: " + fiftyThousandExecutionTime);

        long oneHundredThousandStart = System.currentTimeMillis();
        mergeSort(oneHundredThousand);
        long oneHundredThousandEnd = System.currentTimeMillis();
        long oneHundredThousandExecutionTime = oneHundredThousandEnd - oneHundredThousandStart;
        System.out.println("Merge sort of size 100,000: " + oneHundredThousandExecutionTime);

        long oneHundredFiftyThousandStart = System.currentTimeMillis();
        mergeSort(oneHundredFiftyThousand);
        long oneHundredFiftyThousandEnd = System.currentTimeMillis();
        long oneHundredFiftyThousandExecutionTime = oneHundredFiftyThousandEnd - oneHundredFiftyThousandStart;
        System.out.println("Merge sort of size 150,000: " + oneHundredFiftyThousandExecutionTime);

        long twoHundredThousandStart = System.currentTimeMillis();
        mergeSort(twoHundredThousand);
        long twoHundredThousandEnd = System.currentTimeMillis();
        long twoHundredThousandExecutionTime = twoHundredThousandEnd - twoHundredThousandStart;
        System.out.println("Merge sort of size 200,000: " + twoHundredThousandExecutionTime);

        long twoHundredFiftyThousandStart = System.currentTimeMillis();
        mergeSort(twoHundredFiftyThousand);
        long twoHundredFiftyThousandEnd = System.currentTimeMillis();
        long twoHundredFiftyThousandExecutionTime = twoHundredFiftyThousandEnd - twoHundredFiftyThousandStart;
        System.out.println("Merge sort of size 250,000: " + twoHundredFiftyThousandExecutionTime);

        long threeHundredThousandStart = System.currentTimeMillis();
        mergeSort(threeHundredThousand);
        long threeHundredThousandEnd = System.currentTimeMillis();
        long threeHundredThousandExecutionTime = threeHundredThousandEnd - threeHundredThousandStart;
        System.out.println("Merge sort of size 300,000: " + threeHundredThousandExecutionTime);
    }

    private static void quickSortArrayCreationAndExecution() {

        Integer[] fiftyThousand = new Integer[FIFTY_THOUSAND];
        Integer[] oneHundredThousand = new Integer[ONE_HUNDRED_THOUSAND];
        Integer[] oneHundredFiftyThousand = new Integer[ONE_HUNDRED_FIFTY_THOUSAND];
        Integer[] twoHundredThousand = new Integer[TWO_HUNDRED_THOUSAND];
        Integer[] twoHundredFiftyThousand = new Integer[TWO_HUNDRED_FIFTY_THOUSAND];
        Integer[] threeHundredThousand = new Integer[THREE_HUNDRED_THOUSAND];

        for (int i = 0; i < FIFTY_THOUSAND; i++) {
            fiftyThousand[i] = random.nextInt(FIFTY_THOUSAND);
        }
        for (int i = 0; i < ONE_HUNDRED_THOUSAND; i++) {
            oneHundredThousand[i] = random.nextInt(ONE_HUNDRED_THOUSAND);
        }
        for (int i = 0; i < ONE_HUNDRED_FIFTY_THOUSAND; i++) {
            oneHundredFiftyThousand[i] = random.nextInt(ONE_HUNDRED_FIFTY_THOUSAND);
        }
        for (int i = 0; i < TWO_HUNDRED_THOUSAND; i++) {
            twoHundredThousand[i] = random.nextInt(TWO_HUNDRED_THOUSAND);
        }
        for (int i = 0; i < TWO_HUNDRED_FIFTY_THOUSAND; i++) {
            twoHundredFiftyThousand[i] = random.nextInt(TWO_HUNDRED_FIFTY_THOUSAND);
        }
        for (int i = 0; i < THREE_HUNDRED_THOUSAND; i++) {
            threeHundredThousand[i] = random.nextInt(THREE_HUNDRED_THOUSAND);
        }

        long fiftyThousandStart = System.currentTimeMillis();
        quickSort(fiftyThousand);
        long fiftyThousandEnd = System.currentTimeMillis();
        long fiftyThousandExecutionTime = fiftyThousandEnd - fiftyThousandStart;
        System.out.println("Quick sort of size 50,000: " + fiftyThousandExecutionTime);

        long oneHundredThousandStart = System.currentTimeMillis();
        quickSort(oneHundredThousand);
        long oneHundredThousandEnd = System.currentTimeMillis();
        long oneHundredThousandExecutionTime = oneHundredThousandEnd - oneHundredThousandStart;
        System.out.println("Quick sort of size 100,000: " + oneHundredThousandExecutionTime);

        long oneHundredFiftyThousandStart = System.currentTimeMillis();
        quickSort(oneHundredFiftyThousand);
        long oneHundredFiftyThousandEnd = System.currentTimeMillis();
        long oneHundredFiftyThousandExecutionTime = oneHundredFiftyThousandEnd - oneHundredFiftyThousandStart;
        System.out.println("Quick sort of size 150,000: " + oneHundredFiftyThousandExecutionTime);

        long twoHundredThousandStart = System.currentTimeMillis();
        quickSort(twoHundredThousand);
        long twoHundredThousandEnd = System.currentTimeMillis();
        long twoHundredThousandExecutionTime = twoHundredThousandEnd - twoHundredThousandStart;
        System.out.println("Quick sort of size 200,000: " + twoHundredThousandExecutionTime);

        long twoHundredFiftyThousandStart = System.currentTimeMillis();
        quickSort(twoHundredFiftyThousand);
        long twoHundredFiftyThousandEnd = System.currentTimeMillis();
        long twoHundredFiftyThousandExecutionTime = twoHundredFiftyThousandEnd - twoHundredFiftyThousandStart;
        System.out.println("Quick sort of size 250,000: " + twoHundredFiftyThousandExecutionTime);

        long threeHundredThousandStart = System.currentTimeMillis();
        quickSort(threeHundredThousand);
        long threeHundredThousandEnd = System.currentTimeMillis();
        long threeHundredThousandExecutionTime = threeHundredThousandEnd - threeHundredThousandStart;
        System.out.println("Quick sort of size 300,000: " + threeHundredThousandExecutionTime);
    }

    private static void heapSortArrayCreationAndExecution() {

        Integer[] fiftyThousand = new Integer[FIFTY_THOUSAND];
        Integer[] oneHundredThousand = new Integer[ONE_HUNDRED_THOUSAND];
        Integer[] oneHundredFiftyThousand = new Integer[ONE_HUNDRED_FIFTY_THOUSAND];
        Integer[] twoHundredThousand = new Integer[TWO_HUNDRED_THOUSAND];
        Integer[] twoHundredFiftyThousand = new Integer[TWO_HUNDRED_FIFTY_THOUSAND];
        Integer[] threeHundredThousand = new Integer[THREE_HUNDRED_THOUSAND];

        for (int i = 0; i < FIFTY_THOUSAND; i++) {
            fiftyThousand[i] = random.nextInt(FIFTY_THOUSAND);
        }
        for (int i = 0; i < ONE_HUNDRED_THOUSAND; i++) {
            oneHundredThousand[i] = random.nextInt(ONE_HUNDRED_THOUSAND);
        }
        for (int i = 0; i < ONE_HUNDRED_FIFTY_THOUSAND; i++) {
            oneHundredFiftyThousand[i] = random.nextInt(ONE_HUNDRED_FIFTY_THOUSAND);
        }
        for (int i = 0; i < TWO_HUNDRED_THOUSAND; i++) {
            twoHundredThousand[i] = random.nextInt(TWO_HUNDRED_THOUSAND);
        }
        for (int i = 0; i < TWO_HUNDRED_FIFTY_THOUSAND; i++) {
            twoHundredFiftyThousand[i] = random.nextInt(TWO_HUNDRED_FIFTY_THOUSAND);
        }
        for (int i = 0; i < THREE_HUNDRED_THOUSAND; i++) {
            threeHundredThousand[i] = random.nextInt(THREE_HUNDRED_THOUSAND);
        }

        long fiftyThousandStart = System.currentTimeMillis();
        heapSort(fiftyThousand);
        long fiftyThousandEnd = System.currentTimeMillis();
        long fiftyThousandExecutionTime = fiftyThousandEnd - fiftyThousandStart;
        System.out.println("Heap sort of size 50,000: " + fiftyThousandExecutionTime);

        long oneHundredThousandStart = System.currentTimeMillis();
        heapSort(oneHundredThousand);
        long oneHundredThousandEnd = System.currentTimeMillis();
        long oneHundredThousandExecutionTime = oneHundredThousandEnd - oneHundredThousandStart;
        System.out.println("Heap sort of size 100,000: " + oneHundredThousandExecutionTime);

        long oneHundredFiftyThousandStart = System.currentTimeMillis();
        heapSort(oneHundredFiftyThousand);
        long oneHundredFiftyThousandEnd = System.currentTimeMillis();
        long oneHundredFiftyThousandExecutionTime = oneHundredFiftyThousandEnd - oneHundredFiftyThousandStart;
        System.out.println("Heap sort of size 150,000: " + oneHundredFiftyThousandExecutionTime);

        long twoHundredThousandStart = System.currentTimeMillis();
        heapSort(twoHundredThousand);
        long twoHundredThousandEnd = System.currentTimeMillis();
        long twoHundredThousandExecutionTime = twoHundredThousandEnd - twoHundredThousandStart;
        System.out.println("Heap sort of size 200,000: " + twoHundredThousandExecutionTime);

        long twoHundredFiftyThousandStart = System.currentTimeMillis();
        heapSort(twoHundredFiftyThousand);
        long twoHundredFiftyThousandEnd = System.currentTimeMillis();
        long twoHundredFiftyThousandExecutionTime = twoHundredFiftyThousandEnd - twoHundredFiftyThousandStart;
        System.out.println("Heap sort of size 250,000: " + twoHundredFiftyThousandExecutionTime);

        long threeHundredThousandStart = System.currentTimeMillis();
        heapSort(threeHundredThousand);
        long threeHundredThousandEnd = System.currentTimeMillis();
        long threeHundredThousandExecutionTime = threeHundredThousandEnd - threeHundredThousandStart;
        System.out.println("Heap sort of size 300,000: " + threeHundredThousandExecutionTime);
    }
}