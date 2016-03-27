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

    }

    public void addList(Object item) {

    }

    public void addAfter(Object item, Object previous) {

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


    public class Node {
        private Object o;
        private Node node;

        public Node() {
        }

        public Object getO() {
            return o;
        }

        public void setO(Object o) {
            this.o = o;
        }

        public Node getNode() {
            return node;
        }

        public void setNode(Node node) {
            this.node = node;
        }
    }
}
