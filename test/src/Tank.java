/**
 * Created by Rodichka on 21.02.2016.
 */

import java.util.Random;

import static lesson1GameObjectsTask.ActionField.UP;
import static lesson1GameObjectsTask.ActionField.DOWN;
import static lesson1GameObjectsTask.ActionField.LEFT;
import static lesson1GameObjectsTask.ActionField.RIGHT;


public class Tank {
    private int direction;

    private int x;
    private int y;

    private final int speed = 10;

    ActionField engine;
    BattleField battlefield;

    public Tank(ActionField af, BattleField bf) {
        this(af, bf, 128, 512, 1);
    }

    public Tank(ActionField af, BattleField bf, int x, int y, int direction) {
        this.x = x;
        this.y = y;

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

    //getters & setters
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
