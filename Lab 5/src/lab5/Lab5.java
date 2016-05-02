package lab5;

import java.util.Scanner;

public class Lab5<E> {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Test
        Integer[] integers = {23, 3, 94, 2, 11, 9};
        Double[] doubles = {23.3, 3.3, 94.4, 2.2, 11.1, 9.9};

        int choice;
        System.out.println("Enter 1 to start insertion sort");
        System.out.println("Enter 2 to start bubble sort");
        System.out.println("Enter 3 to start merge sort");
        System.out.println("Enter 4 to start heap sort");
        System.out.println("Enter 0 to exit");
        do {

            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.println("Invalid input!");
                System.out.println("Enter 1 to start insertion sort");
                System.out.println("Enter 2 to start bubble sort");
                System.out.println("Enter 3 to start merge sort");
                System.out.println("Enter 4 to start heap sort");
                System.out.println("Enter 0 to exit");
            }
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\nInsertion sort");
                    System.out.println("Integers");
                    insertionSort(integers);
                    System.out.println("\nDoubles");
                    insertionSort(doubles);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("\nBubble sort");
                    System.out.println("Integers");
                    bubbleSort(integers);
                    System.out.println("\nDoubles");
                    bubbleSort(doubles);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("\nMerge sort");
                    System.out.println("Integers");
                    mergeSort(integers);
                    System.out.println("\nDoubles");
                    mergeSort(doubles);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("\nHeap sort");
                    System.out.println("Integers");
                    heapSort(integers);
                    System.out.println("\nDoubles");
                    heapSort(doubles);
                    System.out.println();
                    break;
            }
            if (choice < 0 || choice > 4) {
                System.out.println("Invalid input!");
                System.out.println("Enter 1 to start insertion sort");
                System.out.println("Enter 2 to start bubble sort");
                System.out.println("Enter 3 to start merge sort");
                System.out.println("Enter 4 to start heap sort");
                System.out.println("Enter 0 to exit");
            }
        } while (choice != 0);

    }

    private static <E extends Comparable<E>> void printArray(E[] list) {

        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " | ");
        }
        System.out.println();
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

            printArray(list);
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

                printArray(list);
            }
        }
    }

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

            printArray(list);
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

        printArray(list);
    }
}
