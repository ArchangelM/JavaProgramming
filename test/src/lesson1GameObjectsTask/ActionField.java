/**
 * Created by Osipov on 21.02.2016.
 */
package lesson1GameObjectsTask;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.util.Random;

import static lesson1GameObjectsTask.BattleField.PIXELS_IN_CELL;

import static lesson1GameObjectsTask.BattleField.X_MAX;
import static lesson1GameObjectsTask.BattleField.Y_MAX;

import static lesson1GameObjectsTask.BattleField.PIXELS_IN_CELL;

//import static lesson1GameObjectsTask.Bullet.BULLET_X_DIMENTION;
//import static lesson1GameObjectsTask.Bullet.BULLET_Y_DIMENTION;

public class ActionField extends JPanel {

    private final boolean COLORDED_MODE = false;

    private final int BULLET_X_DELTA = 25;
    private final int BULLET_Y_DELTA = 25;

    private final int BULLET_X_DIMENTION = 14;
    private final int BULLET_Y_DIMENTION = 14;

    private final String DESTRUCTABLE = "BCE"; //коды разрушаемых объектов: кирпич, танк компьютера, штаб
    private final String UN_DESTRUCTABLE = "WS"; //коды не разрушаемых объектов: вода, камни

    private final int EXPLOSIVE = 1000;
    private final int RESURECTION = 3000;

    private BattleField battleField;
    private Tank mainTank;
    private Bullet tankBullet;

    private Tiger aggressor;


    public void runTheGame() throws Exception {
        //clean(); //bricks destruction


        mainTank.moveToQuadrant(1, 4);
       // mainTank.moveToQuadrant(1, 6);
        mainTank.turn(Direction.LEFT);
        mainTank.fire();
        mainTank.fire();
        mainTank.fire();
        repaint();

        //aggressor.destroy();

        //mainTank.destroy();

        /*
        mainTank.moveToQuadrant(1, 3);

        mainTank.moveToQuadrant(4, 3);
        mainTank.moveToQuadrant(4, 4);

        mainTank.moveToQuadrant(4, 2);
        mainTank.clean();
        */

    }

