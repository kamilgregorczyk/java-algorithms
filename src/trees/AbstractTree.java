package trees;

public abstract class AbstractTree<T> implements Tree<T> {

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean isRoot(T p) throws IllegalArgumentException {
        return p.equals(root());
    }

    @Override
    public boolean isInternal(T p) throws IllegalArgumentException {

        return childrenCount(p) > 0;
    }

    @Override
    public boolean isExternal(T p) throws IllegalArgumentException {
        return childrenCount(p) == 0;
    }

    public int depth() {
        return depth(root());
    }

    public int depth(T p) {
        if (isRoot(p)) {
            return 0;
        } else {
            return 1 + depth(parent(p));
        }
    }

    public int height() {
        return height(root());
    }

    public int height(T p) {
        int h = 0;
        for (T child : children(p)) {
            h = Math.max(h, height(child) + 1);
        }
        return h;
    }

}
