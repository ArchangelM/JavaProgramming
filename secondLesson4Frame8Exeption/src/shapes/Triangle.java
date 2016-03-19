package shapes;

import java.awt.*;

/**
 * Created by Osipov on 16.03.2016.
 */
public class Triangle  extends AbstractShape {
    private final static int VERTEX_NUM = 3;
    private int[] xPos;
    private int[] yPos;

    public Triangle() {
        color = new Color(0, 100, 200);
        setShapeDepth(2);
        stroke = new BasicStroke(getShapeDepth());

        xPos = new int[VERTEX_NUM];
        yPos = new int[VERTEX_NUM];

        xPos[0] = 440; yPos[0] = 210;
        xPos[1] = 500; yPos[1] = 10;
        xPos[2] = 560; yPos[2] = 210;
    }

    @Override
    public void draw(Graphics g) {
        System.out.println("I`m draw triangle");

        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(getStroke());
        g2d.setColor(getColor());
        g2d.drawPolygon(xPos, yPos, VERTEX_NUM);

        xPos[0] = 460; yPos[0] = 190;
        xPos[1] = 500; yPos[1] = 40;
        xPos[2] = 540; yPos[2] = 190;

        g2d.setColor(new Color(250, 50, 250));
        g2d.fillPolygon(xPos, yPos, VERTEX_NUM);
    }

}
