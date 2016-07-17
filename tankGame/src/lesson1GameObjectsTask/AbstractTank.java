/**
 * Created by Osipov on 21.02.2016.
 */
package lesson1GameObjectsTask;

import lesson1GameObjectsTask.fields.Explosion;
import lesson1GameObjectsTask.fields.Water;
import lesson1GameObjectsTask.interfaces.Destroyable;
import lesson1GameObjectsTask.interfaces.Drawable;
import lesson1GameObjectsTask.tanks.TankType;
import lesson1GameObjectsTask.utils.Memoirs;
import lesson1GameObjectsTask.utils.TankAction;
import lesson1GameObjectsTask.utils.Utils;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public abstract class AbstractTank implements Drawable, Destroyable {

    //private Direction direction;
    protected Direction direction;
    protected Color color;
    protected Color towerColor;

    //private int x;
    //private int y;
    protected int x;
    protected int y;

    //private int speed;
    //private final int step = 1;
    //private boolean isDestructed;
    protected int speed;
    protected final int step = 1;
    protected boolean isDestructed;

    protected ActionField engine;
    protected BattleField battleField;

    protected String[] spritesTankFilesName;
    protected Image[] imgTank;

    private TankType tankType;

    private Bullet bullet;
    private boolean writeActionFile;
    private Memoirs memoirs;



    public AbstractTank(ActionField af, BattleField bf) {
        this(af, bf, 128, 512, Direction.UP);
        speed = 10;
        isDestructed = false;
    }

    public AbstractTank(ActionField af, BattleField bf, String coord, Direction direction) {
        this(af, bf, Integer.parseInt(coord.split("_")[0]), Integer.parseInt(coord.split("_")[1]), direction);
    }

    public AbstractTank(ActionField af, BattleField bf, int x, int y, Direction direction) {
        this.x = x;
        this.y = y;

        speed = 10;
        isDestructed = false;

        this.direction = direction;

        engine = af;
        battleField = bf;
        writeActionFile = false;

        tankType = TankType.PLAYERTANK;

    }

    public boolean isWriteActionFile() {
        return writeActionFile;
    }

    public void setWriteActionFile(boolean writeActionFile) {
        this.writeActionFile = writeActionFile;
    }

    public void setMemoirs(Memoirs memoirs) {
        this.memoirs = memoirs;
    }

    public TankType getTankType() {
        return tankType;
    }

    public void setTankType(TankType tankType) {
        this.tankType = tankType;
    }

    public void loadSpritesTank() {
        File f;


        imgTank = new Image[spritesTankFilesName.length];
        for (int i = 0; i < spritesTankFilesName.length; i++) {
            f = new File(spritesTankFilesName[i]);
            if (f.exists()) imgTank[i] = new ImageIcon(spritesTankFilesName[i]).getImage();
        }

        /*
        try {
            imgTank[0] = ImageIO.read(new File("tankleft64.png")).getAbsoluteFile());
        } catch (IOException e) {
            throw new IllegalStateException("Can't find spites");
        }*/
    }

    public void turn(Direction direction) throws Exception {
        this.direction = direction;

        //mem
        if(isWriteActionFile()) {
            memoirs.writeActionToFile(this, Utils.directionToAction(direction));
        }

        engine.processTurn(this);
    }


    public void fire() throws Exception {
        //Bullet bullet = new Bullet(x+25, y+25, direction);
        bullet = new Bullet(x+25, y+25, direction);

        //mem
        if(isWriteActionFile()) {
            memoirs.writeActionToFile(this, TankAction.FIRE);
        }

        engine.processFire(this, bullet);
    }

    public boolean destroy() throws Exception {
        if (x >= 0 && y >= 0) {
            isDestructed = true;
            engine.destroyTank(x, y);
            x = -100;
            y = -100;
            direction = Direction.NONE;
            System.out.println("Танк уничтожен!");
            return true;
        }
        return false;
    }

    public boolean stricken() throws Exception {
        return destroy();
    }

    public boolean myBullet(Bullet bullet) {
        if (bullet == this.bullet) return true;
        else return false;
    }

    public boolean isDestroyed() {
        return isDestructed || x < 0 || y < 0;

    }

    public void moveForvard() throws Exception {

    }

    public void move() throws Exception {

		switch (direction) {
		case UP:
            if (battleField.isQuadrantDestructable(battleField.getQuadrantH(x), battleField.getQuadrantV(y)-1)){
                fire();
            }

			break;
		case DOWN:
            if (battleField.isQuadrantDestructable(battleField.getQuadrantH(x), battleField.getQuadrantV(y)+1)){
                fire();
            }
            //if (engine.checkTank(defender))

         break;
		case LEFT:
            if (battleField.isQuadrantDestructable(battleField.getQuadrantH(x)-1, battleField.getQuadrantV(y))){
                fire();
            }

			break;
		case RIGHT:
            if (battleField.isQuadrantDestructable(battleField.getQuadrantH(x)+1, battleField.getQuadrantV(y))){
                fire();
            }

			break;
		}

        //mem
        if(isWriteActionFile()) {
            memoirs.writeActionToFile(this, TankAction.MOVE);
        }

        engine.processMove(this);
    }

    public Direction randomDirection(Direction current)throws Exception {
        Random r = new Random();
        int randomDirection = r.nextInt(5);

        switch (randomDirection) {
            case 1:
                return Direction.UP;
            case 2:
                return Direction.DOWN;
            case 3:
                return Direction.LEFT;
            case 4:
                return Direction.RIGHT;
            default:
                fire();

        }


        return current;

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
        int tankV = battleField.getQuadrantV(y);
        int tankH = battleField.getQuadrantH(x);

        int difference = battleField.getDifferenceH(tankH, h);
        int next = tankH;

        if (difference > 0) {
            turn(Direction.RIGHT);
            while(difference > 0) {
                next++;

                if (battleField.isQuadrantDestructable(next, tankV)) {
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

                if (battleField.isQuadrantDestructable(next, tankV)) {
                    fire();
                }

                move();
                difference++;
            }
        }

        difference = battleField.getDifferenceV(tankV, v);
       tankH = battleField.getQuadrantH(x);
        next = tankV;

        if (difference > 0) {
            turn(Direction.DOWN);
            while(difference > 0) {
                next++;

                if (battleField.isQuadrantDestructable(tankH, next)) {
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

                if (battleField.isQuadrantDestructable(tankH, next)) {
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
            while (battleField.getDimentionY() >= moveY) {
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
        int rightBorder = battleField.getDimentionX();
        int upBorder = 0;
        int downBorder = battleField.getDimentionY();

        int beam;

        int tankV = battleField.getQuadrantV(y);
        int tankH = battleField.getQuadrantH(x);

        switch (direction) {
            case UP:
                //if (y != upBorder) {
                if (tankV != upBorder) {
                    beam = tankV;
                    while (beam >= upBorder && (tankV - beam) <= length) {
                        if(battleField.isQuadrantDestructable(tankH, beam)) return true;
                        beam--;
                    }
                }
                break;
            case DOWN:
               // if (y != downBorder*PIXELS_IN_CELL) {
                if (tankV != downBorder) {
                    beam = tankV;
                    while (beam <= downBorder && (beam - tankV) <= length) {
                        if(battleField.isQuadrantDestructable(tankH, beam)) return true;
                        beam++;
                    }
                }
                break;
            case LEFT:
                //if (x != leftBorder) {
                if (tankH != leftBorder) {
                    beam = tankH;
                    while (beam >= leftBorder && (tankH - beam) <= length) {
                        if(battleField.isQuadrantDestructable(beam, tankV)) return true;
                        beam--;
                    }
                }
                break;
            case RIGHT:
                //if (x != rightBorder*PIXELS_IN_CELL) {
                if (tankH != rightBorder) {
                    beam = tankH;
                    while (beam <= rightBorder && (beam - tankH) <= length) {
                        if(battleField.isQuadrantDestructable(beam, tankV)) return true;
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

    //changed
    public void draw(Graphics g) {
        // boolean tmp = battleField.scanQuadrantScreenCoords(mainTank.getX(), mainTank.getY()).equals("X");

        if (!isDestroyed()) {
            //if (!battleField.scanQuadrantScreenCoords(x, y).equals("X")) {
            if (!(battleField.scanQuadrantScreenCoords(x, y) instanceof Explosion)) {


                if (direction == Direction.UP) {
                    if(imgTank[0] != null) {
                        g.drawImage(imgTank[0], x, y, null);
                    }
                    else {
                        g.setColor(color);
                        g.setColor(towerColor);
                        g.fillRect(x, y, BattleField.PIXELS_IN_CELL, BattleField.PIXELS_IN_CELL);
                        g.fillRect(x + 20, y, 24, 34);
                    }
                } else if (direction == Direction.DOWN) {
                    if(imgTank[1] != null) {
                        g.drawImage(imgTank[1], x, y, null);
                    }
                    else {
                        g.setColor(color);
                        g.setColor(towerColor);
                        g.fillRect(x, y, BattleField.PIXELS_IN_CELL, BattleField.PIXELS_IN_CELL);
                        g.fillRect(x + 20, y + 30, 24, 34);
                    }
                } else if (direction == Direction.LEFT) {
                    if(imgTank[2] != null) {
                        g.drawImage(imgTank[2], x, y, null);
                    }
                    else {
                        g.setColor(color);
                        g.setColor(towerColor);
                        g.fillRect(x, y, BattleField.PIXELS_IN_CELL, BattleField.PIXELS_IN_CELL);
                        g.fillRect(x, y + 20, 34, 24);
                    }
                } else {
                    if(imgTank[3] != null) {
                        g.drawImage(imgTank[3], x, y, null);
                    }
                    else {
                        g.setColor(color);
                        g.setColor(towerColor);
                        g.fillRect(x, y, BattleField.PIXELS_IN_CELL, BattleField.PIXELS_IN_CELL);
                        g.fillRect(x + 30, y + 20, 34, 24);
                    }
                }

                if ((battleField.scanQuadrantScreenCoords(x, y) instanceof Water)) {
                    battleField.draw(g, x, y);
                }
            }
        }
    }

}

/*
if (tankDirection == 1) {
			if(imgTank[0] != null) g.drawImage(imgTank[0], tankX, tankY, null);
			else g.fillRect(tankX + 20, tankY, 24, 34);

		} else if (tankDirection == 2) {
			if(imgTank[1] != null) g.drawImage(imgTank[1], tankX, tankY, null);
			else g.fillRect(tankX + 20, tankY + 30, 24, 34);
		} else if (tankDirection == 3) {
			if(imgTank[2] != null) g.drawImage(imgTank[2], tankX, tankY, null);
			else g.fillRect(tankX, tankY + 20, 34, 24);
		} else {
			if(imgTank[3] != null) g.drawImage(imgTank[3], tankX, tankY, null);
			else g.fillRect(tankX + 30, tankY + 20, 34, 24);
		}
 */