package threads.gate;

import java.awt.*;

public class Gate implements Runnable {
    private int x = 400;
    private int y = 150;

    private final int yTop = 50;

    private int speed;
    private Color color;

    private boolean isOpen;

    public Gate() {
        color = Color.RED;
        isOpen = false;
    }

    @Override
    public void run() {

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
