package publish;


public class Newspaper extends Printed {
    @Override
    public void notifyObservers(String event) {
        super.notifyObservers("газета " + event);
    }
}
