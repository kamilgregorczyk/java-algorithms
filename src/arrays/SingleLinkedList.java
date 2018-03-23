package arrays;

/**
 * Single linked list.
 */
public class SingleLinkedList<T> {


    private SingleLinkedNode<T> head = null;
    private SingleLinkedNode<T> tail = null;
    private long size = 0;

    public SingleLinkedList() {
    }

    public long size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(T newHead) {
        SingleLinkedNode<T> currentHead = head;
        head = new SingleLinkedNode<>(newHead, currentHead);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(T newTail) {
        SingleLinkedNode<T> newTailSingleLinkedNode = new SingleLinkedNode<>(newTail, null);
        if (isEmpty()) {
            head = newTailSingleLinkedNode;
        } else {
            tail.setNextNode(newTailSingleLinkedNode);
        }
        tail = newTailSingleLinkedNode;
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T result = head.getElement();
        head = head.getNextNode();
        size--;
        if (size == 0) {
            tail = null;
        }
        return result;
    }
}
