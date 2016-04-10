package arraylist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayList implements Iterable<Object> {
    private Object[] list;
    //private int size;

    public SimpleArrayList() {

    }

    public SimpleArrayList(int num) {
        list = new Object[num];
    }

    public void SimpleArrayList(Object item) {
        list = new Object[1];
        list[0] = item;
    }

    public void SimpleArrayList(Object[] objs) {
        list = objs;
    }

    private void listCopy(Object[] tmp, int first, int last, int smeshForInsert) {
        for(int i = first; i < last;i++) {
            tmp[i+smeshForInsert] = list[i];
        }

        if (list.length < tmp.length) {
            if(last < list.length) {
                //tmp[last] = list[last];
                for(int i = last+1; i < list.length ;i++) {
                    tmp[i] = list[i-1];
                }
            }
        } else {
            if(last < tmp.length) {
                for(int i = last; i < tmp.length ;i++) {
                    tmp[i] = list[i+1];
                }
            }
        }

    }


    public void addFirst(Object item) {
        Object[] tmpList = new Object[list.length+1];
        tmpList[0] = item;
        listCopy(tmpList,0, list.length, 1);
        list = tmpList;

    }

    public void addLast(Object item) {
        Object[] tmpList = new Object[list.length + 1];
        tmpList[tmpList.length - 1] = item;
        listCopy(tmpList,0, list.length,  0);
        list = tmpList;

    }

    public void addAfter(Object item, int previous) {
        if (previous < 0 || previous > list.length || item == null) {
            throw new IllegalStateException();
        }

        if (list == null) {
            list = new Object[1];
            list[0] = item;
        } else {
            Object[] tmpList = new Object[list.length + 1];

            listCopy(tmpList,0, previous, 0);
            tmpList[previous] = item;
            list = tmpList;

        }

    }

    public void addAfter(Object item, Object previous) {
        if (previous == null || item == null) {
            throw new IllegalStateException();
        }
        if (list == null) {
            list = new Object[1];
            list[0] = item;
        } else {
            int i = 0;
            while(i < list.length && !list[i].equals(previous)) {
                i++;
            }

            if (i < list.length) {
                Object[] tmpList = new Object[list.length + 1];

                tmpList[tmpList.length - 1] = item;
                listCopy(tmpList,0, i, 0);
                tmpList[i] = item;
                list = tmpList;
            } else {
                throw new IllegalStateException();
            }
        }

    }

    public void remove(Object unNeeded) {
        if (list == null || unNeeded == null) {
            throw new IllegalStateException();
        }

        int i = 0;
        while(i < list.length && !list[i].equals(unNeeded)) {
            i++;
        }

        if (i < list.length) {

        }  else {
            throw new IllegalStateException();
        }

    }

    public int getSize() {
        return list.length;
    }



/*
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
*/
    public SLLIterator getIterator() {
        return new SLLIterator();
    }

    @Override
    public Iterator<Object> iterator() {
        return new SLLIterator();
    }

    private class SLLIterator implements Iterator<Object>{
        private int cur;

        public SLLIterator() {
            cur = 0;
        }

        public boolean hasNext() {
            return (cur != list.length);
        }

        public Object next() {
            if (cur >= list.length) throw new NoSuchElementException();

            cur++;
            return list[cur];
        }

        @Override
        public void remove() {
            if(list == null) {
                return;
            }

            if(!hasNext() && cur == 0) {
                list = null;
                cur = 0;
            } else if (!hasNext() && cur > 0) {
                Object[] tmpList = new Object[list.length - 1];
                listCopy(tmpList,0, tmpList.length, 0);
                cur--;
                list = tmpList;
            } else if (hasNext() && cur == 0) {
                Object[] tmpList = new Object[list.length - 1];
                listCopy(tmpList,1, tmpList.length, -1);
                list = tmpList;

            } else {
                Object[] tmpList = new Object[list.length - 1];
                listCopy(tmpList,0, cur, 0);
                list = tmpList;
            }

        }


    }
}
