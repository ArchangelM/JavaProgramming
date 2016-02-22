package lesson1CarsEnum;

/**
 * Created by Rodichka on 23.02.2016.
 */
public class Launcher {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Car myCar = new Car(Colors.MAGENTA, "GM", "Chevy");
        Car friendCar = new Car();

        //System.out.print(myCar.getColor() + "car. ");
        myCar.moveForward();
        System.out.println();

        friendCar.moveTo(50.357373, 30.549857);
        System.out.println();

        myCar.rePaint(Colors.VIOLET);
        friendCar.moveBackward();


    }

}
