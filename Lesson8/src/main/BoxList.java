package main;

import java.util.ArrayList;
import java.util.List;

public class BoxList<T> {
    private List<T> list;

    public BoxList() {
        list = new ArrayList<T>();
    }

    public void addNode(T node) {
        list.add(node);
    }

    public T getNode(int i) {
        return list.get(i);
    }
}
