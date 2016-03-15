package shapes;

import java.awt.*;

/**
 * Created by Osipov on 16.03.2016.
 */
public class Rectangle  extends Shape {
    @Override
    public void draw(Graphics g) {
        System.out.println("I`m draw rectangle");
        g.drawRect(300, 300, 40,80);

    }
}
