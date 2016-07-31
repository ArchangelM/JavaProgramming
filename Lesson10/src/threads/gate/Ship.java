package threads.gate;

import java.awt.*;

public class Ship {
    private int x;
    private int y;

    private int speed;
    private Color color;

    public Ship() {
        color = Color.GREEN;
        x = 40;
        y = 170;
        speed = 4;

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

    public int getSpeed() {
        return speed;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 20, 20);
    }
}
