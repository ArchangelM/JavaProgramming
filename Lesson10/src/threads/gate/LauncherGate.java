package threads.gate;

import javax.swing.*;
import java.awt.*;

public class LauncherGate extends JPanel {

    private final static int BEGIN_X = 100;
    private final static int BEGIN_Y = 10;

    private final static int WIDTH = 700;
    private final static int HEIGTH = 350;

    private Ship ship;
    private Gate gate;

    public static void main(String[] args) {
        LauncherGate lg = new LauncherGate();
    }

    public LauncherGate() {
        JFrame frame = new JFrame("Gate");
        JPanel panel = new JPanel();

        frame.setLocation(BEGIN_X, BEGIN_Y);
        frame.setMinimumSize(new Dimension(WIDTH, HEIGTH));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.getContentPane().add(this);

        frame.pack();
        frame.setVisible(true);

        ship = new Ship();
        gate = new Gate();

        gate.setOpen(false);


        new Thread(new Runnable() {
            @Override
            public void run() {
               while(gate.isOpen()) {
                   gateAnimation();

               }

            }
        });


        new Thread(new Runnable() {
            @Override
            public void run() {
               while(true) {
                    repaint();

                    try {
                        Thread.sleep(1000/60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }


    public void gateAnimation() {
//        while (gate.getX() < getWidth()) {
//            gate.setX(gate.getX() + 1);
//        }
        if (!gate.isOpen()) {
           if(gate.getY() > gate.getyTop()) {
               gate.setY(gate.getY() - 1);
           } else {
               gate.setOpen(true);
           }

        } else {
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void shipTurn() {
        while (ship.getX() < getWidth()) {
            ship.setX(ship.getX() + 1);
        }
    }

    public void gateOpen() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (gate) {
                        System.out.println("Wait");
                        gate.wait();
                    }

                    while(!gate.isOpen()) {
                        gateAnimation();
                    }

                    synchronized (ship) {

                        ship.notify();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
            }
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        gate.draw(g);
        ship.draw(g);
    }
}
