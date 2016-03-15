package shapes;

import java.awt.*;

/**
 * Created by Osipov on 16.03.2016.
 */
public class Triangle  extends Shape {
    @Override
    public void draw(Graphics g) {
        System.out.println("I`m draw triangle");
        g.drawOval(120, 300, 100, 10);
    }

}
