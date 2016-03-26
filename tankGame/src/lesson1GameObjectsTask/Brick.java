package lesson1GameObjectsTask;

import java.awt.*;
import static lesson1GameObjectsTask.BattleField.PIXELS_IN_CELL;

/**
 * Created by Osipov on 26.03.2016.
 */
public class Brick extends FieldCell implements Destroyable, Drawable {
    private Color color;

    public Brick(int x, int y) {
        super (x, y);
        color = new Color(0, 0, 255);
    }


    @Override
    public boolean destroy() throws Exception {
        return false;
    }

    @Override
    public boolean stricken() throws Exception {
        return false;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, PIXELS_IN_CELL, PIXELS_IN_CELL);
    }
}
