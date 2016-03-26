package lesson1GameObjectsTask.tanks;

import lesson1GameObjectsTask.AbstractTank;
import lesson1GameObjectsTask.ActionField;
import lesson1GameObjectsTask.BattleField;
import lesson1GameObjectsTask.Direction;

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
        towerColor = new Color(255, 0, 0);
    }

    public BT7(ActionField af, BattleField bf, String coord, Direction direction) {
        this(af, bf, Integer.parseInt(coord.split("_")[0]), Integer.parseInt(coord.split("_")[1]), direction);
    }


}
