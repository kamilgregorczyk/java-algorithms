package arrays;

/**
 * Node for double linked lists.
 */
class DoubleLinkedNode<T> {
    private final T element;
    private DoubleLinkedNode<T> nextNode;
    private DoubleLinkedNode<T> prevNode;

    DoubleLinkedNode(T element, DoubleLinkedNode<T> prevNode, DoubleLinkedNode<T> nextNode) {
        this.element = element;
        this.nextNode = nextNode;
        this.prevNode = prevNode;
    }

    T getElement() {
        return element;
    }

    DoubleLinkedNode<T> getNextNode() {
        return nextNode;
    }

    DoubleLinkedNode<T> getPrevNode() {
        return prevNode;
    }

    void setNextNode(DoubleLinkedNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    void setPrevNode(DoubleLinkedNode<T> nextNode) {
        this.prevNode = prevNode;
    }
}
