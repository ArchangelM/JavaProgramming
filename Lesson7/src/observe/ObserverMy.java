package observe;


import java.util.Observable;
import java.util.Observer;

public class ObserverMy implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(o.toString() + " Вас ожидает " + arg);
    }


}
