package threads.circles;

import java.awt.*;

import static threads.circles.MyPanel.DIAMETR;

public class Circle implements Runnable{
    private int speed;
    private Color color;

    private int x;
    private int y;
    private int w;
    private int h;

    public final static int WIDTH = 700;

    public Circle() {
    }

    public Circle(int speed, Color color) {
        this.speed = speed;
        this.color = color;

    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, w, h);
        //System.out.println("Draw circle");
    }

    @Override
    public void run() {
        while (true) {
            while (x < WIDTH - 2*DIAMETR) {
               // System.out.println("circle move " + x);
                x++;
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            while (x > DIAMETR) {

                x--;
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //repaint();
            }
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

}
