package comparator;

import comparatr.CollectionsSort;
import comparatr.Comparator;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Osipov on 03.04.2016.
 */
public class LauncherComparator1 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> lst = new ArrayList<>();

        lst.add(0, "sksajldf");
        lst.add(1, "aksajldf");
        lst.add(2, "zksajldf");
        lst.add(3, "sksajldf");
        lst.add(4, "vksajldf");
        lst.add(5, "nksajldf");
        lst.add(6, "mksajldf");
        lst.add(7, "kksajldf");
        lst.add(8, "1ksajldf");
        lst.add(9, "eksajldf");

        Collections.sort(lst);

        for (String cur:
                lst) {
            System.out.println(": " + cur);
        }

        System.out.println("");

        Collections.sort(lst, new Comparator());

        for (String cur:
             lst) {
            System.out.println(": " + cur);
        }

    }
}
