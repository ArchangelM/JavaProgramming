package lesson1Tanks;

/**
 * Created by Rodichka on 29.02.2016.
 */
public class Tank {
    private String color;
    private int crew;
    private int maxSpeed;
    private String speedUnit;

    private int directionDegrees;

    public  Tank() {
        this("маскировка", 3, 30, "км/ч", 123);
    }

    public Tank(String color, int crew, int maxSpeed, String speedUnit, int directionDegrees) {
        this.color = color;
        this.crew = crew;
        this.setMaxSpeed(maxSpeed);
        this.speedUnit = speedUnit;

        this.directionDegrees = directionDegrees;
    }

    public void printTankInfo() {
        System.out.println("Танк цвета " + color + ". ");
        System.out.println("Экипаж составляет " + crew + " человека. ");
        System.out.println("Максимальная скорость " + maxSpeed + " " + speedUnit + ".");
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public int getCrew() {
        return crew;
    }

    public void setMaxSpeed(int maxSpeed) {
        if (maxSpeed > 200) this.maxSpeed = 200;
        else this.maxSpeed = maxSpeed;
    }

    public void move() {
        System.out.print(toString());
        System.out.println(" Танк переместился в направлении " + directionDegrees + " градуса/ов.");
    }

    @Override
    public String toString() {
        String tankIdent = color + " танк c экипажем " + crew + " человека. Развивает макс скорость: " + maxSpeed;
        return tankIdent;
    }


    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setSpeedUnit(String speedUnit) {
        this.speedUnit = speedUnit;
    }

    public String getSpeedUnit() {
        return speedUnit;
    }

    public int getDirectionDegrees() {
        return directionDegrees;
    }
}
