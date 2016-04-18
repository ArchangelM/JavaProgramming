package lesson1GameObjectsTask.tanks;

import lesson1GameObjectsTask.AbstractTank;
import lesson1GameObjectsTask.ActionField;
import lesson1GameObjectsTask.BattleField;
import lesson1GameObjectsTask.Direction;

import java.awt.*;

/**
 * Created by Osipov on 20.03.2016.
 */
public class T34 extends AbstractTank {
    /*final String[] STR_T34= {
            "sprites\\T34\\tankup64.png",
            "sprites\\T34\\tankdown64.png",
            "sprites\\T34\\tankleft64.png",
            "sprites\\T34\\tankright64.png"
            //"sprites\\images_tank64_tr.png",
            //"sprites\\tankdown64.jpg",
            //"sprites\\tankleft64.jpg",
            //"sprites\\tankright64.jpg"
    };*/

    public T34(ActionField af, BattleField bf) {
        this(af, bf, 128, 512, Direction.UP);
    }

    public T34(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        color = new Color(0, 255, 0);
        towerColor = new Color(255, 0, 0);

        super.spritesTankFilesName = new String[] {
                "sprites\\T34\\tankup64.png",
                "sprites\\T34\\tankdown64.png",
                "sprites\\T34\\tankleft64.png",
                "sprites\\T34\\tankright64.png"
        };

        super.loadSpritesTank();
    }

    public T34(ActionField af, BattleField bf, String coord, Direction direction) {
        this(af, bf, Integer.parseInt(coord.split("_")[0]), Integer.parseInt(coord.split("_")[1]), direction);
    }


}

/*

final String[] STR_FIELD = {
			"sprites\\brick64.jpg",
			"sprites\\water64.jpg",
			"sprites\\grass64.jpg"
		 };


	Image imgBrick, imgWater, imgGrass;


 */