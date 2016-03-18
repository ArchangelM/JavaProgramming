package shapes;


import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Created by Osipov on 16.03.2016.
 */
public class Circle extends Shape {
    @Override
    public void draw(Graphics g) {
        System.out.println("I`m draw circle");

        g.setColor(new Color(100, 200, 100));
        g.drawOval(80, 100, 100, 100);
        g.setColor(new Color(50, 250, 50));
        g.fillOval(85, 105, 90, 90);

    }
}
