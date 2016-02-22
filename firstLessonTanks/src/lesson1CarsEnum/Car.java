package lesson1CarsEnum;

/**
 * Created by Rodichka on 22.02.2016.
 */
public class Car {
    private Colors color;

    private String manufacturer;
    private String model;

    private double maxSpeed;
    private double curSpeed;

    private int direction;

    private double gpsLatitude;
    private double gpsLongitude;

    //Constructors
    public Car() {
        color = Colors.GREEN;
        manufacturer = "FORD";
        model = "Fiesta";

        gpsLatitude = 50.356107;
        gpsLongitude = 30.550393;
        direction = 0;
        maxSpeed = 200;
        curSpeed = 0;
    }

    public Car(Colors color, String manufacturer, String model) {
        this.color = color;
        this.manufacturer = manufacturer;
        this.model = model;

        gpsLatitude = 50.356107;
        gpsLongitude = 30.550393;
        direction = 0;
        maxSpeed = 200;
        curSpeed = 0;

    }

    //methods
    public void rePaint(Colors color) {
        System.out.println(this.color + " car is repainted in " + color);
        this.color = color;
    }

    public void moveTo(double gpsLatitude, double gpsLongitude) {
        System.out.println("The " + color + " car changes the coordinates to " + gpsLatitude + ", " + gpsLongitude);
        this.gpsLatitude = gpsLatitude;
        this.gpsLongitude = gpsLongitude;
    }

    public void changeDirection(int delta) {
        System.out.println("The " + color + " car changes direction on " + delta + " degrees.");
        direction += delta;

    }

    public void moveForward() {
        System.out.println("The " + color + " car moves in direction of " + direction + " degrees.");

    }

    public void moveBackward() {
        System.out.println("The " + color + " car moves in direction of " + (direction+180)+ " degrees.");

    }

    //getters & setters
    public Colors getColor() {
        return color;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getCurSpeed() {
        return curSpeed;
    }

    public void setCurSpeed(double curSpeed) {
        this.curSpeed = curSpeed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public double getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(double gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public double getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(double gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
