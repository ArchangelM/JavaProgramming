package publish;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Printed implements Subject{

    private String name;
    private List<Observer> observers;
    private Date publishingDate;


    public Printed() {
        observers = new ArrayList<>();
    }

    public Printed(String name) {
        observers = new ArrayList<>();
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void add(Observer o) {
        observers.add(o);
    }

    @Override
    public void remove(Observer o) {
        observers.remove(o);

    }

    @Override
    public void notifyObservers(String event) {
        for (Observer observer: observers
             ) {
            observer.update(event + name);
        }
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }
}
