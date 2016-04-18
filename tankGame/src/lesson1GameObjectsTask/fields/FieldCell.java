package lesson1GameObjectsTask.fields;

import lesson1GameObjectsTask.interfaces.Drawable;

import javax.swing.*;
import java.awt.*;
import java.io.File;

import static lesson1GameObjectsTask.BattleField.PIXELS_IN_CELL;

/**
 * Created by Osipov on 26.03.2016.
 */
public class FieldCell implements Drawable {
    protected int x;
    protected int y;

    protected String spriteFieldFileName;
    protected Image imgField;

    protected Color color;

    public FieldCell() {
        color = new Color(180, 180, 180);
    }

    public FieldCell(int v, int h) {
        x = h * PIXELS_IN_CELL;
        y = v * PIXELS_IN_CELL;

        color = new Color(180, 180, 180);
    }

    public void loadSpriteField() {
        File f = new File(spriteFieldFileName);
        if (f.exists())	imgField = new ImageIcon(spriteFieldFileName).getImage();
    }

    @Override
    public void draw(Graphics g) {

        if(imgField != null) g.drawImage(imgField, x, y, null);
        else {
            g.setColor(color);
            g.fillRect(x, y, PIXELS_IN_CELL, PIXELS_IN_CELL);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
