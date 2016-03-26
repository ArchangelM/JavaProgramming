/**
 * Created by Osipov on 21.02.2016.
 */
package lesson1GameObjectsTask;

import lesson1GameObjectsTask.interfaces.Drawable;

import java.awt.*;

public class Bullet implements Drawable {
    public static final int BULLET_X_DIMENTION = 14;
    public static final int BULLET_Y_DIMENTION = 14;


    private int x;
    private int y;
    private Color color;

    private int speed;

    private Direction direction;

    public Bullet() {
        this(-100, -100, Direction.UP);
        /*
        direction = Direction.UP;
        color = new Color(255, 255, 0);

        parking();
        speed = 5;
        */
    }

    public Bullet(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;

        this.direction = direction;
        color = new Color(255, 255, 0);

        speed = 5;
    }

    public void parking() {
        x = -100;
        y = -100;

        direction = Direction.NONE;
    }

    public void hit() {
        parking();
    }

    public void updateX(int deltaX) {
        x += deltaX;
    }

    public void updateY(int deltaY) {
        y += deltaY;
    }

   //getters & setters

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public Direction getDirection() {
        return direction;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, BULLET_X_DIMENTION, BULLET_Y_DIMENTION);
    }
}
