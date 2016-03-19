package old;

/**
 * Created by Rodichka on 28.02.2016.
 */
public class ActionField {
/*
    public void processMove(AbstractTank tank) throws Exception {
        int leftBorder = 0;
        int rightBorder = X_MAX*PIXELS_IN_CELL;
        int upBorder = 0;
        int downBorder = Y_MAX*PIXELS_IN_CELL;

        int vihod;

        if (mainTank.getDirection() == UP) {
            int next = 0;
            mainTank.setDirection(UP);

            if (mainTank.getY() != upBorder) {
                next = mainTank.getY() - PIXELS_IN_CELL;

                //
                vihod = 1;

                while (vihod != 0) {
                    if (mainTank.getY() == next) {
                        vihod = 0;
                    } else {
                        mainTank.moveUp();
                    }

                    repaint();
                    Thread.sleep(mainTank.getSpeed());
                }

                System.out.println("Танк переехал вверх из квадранта " + battleField.getQuadrantNum(mainTank.getX(),
                        mainTank.getY()+PIXELS_IN_CELL) + " в квадрант " +
                        battleField.getQuadrantNum(mainTank.getX(), mainTank.getY()));
            }
            else {
                System.out.println("Граница поля.");
                vihod = 0;
            }

        } else if (mainTank.getDirection() == DOWN) {
            int next = 0;
            mainTank.setDirection(DOWN);

            if (mainTank.getY() != downBorder) {
                next = mainTank.getY() + PIXELS_IN_CELL;

                //
                vihod = 1;

                while (vihod != 0) {
                    if (mainTank.getY() == next) {
                        vihod = 0;
                    } else {
                        mainTank.moveDown();
                    }

                    repaint();
                    Thread.sleep(mainTank.getSpeed());
                }

                System.out.println("Танк переехал вниз из квадранта " +
                        battleField.getQuadrantNum(mainTank.getX(), mainTank.getY()-PIXELS_IN_CELL) +
                        " в квадрант " + battleField.getQuadrantNum(mainTank.getX(), mainTank.getY()));
            }
            else {
                System.out.println("Граница поля.");
                vihod = 0;
            }

        } else if (mainTank.getDirection() == LEFT) {
            int  next = 0;
            mainTank.setDirection(LEFT);

            if (mainTank.getX() != leftBorder) {
                next = mainTank.getX() - PIXELS_IN_CELL;

                //
                vihod = 1;

                while (vihod != 0) {
                    if (mainTank.getX() == next) {
                        vihod = 0;

                    } else {
                        mainTank.moveLeft();
                    }

                    repaint();
                    Thread.sleep(mainTank.getSpeed());
                }

                System.out.println("Танк переехал влево из квадранта " +
                        battleField.getQuadrantNum(mainTank.getX()+PIXELS_IN_CELL ,
                                mainTank.getY()) + " в квадрант " +
                        battleField.getQuadrantNum(mainTank.getX(), mainTank.getY()));
            }
            else {
                System.out.println("Граница поля.");
                vihod = 0;
            }

        } else if (mainTank.getDirection() == RIGHT) {
            int  next = 0;
            mainTank.setDirection(RIGHT);

            if (mainTank.getX() != rightBorder) {
                next = mainTank.getX() + PIXELS_IN_CELL;

                //
                vihod = 1;

                while (vihod != 0) {
                    if (mainTank.getX() == next) {
                        vihod = 0;

                    } else{
                        mainTank.moveRight();
                    }

                    repaint();
                    Thread.sleep(mainTank.getSpeed());
                }

                System.out.println("Танк переехал вправо из квадранта " +
                        battleField.getQuadrantNum(mainTank.getX()-PIXELS_IN_CELL,
                                mainTank.getY()) + " в квадрант " +
                        battleField.getQuadrantNum(mainTank.getX(), mainTank.getY()));
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

    boolean isQuadrantDestructable(int[] quadrantCoord) {
        if (DESTRUCTABLE.indexOf(battleField[quadrantCoord[QY]][quadrantCoord[QX]]) >= 0) {
            return true;
        }
        else {
            return false;
        }
    }
    */
}
