package lesson1GameObjectsTask.fields;

import lesson1GameObjectsTask.interfaces.Destroyable;

import java.awt.*;

/**
 * Created by Osipov on 26.03.2016.
 */
public class Brick extends FieldCell implements Destroyable {

    public Brick(int x, int y) {
        super (x, y);
        color = new Color(0, 0, 255);
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
