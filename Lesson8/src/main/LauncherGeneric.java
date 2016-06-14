package main;

public class LauncherGeneric {
    public static void main(String[] args) {
        BoxList<Tank> box = new BoxList<>();

        box.addNode(new T34());
        box.addNode(new Tiger());

    }
}
