package stack;

public class LIFO {
    private Node root;
    private int size;

    public LIFO() {
        root = null;
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
        } else {
            root.next = tmp;
        }
        size++;
    }

    public Object pop() {
        Object tmp;

        if(root == null) {
            return null;
        } else if (size == 1) {
            tmp = root.cell;
            root = null;
        } else {
            tmp = root.cell;
            root = root.next;
        }
        size--;
        return tmp;
    }

    public Object peak() {
        if (root == null) {
            return null;
        } else {
            return root.cell;
        }
    }

    private class Node {
        Object cell;
        Node next;
    }
}
