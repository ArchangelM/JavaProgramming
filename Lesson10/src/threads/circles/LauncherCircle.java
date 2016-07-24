package threads.circles;

import javax.swing.*;
import java.awt.*;

public class LauncherCircle {
    public final static int CIRCLES_NUM = 10;

    public final static int BEGIN_X = 100;
    public final static int BEGIN_Y = 10;

    public final static int WIDTH = 700;
    public final static int HEIGTH = 350;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Balls");
        frame.setLocation(BEGIN_X, BEGIN_Y);
        frame.setMinimumSize(new Dimension(WIDTH, HEIGTH));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setLayout(new GridLayout(10, 1));

        frame.pack();
        frame.setVisible(true);

        JPanel mainPanel = new JPanel();
        //mainPanel.setLayout(new BorderLayout(10, 1));
        mainPanel.setLayout(new GridLayout(10, 1));
        frame.getContentPane().add(mainPanel);

        MyPanel[] panels = new MyPanel[10];


        for (int i = 0;i < panels.length;i++) {
            Circle circle = new Circle();
            Utils.circleInit(circle, i);

            panels[i] = new MyPanel();
            panels[i].setCircle(circle);
            panels[i].setSize(WIDTH, HEIGTH/CIRCLES_NUM);
           // panels[i].setLocation(0, i*HEIGTH/CIRCLES_NUM);
           //frame.getContentPane().add(panels[i]);
            mainPanel.add(panels[i]);

            new Thread(panels[i]).start();
        }

        //panel.circleFly();

/*
        Circle circle = new Circle();
        Utils.circleInit(circle, 0);
        MyPanel panel = new MyPanel();

        panel.setCircle(circle);
        panel.setSize(WIDTH, HEIGTH/CIRCLES_NUM);

        //frame.getContentPane().add(panel);
        mainPanel.add(panel);
        new Thread(panel).start();

        MyPanel panel1 = new MyPanel();
        Circle circle1 = new Circle();
        Utils.circleInit(circle1, 5);

        panel1.setCircle(circle1);
        panel1.setSize(WIDTH, HEIGTH/CIRCLES_NUM);

        //frame.getContentPane().add(panel1);
        mainPanel.add(panel1);
        new Thread(panel1).start();
*/


    }


}
