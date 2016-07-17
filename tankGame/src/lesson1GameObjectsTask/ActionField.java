/**
 * Created by Osipov on 21.02.2016.
 */
package lesson1GameObjectsTask;

import lesson1GameObjectsTask.ai.AI;
import lesson1GameObjectsTask.fields.Explosion;
import lesson1GameObjectsTask.fields.FieldCell;
import lesson1GameObjectsTask.fields.Grass;
import lesson1GameObjectsTask.interfaces.Destroyable;
import lesson1GameObjectsTask.tanks.BT7;
import lesson1GameObjectsTask.tanks.T34;
import lesson1GameObjectsTask.tanks.TankType;
import lesson1GameObjectsTask.tanks.Tiger;
import lesson1GameObjectsTask.utils.Memoirs;
import lesson1GameObjectsTask.utils.TankAction;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


import javax.swing.*;

import static lesson1GameObjectsTask.BattleField.PIXELS_IN_CELL;

import static lesson1GameObjectsTask.BattleField.X_MAX;
import static lesson1GameObjectsTask.BattleField.Y_MAX;
//import static lesson1GameObjectsTask.Bullet.*;

import static lesson1GameObjectsTask.Bullet.BULLET_X_DIMENTION;
import static lesson1GameObjectsTask.Bullet.BULLET_Y_DIMENTION;

public class ActionField extends JPanel {

    private final boolean COLORDED_MODE = false;

    private final int BULLET_X_DELTA = 25;
    private final int BULLET_Y_DELTA = 25;
    private JPanel panelFirstScreen;
    private JPanel panelGameover;
    private JFrame myFrame;

    private String tankType;

    private final String DESTRUCTABLE = "BCE"; //коды разрушаемых объектов: кирпич, танк компьютера, штаб
    private final String UN_DESTRUCTABLE = "WS"; //коды не разрушаемых объектов: вода, камни

    private final int EXPLOSIVE = 1000;
    private final int RESURECTION = 3000;

    private BattleField battleField;
    private AbstractTank mainTank;
    private Bullet tankBullet;

    private AbstractTank aggressor;
    private AbstractTank atacker;

    private boolean writeActionFile;
    private String fileName;
    private Memoirs memoirs;

    private AI ai;


