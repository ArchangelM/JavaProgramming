package threads.circles;

import javax.swing.*;
import java.awt.*;

public class LauncherC extends JPanel{
    public final static int CIRCLES_NUM = 10;

    public final static int BEGIN_X = 100;
    public final static int BEGIN_Y = 10;

    public final static int WIDTH = 700;
    public final static int HEIGTH = 450;

    Circle[] circles;

    public LauncherC() {
        circles = new Circle[CIRCLES_NUM];
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true) {
//                    repaint();
//                    System.out.println("thread1");
//                    try {
//                        Thread.sleep(1000 / 60);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Balls");
        frame.setLocation(BEGIN_X, BEGIN_Y);
        frame.setMinimumSize(new Dimension(WIDTH, HEIGTH));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);

        LauncherC mainPanel = new LauncherC();
        frame.getContentPane().add(mainPanel);

        mainPanel.play();
        mainPanel.rePaint();
    }

    public void play() {
        for (int i = 0; i < circles.length; i++) {
            circles[i] = new Circle();
            Utils.circleInit(circles[i], i);

            new Thread(circles[i]).start();
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //System.out.println("Paint component");
        for(int i = 0; i < circles.length; i++) {
            if (circles[i] != null) {
                circles[i].draw(g);
                //System.out.println("Paint component, circle paint " + i);
            }

        }
    }

    public void rePaint() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    repaint();
                    try {
                        Thread.sleep(1000 / 60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
