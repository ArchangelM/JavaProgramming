/**
 * Created by Rodichka on 21.03.2016.
 */
public class GoodIngridient {
    private Ingridient ingridient;
    private int count;
    private double price;
    private double weight;

    public GoodIngridient(Ingridient ingridient, int count) {
        this.ingridient = ingridient;
        this.count = count;

        price = count*ingridient.getCost();
        weight = count*ingridient.getSaleUnit();
    }

    public Ingridient getIngridient() {
        return ingridient;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setIngridient(Ingridient ingridient) {
        this.ingridient = ingridient;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
