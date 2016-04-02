package mylist;

import lists.Node;

import java.util.Iterator;

/**
 * Created by Osipov on 28.03.2016.
 */
public class LauncherMyList {
    public static void main(String[] args) throws Exception {
        SimpleLinkedList sll = new SimpleLinkedList();
        sll.addFirst("hgk");
        sll.addFirst("hgk1");
        sll.addLast("hgk3");

        SimpleLinkedList slll = new SimpleLinkedList();
        slll.addLast("hgk1");
        slll.addLast("hgk2");
        slll.addAfter("hgk3", "hgk2");
        slll.addAfter("hgk4", "hgk1");
        //slll.addAfter("hgk4", null);
        //slll.addAfter(null, "hgk2");

        SimpleLinkedList slla = new SimpleLinkedList();
        slla.addAfter("hgk1", "hgk2");
        slla.addAfter("hgk4", "hgk1");

        System.out.println("First list");

        for (Object line : slll) {
            System.out.println(line);
        }

        System.out.println("");
        System.out.println("Next list");

        for(Iterator<Object> it = sll.iterator(); it.hasNext();) {
            Object tmp = it.next();
            System.out.println(tmp);
        }

        System.out.println("");

        slll.remove("hgk1");
        slll.remove("hgk4");
        slll.remove("hgk2");
        System.out.println("");
        System.out.println("List after remove");

        for (Object line : slll) {
            System.out.println(line);
        }

        slll.remove("hgk3");

        System.out.println("");
        System.out.println("List after all remove");

        for (Object line : slll) {
            System.out.println(line);
        }
    }
}
