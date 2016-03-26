/**
 * Created by Osipov on 21.02.2016.
 */
package lesson1GameObjectsTask;

import java.awt.*;
import java.util.Random;

public class BattleField implements Drawable {
    private final int BF_WIDTH = 576;
    private final int BF_HEIGHT = 576;

    final static int PIXELS_IN_CELL = 64;

    final static int X_MAX = 8;
    final static int Y_MAX = 8;

    final String DESTRUCTABLE = "BCE"; //коды разрушаемых объектов: кирпич, танк компьютера, штаб
    final String UN_DESTRUCTABLE = "WS"; //коды не разрушаемых объектов: вода, камни

    private FieldCell[][] battleFieldCell;

    private String[][] battleField = {
            {"B", "B", " ", "B", "W", "B", " ", "B", "B"},
            {"B", " ", " ", "B", "W", "B", " ", " ", "B"},
            {"G", "G", " ", " ", "W", " ", " ", " ", " "},
            {"B", "B", "B", " ", " ", " ", "B", "B", "B"},
            {"B", " ", "B", "B", "B", "B", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " "},
            {"B", "G", "G", " ", " ", " ", " ", "B", "B"},
            {"B", "B", "B", "B", " ", "B", "B", "B", "B"},
            {"B", " ", " ", " ", "E", "B", " ", "B", "B"}
    };

    public BattleField() {
        battleFieldCell = new FieldCell[X_MAX+1][Y_MAX+1];
        Utils.Init(battleFieldCell, battleField);

    }

    @Override
    public void draw(Graphics g) {
        for (int i = 0; i < battleFieldCell.length; i++) {
            for (int j = 0; j < battleFieldCell[i].length; j++) {
                battleFieldCell[i][j].draw(g);
            }
        }
    }

    /*
        boolean isQuadrantDestructable(int[] quadrantCoord) {
            if (DESTRUCTABLE.indexOf(battleField[quadrantCoord[QY]][quadrantCoord[QX]]) >= 0) {
                return true;
            }
            else {
                return false;
            }
        }

        boolean isQuadrantDestructable(int x, int y) {
            if (x <= X_MAX && y <= Y_MAX && DESTRUCTABLE.indexOf(battleField[y][x]) >= 0) {
                return true;
            }
            else {
                return false;
            }
        }
    */
    boolean isQuadrantDestructable(int x, int y) {
        if (x <= X_MAX && y <= Y_MAX && battleFieldCell[y][x] instanceof Destroyable) {
            return true;
        }
        else {
            return false;
        }
    }

    String getQuadrantNum(int x, int y) {
        String horisontalCode = "123456789";
        String verticalCode = "abcdefghi";

        x = x / PIXELS_IN_CELL;
        y /= PIXELS_IN_CELL;

        String horizontal, vertical;

        if (x >= 0 && x <= horisontalCode.length()) {
            horizontal = horisontalCode.substring(x, x+1);
        }
        else {
            horizontal = "Ошибка";
        }

        if (y >= 0 && y <= verticalCode.length()) {
            vertical = verticalCode.substring(y, y+1);
        }
        else {
            vertical = "Ошибка";
        }

        return vertical+horizontal;

    }

    int getQuadrantV(int y) {
        return y/PIXELS_IN_CELL;
    }

    int getQuadrantH(int x) {
        return x/PIXELS_IN_CELL;
    }

    int getDifferenceH(int curH, int finishH) {
        if (finishH < 0 || finishH > X_MAX) return 0;
        else return finishH - curH;

    }

    int getDifferenceV(int curV,int finishV) {
        if (finishV < 0 || finishV > Y_MAX) return 0;
        else return finishV - curV;

    }

    public String getRandomLocationAggressor() {
        Random r = new Random();
        int randomPlace = r.nextInt(3);

        return "64_64"; //for test
/*
        switch (randomPlace) {
            case 0:
                return "128_0";
            case 1:
                return "384_0";
            case 2:
                return "64_64";
        }

        return "128_0";
        */
    }

/*
    public BattleField(String [][] battleField) {
        this.battleField = battleField;
    }
/*
    public String scanQuadrant(int qx, int qy) {
        return battleField[qx][qy];
    }

    public String scanQuadrantScreenCoords(int x, int y) {
        return battleField[getQuadrantH(x)][getQuadrantV(y)];
    }

    public void updateQuadrant(int qx, int qy, String newField) {
        battleField[qx][qy] = newField;
    }
*/

    public FieldCell scanQuadrant(int qx, int qy) {
    return battleFieldCell[qx][qy];
}

    public FieldCell scanQuadrantScreenCoords(int x, int y) {
        return battleFieldCell[getQuadrantH(x)][getQuadrantV(y)];
    }

    public void updateQuadrant(int qx, int qy, FieldCell newField) {
        battleFieldCell[qx][qy] = newField;
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
