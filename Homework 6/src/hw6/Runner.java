package hw6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Runner<E> {

    public static void main(String[] args) {

        Random random = new Random();
        int randomInt;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 50000; i++) {
            list.add(random.nextInt(50000));
        }

    }

    private static void print(String s) {
        System.out.println(s);
    }

    private void selectionSortExecutionTime(E[] list) {


    }
}
