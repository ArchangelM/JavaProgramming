package lesson1GameObjectsTask;

import java.awt.*;

/**
 * Created by Osipov on 07.03.2016.
 */
public class BT7 extends AbstractTank {
    public BT7(ActionField af, BattleField bf) {
        this(af, bf, 128, 512, Direction.UP);
    }

    public BT7(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        speed /= 2;
        color = new Color(0, 255, 0);
    }

    public BT7(ActionField af, BattleField bf, String coord, Direction direction) {
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
