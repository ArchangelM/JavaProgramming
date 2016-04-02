package mylist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Created by Osipov on 28.03.2016.
 */
public class SimpleLinkedList implements Iterable<Object> {
    private Node root;
    private int size;

    public SimpleLinkedList() {
        size = 0;
        root = null;
    }

    public void addFirst(Object item) {
        //if (item != null) {
            Node n = new Node(item, root);
            root = n;
            size++;
       // }

    }

    public void addLast(Object item) {
        Node n = new Node(item, null);
        if (root == null) {
            root = n;
        } else {
            Node tmp = root;
            for (int i = 1;i < size;i++) {
                tmp = tmp.node;
            }
            tmp.node = n;
        }
        size++;

    }

    public void addAfter(Object item, Object previous) {
        if (previous == null || item == null) {
            throw new IllegalStateException();
        }
        Node n = new Node(item, null);
        if (root == null) {
            root = n;
        } else {
            Node current = root;

            while(current.node != null && !current.equals(previous)) {
                current = current.node;
            }

            if(!current.equals(previous)) {
                throw new IllegalStateException();
            }

            n.node = current.node;
            current.node = n;

        }

        size++;
    }

    public void remove(Object unNeeded) {
        if (root == null || unNeeded == null) {
            throw new IllegalStateException();
        }

        Node current = root;
        Node previous = null;

        while(current.node != null && !current.equals(unNeeded)) {
            previous = current;
            current = current.node;
        }

        if(!current.equals(unNeeded)) {
            throw new IllegalStateException();
        }
        if (previous == null) {
            root = root.node;
        } else {
            previous.node = current.node;
        }

        size--;

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

        @Override
        public boolean equals(Object object) {
            if (obj.equals(object)) {
                        return true;
            }

            return false;
        }

        @Override
        public String toString() {
            return obj.toString();
        }

        public Object getObject() {
            return obj;
        }

    }

    public SLLIterator getIterator() {
        return new SLLIterator();
    }

    @Override
    public Iterator<Object> iterator() {
        return new SLLIterator();
    }

    private class SLLIterator implements Iterator<Object>{
        private int cur;
        private Node current;

        public SLLIterator() {
            cur = 0;
            current = root;
        }
/*
        public SLLIterator(int cur) {
            if (cur >= 0 && cur < size) this.cur = cur;
        }
*/
        public boolean hasNext() {
            return (cur != size);
        }

        public Node next() {
            if (cur >= size) throw new NoSuchElementException();

            Node tmp = root;

            for (int i = 0; i < cur; i++) {
                tmp = tmp.node;
            }
            if(tmp == null) throw new NoSuchElementException();
            cur++;
            current = tmp;
            return tmp;
        }



         /*Node link;

        public SLLIterator() {

        }

        public SLLIterator(Node link) {
            this.link = link;
        }

        public boolean hasNext() {
            if(link.node != null) {
                return true;
            }
            return false;

        }

        public Node next() {
            if (hasNext()) {
                link = link.node;
                return link;
            }
            return null;
        }
        */
    }
}
