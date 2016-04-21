package lab3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Lab3 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {

        int choice;

        do {
            System.out.println("Press 1 for: Write a program that reads words from your input and display all words in the inserted order.");
            System.out.println("Press 2 for: Write a program that reads words from your input and displays all the non-duplicate words in ascending order.");
            System.out.println("Press 3 for: Rewrite 3) (Option 2) using one of set data structure.");
            System.out.println("Press 4 for: Write a program that reads words from a text file and display all the non duplicate words in ascending order.");
            System.out.println("Press 5 for: Write a program that reads a text file and displays the number of each vowel (a, e, i, o, u)  in the file.");
            System.out.println("Press 6 for: Write a program that reads a text file and count the occurrences of words in the text file and display the words and number of occurrences.");
            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.println("Invalid Input!");
                System.out.println("Press 1 for: Write a program that reads words from your input and display all words in the inserted order.");
                System.out.println("Press 2 for: Write a program that reads words from your input and displays all the non-duplicate words in ascending order.");
                System.out.println("Press 3 for: Rewrite 3) (Option 2) using one of set data structure.");
                System.out.println("Press 4 for: Write a program that reads words from a text file and display all the non duplicate words in ascending order.");
                System.out.println("Press 5 for: Write a program that reads a text file and displays the number of each vowel (a, e, i, o, u)  in the file.");
                System.out.println("Press 6 for: Write a program that reads a text file and count the occurrences of words in the text file and display the words and number of occurrences.");
            }
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    readFromInsertedOrder();
                    break;
                case 2:
                    readNonDuplicatesAscending();
                    break;
                case 3:
                    rewriteNonDuplicates();
                    break;
                case 4:
                    textFileNonDuplicates();
                    break;
                case 5:
                    break;
                case 6:
                    numberOfOccurrences();
                    break;
            }
            if (choice < 0 || choice > 6) {
                System.out.println("Invalid Input!");
                System.out.println("Press 1 for: Write a program that reads words from your input and display all words in the inserted order.");
                System.out.println("Press 2 for: Write a program that reads words from your input and displays all the non-duplicate words in ascending order.");
                System.out.println("Press 3 for: Rewrite 3) (Option 2) using one of set data structure.");
                System.out.println("Press 4 for: Write a program that reads words from a text file and display all the non duplicate words in ascending order.");
                System.out.println("Press 5 for: Write a program that reads a text file and displays the number of each vowel (a, e, i, o, u)  in the file.");
                System.out.println("Press 6 for: Write a program that reads a text file and count the occurrences of words in the text file and display the words and number of occurrences.");
                System.out.println("Enter 0 to exit the program.");
            }
            if (choice == 0) {
                System.out.println("Thank you! Have a nice day!");
            }
        } while (choice != 0);
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

        for (int i = 0; i < arrayList.size() - 1; i++) {
            for (int j = i; j < arrayList.size() - 1; j++) {
                if (arrayList.get(j).equals(arrayList.get(i))) {
                    arrayList.remove(j);
                }
            }
        }

        arrayList.forEach(System.out::println);
    }

    private static void rewriteNonDuplicates() {

        Set<String> set = new TreeSet<>();

        int counter = 0;
        System.out.println("We will now get five words to display in ascending order with duplicates removed with a new data structure");
        do {
            System.out.println("Please enter word #" + (counter + 1) + ":");
            set.add(sc.next());
            counter++;
        } while (counter != 5);

        set.forEach(System.out::println);
    }

    private static void textFileNonDuplicates() throws FileNotFoundException {

        Set<String> set = new TreeSet<>();
        List<String> list = new ArrayList<>();
        File file = new File("C:\\Users\\kcr12\\Documents\\JetBrains\\IdeaProjects\\CS203\\Lab 3\\src\\lab3\\lincoln.txt");
        Scanner fileScanner = new Scanner(file);
        String s;
        while (fileScanner.hasNext()) {
            s = fileScanner.next();
            String finalResult = s.replaceAll("[-,.?]", "");
            set.add(finalResult);
        }
        fileScanner.close();

        list.forEach(System.out::println);

//        Path path = Paths.get("C:\\Users\\kcr12\\Documents\\JetBrains\\IdeaProjects\\CS203\\Lab 3\\src\\lab3\\lincoln.txt");
//        Charset charset = Charset.forName("UTF-8");
//        try {
//            list = Files.readAllLines(path, charset);
//
//        } catch (IOException e) {
//            System.err.format("IOException %s%n:", e);
//        }

//        set.addAll(list);
        set.forEach(System.out::println);
    }

    private static void numberOfOccurrences() {

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        Path path = Paths.get("lab3/lincoln.txt");
        Charset charset = Charset.forName("UTF-8");
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            list = Files.readAllLines(path, charset);
        } catch (NoSuchFileException e) {
            System.err.format("NoSuchFileException %s%n:", e);
        } catch (IOException e) {
            System.err.format("IOException %s%n:", e);
        }

        list.forEach(System.out::println);

    }
}
