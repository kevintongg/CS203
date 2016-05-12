package lab6;

import java.util.Iterator;

public class MyLinkedList<E> extends MyAbstractList<E> {

    private Node<E> head, tail;

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
        if ()
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(E o) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int indexOf(E o) {
        return 0;
    }

    @Override
    public int lastIndexOf(E o) {
        return 0;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E set(int index, E o) {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    private class Node<E> {

        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }
}
