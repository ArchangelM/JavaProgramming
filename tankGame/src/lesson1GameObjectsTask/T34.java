package lesson1GameObjectsTask;

/**
 * Created by Osipov on 20.03.2016.
 */
public class T34 extends AbstractTank {
    public T34(ActionField af, BattleField bf) {
        this(af, bf, 128, 512, Direction.UP);
    }

    public T34(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
    }

    public T34(ActionField af, BattleField bf, String coord, Direction direction) {
        this(af, bf, Integer.parseInt(coord.split("_")[0]), Integer.parseInt(coord.split("_")[1]), direction);
    }
}
