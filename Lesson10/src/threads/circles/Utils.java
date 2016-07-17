package threads.circles;

import java.awt.*;

public class Utils {
    private static final int begin = 40;
    private static final int diametr = 16;

    public static void circleInit(Circle circle, int num) {
        switch (num%10) {
            case 0:
                circle.setColor(Color.BLACK);
                break;
            case 1:
                circle.setColor(Color.RED);
                break;
            case 2:
                circle.setColor(Color.BLUE);
                break;
            case 3:
                circle.setColor(Color.YELLOW);
                break;
            case 4:
                circle.setColor(Color.DARK_GRAY);
                break;
            case 5:
                circle.setColor(Color.GREEN);
                break;
            case 6:
                circle.setColor(Color.CYAN);
                break;
            case 7:
                circle.setColor(Color.MAGENTA);
                break;
            case 8:
                circle.setColor(Color.PINK);
                break;
            case 9:
                circle.setColor(Color.ORANGE);
                break;
        }

        circle.setSpeed((num+1)*100);
        circle.setX(diametr/2);
        circle.setY(begin + 2*diametr*num);
        circle.setH(diametr);
        circle.setW(diametr);
    }
}
