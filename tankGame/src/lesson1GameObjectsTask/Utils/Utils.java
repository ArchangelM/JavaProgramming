package lesson1GameObjectsTask.Utils;

import lesson1GameObjectsTask.fields.*;

/**
 * Created by Odsipov on 26.03.2016.
 */
public class Utils {

    public static void Init(FieldCell[][] battleField, String[][] battleFieldS) {

        for(int i = 0;i < battleFieldS.length;i++) {
            for(int j = 0;j < battleFieldS[i].length;j++) {
                if (battleFieldS[i][j].equals("B")) {
                    battleField[i][j] = new Brick(i, j);

                }  else if (battleFieldS[i][j].equals("G")) {
                    battleField[i][j] = new Grass(i, j);

                } else if (battleFieldS[i][j].equals("W")) {
                    battleField[i][j] = new Water(i, j);

                } else if (battleFieldS[i][j].equals("E")) {
                    battleField[i][j] = new Eagle(i, j);

                } else {
                    battleField[i][j] = new FieldCell(i, j);
                }
            }
        }
    }
}
