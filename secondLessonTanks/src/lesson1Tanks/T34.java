package lesson1Tanks;

/**
 * Created by Rodichka on 29.02.2016.
 */
public class T34 extends Tank {
    public T34() {
        super("зелёный", 4, 50, "км/ч", 156);
    }

    public T34(String color, int crew, int maxSpeed, String speedUnit, int directionDegrees) {
        super(color, crew, maxSpeed, speedUnit, directionDegrees);
    }

    @Override
    public String toString() {
        String t34Ident = " Т34. " + super.toString();
        return t34Ident;
    }

    @Override
    public void move() {
        System.out.print(toString());
        super.move();
    }
}
