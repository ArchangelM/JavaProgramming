package lesson1GameObjectsTask.fields;

import lesson1GameObjectsTask.interfaces.Drawable;

import java.awt.*;

import static lesson1GameObjectsTask.BattleField.PIXELS_IN_CELL;

/**
 * Created by Osipov on 26.03.2016.
 */
public class FieldCell implements Drawable {
    protected int x;
    protected int y;

    protected Color color;

    public FieldCell() {
        color = new Color(180, 180, 180);
    }

    public FieldCell(int v, int h) {
        x = h * PIXELS_IN_CELL;
        y = v * PIXELS_IN_CELL;

        color = new Color(180, 180, 180);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, PIXELS_IN_CELL, PIXELS_IN_CELL);
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
