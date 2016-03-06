/**
 * Created by Osipov on 21.02.2016.
 */
package lesson1GameObjectsTask;

import java.util.Random;

public class Tank {

    /*
    final static int UP    = 1;
    final static int DOWN  = 2;
    final static int LEFT  = 3;
    final static int RIGHT = 4;
    */
    private Direction direction;

    private int x;
    private int y;

    private int speed;
    private final int step = 1;
    private boolean isDestructed;

    ActionField engine;
    BattleField battlefield;

    public Tank(ActionField af, BattleField bf) {
        this(af, bf, 128, 512, Direction.UP);
        speed = 10;
        isDestructed = false;
    }

    public Tank(ActionField af, BattleField bf, int x, int y, Direction direction) {
        this.x = x;
        this.y = y;

        speed = 10;
        isDestructed = false;

        this.direction = direction;

        engine = af;
        battlefield = bf;
    }

    public void turn(Direction direction) throws Exception {
        this.direction = direction;
        engine.processTurn(this);
    }


    public void fire() throws Exception {
        Bullet bullet = new Bullet(x+25, y+25, direction);
        engine.processFire(bullet);
    }

    public void destroy() throws Exception {
        if (x >= 0 && y >= 0) {
            isDestructed = true;
            engine.destroyTank(x, y);
            x = -100;
            y = -100;
            direction = Direction.NONE;
        }

    }

    public boolean isDestroyed() {
        return isDestructed || x < 0 || y < 0;

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


    void moveRandom() throws Exception {
        Random r = new Random();
        int randomDirection;
        while (true) {
            randomDirection = r.nextInt(5);
            if (randomDirection > 0) {

                switch (randomDirection) {
                    case 1:
                        turn(Direction.UP);
                        break;
                    case 2:
                        turn(Direction.DOWN);
                        break;
                    case 3:
                        turn(Direction.LEFT);
                        break;
                    case 4:
                        turn(Direction.RIGHT);
                        break;
                }
                move();
            }
        }
    }

    void moveToQuadrant(int v, int h) throws Exception {
        if ((x < 0) || (y < 0)) {
            return;
        }
        int tankV = battlefield.getQuadrantV(y);
        int tankH = battlefield.getQuadrantH(x);

        int difference = battlefield.getDifferenceH(tankH, h);
        int next = tankH;

        if (difference > 0) {
            turn(Direction.RIGHT);
            while(difference > 0) {
                next++;

                if (battlefield.isQuadrantDestructable(next, tankV)) {
                    fire();
                }

                move();
                difference--;
            }
        }
        else if (difference < 0) {
            turn(Direction.LEFT);
            while(difference < 0) {
                next--;

                if (battlefield.isQuadrantDestructable(next, tankV)) {
                    fire();
                }

                move();
                difference++;
            }
        }

        difference = battlefield.getDifferenceV(tankV, v);
       tankH = battlefield.getQuadrantH(x);
        next = tankV;

        if (difference > 0) {
            turn(Direction.DOWN);
            while(difference > 0) {
                next++;

                if (battlefield.isQuadrantDestructable(tankH, next)) {
                    fire();
                }

                move();
                difference--;
            }
        }
        else if (difference < 0) {
            turn(Direction.UP);
            while (difference < 0) {
                next--;

                if (battlefield.isQuadrantDestructable(tankH, next)) {
                    fire();
                }

                move();
                difference++;
            }
        }
    }

    void clean() throws Exception {
        int moveY = 0;
        if (x > 0 && y > 0) {
            while (battlefield.getDimentionY() >= moveY) {
                moveToQuadrant(0, moveY);
                turn(Direction.DOWN);
                clearWay(8);
                moveY++;
            }
        }

    }

    void clearWay(int length) throws Exception {
        while(radar(length)) {
            fire();
        }
    }

    boolean radar(int length) {
        int leftBorder = 0;
        int rightBorder = battlefield.getDimentionX();
        int upBorder = 0;
        int downBorder = battlefield.getDimentionY();

        int beam;

        int tankV = battlefield.getQuadrantV(y);
        int tankH = battlefield.getQuadrantH(x);

        switch (direction) {
            case UP:
                //if (y != upBorder) {
                if (tankV != upBorder) {
                    beam = tankV;
                    while (beam >= upBorder && (tankV - beam) <= length) {
                        if(battlefield.isQuadrantDestructable(tankH, beam)) return true;
                        beam--;
                    }
                }
                break;
            case DOWN:
               // if (y != downBorder*PIXELS_IN_CELL) {
                if (tankV != downBorder) {
                    beam = tankV;
                    while (beam <= downBorder && (beam - tankV) <= length) {
                        if(battlefield.isQuadrantDestructable(tankH, beam)) return true;
                        beam++;
                    }
                }
                break;
            case LEFT:
                //if (x != leftBorder) {
                if (tankH != leftBorder) {
                    beam = tankH;
                    while (beam >= leftBorder && (tankH - beam) <= length) {
                        if(battlefield.isQuadrantDestructable(beam, tankV)) return true;
                        beam--;
                    }
                }
                break;
            case RIGHT:
                //if (x != rightBorder*PIXELS_IN_CELL) {
                if (tankH != rightBorder) {
                    beam = tankH;
                    while (beam <= rightBorder && (beam - tankH) <= length) {
                        if(battlefield.isQuadrantDestructable(beam, tankV)) return true;
                        beam++;
                    }
                }
                break;
        }

        return false;
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
    void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
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
