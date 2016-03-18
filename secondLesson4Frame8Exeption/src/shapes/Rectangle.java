package shapes;

import java.awt.*;

/**
 * Created by Osipov on 16.03.2016.
 */
public class Rectangle  extends Shape {
    @Override
    public void draw(Graphics g) {
        System.out.println("I`m draw rectangle");

        g.setColor(new Color(100, 100, 200));
        g.drawRect(300, 150, 70, 120);
        g.setColor(new Color(50, 50, 250));
        g.fillRect(305, 155, 60, 110);
    }
}
