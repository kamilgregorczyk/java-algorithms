package arrays;

public class DoubleLinkedList<T> {

    private DoubleLinkedNode<T> head;
    private DoubleLinkedNode<T> tail;
    private long size = 0;

    public DoubleLinkedList() {
        head = new DoubleLinkedNode(null, null, null);
        tail = new DoubleLinkedNode<>(null, head, null);
        head.setNextNode(tail);
    }

    public long size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T getFirst() {
        if (isEmpty()) return null;
        return head.getNextNode().getElement();
    }

    public T getLast() {
        if (isEmpty()) return null;
        return tail.getPrevNode().getElement();
    }

    public void addFirst(T element) {
        addBetween(element, head, head.getNextNode());
    }

    public void addLast(T element) {
        addBetween(element, tail, tail.getPrevNode());
    }

    public T removeFirst() {
        if (isEmpty()) return null;
        return remove(head.getNextNode());
    }

    public T removeLast() {
        if (isEmpty()) return null;
        return remove(tail.getPrevNode());
    }

    private T remove(DoubleLinkedNode<T> node) {
        DoubleLinkedNode<T> predecessor = node.getPrevNode();
        DoubleLinkedNode<T> successor = node.getNextNode();
        predecessor.setNextNode(successor);
        successor.setNextNode(predecessor);
        size--;
        return node.getElement();
    }

    private void addBetween(T element, DoubleLinkedNode<T> predecessor, DoubleLinkedNode<T> successor) {
        DoubleLinkedNode<T> newNode = new DoubleLinkedNode<>(element, predecessor, successor);
        predecessor.setNextNode(newNode);
        successor.setPrevNode(newNode);
        size++;
    }

}
