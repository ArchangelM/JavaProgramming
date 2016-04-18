package lesson1GameObjectsTask.fields;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by Osipov on 26.03.2016.
 */
public class Explosion extends FieldCell {
    //private final String spriteExplosionFileName = "sprites\\explosione64.jpg";
   // private Image imgExplosione;

    public Explosion(int x, int y) {
        super (x, y);
        color = new Color(250, 160, 40);

        super.spriteFieldFileName ="sprites\\explosione64.png";
        super.loadSpriteField();
    }
/*
    private void loadSprite() {
        File f = new File(spriteExplosionFileName);
        if (f.exists()) imgExplosione= new ImageIcon(spriteExplosionFileName).getImage();
    }
*/

}
