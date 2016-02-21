/**
 * Created by Rodichka on 21.02.2016.
 */
package lesson1GameObjectsTask;

public class BattleField {
    private final int BF_WIDTH = 576;
    private final int BF_HEIGHT = 576;

    final static int PIXELS_IN_CELL = 64;

    private String[][] battleField = {
            {"B", "B", " ", "B", " ", "B", " ", "B", "B"},
            {"B", " ", " ", "B", " ", "B", " ", " ", "B"},
            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
            {"B", "B", "B", " ", " ", " ", "B", "B", "B"},
            {"B", " ", "B", "B", "B", "B", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
            {"B", " ", " ", " ", " ", " ", " ", "B", "B"},
            {"B", "B", " ", "B", " ", "B", "B", "B", "B"},
            {"B", " ", "B", " ", " ", "B", " ", "B", "B"}
    };

    public BattleField() {

    }

    public BattleField(String [][] battleField) {
        this.battleField = battleField;
    }

    public String scanQuadrant(int qx, int qy) {
        return battleField[qx][qy];
    }

    public void updateQuadrant(int qx, int qy, String newField) {
        battleField[qx][qy] = newField;
    }

    public int getDimentionX() {
        return  BF_WIDTH/PIXELS_IN_CELL;
    }

    public int getDimentionY() {
        return  BF_HEIGHT/PIXELS_IN_CELL;
    }

    //getters & setters
    public int getBF_WIDTH() {
        return BF_WIDTH;
    }

    public int getBF_HEIGHT() {
        return BF_HEIGHT;
    }

}
