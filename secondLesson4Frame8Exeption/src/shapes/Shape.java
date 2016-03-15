package shapes;

import java.awt.*;

/**
 * Created by Osipov on 16.03.2016.
 */
public class Shape {
    public void draw(Graphics g) {
        throw new IllegalStateException("I dont know how to draw abstract shape!!! Please override me.");
    }

    public void colorDraw(String color) {
        System.out.println("I drew " + color + "  the figure!");
    }

}
