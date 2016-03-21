/**
 * Created by Odsipov on 20.03.2016.
 */
public class Storage {
    private Ingridient[] ingridients;

    public Storage() {
        ingridients = new Ingridient[1];
    }

    public Storage(Ingridient ingridient) {
        ingridients = new Ingridient[1];
        ingridients[0] = ingridient;
    }

    public Storage(Ingridient[] ingridients) {
        this.ingridients = ingridients;
    }

    public void addIngridient(Ingridient ingridient) {
        for (Ingridient tmp:
             ingridients) {
            if (ingridient.getName().equals(tmp.getName())) {
                System.out.println("Curent ingridient is in storage.");
                return;
            }
        }

        Ingridient[] newIngridients = new Ingridient[ingridients.length+1];
        ingridients = newIngridients;
        ingridients[ingridients.length-1] = ingridient;
    }

    public Ingridient getIngridient(String ingrName) {
        int i = 0;

        while (i < ingridients.length && !ingrName.equals(ingridients[i].getName())) {
            i++;
        }
        if (i < ingridients.length) return ingridients[i];
        return null;
    }

    public double getIngridientCost(Ingridient ingridient) {
        int i = 0;

        while (i < ingridients.length && !ingridient.equals(ingridients[i])) {
            i++;
        }
        if (i < ingridients.length) return ingridients[i].getCost();
        return -1d;
    }

    public double getIngridientQuantity(Ingridient ingridient) {
        int i = 0;

        while (i < ingridients.length && !ingridient.equals(ingridients[i])) {
            i++;
        }
        if (i < ingridients.length) return ingridients[i].getQuantity();
        return -1d;
    }

    public double substractIngridient(Ingridient ingridient) {
        int i = 0;

        while (i < ingridients.length && !ingridient.equals(ingridients[i])) {
            i++;
        }
        if (i < ingridients.length) return ingridients[i].getQuantity();
        return -1d;
    }

}
