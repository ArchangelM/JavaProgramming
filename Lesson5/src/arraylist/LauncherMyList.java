package arraylist;


import java.util.Iterator;

public class LauncherMyList {
    public static void main(String[] args) throws Exception {
        SimpleArrayList sll = new SimpleArrayList();
        sll.addFirst("hgk");
        sll.addFirst("hgk1");
        sll.addLast("hgk3");

        SimpleArrayList slll = new SimpleArrayList();
        slll.addLast("hgk1");
        slll.addLast("hgk2");
        slll.addAfter("hgk3", "hgk2");
        slll.addAfter("hgk4", "hgk1");
        //slll.addAfter("hgk4", null);
        //slll.addAfter(null, "hgk2");

        SimpleArrayList slla = new SimpleArrayList();
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

        slll.addLast("hgk1");

        for(Iterator<Object> it = slll.iterator(); it.hasNext();) {
            it.next();
            it.remove();
            break;
        }

        System.out.println("");
        System.out.println("List 1 element. Del");

        for (Object line : slll) {
            System.out.println(line);
        }


        for(Iterator<Object> it = sll.iterator(); it.hasNext();) {
            it.next();
            it.remove();
            break;
        }

        System.out.println("");
        System.out.println("List. First element del");

        sll.addFirst("hgk8");
        sll.addFirst("hgk11");
        sll.addLast("hgk17");

        for (Object line : sll) {
            System.out.println(line);
        }

        int i = 0;

        for(Iterator<Object> it = sll.iterator(); it.hasNext()  && i < 3; i++) {
            it.next();
            if(i == 2) it.remove();
        }

        System.out.println("");
        System.out.println("List. Middle element del");

        for (Object line : sll) {
            System.out.println(line);
        }

        i = 0;

        for(Iterator<Object> it = sll.iterator(); it.hasNext()  && i < sll.getSize(); i++) {
            it.next();
            if(i == (sll.getSize()-1)) it.remove();
        }

        System.out.println("");
        System.out.println("List. Last element del");

        for (Object line : sll) {
            System.out.println(line);
        }
    }
}
