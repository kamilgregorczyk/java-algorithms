package trees;

import java.util.Iterator;

public interface Tree<T> extends Iterable<T> {

    T root();

    T parent(T p) throws IllegalArgumentException;

    Iterable<T> children(T p)
            throws IllegalArgumentException;

    int childrenCount(T p) throws IllegalArgumentException;

    boolean isInternal(T p) throws IllegalArgumentException;

    boolean isExternal(T p) throws IllegalArgumentException;

    boolean isRoot(T p) throws IllegalArgumentException;

    int size();

    boolean isEmpty();

    Iterator<T> iterator();

    Iterable<T> positions();

}
