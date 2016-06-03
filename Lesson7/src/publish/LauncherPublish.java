package publish;


public class LauncherPublish {

    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        Newspaper newspaper1 = new Newspaper();
        newspaper1.setName("Time");
        Newspaper newspaper2 = new Newspaper();
        newspaper2.setName("Факты");
        Magazine magazine1 = new Magazine();
        magazine1.setName("Forbes");

        Observer observer1 = new Observer();
        observer1.setName("1");
        Observer observer2 = new Observer();
        observer2.setName("3265");
        Observer observer3 = new Observer();
        observer3.setName("2");

        newspaper1.add(observer1);
        newspaper1.add(observer3);

        newspaper2.add(observer1);

        magazine1.add(observer1);
        magazine1.add(observer2);
        magazine1.add(observer3);

        publisher.add(newspaper1);
        publisher.add(newspaper2);
        publisher.add(magazine1);

        publisher.published("");
    }
}
