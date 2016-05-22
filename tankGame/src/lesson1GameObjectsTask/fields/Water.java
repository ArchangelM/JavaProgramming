package lesson1GameObjectsTask.fields;

import lesson1GameObjectsTask.interfaces.UnMovable;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

import static lesson1GameObjectsTask.BattleField.PIXELS_IN_CELL;

/**
 * Created by Osipov on 26.03.2016.
 */
public class Water extends FieldCell implements UnMovable {
    //private Color color;

    public Water(int x, int y) {
        super (x, y);
        color = new Color(0, 200, 200);

        super.spriteFieldFileName = "sprites\\water64.jpg";
        super.loadSpriteField();
    }

    @Override
    public void draw(Graphics g) {

        if(imgField != null) {
            /*
                * Create a rescale filter op that makes the image
                * 50% opaque.
                */
            float[] scales = { 1f, 1f, 1f, 0.7f };
            float[] offsets = new float[4];
            RescaleOp rop = new RescaleOp(scales, offsets, null);
            int w = imgField.getWidth(null);
            int h = imgField.getHeight(null);
            BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics gi = bi.getGraphics();
            gi.drawImage(imgField, 0, 0, null);



            //g.drawImage(imgField, x, y, null);
            Graphics2D g2d = (Graphics2D)g;
            g2d.drawImage(bi, rop, x, y);

        }
        else {
            g.setColor(color);
            g.fillRect(x, y, PIXELS_IN_CELL, PIXELS_IN_CELL);
        }
    }


}
