package lab7;

import java.util.Scanner;

public class AVLTest {

    public static void main(String[] args) {

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
