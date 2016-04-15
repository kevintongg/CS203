package lab3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Lab3 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("Enter 0 to quit, 1 to enter and display all words in inserted order, or 2 to enter and display all non-duplicate words in ascending order");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    readFromInsertedOrder();
                    break;
                case 2:
                    readNonDuplicatesAscending();
                    break;
            }
        } while (choice != 0);
    }


    private static void readFromInsertedOrder() {

        List<String> linkedList = new LinkedList<>();

        int choice;
        do {
            System.out.println("Enter 0 to exit to main menu or 1 to add or continue adding words");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    int pick;
                    do {
                        System.out.println("Enter 0 to quit or 1 to continue");
                        pick = sc.nextInt();
                    } while (pick != 0);
                    break;
            }
        } while (choice != 0);

    }

    private static void readNonDuplicatesAscending() {

        List<String> arrayList = new ArrayList<>();
    }
}
