package observe;

import day9f11.jdkone.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

public class Printed extends Observable {

    private String name;
    private Date publishingDate;


    public Printed() {

    }

    public Printed(String name) {

        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void notification() {
        setChanged();
        notifyObservers(new ActionEvent(null));
    }


    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }
}
