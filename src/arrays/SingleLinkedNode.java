package arrays;

/**
 * Node for linked lists.
 */
class SingleLinkedNode<T> {
    private final T element;
    private SingleLinkedNode<T> nextNode;

    SingleLinkedNode(T element, SingleLinkedNode<T> nextNode) {
        this.element = element;
        this.nextNode = nextNode;
    }

    T getElement() {
        return element;
    }

    SingleLinkedNode<T> getNextNode() {
        return nextNode;
    }

    void setNextNode(SingleLinkedNode<T> nextNode) {
        this.nextNode = nextNode;
    }
}
