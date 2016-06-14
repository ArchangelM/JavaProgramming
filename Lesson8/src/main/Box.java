package main;

public class Box<T> {
    private T node;

    public T getNode() {
        return node;
    }

    public void setNode(T node) {
        this.node = node;
    }

    public void delete() {
        node = null;
    }
}
