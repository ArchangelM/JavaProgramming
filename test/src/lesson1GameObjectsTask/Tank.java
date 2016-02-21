/**
 * Created by Rodichka on 21.02.2016.
 */
package lesson1GameObjectsTask;
public class Tank {

    final static int UP    = 1;
    final static int DOWN  = 2;
    final static int LEFT  = 3;
    final static int RIGHT = 4;

    private int direction;

    private int x;
    private int y;

    private int speed;
    private final int step = 1;

    ActionField engine;
    BattleField battlefield;

    public Tank(ActionField af, BattleField bf) {
        this(af, bf, 128, 512, 1);
        speed = 10;

    }

    public Tank(ActionField af, BattleField bf, int x, int y, int direction) {
        this.x = x;
        this.y = y;

        speed = 10;

        this.direction = direction;

        engine = af;
        battlefield = bf;
    }

    public void turn(int direction) throws Exception {
        this.direction = direction;
        engine.processTurn(this);
    }


    public void fire() throws Exception {
        Bullet bullet = new Bullet(x+25, y+25, direction);
        engine.processFire(bullet);
    }

    public void move() throws Exception {
        engine.processMove(this);
		/*
		switch (direction) {
		case UP:
				y--;

			break;
		case DOWN:
				y++;

			break;
		case LEFT:
				x--;

			break;
		case RIGHT:
				x++;

			break;
		}*/
    }


    void moveRandom() {

    }

    void moveToQuadrant(int v, int h) {


    }

    void updateX(int x) {
        this.x += x;
    }

    void updateY(int y) {
        this.y += y;
    }

    ////
    void moveUp() {
        y -= step;
    }

    void moveDown() {
        y += step;
    }

    void moveLeft() {
        x -= step;
    }

    void moveRight() {
        x += step;
    }

    //getters & setters
    void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getSpeed() {
        return speed;
    }

}
