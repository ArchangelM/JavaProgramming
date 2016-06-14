package main;

public class LauncherGeneric {
    public static void main(String[] args) {
        BoxList<Tank> box = new BoxList<>();

        T34 cur = new T34();
        cur.setName("stal1");
        cur.setId(1);
        cur.setPrice(678d);
        cur.setCalibre(100);
        box.addNode(cur);

        Tiger curT = new Tiger();
        curT.setName("Tiger1");
        curT.setId(2);
        curT.setPrice(15438d);
        curT.setShield(3);
        box.addNode(curT);

        cur = new T34();
        cur.setName("Stal2");
        cur.setId(3);
        cur.setPrice(888d);
        cur.setCalibre(105);
        box.addNode(cur);

        curT = new Tiger();
        curT.setName("Tiger0");
        curT.setId(4);
        curT.setPrice(15038d);
        curT.setShield(3);
        box.addNode(curT);

        box.printList();
        box.sort();
        System.out.println();
        box.printList();



    }
}
