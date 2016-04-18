package lesson1GameObjectsTask.tanks;

import lesson1GameObjectsTask.AbstractTank;
import lesson1GameObjectsTask.ActionField;
import lesson1GameObjectsTask.BattleField;
import lesson1GameObjectsTask.Direction;

import java.awt.*;

/**
 * Created by Osipov on 07.03.2016.
 */
public class BT7 extends AbstractTank {
    /*final String[] STR_BT7= {
            "sprites\\BT7\\tankup64.png",
            "sprites\\BT7\\tankdown64.png",
            "sprites\\BT7\\tankleft64.png",
            "sprites\\BT7\\tankright64.png"
            //"sprites\\images_tank64_tr.png",
            //"sprites\\tankdown64.jpg",
            //"sprites\\tankleft64.jpg",
            //"sprites\\tankright64.jpg"
    };*/

    public BT7(ActionField af, BattleField bf) {
        this(af, bf, 128, 512, Direction.UP);
    }

    public BT7(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        speed /= 2;
        color = new Color(0, 255, 0);
        towerColor = new Color(255, 0, 0);

        super.spritesTankFilesName = new String[] {
                "sprites\\BT7\\tankup64.png",
                "sprites\\BT7\\tankdown64.png",
                "sprites\\BT7\\tankleft64.png",
                "sprites\\BT7\\tankright64.png"
        };

        super.loadSpritesTank();
    }

    public BT7(ActionField af, BattleField bf, String coord, Direction direction) {
        this(af, bf, Integer.parseInt(coord.split("_")[0]), Integer.parseInt(coord.split("_")[1]), direction);
    }


}
