package lesson1GameObjectsTask.fields;

import lesson1GameObjectsTask.interfaces.Drawable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;

import static lesson1GameObjectsTask.BattleField.PIXELS_IN_CELL;

public class FieldCell implements Drawable {
    protected int x;
    protected int y;

    protected String spriteFieldFileName;
    protected BufferedImage imgField;

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
        try {
            imgField = ImageIO.read(f);
        } catch (IOException e) {
            System.err.println("File " + spriteFieldFileName + " not found. " + e);
        }

    }

    @Override
    public void draw(Graphics g) {

        if(imgField != null) {
           g.drawImage(imgField, x, y, null);
        }
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

