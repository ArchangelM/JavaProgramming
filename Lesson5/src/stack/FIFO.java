package stack;


public class FIFO {
    private Node root;
    private Node tail;
    private int size;

    public FIFO() {
        root = null;
        tail = null;
        size = 0;
    }

    public void push(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        Node tmp = root;
        root = new Node();
        root.cell = obj;
        if(root == null) {
            root.next = null;
            root.previous = null;
            tail = root;

        } else {
            tmp.previous = root;
            root.next = tmp;
            root.previous = null;
        }
        size++;
    }

    public Object pop() {
        Object tmp;

        if(root == null || tail == null) {
            return null;
        } else if (tail == root) {
            root = null;
            tmp = tail.cell;
            tail = null;
        } else {
            tmp = tail.cell;
            tail.previous.next = null;
        }
        size--;
        return tmp;
    }

    public Object peak() {
        if (tail == null) {
            return null;
        } else {
            return tail.cell;
        }
    }

    private class Node {
        Object cell;
        Node next;
        Node previous;
    }
}
