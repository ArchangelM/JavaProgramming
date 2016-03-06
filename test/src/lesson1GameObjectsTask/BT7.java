package lesson1GameObjectsTask;

/**
 * Created by Osipov on 07.03.2016.
 */
public class BT7 extends Tank {
    public BT7(ActionField af, BattleField bf) {
        this(af, bf, 128, 512, Direction.UP);
    }

    public BT7(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        speed /= 2;
    }
}
