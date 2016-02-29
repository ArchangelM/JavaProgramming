/**
 * Created by Rodichka on 21.02.2016.
 */
package lesson1GameObjectsTask;

public class Bullet {
    private int x;
    private int y;

    private int speed;

    private int direction;

    public Bullet() {
        direction = 1;

        parking();
        speed = 5;
    }

    public Bullet(int x, int y, int direction) {
        this.x = x;
        this.y = y;

        this.direction = direction;

        speed = 5;
    }

    public void parking() {
        x = -100;
        y = -100;
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

    public int getDirection() {
        return direction;
    }
}
