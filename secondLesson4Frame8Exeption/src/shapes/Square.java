package shapes;

import java.awt.*;

/**
 * Created by Osipov on 19.03.2016.
 */
public class Square extends Shape {

    @Override
    public void draw(Graphics g) {
        System.out.println("I`m draw square");

        g.setColor(new Color(0, 0, 0));
        g.fillRect(205, 55, 80, 80);
    }
    
}
