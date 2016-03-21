/**
 * Created by Osipov on 20.03.2016.
 */
public class Ingridient {
    private String name;
    private double quantity;
    private double saleUnit;
    private double cost;

    private String currency;
    private String unit;


    public Ingridient() {
        currency = "UAH";
        unit = "gram";
    }

    public Ingridient(String name, double quantity, double cost, double saleUnit, String currency, String unit) {
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
        this.saleUnit = saleUnit;
        this.currency = currency;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getSaleUnit() {
        return saleUnit;
    }

    public void setSaleUnit(double saleUnit) {
        this.saleUnit = saleUnit;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
