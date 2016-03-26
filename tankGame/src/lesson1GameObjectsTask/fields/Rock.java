package lesson1GameObjectsTask.fields;

import lesson1GameObjectsTask.fields.FieldCell;
import lesson1GameObjectsTask.interfaces.Destroyable;

import java.awt.*;

/**
 * Created by Rodichka on 26.03.2016.
 */
public class Rock extends FieldCell implements Destroyable {

    public Rock(int x, int y) {
        super (x, y);
        color = new Color(0, 0, 0);
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
