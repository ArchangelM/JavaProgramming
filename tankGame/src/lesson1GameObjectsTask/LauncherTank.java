/**
 * Created by Osipov on 21.02.2016.
 */
package lesson1GameObjectsTask;

import lesson1GameObjectsTask.ai.AI;

public class LauncherTank {
        public static void main(String[] args) throws Exception {

            if(args.length > 0) {
                System.out.println(args[0]);
                ActionField myGame = new ActionField(args[0]);
            }
            else {
                ActionField myGame = new ActionField();
            }


            /*
            AI ai = new AI();
            BattleField bf = new BattleField();
            Direction[] path = ai.pathFinder(bf, 2, 2, 7, 7);
            System.out.println();
            */
            //myGame.runTheGame();
        }

}
