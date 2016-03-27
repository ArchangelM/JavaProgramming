package mylist;

/**
 * Created by Osipov on 28.03.2016.
 */
public class SimpleLinkedList {
    private Node root;
    private int size;

    public SimpleLinkedList() {
        size = 0;
    }

    public void addFirst(Object item) {
        if (item != null) {
            Node n = new Node(item, root);
            root = n;
        }
    }

    public void addList(Object item) {
        if (item != null) {
            if (root != null) {

            }
        }
    }

    public void addAfter(Object item, Object previous) {
        if (root != null && item != null && previous != null) {

        }
    }

    public Node getNodeList() {
        return root;
    }

    public void setNodeList(Node nodeList) {
        this.root = nodeList;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    private class Node {
        Object obj;
        Node node;

        public Node() {
        }

        public Node(Object obj, Node node) {
            this.obj = obj;
            this.node = node;
        }
    }
}
