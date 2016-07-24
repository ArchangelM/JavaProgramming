package threads.circles;

import javax.swing.*;
import java.awt.*;



public class MyPanel extends JPanel implements Runnable {
    public final static int DIAMETR = 10;

    Circle circle;
    //Graphics g;

    public MyPanel() {
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        circle.draw(g);
    }

    @Override
    public void run() {
        while (true) {
            while (circle.getX() < getWidth()- 2*DIAMETR) {

                circle.setX(circle.getX() + 1);
                try {
                    Thread.sleep(circle.getSpeed());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }

            while (circle.getX() > DIAMETR) {

                circle.setX(circle.getX() - 1);
                try {
                    Thread.sleep(circle.getSpeed());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        }

    }

    public void circleFly() {
      while (circle.getX() < getWidth()- 2*DIAMETR) {

            circle.setX(circle.getX() + 1);
            try {
                Thread.sleep(circle.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }

        while (circle.getX() > 2*DIAMETR) {

            circle.setX(circle.getX() - 1);
            try {
                Thread.sleep(circle.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }
}
