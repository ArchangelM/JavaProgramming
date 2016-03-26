package lesson1GameObjectsTask;

/**
 * Created by Rodichka on 26.03.2016.
 */
public class Utils {

    public static void Init(FieldCell[][] battleField, String[][] battleFieldS) {

        for(int i = 0;i < battleFieldS.length;i++) {
            for(int j = 0;j < battleFieldS[i].length;j++) {
                if (battleFieldS[i][j].equals("B")) {
                    battleField[i][j] = new Brick(j, i);

                }  else if (battleFieldS[i][j].equals("G")) {
                    battleField[i][j] = new Grass(j, i);

                } else if (battleFieldS[i][j].equals("W")) {
                    battleField[i][j] = new Water(j, i);

                } else if (battleFieldS[i][j].equals("E")) {
                    battleField[i][j] = new Eagle(j, i);

                }
            }
        }
    }
}
