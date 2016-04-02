package comparatr;

/**
 * Created by Osipov on 03.04.2016.
 */
public class Comparator implements java.util.Comparator<String> {

    @Override
    public int compare(String str1, String str2) {
        if (str1.equals(str2)) return 0;
        return 1;
    }
}
