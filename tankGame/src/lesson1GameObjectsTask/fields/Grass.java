package lesson1GameObjectsTask.fields;

import java.awt.*;

/**
 * Created by Osipov on 26.03.2016.
 */
public class Grass extends FieldCell {

    public Grass(int x, int y) {
        super(x, y);
        color = new Color(0, 255, 0);

        super.spriteFieldFileName = "sprites\\grass64.jpg";
        super.loadSpriteField();
    }

}
