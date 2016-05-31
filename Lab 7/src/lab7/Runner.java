package lab7;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Integer[] integers = {50, 20, 1, 8, 100, 30, 23, 24, -4, -9};
        BST<Integer> bst = new BST<>(integers);

        bst.breadthFirstTraversal();
        System.out.println("\nLeaves: " + bst.getNumberOfLeaves());
        System.out.println("Non-leaves: " + bst.getNumberOfNonLeaves());

        AVLTree<Double> tree = new AVLTree<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 10 numbers: ");
        for (int i = 0; i < 10; i++) {
            tree.insert(sc.nextDouble());
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();
        System.out.println("The " + k + "th smallest number is " + tree.find(k));
    }
}
