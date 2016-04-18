/**
 * Created by Osipov on 21.02.2016.
 */
package lesson1GameObjectsTask;

import lesson1GameObjectsTask.ai.AI;

public class LauncherTank {
        public static void main(String[] args) throws Exception {
            // TODO Auto-generated method stub
            ActionField myGame = new ActionField();

            /*
            AI ai = new AI();
            BattleField bf = new BattleField();
            Direction[] path = ai.pathFinder(bf, 2, 2, 7, 7);
            System.out.println();
            */
            myGame.runTheGame();
        }

}
