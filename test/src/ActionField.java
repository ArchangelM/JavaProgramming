/**
 * Created by Rodichka on 21.02.2016.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.util.Random;

import static lesson1GameObjectsTask.BattleField.PIXELS_IN_CELL;

public class ActionField extends JPanel {

    //directions
    final static int UP    = 1;
    final static int DOWN  = 2;
    final static int LEFT  = 3;
    final static int RIGHT = 4;

    private final boolean COLORDED_MODE = false;

    private final int BULLET_X_DELTA = 25;
    private final int BULLET_Y_DELTA = 25;

    private final int BULLET_X_DIMENTION = 14;
    private final int BULLET_Y_DIMENTION = 14;

    private final String DESTRUCTABLE = "BCE"; //коды разрушаемых объектов: кирпич, танк компьютера, штаб
    private final String UN_DESTRUCTABLE = "WS"; //коды не разрушаемых объектов: вода, камни

    private final int EXPLOSIVE = 1000;

    private BattleField battleField;
    private Tank mainTank;
    private Bullet tankBullet;


    public void runTheGame() throws Exception {
        //clean(); //bricks destruction



		/*
		moveToQuadrant(1, 6);

		moveToQuadrant(1, 3);

		moveToQuadrant(4, 3);
		moveToQuadrant(4, 4);

		moveToQuadrant(4, 2);
		 */
    }

    public ActionField() throws Exception {
        battleField = new BattleField();
        mainTank = new Tank();
        tankBullet = new Bullet();

        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(500, 150);
        //frame.setMinimumSize(new Dimension(BF_WIDTH+15, BF_HEIGHT + 38));
        frame.setMinimumSize(new Dimension(battleField.getBF_WIDTH(), battleField.getBF_HEIGHT() + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }


    private boolean processInterception() throws Exception {
        if (mainTank.getY() < 0 || mainTank.getY() > battleField.getBF_HEIGHT()) return false;
        if (mainTank.getX() < 0 || mainTank.getX() > battleField.getBF_WIDTH()) return false;

        //String bulletQuadrant = getQuadrant(tankBullet.getX(), tankBullet.getY());

        //if (isQuadrantEqual(bulletQuadrant, getQuadrant(mainTank.getX(), mainTank.getY()))) return false;

        //if (isQuadrantEqual(bulletQuadrant, curentBulletPosition)) return false;
        //else curentBulletPosition = bulletQuadrant;

        if (isDestructable(tankBullet.getX() , tankBullet.getY())) {
            destroyQuadrant(tankBullet.getX(), tankBullet.getY());
            return true;
        }
        return false;
    }

    private boolean isDestructable(int x, int y) {
        String field = battleField.scanQuadrant(x / PIXELS_IN_CELL + 1, y / PIXELS_IN_CELL + 1);
        if (DESTRUCTABLE.indexOf(field) >= 0) return true;
        else return false;
    }

    private void destroyQuadrant(int x, int y) throws Exception {
        battleField.updateQuadrant(x, y, "X");
        tankBullet.parking();
        repaint();
        Thread.sleep(EXPLOSIVE);
        battleField.updateQuadrant(x, y, " ");
        repaint();
    }

    public String getQuadrant(int x, int y) {
        int screenXCoord = x / PIXELS_IN_CELL + 1;
        int screenYCoord = y / PIXELS_IN_CELL + 1;
        return screenYCoord + "_" + screenXCoord;
    }

    public String getQuadrantXY(int v, int h) {
        int screenXCoord = (h - 1) * PIXELS_IN_CELL;
        int screenYCoord = (v - 1) * PIXELS_IN_CELL;

        return screenYCoord + "_" + screenXCoord;
    }


    public void processTurn(Tank tank) throws Exception {
        tank.changeDirection();
        repaint();
    }

    public void processMove(Tank tank) throws Exception {
        tank.move();
        repaint();
    }

    public void processFire(Bullet bullet) throws Exception {
        int leftBorder = 0;
        int rightBorder = battleField.getDimentionX()*PIXELS_IN_CELL;
        int upBorder = 0;
        int downBorder = battleField.getDimentionY()*PIXELS_IN_CELL;

        switch (bullet.getDirection()) {
            case UP:
                //if (mainTank.getTankY() != upBorder) {
                while (checkUpBorder(bullet.getY(), upBorder) && !processInterception()) {
                    repaint();
                    Thread.sleep(bullet.getSpeed());
                }

                //}

                break;
            case DOWN:
                //if (mainTank.getTankY() != downBorder) {

                while (checkDownBorder(bullet.getY(), downBorder) && !processInterception()) {
                    repaint();
                    Thread.sleep(bullet.getSpeed());
                }

                //}

                break;
            case LEFT:
                //if (mainTank.getTankX() != leftBorder) {

                while (checkLeftBorder(bullet.getX(), leftBorder) && !processInterception()) {
                    repaint();
                    Thread.sleep(bullet.getSpeed());
                }
                //}

                break;
            case RIGHT:
                //if (mainTank.getTankX() != rightBorder) {

                while (checkRightBorder(bullet.getX(), rightBorder) && !processInterception()) {
                    repaint();
                    Thread.sleep(bullet.getSpeed());
                }
                //}

                break;
        }
    }

    public boolean checkUpBorder(int y, int upBorder) {
        if (y-- >= upBorder - BULLET_Y_DIMENTION) return true;
        return false;
    }

    public boolean checkDownBorder(int y, int downBorder) {
        if (y++ <= downBorder + PIXELS_IN_CELL) return true;
        return false;
    }

    public boolean checkLeftBorder(int x, int leftBorder) {
        if (x-- >= leftBorder - BULLET_X_DIMENTION) return true;
        return false;
    }

    public boolean checkRightBorder(int x, int rightBorder) {
        if (x <= rightBorder + PIXELS_IN_CELL) return true;
        return false;
    }

    //Graphics
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int i = 0;
        Color cc;
        for (int v = 0; v < 9; v++) {
            for (int h = 0; h < 9; h++) {
                if (COLORDED_MODE) {
                    if (i % 2 == 0) {
                        cc = new Color(252, 241, 177);
                    } else {
                        cc = new Color(233, 243, 255);
                    }
                } else {
                    cc = new Color(180, 180, 180);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * PIXELS_IN_CELL, v * PIXELS_IN_CELL, PIXELS_IN_CELL, PIXELS_IN_CELL);
            }
        }

        for (int j = 0; j < battleField.getDimentionX(); j++) {
            for (int k = 0; k <battleField.getDimentionY(); k++) {
                if (battleField.scanQuadrant(j, k).equals("B")) {
                    String coordinates = getQuadrantXY(j + 1, k + 1);
                    int separator = coordinates.indexOf("_");
                    int y = Integer.parseInt(coordinates.substring(0, separator));
                    int x = Integer.parseInt(coordinates.substring(separator + 1));
                    g.setColor(new Color(0, 0, 255));
                    g.fillRect(x, y, PIXELS_IN_CELL, PIXELS_IN_CELL);
                }  else if (battleField.scanQuadrant(j, k).equals("G")) {
                    String coordinates = getQuadrantXY(j + 1, k + 1);
                    int separator = coordinates.indexOf("_");
                    int y = Integer.parseInt(coordinates.substring(0, separator));
                    int x = Integer.parseInt(coordinates.substring(separator + 1));
                    g.setColor(new Color(0, 255, 0));
                    g.fillRect(x, y, PIXELS_IN_CELL, PIXELS_IN_CELL);
                } else if (battleField.scanQuadrant(j, k).equals("W")) {
                    String coordinates = getQuadrantXY(j + 1, k + 1);
                    int separator = coordinates.indexOf("_");
                    int y = Integer.parseInt(coordinates.substring(0, separator));
                    int x = Integer.parseInt(coordinates.substring(separator + 1));
                    g.setColor(new Color(0, 200, 200));
                    g.fillRect(x, y, PIXELS_IN_CELL, PIXELS_IN_CELL);
                }
                else if (battleField.scanQuadrant(j, k).equals("X")) {
                    String coordinates = getQuadrantXY(j + 1, k + 1);
                    int separator = coordinates.indexOf("_");
                    int y = Integer.parseInt(coordinates.substring(0, separator));
                    int x = Integer.parseInt(coordinates.substring(separator + 1));
                    g.setColor(new Color(250, 160, 40));
                    g.fillRect(x, y, PIXELS_IN_CELL, PIXELS_IN_CELL);
                }
            }
        }

        g.setColor(new Color(255, 0, 0));
        g.fillRect(mainTank.getX(), mainTank.getY(), PIXELS_IN_CELL, PIXELS_IN_CELL);

        g.setColor(new Color(0, 255, 0));
        if (mainTank.getDirection() == 1) {
            g.fillRect(mainTank.getX() + 20, mainTank.getY(), 24, 34);
        } else if (mainTank.getDirection() == 2) {
            g.fillRect(mainTank.getX() + 20, mainTank.getY() + 30, 24, 34);
        } else if (mainTank.getDirection() == 3) {
            g.fillRect(mainTank.getX(), mainTank.getY() + 20, 34, 24);
        } else {
            g.fillRect(mainTank.getX() + 30, mainTank.getY() + 20, 34, 24);
        }

        g.setColor(new Color(255, 255, 0));
        g.fillRect(tankBullet.getX(), tankBullet.getY(), BULLET_X_DIMENTION, BULLET_Y_DIMENTION);
    }

}