    public ActionField() throws Exception {
        battleField = new BattleField();
        mainTank = new Tank(this, battleField);
        tankBullet = new Bullet();

        aggressor = new Tiger(this, battleField, battleField.getRandomLocationAggressor(), Direction.DOWN);

        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(500, 150);
        //frame.setMinimumSize(new Dimension(BF_WIDTH+15, BF_HEIGHT + 38));
        frame.setMinimumSize(new Dimension(battleField.getBF_WIDTH(), battleField.getBF_HEIGHT() + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }


    private boolean processInterception(Bullet bullet) throws Exception {
       // if (mainTank.getY() < 0 || mainTank.getY() > battleField.getBF_HEIGHT()) return false;
      //  if (mainTank.getX() < 0 || mainTank.getX() > battleField.getBF_WIDTH()) return false;

        //Interception function
        //String bulletQuadrant = getQuadrant(tankBullet.getX(), tankBullet.getY());
        //if (isQuadrantEqual(bulletQuadrant, getQuadrant(mainTank.getX(), mainTank.getY()))) return false;

        //if (isQuadrantEqual(bulletQuadrant, curentBulletPosition)) return false;
        //else curentBulletPosition = bulletQuadrant;
        int bH = battleField.getQuadrantH(bullet.getX());
        int bV = battleField.getQuadrantV(bullet.getY());
        //if (isDestructable(battleField.getQuadrantH(bullet.getX()), battleField.getQuadrantV(bullet.getY()))) {
        //    destroyQuadrant(battleField.getQuadrantH(bullet.getX()), battleField.getQuadrantV(bullet.getY()));
        if (isDestructable(bullet.getX(), bullet.getY())) {
            destroyQuadrant(bV, bH);
            return true;
        }

        if (checkInterception(aggressor, bullet)) {
            if (aggressor.destroy()) {
                Thread.sleep(RESURECTION);
                aggressor = new Tiger(this, battleField, battleField.getRandomLocationAggressor(), Direction.DOWN);
                return true;
            } else {
                bullet.hit();
                return false;
            }
        }
        return false;
    }

    private boolean isDestructable(int x, int y) {
        //String field = battleField.scanQuadrant(x / PIXELS_IN_CELL + 1, y / PIXELS_IN_CELL + 1);
        String field = battleField.scanQuadrant(y / PIXELS_IN_CELL, x / PIXELS_IN_CELL);
        if (DESTRUCTABLE.indexOf(field) >= 0) return true;
        else {
            return false;
        }
    }

    private boolean checkInterception(Tank tank, Bullet bullet) {
        if (tank.myBullet(bullet)) return false;
        String bulletQuadrant = getQuadrant(bullet.getX(), bullet.getY());

        if (bulletQuadrant.equals(getQuadrant(tank.getX(), tank.getY()))) return true;

        return false;
    }

    private void destroyQuadrant(int x, int y) throws Exception {
        battleField.updateQuadrant(x, y, "X");
        if (tankBullet != null) tankBullet.parking();
        repaint();
        Thread.sleep(EXPLOSIVE);
        battleField.updateQuadrant(x, y, " ");
        repaint();
    }

    public void destroyTank(int x, int y) throws Exception {
        destroyQuadrant(getQuadrantV(y), getQuadrantH(x));
        /*getQuadrantV
        battleField.updateQuadrant(x, y, "X");
        tankBullet.parking();
        repaint();
        Thread.sleep(EXPLOSIVE);
        battleField.updateQuadrant(x, y, " ");
        repaint();
        */
    }

    private int getQuadrantV(int y) {
        return battleField.getQuadrantV(y);
    }

    private int getQuadrantH(int x) {
        return battleField.getQuadrantH(x);
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
        repaint();
    }

    public void processMove(Tank tank) throws Exception {
        int leftBorder = 0;
        int rightBorder = X_MAX*PIXELS_IN_CELL;
        int upBorder = 0;
        int downBorder = Y_MAX*PIXELS_IN_CELL;

        int vihod;

        if (tank.getDirection() == Direction.UP) {
            int next = 0;

            if (tank.getY() != upBorder) {
                next = tank.getY() - PIXELS_IN_CELL;

                vihod = 1;

                while (vihod != 0) {
                    if (tank.getY() == next) {
                        vihod = 0;
                    } else {
                        tank.moveUp();
                    }

                    repaint();
                    Thread.sleep(tank.getSpeed());
                }

                System.out.println("Танк переехал вверх из квадранта " + battleField.getQuadrantNum(tank.getX(),
                        tank.getY()+PIXELS_IN_CELL) + " в квадрант " +
                        battleField.getQuadrantNum(tank.getX(), tank.getY()));
            }
            else {
                System.out.println("Граница поля.");
                vihod = 0;
            }

        } else if (tank.getDirection() == Direction.DOWN) {
            int next = 0;

            if (tank.getY() != downBorder) {
                next = tank.getY() + PIXELS_IN_CELL;

                //
                vihod = 1;

                while (vihod != 0) {
                    if (tank.getY() == next) {
                        vihod = 0;
                    } else {
                        tank.moveDown();
                    }

                    repaint();
                    Thread.sleep(tank.getSpeed());
                }

                System.out.println("Танк переехал вниз из квадранта " +
                        battleField.getQuadrantNum(tank.getX(), tank.getY()-PIXELS_IN_CELL) +
                        " в квадрант " + battleField.getQuadrantNum(tank.getX(), tank.getY()));
            }
            else {
                System.out.println("Граница поля.");
                vihod = 0;
            }

        } else if (tank.getDirection() == Direction.LEFT) {
            int  next = 0;

            if (tank.getX() != leftBorder) {
                next = tank.getX() - PIXELS_IN_CELL;

                //
                vihod = 1;

                while (vihod != 0) {
                    if (tank.getX() == next) {
                        vihod = 0;

                    } else {
                        tank.moveLeft();
                    }

                    repaint();
                    Thread.sleep(tank.getSpeed());
                }

                System.out.println("Танк переехал влево из квадранта " +
                        battleField.getQuadrantNum(tank.getX()+PIXELS_IN_CELL ,
                                tank.getY()) + " в квадрант " +
                        battleField.getQuadrantNum(tank.getX(), tank.getY()));
            }
            else {
                System.out.println("Граница поля.");
                vihod = 0;
            }

        } else if (tank.getDirection() == Direction.RIGHT) {
            int  next = 0;
            tank.setDirection(Direction.RIGHT);

            if (tank.getX() != rightBorder) {
                next = tank.getX() + PIXELS_IN_CELL;

                //
                vihod = 1;

                while (vihod != 0) {
                    if (tank.getX() == next) {
                        vihod = 0;

                    } else{
                        tank.moveRight();
                    }

                    repaint();
                    Thread.sleep(tank.getSpeed());
                }

                System.out.println("Танк переехал вправо из квадранта " +
                        battleField.getQuadrantNum(tank.getX()-PIXELS_IN_CELL,
                                tank.getY()) + " в квадрант " +
                        battleField.getQuadrantNum(tank.getX(), tank.getY()));
            }
            else {
                System.out.println("Граница поля.");
                vihod = 0;
            }

        }
        else {
            System.out.println("Не правильное направление.");
        }
        repaint();
    }

    public void processFire(Bullet bullet) throws Exception {
        int leftBorder = 0;
        int rightBorder = battleField.getDimentionX()*PIXELS_IN_CELL;
        int upBorder = 0;
        int downBorder = battleField.getDimentionY()*PIXELS_IN_CELL;

        switch (bullet.getDirection()) {
            case UP:
                //if (mainTank.getY() != upBorder) {
                while (checkUpBorder(bullet.getY(), upBorder) && !processInterception(bullet)) {
                    bullet.updateY(-1);
                    tankBullet = bullet;
                    repaint();
                    Thread.sleep(bullet.getSpeed());
                }

                //}

                break;
            case DOWN:
                //if (mainTank.getY() != downBorder) {

                while (checkDownBorder(bullet.getY(), downBorder) && !processInterception(bullet)) {
                    bullet.updateY(1);
                    tankBullet = bullet;
                    repaint();
                    Thread.sleep(bullet.getSpeed());
                }

                //}

                break;
            case LEFT:
                //if (mainTank.getX() != leftBorder) {

                while (checkLeftBorder(bullet.getX(), leftBorder) && !processInterception(bullet)) {
                    bullet.updateX(-1);
                    tankBullet = bullet;
                    repaint();
                    Thread.sleep(bullet.getSpeed());
                }
                //}

                break;
            case RIGHT:
                //if (mainTank.getX() != rightBorder) {

                while (checkRightBorder(bullet.getX(), rightBorder) && !processInterception(bullet)) {
                    bullet.updateX(1);
                    tankBullet = bullet;
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

        /*
        int x = mainTank.getX();
        int y = mainTank.getY();
        // boolean tmp = battleField.scanQuadrantScreenCoords(mainTank.getX(), mainTank.getY()).equals("X");

        if (!mainTank.isDestroyed()) {
            if (!battleField.scanQuadrantScreenCoords(x, y).equals("X")) {
                g.setColor(new Color(255, 0, 0));
                g.fillRect(mainTank.getX(), mainTank.getY(), PIXELS_IN_CELL, PIXELS_IN_CELL);

                g.setColor(new Color(0, 255, 0));
                if (mainTank.getDirection() == Direction.UP) {
                    g.fillRect(mainTank.getX() + 20, mainTank.getY(), 24, 34);
                } else if (mainTank.getDirection() == Direction.DOWN) {
                    g.fillRect(mainTank.getX() + 20, mainTank.getY() + 30, 24, 34);
                } else if (mainTank.getDirection() == Direction.LEFT) {
                    g.fillRect(mainTank.getX(), mainTank.getY() + 20, 34, 24);
                } else {
                    g.fillRect(mainTank.getX() + 30, mainTank.getY() + 20, 34, 24);
                }
            }
        }
*/
        paintTank(g, mainTank);
        paintTank(g, aggressor);

        paintBullet(g, tankBullet);
        /*
        g.setColor(new Color(255, 255, 0));
        g.fillRect(tankBullet.getX(), tankBullet.getY(), BULLET_X_DIMENTION, BULLET_Y_DIMENTION);
        */
    }

    protected void paintTank(Graphics g, Tank tank) {
        int x = tank.getX();
        int y = tank.getY();
        // boolean tmp = battleField.scanQuadrantScreenCoords(mainTank.getX(), mainTank.getY()).equals("X");

        if (!tank.isDestroyed()) {
            if (!battleField.scanQuadrantScreenCoords(x, y).equals("X")) {
                g.setColor(new Color(255, 0, 0));
                g.fillRect(tank.getX(), tank.getY(), PIXELS_IN_CELL, PIXELS_IN_CELL);

                g.setColor(new Color(0, 255, 0));
                if (tank.getDirection() == Direction.UP) {
                    g.fillRect(tank.getX() + 20, tank.getY(), 24, 34);
                } else if (tank.getDirection() == Direction.DOWN) {
                    g.fillRect(tank.getX() + 20, tank.getY() + 30, 24, 34);
                } else if (tank.getDirection() == Direction.LEFT) {
                    g.fillRect(tank.getX(), tank.getY() + 20, 34, 24);
                } else {
                    g.fillRect(tank.getX() + 30, tank.getY() + 20, 34, 24);
                }
            }
        }
    }

    protected void paintBullet(Graphics g, Bullet bullet) {
        g.setColor(new Color(255, 255, 0));
        g.fillRect(bullet.getX(), bullet.getY(), BULLET_X_DIMENTION, BULLET_Y_DIMENTION);
    }

}
