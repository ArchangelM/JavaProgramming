package observe;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;


public class Publisher {
    private List<Newspaper> newspapers;
    private List<Magazine> magazines;
    //надобы на Хеш мапы переделать

    public Publisher() {
        newspapers = new ArrayList<>();
        magazines = new ArrayList<>();
    }

    public void add(Newspaper newspaper) {
        newspapers.add(newspaper);
    }


    public void add(Magazine magazine) {
        magazines.add(magazine);
    }

    public void published(String name) {
        //Заглушка
        magazines.get(0).setPublishingDate(new GregorianCalendar().getTime());
        //setChanged();
        //magazines.get(0).notifyObservers(name);
        magazines.get(0).notification();
    }
}
