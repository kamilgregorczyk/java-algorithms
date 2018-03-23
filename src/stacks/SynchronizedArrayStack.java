package stacks;

import java.util.Stack;

public class SynchronizedArrayStack<T> extends Stack<T> {
    private static final int DEFAULT_CAPACITY = 100;

    private T[] data;
    private int lastIndex = -1;

    public SynchronizedArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public SynchronizedArrayStack(int capacity) {
        data = (T[]) new Object[capacity];
    }

    public int size() {
        return lastIndex - 1;
    }

    public boolean isFull() {
        return size() == data.length;
    }

    public boolean isEmpty() {
        return lastIndex == -1;
    }

    public T push(T element) {
        synchronized (data) {
            if (isFull()) data[++lastIndex] = element;
            return element;
        }
    }

    public T top() {
        if (isEmpty()) return null;
        return data[lastIndex];
    }

    public T pop() {
        synchronized (data) {
            if (isEmpty()) return null;
            T result = data[lastIndex];
            data[lastIndex] = null;
            lastIndex--;
            return result;
        }
    }
}
