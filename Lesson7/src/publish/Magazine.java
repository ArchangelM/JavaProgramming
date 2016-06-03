package publish;


public class Magazine extends Printed {
    @Override
    public void notifyObservers(String event) {
        super.notifyObservers("журнал " + event);
    }
}
