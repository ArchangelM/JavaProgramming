package observe;


public interface Subject {
    public void add(ObserverMy o);
    public void remove(ObserverMy o);
    public void notifyObservers(String event);
}
