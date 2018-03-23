package arrays;

/**
 * Circularly linked list, can be used for the rotate-robin mechanism.
 */
public class CircularlLinkedList<T> {

    private SingleLinkedNode<T> tail = null;
    private long size;

    public CircularlLinkedList() {
    }

    public long size() {
        return size;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public T getFirst() {
        if (isEmpty()) return null;
        return tail.getNextNode().getElement();
    }

    public T getLast() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void rotate() {
        if (tail != null) {
            tail = tail.getNextNode();
        }
    }

    public T removeFirst() {
        if (isEmpty()) return null;
        SingleLinkedNode<T> head = tail.getNextNode();
        if (head == tail) {
            tail = null;
        } else {
            tail.setNextNode(head.getNextNode());
        }
        size--;
        return head.getElement();
    }
}
