package lesson1Tanks;

/**
 * Created by Rodichka on 29.02.2016.
 */
public class Tiger  extends Tank {
    private int armor;

    public Tiger() {
        super("чёрный", 4, 36, "км/ч", 24);
        armor = 1;
    }

    public Tiger(String color, int crew, int maxSpeed, String speedUnit, int armor, int directionDegrees) {
        super(color, crew, maxSpeed, speedUnit, directionDegrees);
        this.armor = armor;
    }

    public void printTankInfo() {
        super.printTankInfo ();
        System.out.println("Класс брони " + armor + ". ");

    }

    @Override
    public String toString() {
        String tigerIdent = "Тигр. " + super.toString() + ". Броня " + armor + ". ";
        return tigerIdent;
    }

    @Override
    public void move() {
        System.out.print(toString());
        System.out.println(" Тигр переместился в направлении " + super.getDirectionDegrees() + " градуса/ов.");
    }
}
