package lab2;

import java.util.ArrayList;

public class GenericStack<E> extends ArrayList<E> {

  /**
   * Push a new element into the top of the stack
   */

  public void push(E value) {
    add(value);
  }

  /**
   * Return and remove the top element from the stack
   */

  public E pop() {
    return remove(getSize() - 1);
  }


  /**
   * Return the top element from the stack
   */

  public E peek() {

    return get(getSize() - 1);

  }

  /**
   * Exercise03_21 whether the stack is empty
   */

  public boolean isEmpty() {

    return super.isEmpty();

  }

  /**
   * Return the number of elements in the stack
   */

  public int getSize() {
    return size();
  }
}
