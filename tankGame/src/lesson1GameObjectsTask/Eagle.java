package lesson1GameObjectsTask;

import java.awt.*;
import static lesson1GameObjectsTask.BattleField.PIXELS_IN_CELL;

/**
 * Created by Osipov on 26.03.2016.
 */
public class Eagle extends FieldCell implements Destroyable {

    public Eagle(int x, int y) {
        super (x, y);
        color = new Color(200, 0, 200);
    }


    @Override
    public boolean destroy() throws Exception {
        return false;
    }

    @Override
    public boolean stricken() throws Exception {
        return false;
    }

}
