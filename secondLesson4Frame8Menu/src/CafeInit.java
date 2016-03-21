/**
 * Created by Osipov on 21.03.2016.
 */
public class CafeInit {

   // public void storageInit(Ingridient[] ingridients){
   public Ingridient[] storageInit(){
       Ingridient[] ingridients = new Ingridient[8];

        ingridients[0] = new Ingridient("Water", 20*1000d, 0.5/10, 100d, "UAH", "gram");
        ingridients[1] = new Ingridient("Coffee", 500, 5d, 5d, "UAH", "gram");
        ingridients[2] = new Ingridient("Black tea", 100d, 0.45, 1d, "UAH", "gram");
        ingridients[3] = new Ingridient("Green tea", 50d, 0.8, 1d, "UAH", "gram");
        ingridients[4] = new Ingridient("Sugar", 100d, 0.1, 5d, "UAH", "gram");
        ingridients[5] = new Ingridient("Milk", 1000d, 1d, 50d, "UAH", "gram");
        ingridients[6] = new Ingridient("Berhamot", 15d, 5.0, 1d, "UAH", "gram");
        ingridients[7] = new Ingridient("Icecream", 2000, 10, 50d, "UAH", "gram");

       return ingridients;
    }

    public void menuInit(Offer[] offers, Ingridient[] ingridients){
        offers[0] = new Offer("Black Coffee", receptBlackCoffee(ingridients), 3);
        offers[1] = new Offer("Coffee americano", receptCoffeaAmericano(ingridients), 3);
        offers[2] = new Offer("Cappuchino", receptCappuchino(ingridients), 3);
        offers[3] = new Offer("Moccachino", receptMoccachino(ingridients), 3);
        offers[4] = new Offer("Coffee with milk", receptCoffeeMilk(ingridients), 3);
        offers[5] = new Offer("Black tea", receptBlackTea(ingridients), 3);
        offers[6] = new Offer("Green tea", receptGreenTea(ingridients), 3);
        offers[7] = new Offer("Tea with berhamout", receptTeaBerhamout(ingridients), 3);
    }

    public GoodIngridient[] receptBlackCoffee(Ingridient[] ingridients){
        GoodIngridient[] composition = new GoodIngridient[3];

        composition[0] = new GoodIngridient(ingridients[0], 1);
        composition[1] = new GoodIngridient(ingridients[1], 1);
        composition[2] = new GoodIngridient(ingridients[4], 2);

        return composition;
    }

    public GoodIngridient[] receptCoffeaAmericano(Ingridient[] ingridients){
        GoodIngridient[] composition = new GoodIngridient[3];

        composition[0] = new GoodIngridient(ingridients[0], 2);
        composition[1] = new GoodIngridient(ingridients[1], 1);
        composition[2] = new GoodIngridient(ingridients[4], 2);

        return composition;
    }

    public GoodIngridient[] receptCappuchino(Ingridient[] ingridients){
        GoodIngridient[] composition = new GoodIngridient[4];

        composition[0] = new GoodIngridient(ingridients[0], 1);
        composition[1] = new GoodIngridient(ingridients[1], 1);
        composition[2] = new GoodIngridient(ingridients[4], 2);
        composition[3] = new GoodIngridient(ingridients[5], 1);

        return composition;
    }

    public GoodIngridient[] receptMoccachino(Ingridient[] ingridients){
        GoodIngridient[] composition = new GoodIngridient[4];

        composition[0] = new GoodIngridient(ingridients[0], 1);
        composition[1] = new GoodIngridient(ingridients[1], 1);
        composition[2] = new GoodIngridient(ingridients[4], 2);
        composition[3] = new GoodIngridient(ingridients[7], 2);

        return composition;
    }

    public GoodIngridient[] receptCoffeeMilk(Ingridient[] ingridients){
        GoodIngridient[] composition = new GoodIngridient[4];

        composition[0] = new GoodIngridient(ingridients[0], 1);
        composition[1] = new GoodIngridient(ingridients[1], 1);
        composition[2] = new GoodIngridient(ingridients[4], 2);
        composition[3] = new GoodIngridient(ingridients[7], 1);

        return composition;
    }

    public GoodIngridient[] receptBlackTea(Ingridient[] ingridients){
        GoodIngridient[] composition = new GoodIngridient[3];

        composition[0] = new GoodIngridient(ingridients[0], 2);
        composition[1] = new GoodIngridient(ingridients[2], 1);
        composition[2] = new GoodIngridient(ingridients[4], 2);

        return composition;
    }

    public GoodIngridient[] receptGreenTea(Ingridient[] ingridients){
        GoodIngridient[] composition = new GoodIngridient[3];

        composition[0] = new GoodIngridient(ingridients[0], 2);
        composition[1] = new GoodIngridient(ingridients[3], 1);
        composition[2] = new GoodIngridient(ingridients[4], 2);

        return composition;
    }

    public GoodIngridient[] receptTeaBerhamout(Ingridient[] ingridients){
        GoodIngridient[] composition = new GoodIngridient[4];

        composition[0] = new GoodIngridient(ingridients[0], 1);
        composition[1] = new GoodIngridient(ingridients[2], 1);
        composition[2] = new GoodIngridient(ingridients[4], 2);
        composition[3] = new GoodIngridient(ingridients[6], 1);

        return composition;
    }
}
