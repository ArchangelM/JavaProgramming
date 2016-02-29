package lesson1Tanks;

/**
 * Created by Rodichka on 29.02.2016.
 */
public class T34 extends Tank {
    public T34() {
        super("маскировка", 4, 50, "км/ч");
    }

    public T34(String color, int crew, int maxSpeed, String speedUnit) {
        super(color, crew, maxSpeed, speedUnit);
    }
}
