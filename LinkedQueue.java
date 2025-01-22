/**
 * Anmoldeep Singh
 * 3149800
 */
import java.util.NoSuchElementException;

public class LinkedQueue<E> {

    private Node<E> front;
    private Node<E> rear;
    private int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element, null);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }
        rear = newNode;
        size++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        E removedElement = front.getElement();
        front = front.getNext();
        size--;
        if (isEmpty()) {
            rear = null;
        }
        return removedElement;
    }

    public E first() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.getElement();
    }

    // Node class for linked list
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
