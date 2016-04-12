package lab2;

import java.util.ArrayList;
import java.util.Arrays;

public class Lab2 {

    public static void main(String[] args) {

        mainProgram();

    }

    public static void mainProgram() {

        genericStackRunner();

        System.out.println("Generic Linear Search");
        Integer[] linearSearchList = {1, 2, 3, 4, 5, 11, 23, 32};
        System.out.println("The index of our key is " + linearSearch(linearSearchList, 23) + ".");

        System.out.println("\nGeneric Binary Search");
        Integer[] binarySearchList = {7, 9, 10, 15, 20, 25};
        System.out.println("The index of our key is " + binarySearch(binarySearchList, 15) + ".");

        System.out.println("\nGeneric Selection Sort");
        Integer[] selectionList = {10, 1, 5, 6, 2, 4, 7};
        System.out.println("Before selection sort:");
        System.out.println(Arrays.toString(selectionList));
        selectionSort(selectionList);
        System.out.println("After selection sort:");
        System.out.println(Arrays.toString(selectionList));

        System.out.println("\nExtra Credit: Implement the following method that returns a new ArrayList. The new list contains the non-duplicate elements from the original list.");
        ArrayList<Integer> list1 = new ArrayList();
        list1.add(1);
        list1.add(1);
        list1.add(2);
        list1.add(2);
        list1.add(3);
        list1.add(3);
        System.out.println("Before removal of duplicates");
        for (Integer preRemoval : list1) {
            System.out.print(preRemoval + " ");
        }
        removeDuplicates(list1);
        System.out.println("\nAfter removal of duplicates");
        for (Integer postRemoval : list1) {
            System.out.print(postRemoval + " ");
        }
        System.out.println();

        System.out.println("\nExtra Credit: Implement the method returns largest element from the two dimensional array");
        Integer[][] list2 = {{1, 3, 5}, {2, 4, 6}, {7, 9, 11}, {8, 10, 12}};
        System.out.println("The largest element in our two-dimensional array is " + max(list2) + ".");

        System.out.println("\nExtra Credit: Implement a method that sorts an ArrayList");
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1024);
        list3.add(512);
        list3.add(256);
        list3.add(128);
        list3.add(64);
        list3.add(32);
        list3.add(16);
        list3.add(8);
        System.out.println("Before Sort");
        for (Integer preSort : list3) {
            System.out.print(preSort + " ");
        }
        sort(list3);
        System.out.println("\nAfter Sort");
        for (Integer postSort : list3) {
            System.out.print(postSort + " ");
        }

    }

    public static void genericStackRunner() {

        GenericStack<Integer> stack = new GenericStack();

        for (int i = 1; i <= 23; i++) {
            stack.push(i);
        }

        System.out.println("Your items in the stack:");
        for (Integer i : stack) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("We are removing this item in the stack: " + stack.pop() + ".");
        System.out.println("The topmost item in the stack is: " + stack.peek() + ".");
        System.out.println("Is the stack empty: " + stack.isEmpty());
        System.out.println("There are " + stack.getSize() + " items in the stack.");

        System.out.println("Your items in the stack now:");
        for (Integer j : stack) {
            System.out.print(j + " ");
        }
        System.out.println("\n");
    }

    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {

        for (int i = 0; i < list.length; i++) {
            if (list[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {

        int mid = list.length / 2;
        while (mid > 0 && mid < list.length) {
            if (list[mid] == key) {
                return mid;
            } else if (list[mid].compareTo(key) < 0) {
                mid = list.length - ((list.length - (mid - 1)) / 2);
            } else {
                mid = list.length - ((list.length - (mid + 1)) / 2);
            }
        }
        return -1;
    }

    public static <E extends Comparable<E>> void selectionSort(E[] list) {

        for (int i = 0; i < list.length; i++) {
            for (int j = i; j < list.length; j++) {
                if (list[j].compareTo(list[i]) < 0) {
                    E temp = list[j];
                    list[j] = list[i];
                    list[i] = temp;
                }
            }
        }
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i))) {
                list.remove(i);
            }
        }
        return list;
    }

    public static <E extends Comparable<E>> E max(E[][] list) {

        E max = list[0][0];

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if (max.compareTo(list[i][j]) < 0) {
                    max = list[i][j];
                }
            }
        }
        return max;
    }

    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {

        for (int i = 0; i < list.size(); i++) {
            E temp = list.get(i);
            int k = i;
            for (int j = i; j < list.size(); j++) {
                if (list.get(j).compareTo(temp) < 0) {
                    temp = list.get(j);
                    k = j;
                }
            }
            if (k != i) {
                list.set(k, list.get(i));
                list.set(i, temp);
            }
        }
    }
}
