package main;

import java.util.ArrayList;
import java.util.List;

public class BoxList<T extends Tank> {
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

    public List<T> getList() {
        return new ArrayList<T>(list);
    }
}
