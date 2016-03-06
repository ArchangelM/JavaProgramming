package lesson1GameObjectsTask;

/**
 * Created by Osipov on 07.03.2016.
 */
public class Tiger extends Tank {
    private int armor;

    public Tiger(ActionField af, BattleField bf) {
        this(af, bf, 128, 512, Direction.UP);
    }

    public Tiger(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        armor = 1;
    }
}
