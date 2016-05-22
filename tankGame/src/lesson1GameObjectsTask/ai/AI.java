package lesson1GameObjectsTask.ai;


import lesson1GameObjectsTask.BattleField;
import lesson1GameObjectsTask.Direction;
//import lesson1GameObjectsTask.fields.FieldCell;
import lesson1GameObjectsTask.fields.*;

import java.util.ArrayList;
import java.util.List;

public class AI {

    final static int FIELD_BORDER = 1000000;

    public Direction[] pathFinder(BattleField battleField, int qxStart, int qyStart, int qxFinish, int qyFinish) {
        int pathLength = 0;
        CrossNode[] helix = {new CrossNode(0, 0), new CrossNode(1, 0), new CrossNode(1, -1), new CrossNode(0, -1),
                new CrossNode(-1, -1), new CrossNode(-1, 0), new CrossNode(-1, 1), new CrossNode(0, 1), new CrossNode(1, 1)};
        CrossNode[] weigthStep = {new CrossNode(1, 0), new CrossNode(0, -1), new CrossNode(-1, 0), new CrossNode(0, 1)};

        int[][] wayMap = new int[battleField.getDimentionX()+2][battleField.getDimentionY()+2];
        boolean exit = false;

        //qxFinish++;
       // qyFinish++;
        wayMap[qxStart][qyStart] = 0;
        for(int i = 0;i < wayMap[0].length;i++) {
            wayMap[0][i] = FIELD_BORDER;
            wayMap[wayMap.length-1][i] = FIELD_BORDER;
        }
        for(int i = 1;i < wayMap.length-1;i++) {
            wayMap[i][0] = FIELD_BORDER;
            wayMap[i][wayMap[0].length-1] = FIELD_BORDER;
        }

       // wayMap[qxStart][qyStart+1] = fieldStep(battleField.scanQuadrant(qxStart, qyStart+1)) - directionOnEagle(qxStart, qyStart, qxFinish, qyFinish);

 //       int cur = wayMap[qxStart][qyStart];

        boolean find = false;
        int xProhod = qxStart;
        int yProhod = qyStart;

        int xCur = xProhod;
        int yCur = yProhod;

        while(!exit) {
            exit = true;

            for(int i=0;i < helix.length;i++) {
                xCur = xProhod + helix[i].dx;
                yCur = yProhod + helix[i].dy;
                int cur = wayMap[xCur][yCur];
                CrossNode cross = new CrossNode(xCur, yCur);

                for(int j=0;j < weigthStep.length;j++) {
                    cross = new CrossNode(xCur + weigthStep[j].dx, yCur + weigthStep[j].dy);

                    if (wayMap[cross.dx][cross.dy] < 100000) {
                        int tmp = cur + fieldStep(battleField.scanQuadrant(cross.dx-1, cross.dy-1)) -
                                directionOnEagle(cross.dx-1, cross.dy-1, qxFinish-1, qyFinish-1);
                        if((wayMap[cross.dx][cross.dy] == 0 && !(cross.dx == qxStart && cross.dy == qyStart))
                                || (wayMap[cross.dx][cross.dy] < 100000 && tmp < wayMap[cross.dx][cross.dy])) {
                            exit = false;

                            wayMap[cross.dx][cross.dy] = tmp;
                        }
                    }

                }
               // printArray(wayMap);

                //System.out.println();
                /*int tmp = wayMap[xCur + helix[i].dx][yCur+helix[i].dy];

                if(tmp == 0 || tmp < cur) {
                    exit = false;
                    wayMap[xCur + helix[i].dx][yCur+helix[i].dy] =
                            fieldStep(battleField.scanQuadrant(qxStart, qyStart+1)) - directionOnEagle(qxStart, qyStart, qxFinish, qyFinish);
                }*/
            }

            //cur = wayMap[qxStart][qyStart];
            //int numOfStep = 2;//for max/2
            for(int numOfStep = 2; numOfStep < 8;numOfStep++) {
                for(int i = -numOfStep;i < numOfStep;i++) {
                    for(int k = -numOfStep;k < numOfStep;k++) {
                        xCur = xProhod + i;
                        yCur = yProhod + k;

                        if (xCur > 0 && xCur < wayMap.length && yCur > 0 && yCur < wayMap[0].length) {
                            int cur = wayMap[xCur][yCur];
                            CrossNode cross = new CrossNode(xCur, yCur);

                            for(int j=0;j < weigthStep.length;j++) {
                                cross = new CrossNode(xCur + weigthStep[j].dx, yCur + weigthStep[j].dy);

                                if (wayMap[cross.dx][cross.dy] < 100000) {
                                    int tmp = cur + fieldStep(battleField.scanQuadrant(cross.dx-1, cross.dy-1)) -
                                            directionOnEagle(cross.dx-1, cross.dy-1, qxFinish-1, qyFinish-1);
                                    if((wayMap[cross.dx][cross.dy] == 0 && !(cross.dx == qxStart && cross.dy == qyStart))
                                            || (wayMap[cross.dx][cross.dy] < 100000 && tmp < wayMap[cross.dx][cross.dy])) {
                                        exit = false;

                                        wayMap[cross.dx][cross.dy] = tmp;
                                    }
                                }

                            }
                        }

                    }
                  //  printArray(wayMap);

                  //  System.out.println();
                }
            }

            printArray(wayMap);

            System.out.println();

            if(xCur >= qxFinish && yCur >= qyFinish) find = true;

            exit = true;
        }

        exit = false;
        xProhod = qxFinish;
        yProhod = qyFinish;
        List<CrossNode> direction = new ArrayList<>();

        while(!exit) {
            int min = wayMap[xProhod][yProhod];//FIELD_BORDER;
            for(int i=0;i < weigthStep.length;i++) {
                int xTmp = xProhod + weigthStep[i].dx;
                int yTmp = yProhod + weigthStep[i].dy;
                if (min > wayMap[xTmp][yTmp]) {
                   min = wayMap[xTmp][yTmp];
                    xCur = xTmp;
                    yCur = yTmp ;
                }

            }

            if(xCur == qxStart && yCur == qyStart) {
                exit = true;
                //break;
            }
            xProhod = xCur;
            yProhod = yCur;
            direction.add(new CrossNode(xProhod, yProhod));
            pathLength++;

        }

        /*
        for(int i = 0;i < battleField.getDimentionX();i++) {
            for(int j = 0; j < battleField.getDimentionY();j++) {
                FieldCell cur = battleField.scanQuadrant(qxStart, qyStart);

            }
        }
        */


        Direction[] path = new Direction[pathLength];
        int i = path.length-1;

        for (CrossNode crn:
             direction) {
            if (i >= 0) {
                path[i] = pathtoDirection(crn.dx, crn.dy, qxFinish, qyFinish);
                qxFinish = crn.dx;
                qyFinish = crn.dy;
            }
            i--;
        }


        return path;
    }

    private void printArray(int[][] array) {
        for(int i = 0; i < array.length;i++) {
            for(int j =0; j <array[i].length-1;j++){
                System.out.print(array[i][j] + ", ");
            }
            System.out.println(array[i][array[i].length-1]);
        }
    }

    private void mapDefinition() {

    }

    private int fieldStep(FieldCell cell) {
        int step = 2;
        if (cell instanceof Brick) {
            step = 10;
        } else if (cell instanceof Rock) {
            step = 1000;
        } else if (cell instanceof Water) {
            step = 5;
            //step = 2000;
        } else {
            step = 2;
        }

        return step;
    }

    private int directionOnEagle(int qxStart, int qyStart, int qxFinish, int qyFinish) {
        return 1;
    }

    private Direction pathtoDirection(int qxStart, int qyStart, int qxFinish, int qyFinish) {
        if (qxFinish > qxStart) {
            return Direction.DOWN;
        } else if (qxFinish < qxStart) {
            return Direction.UP;
        } else if (qyFinish < qyStart) {
            return Direction.LEFT;
        } else {
            return Direction.RIGHT;
        }
    }

    private class CrossNode {
        int dx;
        int dy;


        public CrossNode(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }

}