    public void runTheGame() throws Exception {
        //clean(); //bricks destruction
        //Thread.sleep(2000);
        ai = new AI();

        //Memoirs memoirs = new Memoirs("a.txt");
        //memoirs.fileToWrite();
        //memoirs.fileToRead();


        //memoirs.readActionFile();
        //Thread.sleep(3000);
        atacker.move();
        atacker.fire();

        myFrame.getContentPane().removeAll();
        myFrame.getContentPane().add(panelGameover);
        //Thread.sleep(3000);
        //
        //panelFirstScreen.setEnabled(true);
        //panelFirstScreen.setVisible(true);
/*111111111111
       Direction[] path = ai.pathFinder(battleField, getQuadrantV(atacker.getY())+1, getQuadrantH(atacker.getX())+1,
               getQuadrantH(mainTank.getY())+1,  getQuadrantV(mainTank.getX())+1);
*/
//        Direction[] path = ai.pathFinder(battleField, getQuadrantV(atacker.getY())+1, getQuadrantH(atacker.getX())+1, 9,  3);
/*      for (Direction direction:
                path) {
            atacker.turn(direction);
            checkTank(atacker, mainTank);
            atacker.move();

        }
*/
/*        path = ai.pathFinder(battleField, getQuadrantV(atacker.getY())+1, getQuadrantH(atacker.getX())+1,
                getQuadrantH(mainTank.getY())+1,  getQuadrantV(mainTank.getX())+1);
        for (Direction direction:
                path) {
            atacker.turn(direction);
            checkTank(atacker, mainTank);
            atacker.move();
        }
        */
/*111111111111
        while (!mainTank.isDestroyed() && !atacker.isDestroyed() ) {
            atacker.turn(path[0]);
            checkTank(atacker, mainTank);
            atacker.move();
            //mainTank.turn(mainTank.randomDirection(mainTank.getDirection()));
            mainTank.move();

            path = ai.pathFinder(battleField, getQuadrantV(atacker.getY())+1, getQuadrantH(atacker.getX())+1,
                    getQuadrantH(mainTank.getY())+1,  getQuadrantV(mainTank.getX())+1);

        }
*/
/*
        Direction[] pathAggr = ai.pathFinder(battleField, getQuadrantH(aggressor.getX())+1, getQuadrantV(aggressor.getY())+1, 9, 3);
        for (Direction direction:
             pathAggr) {
            aggressor.turn(direction);
            aggressor.move();

        }
*/
        //aggressor.move();
/*
        mainTank.moveToQuadrant(1, 4);
       // mainTank.moveToQuadrant(1, 6);
        mainTank.turn(Direction.LEFT);
        mainTank.fire();
        mainTank.fire();
        mainTank.fire();
        repaint();
*/
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

        //mem
        writeActionFile = true; //Mock
        fileName = "result.txt";//Mock
        memoriesInit(fileName);//Mock

        mainTank = new T34(this, battleField);

        if(writeActionFile) {
            mainTank.setWriteActionFile(writeActionFile);
            mainTank.setMemoirs(memoirs);
        }

        tankBullet = new Bullet();

        //aggressor = new Tiger(this, battleField, battleField.getRandomLocationAggressor(), Direction.DOWN);
        //aggressor = new BT7(this, battleField, battleField.getRandomLocationAggressor(), Direction.DOWN);
        //atacker = new Tiger(this, battleField, battleField.getRandomLocationAtacker(), Direction.DOWN);


        JFrame frame = new JFrame("BATTLE FIELD, Tanks battles");
        frame.setLocation(500, 150);
        //frame.setMinimumSize(new Dimension(BF_WIDTH+15, BF_HEIGHT + 38));
        frame.setMinimumSize(new Dimension(battleField.getBF_WIDTH(), battleField.getBF_HEIGHT() + 35));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panelFirstScreen = new JPanel();
        panelGameover = new JPanel();

        gameOverPanel(frame);
        frame.getContentPane().removeAll();

        setFirstPanel(frame);
        myFrame = frame;

        frame.getContentPane().add(panelFirstScreen);
        frame.pack();
        frame.setVisible(true);




/*
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
*/
    }

    public void memoriesInit(String str) {
        //mem
        memoirs = new Memoirs(str);
        memoirs.clearFile();
        // memoirs.fileToWrite(this);

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
            if (aggressor.stricken()) {
                Thread.sleep(RESURECTION);
                aggressor = new Tiger(this, battleField, battleField.getRandomLocationAggressor(), Direction.DOWN);
                return true;
            } else {
                bullet.hit();
                return false;
            }
        }

        if (checkInterception(mainTank, bullet)) {
            if (mainTank.stricken()) {
                Thread.sleep(RESURECTION);
                mainTank = new Tiger(this, battleField, battleField.getRandomLocationAggressor(), Direction.DOWN);
                return true;
            } else {
                bullet.hit();
                return false;
            }
        }
        return false;
    }
/*
    private boolean isDestructable(int x, int y) {
        //String field = battleField.scanQuadrant(x / PIXELS_IN_CELL + 1, y / PIXELS_IN_CELL + 1);
        String field = battleField.scanQuadrant(y / PIXELS_IN_CELL, x / PIXELS_IN_CELL);
        if (DESTRUCTABLE.indexOf(field) >= 0) return true;
        else {
            return false;
        }
    }
*/
    //change
private boolean isDestructable(int x, int y) {
    //String field = battleField.scanQuadrant(x / PIXELS_IN_CELL + 1, y / PIXELS_IN_CELL + 1);
    FieldCell field = battleField.scanQuadrant(y / PIXELS_IN_CELL, x / PIXELS_IN_CELL);
    if (field instanceof Destroyable) return true;
    else {
        return false;
    }

    //return battleField.isQuadrantDestructable(y / PIXELS_IN_CELL, x / PIXELS_IN_CELL);
}

    private boolean checkInterception(AbstractTank tank, Bullet bullet) {
        if (tank.myBullet(bullet)) return false;
        String bulletQuadrant = getQuadrant(bullet.getX(), bullet.getY());

        if (bulletQuadrant.equals(getQuadrant(tank.getX(), tank.getY()))) return true;

        return false;
    }
