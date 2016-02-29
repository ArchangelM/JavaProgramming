package lesson1Tanks;

/**
 * Created by Rodichka on 29.02.2016.
 */
public class Tiger  extends Tank {
    private int armor;

    public Tiger() {
        super("а", 4, 36, "км/ч");
        armor = 1;
    }

    public Tiger(String color, int crew, int maxSpeed, String speedUnit, int armor) {
        super(color, crew, maxSpeed, speedUnit);
        this.armor = armor;
    }


}
