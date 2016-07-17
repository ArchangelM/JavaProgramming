package threads.circles;

import javax.swing.*;

public class LauncherCircle {


    public static void main(String[] args) {
        Circle[] circles = new Circle[10];
        int i = 0;

        for (Circle circle: circles
             ) {
            Utils.circleInit(circle, i++);
        }

        JFrame frame = new JFrame("Balls");





    }


}
