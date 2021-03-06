package lesson1GameObjectsTask.tanks;

import lesson1GameObjectsTask.AbstractTank;
import lesson1GameObjectsTask.ActionField;
import lesson1GameObjectsTask.BattleField;
import lesson1GameObjectsTask.Direction;

import java.awt.*;

/**
 * Created by Osipov on 07.03.2016.
 */
public class Tiger extends AbstractTank {
    /*final String[] spritesTankFilesName= {
            "sprites\\TIGER\\tankup64.png",
            "sprites\\TIGER\\tankdown64.png",
            "sprites\\TIGER\\tankleft64.png",
            "sprites\\TIGER\\tankright64.png"
            //"sprites\\images_tank64_tr.png",
            //"sprites\\tankdown64.jpg",
            //"sprites\\tankleft64.jpg",
            //"sprites\\tankright64.jpg"
    };*/

    private int armor;

    public Tiger(ActionField af, BattleField bf) {
        this(af, bf, 128, 512, Direction.UP);
   }

    public Tiger(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        armor = 1;
        color = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);

        super.spritesTankFilesName = new String[] {
                "sprites\\TIGER\\tankup64.png",
                "sprites\\TIGER\\tankdown64.png",
                "sprites\\TIGER\\tankleft64.png",
                "sprites\\TIGER\\tankright64.png"
        };

        super.loadSpritesTank();
    }

    public Tiger(ActionField af, BattleField bf, String coord, Direction direction) {
        this(af, bf, Integer.parseInt(coord.split("_")[0]), Integer.parseInt(coord.split("_")[1]), direction);
    }

    @Override
    public boolean stricken() throws Exception {
        if(armor > 0) {
            armor --;
            System.out.println("Попадание в тигр!");
            return false;
        }
        else return super.destroy();
    }

}
