package threads.gate;

import java.awt.*;

public class Ship {
    private int x = 40;
    private int y = 170;

    private int speed;
    private Color color;

    public Ship() {
        color = Color.GREEN;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 20, 20);
    }
}
