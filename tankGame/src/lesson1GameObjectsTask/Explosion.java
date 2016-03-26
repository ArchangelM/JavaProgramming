package lesson1GameObjectsTask;

import java.awt.*;

import static lesson1GameObjectsTask.BattleField.PIXELS_IN_CELL;

/**
 * Created by Osipov on 26.03.2016.
 */
public class Explosion extends FieldCell{

    public Explosion(int x, int y) {
        super (x, y);
        color = new Color(250, 160, 40);
    }
/*
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, PIXELS_IN_CELL, PIXELS_IN_CELL);
    }
*/

}
