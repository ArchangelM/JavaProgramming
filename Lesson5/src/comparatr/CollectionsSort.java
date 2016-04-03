package comparatr;

import java.util.ArrayList;

/**
 * Created by Osipov on 03.04.2016.
 */
public class CollectionsSort {
    public void collectionsSort(ArrayList<String> list, Comparator strCmp){
        for(int i = 0;i < list.size()-1;i++) {
            int j;
            int maxIndex = i;
            String max = list.get(i);

            for(j = i+1;j < list.size();j++) {
                if (strCmp.compare(max, list.get(j)) > 0) {
                    max = list.get(j);
                    maxIndex = j;
                }
            }

            if(maxIndex != i) {
               elementChange(list, i, maxIndex);
            }
        }
    }

    public void elementChange(ArrayList<String> list, int first, int second) {
        String tmp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, tmp);
    }
}
