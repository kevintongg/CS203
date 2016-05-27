package lab6;

public class MyLinkedList<E> extends MyAbstractList<E> {

    private Node<E> head;
    private Node<E> tail;

    public MyLinkedList() {
    }

    public MyLinkedList(E[] objects) {
        super(objects);
    }

    @Override
    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e); // Insert first
        } else if (index >= size) {
            addLast(e); // Insert last
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
        }
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e); // Create a new node
        newNode.next = head; // link the new node with the head
        head = newNode; // head points to the new node
        size++; // Increase list size

        if (tail == null) {
            tail = head;
        }
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e); // Create a new node for e

        if (tail == null) {
            head = tail = newNode; // The only node in list
        } else {
            tail.next = newNode; // Link the new node with the last node
            tail = tail.next; // tail now points to the last node
        }

        size++; // Increase size
    }

    public E removeFirst() {
        if (size == 0) {
            return null; // Nothing to delete
        } else {
            Node<E> temp = head;
            head = head.next;
            size--;

            if (head == null) {
                tail = null;
            }

            return temp.element;
        }
    }

    public E removeLast() {

        if (size == 0) {
            return null; // nothing to remove
        } else if (size == 1) { // only one element in the list
            Node<E> temp = head;
            head = tail = null; // list becomes empty
            size = 0;
            return temp.element;
        } else {
            Node<E> current = head;

            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;

            return temp.element;
        }
    }

    @Override
    /** Clear the list */
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override
    /** Return true if this list contains the element*/
    public boolean contains(E e) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    /** Return the element at the specified index*/
    public E get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    /** Return the index of the head matching element
     * in this list. Return -1 if no match. */
    public int indexOf(E e) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    /** Return the index of the last matching element
     * in this list. Return -1 if no match. */
    public int lastIndexOf(E e) {
        int lastIndex = -1;
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(e)) {
                lastIndex = 1;
            }
            current = current.next;
        }
        return lastIndex;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null; // out of range
        } else if (index == 0) {
            return removeFirst(); // remove first
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> previous = head;

            for (int i = 0; i < index - 1; i++) {
                previous = previous.next;
            }

            Node<E> current = previous.next;
            previous.next = current.next;
            size--;

            return current.element;
        }
    }

    public String toString() {

        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // separate two elements with a comma
            } else {
                result.append("]"); // insert closing ] in the string
            }
        }

        return result.toString();
    }

    @Override
    /** Replace the element at the specified position
     * in this list with the specified element. */
    public E set(int index, E e) {
        Node<E> node = (Node<E>) get(index);
        E prev = node.element;
        node.element = e;
        return prev;
    }

    @Override
    /** Override iterator() defined in Iterable */
    public java.util.Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    /**
     * This class is only used in LinkedList, so it is private.
     * This class does not need to access any
     * instance members of LinkedList, so it is defined static.
     */
    private static class Node<E> {

        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    private class LinkedListIterator implements java.util.Iterator<E> {

        private Node<E> current = head; // current index
        private boolean remove;

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }

        @Override
        public void remove() {
            if (!remove) {
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove((E) current.next);
            remove = false;
        }
    }
}
