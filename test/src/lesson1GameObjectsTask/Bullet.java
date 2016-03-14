/**
 * Created by Osipov on 21.02.2016.
 */
package lesson1GameObjectsTask;

public class Bullet {
    private int x;
    private int y;

    private int speed;

    private Direction direction;

    public Bullet() {
        direction = Direction.UP;

        parking();
        speed = 5;
    }

    public Bullet(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;

        this.direction = direction;

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
}
