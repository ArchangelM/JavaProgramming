package threads.gate;

import java.awt.*;

public class Gate  {
    private int x = 400;
    private int y = 150;

    private int deltaX = 60;

    private final int yTop = 50;
    private final int yBottom = 150;

    private int speed;
    private int waitTime;
    private Color color;

    private boolean isOpen;

    public Gate() {
        color = Color.RED;
        isOpen = false;
        speed = 5;
        waitTime = 150;
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

    public int getDeltaX() {
        return deltaX;
    }

    public int getyBottom() {
        return yBottom;
    }

    public int getSpeed() {
        return speed;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, 20, 60);
    }

    public int getyTop() {
        return yTop;
    }
}
