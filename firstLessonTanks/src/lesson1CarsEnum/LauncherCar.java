package lesson1CarsEnum;

/**
 * Created by Rodichka on 23.02.2016.
 */
public class LauncherCar {

    public static void main(String[] args) throws Exception {

        Car myCar = new Car(Colors.MAGENTA, "GM", "Chevy");
        Car friendCar = new Car();

        //System.out.print(myCar.getColor() + "car. ");
        myCar.changeGearUp();
        myCar.moveForward(30);
        System.out.println();

        friendCar.moveTo(50.357373, 30.549857);
        System.out.println();

        myCar.rePaint(Colors.VIOLET);
        friendCar.changeGearDown();
        friendCar.moveBackward(10);

        System.out.println();

        myCar.breakCar();


    }

}
