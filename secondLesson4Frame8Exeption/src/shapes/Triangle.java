package shapes;

import java.awt.*;

/**
 * Created by Osipov on 16.03.2016.
 */
public class Triangle  extends Shape {
    final static int VERTEX_NUM = 3;

    @Override
    public void draw(Graphics g) {
        System.out.println("I`m draw triangle");
        int[] xPos = new int[VERTEX_NUM];
        int[] yPos = new int[VERTEX_NUM];

            xPos[0] = 450;
            yPos[0] = 200;
            xPos[1] = 500;
            yPos[1] = 20;
            xPos[2] = 550;
            yPos[2] = 200;

        g.setColor(new Color(200, 100, 200));
        g.drawPolygon(xPos, yPos, VERTEX_NUM);

        xPos[0] = 460;
        yPos[0] = 190;
        xPos[1] = 500;
        yPos[1] = 30;
        xPos[2] = 540;
        yPos[2] = 190;

        g.setColor(new Color(250, 50, 250));
        g.fillPolygon(xPos, yPos, VERTEX_NUM);
    }

}
