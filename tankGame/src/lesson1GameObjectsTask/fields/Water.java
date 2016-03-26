package lesson1GameObjectsTask.fields;

import lesson1GameObjectsTask.interfaces.UnMovable;

import java.awt.*;

/**
 * Created by Osipov on 26.03.2016.
 */
public class Water extends FieldCell implements UnMovable {
    //private Color color;

    public Water(int x, int y) {
        super (x, y);
        color = new Color(0, 200, 200);
    }
}
