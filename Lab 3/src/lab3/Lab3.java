package lab3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Lab3 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        readFromInsertedOrder();
        readNonDuplicatesAscending();

    }

    private static void readFromInsertedOrder() {

        List<String> linkedList = new LinkedList<>();

        int counter = 0;
        System.out.println("We will now get five words to display");
        do {
            System.out.println("Please enter word #" + (counter + 1) + ":");
            linkedList.add(sc.next());
            counter++;
        } while (counter != 5);

        linkedList.forEach(System.out::println);

    }

    private static void readNonDuplicatesAscending() {

        List<String> arrayList = new ArrayList<>();

        int counter = 0;
        System.out.println("We will now get five words to display in ascending order with duplicates removed");
        do {
            System.out.println("Please enter word #" + (counter + 1) + ":");
            arrayList.add(sc.next());
            counter++;
        } while (counter != 5);

        for (int i = 0; i < arrayList.size(); i++) {
        }

        arrayList.forEach(System.out::println);
    }
}
