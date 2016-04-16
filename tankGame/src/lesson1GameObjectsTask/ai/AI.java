package lesson1GameObjectsTask.ai;


import lesson1GameObjectsTask.BattleField;
import lesson1GameObjectsTask.Direction;
//import lesson1GameObjectsTask.fields.FieldCell;
import lesson1GameObjectsTask.fields.*;

public class AI {

    final static int FIELD_BORDER = 1000000;
    public Direction[] pathFinder(BattleField battleField, int qxStart, int qyStart, int qxFinish, int qyFinish) {
        int pathLength = 1;
        int[][] wayMap = new int[battleField.getDimentionX()+2][battleField.getDimentionY()+2];
        qxFinish++;
        qxFinish++;
        wayMap[++qxStart][++qyStart] = 0;
        for(int i = 0;i < wayMap[0].length;i++) {
            wayMap[0][i] = FIELD_BORDER;
            wayMap[wayMap.length-1][i] = FIELD_BORDER;
        }
        for(int i = 1;i < wayMap.length-1;i++) {
            wayMap[i][0] = FIELD_BORDER;
            wayMap[i][wayMap[0].length-1] = FIELD_BORDER;
        }

        wayMap[qxStart][qyStart+1] = fieldStep(battleField.scanQuadrant(qxStart, qyStart+1)) - directionOnEagle(qxStart, qyStart, qxFinish, qyFinish);

        /*
        for(int i = 0;i < battleField.getDimentionX();i++) {
            for(int j = 0; j < battleField.getDimentionY();j++) {
                FieldCell cur = battleField.scanQuadrant(qxStart, qyStart);

            }
        }
        */


        Direction[] path = new Direction[pathLength];


        return path;
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
            step = 2000;
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
            return Direction.RIGHT;
        } else if (qxFinish < qxStart) {
            return Direction.LEFT;
        } else if (qyFinish < qyStart) {
            return Direction.UP;
        } else {
            return Direction.DOWN;
        }
    }

}
