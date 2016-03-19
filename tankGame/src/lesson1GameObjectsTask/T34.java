package lesson1GameObjectsTask;

import java.awt.*;

/**
 * Created by Osipov on 20.03.2016.
 */
public class T34 extends AbstractTank {
    public T34(ActionField af, BattleField bf) {
        this(af, bf, 128, 512, Direction.UP);
    }

    public T34(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        color = new Color(0, 255, 0);
    }

    public T34(ActionField af, BattleField bf, String coord, Direction direction) {
        this(af, bf, Integer.parseInt(coord.split("_")[0]), Integer.parseInt(coord.split("_")[1]), direction);
    }

    public void draw(Graphics g) {
        // boolean tmp = battleField.scanQuadrantScreenCoords(mainTank.getX(), mainTank.getY()).equals("X");

        if (!isDestroyed()) {
            if (!battleField.scanQuadrantScreenCoords(x, y).equals("X")) {
                g.setColor(color);
                g.fillRect(x, y, BattleField.PIXELS_IN_CELL, BattleField.PIXELS_IN_CELL);

                g.setColor(new Color(255, 0, 0));
                if (direction == Direction.UP) {
                    g.fillRect(x + 20, y, 24, 34);
                } else if (direction == Direction.DOWN) {
                    g.fillRect(x + 20, y + 30, 24, 34);
                } else if (direction == Direction.LEFT) {
                    g.fillRect(x, y + 20, 34, 24);
                } else {
                    g.fillRect(x + 30, y + 20, 34, 24);
                }
            }
        }
    }
}
