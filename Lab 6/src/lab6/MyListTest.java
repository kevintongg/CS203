package lab6;

public class MyListTest {

  public static void main(String[] args) {

    MyLinkedList<String> list = new MyLinkedList<>();

    list.add(0, "Honolulu");
    list.add(1, "Seoul");
    list.add(2, "Tokyo");
    list.add(3, "Hong Kong");
    list.remove(0);
    list.forEach(System.out::println);
    System.out.println();
    System.out.println("Is Tokyo in our list? — " + list.contains("Tokyo"));
    list.forEach(System.out::println);
    System.out.println();
    list.removeFirst();
    list.forEach(System.out::println);
  }
}
