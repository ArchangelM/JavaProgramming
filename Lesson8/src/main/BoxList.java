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

    public  void sort() {
        for(int i = 0; i < list.size();i++) {
            T min = list.get(i);
            int position = i;
            for(int j = i+1; j < list.size();j++) {
                if (min.compareTo(list.get(j)) > 0) {
                    min = list.get(j);
                    position = j;
                }
            }
            //Tank tmp = list.get(i);
            if (position > i) {
                list.set(position, list.get(i));
                list.set(i, min);
            }
        }
    }

    public void printList() {
        for (T e:
             list) {
            System.out.println(e.getName());

        }
    }
}
