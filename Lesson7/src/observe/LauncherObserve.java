package observe;


import publish.*;

public class LauncherObserve {

    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        Newspaper newspaper1 = new Newspaper();
        newspaper1.setName("Time");
        Newspaper newspaper2 = new Newspaper();
        newspaper2.setName("Факты");
        Magazine magazine1 = new Magazine();
        magazine1.setName("Forbes");

        ObserverMy observer1 = new ObserverMy();
        ObserverMy observer2 = new ObserverMy();
        ObserverMy observer3 = new ObserverMy();

        newspaper1.addObserver(observer1);
        newspaper1.addObserver(observer3);

        newspaper2.addObserver(observer1);

        magazine1.addObserver(observer1);
        magazine1.addObserver(observer2);
        magazine1.addObserver(observer3);

        publisher.add(newspaper1);
        publisher.add(newspaper2);
        publisher.add(magazine1);

        publisher.published("");
    }
}
