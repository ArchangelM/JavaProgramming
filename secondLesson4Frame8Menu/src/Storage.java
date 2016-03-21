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

    public Ingridient[] getIngridients() {
        return ingridients;
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
        Ingridient ingrTmp= isIngridientInStorage(ingridient);

        if (ingrTmp != null) return ingrTmp.getCost();
        return -1d;
    }

    public double getIngridientQuantity(Ingridient ingridient) {
        Ingridient ingrTmp= isIngridientInStorage(ingridient);

        if (ingrTmp != null) return ingrTmp.getQuantity();
        return -1d;
    }

    public void substractIngridient(Ingridient ingridient, double count) {
        Ingridient ingrTmp= isIngridientInStorage(ingridient);

        if (ingrTmp != null) {
            double quantity = ingrTmp.getQuantity();
            if (quantity >= count) {
                ingrTmp.setQuantity(quantity - count);
            } else {
                System.out.println("Not enoth " + ingrTmp.getName());
            }
        } else {
            System.out.println("Ingridient " + ingridient.getName() + " not found.");
        }

    }

    public Ingridient isIngridientInStorage(Ingridient ingridient) {
        for (Ingridient tmp:
                ingridients) {
            if (tmp.equals(ingridient)) {
                return tmp;
            }
        }
        return null;
    }

    public Ingridient isIngridientInStorage(String ingrName) {
        for (Ingridient tmp:
                ingridients) {
            if (ingrName.equals(tmp.getName())) {
                return tmp;
            }
        }
        return null;
    }

}
