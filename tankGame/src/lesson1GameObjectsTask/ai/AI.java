package lesson1GameObjectsTask.ai;


import lesson1GameObjectsTask.BattleField;
import lesson1GameObjectsTask.Direction;

public class AI {
    public Direction[] pathFinder(BattleField battleField, int qxStart, int qyStart, int qxFinish, int qyFinish) {
        int pathLength = 1;
        int[][] wayMap = new int[battleField.getDimentionX()][battleField.getDimentionY()];

        Direction[] path = new Direction[pathLength];


        return path;
    }

    private void mapDefinition() {

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
