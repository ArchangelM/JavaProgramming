package lesson1GameObjectsTask.fields;

import lesson1GameObjectsTask.interfaces.Destroyable;

import java.awt.*;

/**
 * Created by Osipov on 26.03.2016.
 */
public class Eagle extends FieldCell implements Destroyable {

    public Eagle(int x, int y) {
        super (x, y);
        color = new Color(200, 0, 200);

        super.spriteFieldFileName = "sprites\\eagle64.jpg";
        super.loadSpriteField();
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
