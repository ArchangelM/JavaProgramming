package threads.gate;

import javax.swing.*;
import java.awt.*;

public class LauncherGate extends JPanel {

    private final static int BEGIN_X = 100;
    private final static int BEGIN_Y = 10;

    private final static int WIDTH = 700;
    private final static int HEIGTH = 350;

    private final static int SHIP_DIMENTION = 40;

    private Ship ship;
    private Gate gate;

    public static void main(String[] args) throws Exception {
        LauncherGate lg = new LauncherGate();
    }

    public LauncherGate() {
        JFrame frame = new JFrame("Gate");

        frame.setLocation(BEGIN_X, BEGIN_Y);
        frame.setMinimumSize(new Dimension(WIDTH, HEIGTH));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.getContentPane().add(this);

        frame.pack();
        frame.setVisible(true);

        ship = new Ship();
        gate = new Gate();

        gate.setOpen(false);


        gateOpen();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    shipTurn();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();




        while(true) {
            repaint();

            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void gateAnimation()  throws InterruptedException {

        if (!gate.isOpen()) {
            System.out.println("Gate: opening");
           while (gate.getY() > gate.getyTop()) {
               gate.setY(gate.getY() - 1);
               Thread.sleep(gate.getSpeed());
           }
           gate.setOpen(true);
        }

        else {
            System.out.println("Gate: closing");
            while (gate.getY() < gate.getyBottom()) {
                gate.setY(gate.getY() + 1);
                Thread.sleep(gate.getSpeed());
            }
            gate.setOpen(false);
        }

    }

    public void shipTurn() throws InterruptedException {
        System.out.println("Ship: Move");
        while (ship.getX() < WIDTH - SHIP_DIMENTION) {

            int x = ship.getX();
            if((x < gate.getX() - gate.getDeltaX()) || (gate.isOpen()) || (x > gate.getX() + gate.getDeltaX()) ) {
                ship.setX(ship.getX() + 1);
            } else {
                System.out.println("Ship: Wait. May I come?");

                synchronized (gate) {
                    gate.notify();
                }

                synchronized (ship) {
                        ship.wait();
                        System.out.println("Thanks.");
                }

            }
            Thread.sleep(ship.getSpeed());
        }
    }

    public void gateOpen() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (gate) {
                        System.out.println("Gate: I`m waiting for you!");
                        gate.wait();
                    }

                    while(!gate.isOpen()) {
                        System.out.println("Gate: I`m opening");
                        gateAnimation();
                    }

                    synchronized (ship) {
                        System.out.println("Gate: Ship, coming in please.");
                        ship.notify();
                    }

                    Thread.sleep(150);

                    gateAnimation();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
            }
        }).start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        gate.draw(g);
        ship.draw(g);
    }
}
