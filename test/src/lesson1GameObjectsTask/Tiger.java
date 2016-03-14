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

    public Tiger(ActionField af, BattleField bf, String coord, Direction direction) {
        this(af, bf, Integer.parseInt(coord.split("_")[0]), Integer.parseInt(coord.split("_")[1]), direction);
    }

    @Override
    public boolean destroy() throws Exception {
        return super.destroy();
    }

    @Override
    public boolean stricken() throws Exception {
        if(armor > 0) {
            armor --;
            System.out.println("Попадание в тигр!");
            return false;
        }
        else return super.destroy();
    }
}
