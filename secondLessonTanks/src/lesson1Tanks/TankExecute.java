package lesson1Tanks;

/**
 * Created by Rodichka on 29.02.2016.
 */
public class TankExecute {
    public static void main(String[] args) {

        Tank [] tanks = new Tank[2];
        tankInit(tanks);

        printTankInfo(tanks);

        Tank [] tank = new Tank [1];
        //tankInit(tank);
        printTankInfo(tank);

        Tiger firstTiger = new Tiger();
        BT7 firstBt = new BT7();
        T34 firstT = new T34();

        /*
        firstTiger.printTankInfo();
        firstBt.printTankInfo();
        firstT.printTankInfo();
        */

        System.out.println(tanks[0]);
        System.out.println(firstTiger);
        System.out.println(firstBt);
        System.out.println(firstT);

        firstTiger.move();
        firstBt.move();
        firstT.move();

    }

    public static void printTankInfo(Tank [] tanks) {
        if (tanks != null) {
            for(Tank currentTank:tanks) {
                if (currentTank != null) {
                    currentTank.printTankInfo();
                    System.out.println();
                }
                else {
                    System.out.println("Пустые танки.");
                    System.out.println();
                }
            }

        }
        else {
            System.out.println("Пустой массив танков.");
            System.out.println();
        }

    }

    public static void tankInit(Tank [] tanks) {
        for (int i = 0; i < tanks.length; i++) {
            tanks[i] = new Tank();
            tanks[i].setColor("хаки");
            tanks[i].setCrew(i+2);
            tanks[i].setMaxSpeed(80+2*i);
        }

    }
}
