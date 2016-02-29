package lesson1Tanks;

/**
 * Created by Rodichka on 29.02.2016.
 */
public class TankExecute {
    public static void main(String[] args) {

        Tank [] tanks = new Tank[3];
        tankInit(tanks);

        printTankInfo(tanks);

        Tank [] tank = new Tank [1];
        //tankInit(tank);
        printTankInfo(tank);

        Tiger firstTiger = new Tiger();
        BT7 firstBt = new BT7();
        T34 firstT = new T34();



    }

    public static void printTankInfo(Tank tank) {
        if (tank != null) {
            System.out.println("Танк цвета " + tank.getColor() + ". ");
            System.out.println("Экипаж составляет " + tank.getCrew() + " человека. ");
            System.out.println("Максимальная скорость " + tank.getMaxSpeed() + " " + tank.getSpeedUnit() + ".");
        }
        else {
            System.out.print("Пустой танк.");
        }
    }

    public static void printTankInfo(Tank [] tanks) {
        if (tanks != null) {
            for(Tank currentTank:tanks) {
                printTankInfo(currentTank);
                System.out.println();
            }

        }
        else {
            System.out.println("Пустой массив.");
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
