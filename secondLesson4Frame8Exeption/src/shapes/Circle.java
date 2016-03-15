package shapes;


import java.awt.Dimension;
import java.awt.Graphics;
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
        g.drawOval(80, 100, 70, 10);
        repaint();
    }
}
