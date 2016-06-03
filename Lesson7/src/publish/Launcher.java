package publish;


public class Launcher {

    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        Newspaper newspaper1 = new Newspaper();
        newspaper1.setName("Time");
        Newspaper newspaper2 = new Newspaper();
        newspaper2.setName("Факты");
        Magazine magazine1 = new Magazine();
        magazine1.setName("Forbes");

        Observer observer1 = new Observer();
        Observer observer2 = new Observer();
        Observer observer3 = new Observer();

        newspaper1.add(observer1);
        newspaper1.add(observer3);

        newspaper2.add(observer1);

        magazine1.add(observer1);
        magazine1.add(observer2);
        magazine1.add(observer3);

        publisher.add(newspaper1);
        publisher.add(newspaper2);
        publisher.add(magazine1);

        publisher.published("Факты");
    }
}
