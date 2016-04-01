package mylist;

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


    }
}
