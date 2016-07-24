package threads.circles;

import java.awt.*;

public class Utils {
    private static final int begin = 10;
    private static final int diametr = 16;

    public static void circleInit(Circle circle, int num) {
        //circle.setSpeed((num+1)*5);
        switch (num%10) {
            case 0:
                circle.setColor(Color.BLACK);
                circle.setSpeed(5);
                break;
            case 1:
                circle.setColor(Color.RED);
                circle.setSpeed(15);
                break;
            case 2:
                circle.setColor(Color.BLUE);
                circle.setSpeed(7);
                break;
            case 3:
                circle.setColor(Color.YELLOW);
                circle.setSpeed(8);
                break;
            case 4:
                circle.setColor(Color.DARK_GRAY);
                circle.setSpeed(9);
                break;
            case 5:
                circle.setColor(Color.GREEN);
                circle.setSpeed(10);
                break;
            case 6:
                circle.setColor(Color.CYAN);
                circle.setSpeed(11);
                break;
            case 7:
                circle.setColor(Color.MAGENTA);
                circle.setSpeed(10);
                break;
            case 8:
                circle.setColor(Color.PINK);
                circle.setSpeed(15);
                break;
            case 9:
                circle.setColor(Color.ORANGE);
                circle.setSpeed(20);
                break;
        }


        circle.setX(diametr/2);
        //circle.setY(begin + 2*diametr*num);
        circle.setY(begin);
        circle.setH(diametr);
        circle.setW(diametr);
    }

}
