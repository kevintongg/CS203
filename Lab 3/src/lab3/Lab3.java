package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Lab3 {


  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);

    int choice;

    do {
      System.out.println("Press 1 for: Write a program that reads words from your input and display all words in the inserted order.");
      System.out.println("Press 2 for: Write a program that reads words from your input and displays all the non-duplicate words in ascending order.");
      System.out.println("Press 3 for: Rewrite 3) (Option 2) using one of set data structure.");
      System.out.println("Press 4 for: Write a program that reads words from a text file and display all the non duplicate words in ascending order.");
      System.out.println("Press 5 for: Write a program that reads a text file and displays the number of each vowel (a, e, i, o, u)  in the file.");
      System.out.println("Press 6 for: Write a program that reads a text file and count the occurrences of words in the text file and display the words and number of occurrences.");
      System.out.println("If you want to quit, enter 0.");
      while (!sc.hasNextInt()) {
        sc.nextLine();
        System.out.println("Invalid Input!");
        System.out.println("Press 1 for: Write a program that reads words from your input and display all words in the inserted order.");
        System.out.println("Press 2 for: Write a program that reads words from your input and displays all the non-duplicate words in ascending order.");
        System.out.println("Press 3 for: Rewrite 3) (Option 2) using one of set data structure.");
        System.out.println("Press 4 for: Write a program that reads words from a text file and display all the non duplicate words in ascending order.");
        System.out.println("Press 5 for: Write a program that reads a text file and displays the number of each vowel (a, e, i, o, u)  in the file.");
        System.out.println("Press 6 for: Write a program that reads a text file and count the occurrences of words in the text file and display the words and number of occurrences.");
        System.out.println("If you want to quit, enter 0.");
      }
      choice = sc.nextInt();
      switch (choice) {
        case 1:
          readFromInsertedOrder();
          System.out.println();
          break;
        case 2:
          readNonDuplicatesAscending();
          System.out.println();
          break;
        case 3:
          rewriteNonDuplicates();
          System.out.println();
          break;
        case 4:
          textFileNonDuplicates();
          System.out.println();
          break;
        case 5:
          vowelsInText();
          System.out.println();
          break;
        case 6:
          numberOfOccurrences();
          System.out.println();
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
        System.out.println("If you want to quit, enter 0.");
      }
      if (choice == 0) {
        System.out.println("Thank you! Have a nice day!");
      }
    } while (choice != 0);

    sc.close();

  }

  private static void readFromInsertedOrder() {

    Scanner sc = new Scanner(System.in);
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

    Scanner sc = new Scanner(System.in);
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

    Scanner sc = new Scanner(System.in);
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
    Scanner sc = new Scanner(file);
    String s;
    while (sc.hasNext()) {
      s = sc.next();
      String finalResult = s.replaceAll("[-,.?]", "");
      set.add(finalResult);
    }
    sc.close();

    list.forEach(System.out::println);
    set.forEach(System.out::println);
  }

  private static void vowelsInText() throws IOException {

    File file = new File("C:\\Users\\kcr12\\Documents\\JetBrains\\IdeaProjects\\CS203\\Lab 3\\src\\lab3\\lincoln.txt");
    FileReader reader = new FileReader(file);
    int vowels;
    int a = 0;
    int e = 0;
    int i = 0;
    int o = 0;
    int u = 0;

    while ((vowels = reader.read()) != -1) {
      if (vowels == 65 || vowels == 97) {
        a++;
      }
      if (vowels == 69 || vowels == 101) {
        e++;
      }
      if (vowels == 73 || vowels == 105) {
        i++;
      }
      if (vowels == 79 || vowels == 111) {
        o++;
      }
      if (vowels == 85 || vowels == 117) {
        u++;
      }
    }
    reader.close();

    System.out.println("Number of the following vowels:");
    System.out.println("a — " + a);
    System.out.println("e — " + e);
    System.out.println("i — " + i);
    System.out.println("o — " + o);
    System.out.println("u — " + u);
    System.out.println("Total amount of vowels in 'lincoln.txt' — " + (a + e + i + o + u));

  }


  private static void numberOfOccurrences() throws FileNotFoundException {

    File file = new File("C:\\Users\\kcr12\\Documents\\JetBrains\\IdeaProjects\\CS203\\Lab 3\\src\\lab3\\lincoln.txt");
    Scanner sc = new Scanner(file);

    Map<String, Integer> map = new TreeMap<>();

    while (sc.hasNext()) {
      String words = sc.next().toLowerCase().replaceAll("[-,.?]", "");
      if (!map.containsKey(words)) {
        map.put(words, 1);
      } else {
        map.put(words, map.get(words) + 1);
      }
    }

    System.out.println("Word and number of occurrences:");
    for (String s : map.keySet()) {
      int counter = map.get(s);
      System.out.println(s + " — " + counter);
    }

  }
}
