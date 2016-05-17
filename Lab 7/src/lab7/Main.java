package lab7;

public class Main {

    public static void main(String[] args) {

        Integer[] integers = {50, 20, 1, 8, 100, 30, 23, 24, -4, -9};
        BST<Integer> bst = new BST<>(integers);

        bst.breadthFirstTraversal();
        System.out.println("\nLeaves: " + bst.getNumberOfLeaves());
        System.out.println("Non-leaves: " + bst.getNumberOfNonLeaves());
    }
}
