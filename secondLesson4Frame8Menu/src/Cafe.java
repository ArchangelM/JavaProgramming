/**
 * Created by Rodichka on 21.03.2016.
 */
public class Cafe {
    private Storage storage;
    private Offer[] menu;
    private CafeInit cafeInit;

    public Cafe() {
        cafeInit = new CafeInit();
        storage = new Storage(cafeInit.storageInit());
        menu  = new Offer[8];
        cafeInit.menuInit(menu, storage.getIngridients());

        System.out.println("It`s alive!!!");

    }
}