//change
    private void destroyQuadrant(int x, int y) throws Exception {
        battleField.updateQuadrant(x, y, new Explosion(x, y));
        if (tankBullet != null) tankBullet.parking();
        repaint();
        Thread.sleep(EXPLOSIVE);
        //battleField.updateQuadrant(x, y, new FieldCell(x * PIXELS_IN_CELL, y * PIXELS_IN_CELL));
        battleField.updateQuadrant(x, y, new Grass(x, y));
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


    public void processTurn(AbstractTank tank) throws Exception {
        repaint();
    }

    public void processMove(AbstractTank tank) throws Exception {
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
                //vihod = 0;
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

    public boolean checkTank(AbstractTank atacker, AbstractTank goal) throws Exception  {
        switch (atacker.getDirection()) {
            case UP:
                if (atacker.getX() == goal.getX()) {
                    if(atacker.getY() - PIXELS_IN_CELL == goal.getY()) {

                        atacker.fire();
                        return true;
                    }
                }

                break;
            case DOWN:
                if (atacker.getX() == goal.getX()) {
                    if(atacker.getY() + PIXELS_IN_CELL == goal.getY()) {

                        atacker.fire();
                        return true;
                    }
                }

                break;
            case LEFT:

                if (atacker.getY() == goal.getY()) {
                    if(atacker.getX() - PIXELS_IN_CELL == goal.getX()) {

                        atacker.fire();
                        return true;
                    }
                }
                break;
            case RIGHT:

                if (atacker.getY() == goal.getY()) {
                    if(atacker.getX() + PIXELS_IN_CELL == goal.getX()) {

                        atacker.fire();
                        return true;
                    }
                }


                break;
        }

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

        battleField.draw(g);
        /*
        for (int j = 0; j < battleField.getDimentionX(); j++) {
            for (int k = 0; k < battleField.getDimentionY(); k++) {
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
*/
        //draw(g, mainTank);
        //draw(g, aggressor);
        mainTank.draw(g);
        aggressor.draw(g);
        atacker.draw(g);

        //paintBullet(g, tankBullet);
        tankBullet.draw(g);

    }

    private void setFirstPanel(JFrame frame) throws Exception  {

        panelFirstScreen.setLayout(new GridBagLayout());
        JLabel text = new JLabel("Tank Game");
        JTextArea quation = new JTextArea("Choose your tank:");

        panelFirstScreen.add(text, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panelFirstScreen.add(quation, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                0, new Insets(0, 0, 0, 0), 0, 0));

        JPanel tanksPanel = new JPanel();
        tanksPanel.setLayout(new GridLayout(2, 0));
        tanksPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));

        JButton buttonBuy = new JButton();

        JRadioButton[] tanksRB = new JRadioButton[2];
        tanksRB[0] = new JRadioButton("Tiger");
        tanksRB[0].setMnemonic(KeyEvent.VK_T);
        tanksRB[0].setActionCommand("Tiger");
        tanksRB[0].setSelected(true);

        tanksRB[1] = new JRadioButton();
        tanksRB[1].setText("BT-7");
        tanksRB[1].setMnemonic(KeyEvent.VK_B);
        tanksRB[1].setActionCommand("BT-7");
        //tanksRB[1].onC

        tanksPanel.add(tanksRB[0]);
        tanksPanel.add(tanksRB[1]);

        ButtonGroup tanksGroup = new ButtonGroup();
        tanksGroup.add(tanksRB[0]);
        tanksGroup.add(tanksRB[1]);

        panelFirstScreen.add(tanksPanel, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                0, new Insets(0, 0, 0, 0), 0, 0));



        buttonBuy.setText("Play");
        buttonBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // tankType = e.getActionCommand();
                tankType = tanksGroup.getSelection().getActionCommand();
                        System.out.println(tankType);
                try {
                    panelFirstScreen.setVisible(false);
                    panelFirstScreen.setEnabled(false);

                    setFrame(frame);

                } catch (Exception ex)       {
                    System.out.println("First panel" + ex);
                }
            }
        });

        panelFirstScreen.add(buttonBuy, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                0, new Insets(0, 0, 0, 0), 0, 0));

        frame.getContentPane().add(panelFirstScreen);

        panelFirstScreen.setEnabled(true);
        panelFirstScreen.setVisible(true);

    }

    private void gameOverPanel(JFrame frame) throws Exception  {
        panelGameover.setLayout(new GridBagLayout());
        JLabel text = new JLabel("Gameover");
        JTextArea quation = new JTextArea("Please check:");

        panelGameover.add(text, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panelGameover.add(quation, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                0, new Insets(0, 0, 0, 0), 0, 0));

        JButton buttonPlayAgain = new JButton();
        JButton buttonExit = new JButton();


        buttonPlayAgain.setText("Play again");
        buttonPlayAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    panelGameover.setVisible(false);
                    panelGameover.setEnabled(false);
                    panelFirstScreen.setEnabled(true);
                    panelFirstScreen.setVisible(true);

                    frame.getContentPane().removeAll();
                    //setFirstPanel(frame);
                    frame.getContentPane().add(panelFirstScreen);

                } catch (Exception ex)       {
                    System.out.println("Game over" + ex);
                }
            }
        });

        buttonExit.setText("Exit");
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    frame.dispose();
                } catch (Exception ex)       {
                    System.out.println("Game over" + ex);
                }
            }
        });

        panelGameover.add(buttonPlayAgain, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                0, new Insets(0, 0, 0, 0), 0, 0));
        panelGameover.add(buttonExit, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START,
                0, new Insets(0, 0, 0, 0), 0, 0));

        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelGameover);
        panelGameover.setEnabled(true);
        panelGameover.setVisible(true);
    }

    private void setFrame(JFrame frame) throws Exception {
        if(tankType.equals("Tiger")) {
            aggressor = new Tiger(this, battleField, battleField.getRandomLocationAtacker(), Direction.DOWN);
            aggressor.setTankType(TankType.AGRESSOR);
            atacker = new Tiger(this, battleField, battleField.getRandomLocationAtacker(), Direction.DOWN);
            atacker.setTankType(TankType.ATACKER);
            if(writeActionFile) {
                aggressor.setWriteActionFile(writeActionFile);
                aggressor.setMemoirs(memoirs);
                atacker.setWriteActionFile(writeActionFile);
                atacker.setMemoirs(memoirs);
            }


        } else {
            aggressor = new BT7(this, battleField, battleField.getRandomLocationAggressor(), Direction.DOWN);
            aggressor.setTankType(TankType.AGRESSOR);
            atacker = new Tiger(this, battleField, battleField.getRandomLocationAtacker(), Direction.DOWN);
            atacker.setTankType(TankType.ATACKER);
            if(writeActionFile) {
                aggressor.setWriteActionFile(writeActionFile);
                aggressor.setMemoirs(memoirs);
                atacker.setWriteActionFile(writeActionFile);
                atacker.setMemoirs(memoirs);
            }
        }

        frame.getContentPane().removeAll();
        //panelFirstScreen.setVisible(false);
        //panelFirstScreen.setEnabled(false);

        frame.getContentPane().add(this);
        //this.setVisible(true);
        //this.setEnabled(true);
        frame.pack();
        frame.repaint();

        runTheGame();
    }
/*
    protected void draw(Graphics g, AbstractTank tank) {
        int x = tank.getX();
        int y = tank.getY();
        // boolean tmp = battleField.scanQuadrantScreenCoords(mainTank.getX(), mainTank.getY()).equals("X");

        if (!tank.isDestroyed()) {
            if (!battleField.scanQuadrantScreenCoords(x, y).equals("X")) {
                g.setColor(new TankColor(255, 0, 0));
                g.fillRect(tank.getX(), tank.getY(), PIXELS_IN_CELL, PIXELS_IN_CELL);

                g.setColor(new TankColor(0, 255, 0));
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
*/
}
