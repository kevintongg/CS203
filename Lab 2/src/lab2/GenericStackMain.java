package lab2;

public class GenericStackMain {

    public static void main(String[] args) {

        GenericStack<Integer> stack = new GenericStack();

        for (int i = 1; i <= 23; i++) {
            stack.push(i);
        }

        System.out.println("We are removing this item in the stack: " + stack.pop() + ".");
        System.out.println("The topmost item in the stack is: " + stack.peek() + ".");
        System.out.println("Is the stack empty?: " + stack.isEmpty());
        System.out.println("There are " + stack.getSize() + " items in the stack.");

    }
}
