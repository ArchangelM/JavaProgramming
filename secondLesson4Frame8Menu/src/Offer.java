/**
 * Created by Osipov on 20.03.2016.
 */
public class Offer {
    private String name;
    private GoodIngridient[] composition;

    private double price;
    private double weight;
    private double markUp;

    public Offer() {
    }

    public Offer(String name, GoodIngridient[] composition, double markUp) {
        this.name = name;
        this.composition = composition;
        this.markUp = markUp;
        priceCount();
        weightCount();

    }

    private void weightCount() {
        weight = 0;
        for (GoodIngridient ingridient :
                composition) {
            weight += ingridient.getWeight();
        }

    }

    private void priceCount() {
        price = 0;
        for (GoodIngridient ingridient :
                composition) {
            price += ingridient.getPrice();
        }

        price *= markUp;
    }

    public void addGoodIngridient(GoodIngridient goodIngridient) {

        GoodIngridient ingridient = ingridientInRecept(goodIngridient.getIngridient());
        if (ingridient == null){
            GoodIngridient[] newIngridients = new GoodIngridient[composition.length+1];
            reWrite(newIngridients);
            composition = newIngridients;
            composition[composition.length-1] = goodIngridient;
        } else {
            ingridient.setCount(goodIngridient.getCount());
        }

    }

    public GoodIngridient ingridientInRecept(Ingridient ingridient) {
        for (GoodIngridient tmp:
                composition) {
            if (tmp.getIngridient().equals(ingridient)) {
                return tmp;
            }
        }
        return null;
    }

    public void reWrite(GoodIngridient[] ingridients) {
        int i = 0;
        for (GoodIngridient tmp :
                composition) {
            ingridients[i++] = tmp;
        }
    }
}
