package shapes;

import java.awt.*;

/**
 * Created by Osipov on 16.03.2016.
 */
public abstract class AbstractShape implements Drawable {
    protected Color color;
    protected Stroke stroke;
    protected int shapeDepth;

   // public abstract void draw(Graphics g);

    /*
    public void draw(Graphics g) {
        throw new IllegalStateException("I dont know how to draw abstract shape!!! Please override me.");
    }

    public void colorDraw(String color) {
        System.out.println("I drew " + color + "  the figure!");
    }
    */

    public void setShapeDepth(int shapeDepth) {
        this.shapeDepth = shapeDepth;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public int getShapeDepth() {
        return shapeDepth;
    }

    public Color getColor() {
        return color;
    }
}
