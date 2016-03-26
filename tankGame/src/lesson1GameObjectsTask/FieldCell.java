package lesson1GameObjectsTask;

import static lesson1GameObjectsTask.BattleField.PIXELS_IN_CELL;

/**
 * Created by Osipov on 26.03.2016.
 */
public class FieldCell {
    protected int x;
    protected int y;

    public FieldCell() {
    }

    public FieldCell(int v, int h) {
        x = h * PIXELS_IN_CELL;
        y = v * PIXELS_IN_CELL;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
