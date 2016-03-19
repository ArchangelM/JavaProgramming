package shapes;


import java.awt.*;

/**
 * Created by Osipov on 16.03.2016.
 */
public class Circle extends AbstractShape {

    public Circle() {
        color = new Color(100, 200, 100);
        setShapeDepth(3);
        stroke =new BasicStroke(getShapeDepth());
    }

    @Override
    public void draw(Graphics g) {
        System.out.println("I`m draw circle");

        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(getStroke());
        g2d.setColor(getColor());
        g2d.drawOval(80, 100, 100, 100);

        g.setColor(new Color(50, 250, 50));
        g.fillOval(85, 105, 90, 90);

    }
}
