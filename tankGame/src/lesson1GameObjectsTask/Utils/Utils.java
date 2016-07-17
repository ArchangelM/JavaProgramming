package lesson1GameObjectsTask.utils;

import lesson1GameObjectsTask.AbstractTank;
import lesson1GameObjectsTask.Direction;
import lesson1GameObjectsTask.fields.*;
import lesson1GameObjectsTask.tanks.TankType;
import lesson1GameObjectsTask.utils.TankAction;

import static lesson1GameObjectsTask.tanks.TankType.*;

public class Utils {

    public static void Init(FieldCell[][] battleField, String[][] battleFieldS) {

        for(int i = 0;i < battleFieldS.length;i++) {
            for(int j = 0;j < battleFieldS[i].length;j++) {
                if (battleFieldS[i][j].equals("B")) {
                    battleField[i][j] = new Brick(i, j);

                }  else if (battleFieldS[i][j].equals("G")) {
                    battleField[i][j] = new Grass(i, j);

                } else if (battleFieldS[i][j].equals("W")) {
                    battleField[i][j] = new Water(i, j);

                } else if (battleFieldS[i][j].equals("E")) {
                    battleField[i][j] = new Eagle(i, j);

                } else if (battleFieldS[i][j].equals("R")) {
                    battleField[i][j] = new Rock(i, j);
                } else {
                    battleField[i][j] = new FieldCell(i, j);
                }
            }
        }
    }

    public static char tankTypeWriteConverter(AbstractTank abstractTank) {
        switch(abstractTank.getTankType()) {
            case AGRESSOR: return 'A';
            case DEFFENDER: return 'D';
            case ATACKER: return 'T';
            case PLAYERTANK: return 'P';
        }
        return 0;
    }

    public static TankType tankTypeReadConverter(char ch) {
        switch(ch) {
            case 'A': return AGRESSOR;
            case 'D': return DEFFENDER;
            case 'T': return ATACKER;
            case 'P': return PLAYERTANK;
            default: return DEFFENDER;
        }

    }

    public static char actionWriteConverter(TankAction tankAction) {
        switch(tankAction) {
            case UP: return 'U';
            case DOWN: return 'D';
            case LEFT: return 'L';
            case RIGHT: return 'R';
            case FIRE: return 'F';
            case NONE: return 'N';
            case MOVE: return 'M';
            default: return 'N';
        }

    }

    public static TankAction actionReadConverter(char ch) {
        switch(ch) {
            case 'U': return TankAction.UP;
            case 'D': return TankAction.DOWN;
            case 'L': return TankAction.LEFT;
            case 'R': return TankAction.RIGHT;
            case 'F': return TankAction.FIRE;
            case 'M' : return TankAction.MOVE;
            default: return TankAction.NONE;
        }

    }

    public static TankAction directionToAction(Direction direction) {
        switch(direction) {
            case UP: return TankAction.UP;
            case DOWN: return TankAction.DOWN;
            case LEFT: return TankAction.LEFT;
            case RIGHT: return TankAction.RIGHT;
            default: return TankAction.NONE;
        }

    }
}
