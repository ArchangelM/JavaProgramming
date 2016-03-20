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
}
