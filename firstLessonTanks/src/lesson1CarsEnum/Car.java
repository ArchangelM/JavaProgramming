package lesson1CarsEnum;

/**
 * Created by Rodichka on 22.02.2016.
 */
public class Car {
    private Colors color;

    private String manufacturer;
    private String model;

    public Car(Colors color, String manufacturer, String model) {
        this.color = color;
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public Colors getColor() {
        return color;
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
