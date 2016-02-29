package lesson1Tanks;

/**
 * Created by Rodichka on 29.02.2016.
 */
public class BT7 extends Tank {
    public BT7() {
        super("белый", 3, 72, "км/ч", 180);
    }

    public BT7(String color, int crew, int maxSpeed, String speedUnit, int directionDegrees) {
        super(color, crew, maxSpeed, speedUnit, directionDegrees);
    }

    @Override
    public String toString() {
        String bt7Ident = "БТ7. " + super.toString();
        return bt7Ident;
    }

    @Override
    public void move() {
        System.out.print(toString());
        System.out.println(" Тигр переместился в направлении " + getDirectionDegrees() + " градуса/ов.");
    }

    @Override
    public int getDirectionDegrees() {
        return super.getDirectionDegrees();
    }
}
