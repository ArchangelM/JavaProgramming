package lists;

/**
 * Created by Osipov on 28.03.2016.
 */
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

