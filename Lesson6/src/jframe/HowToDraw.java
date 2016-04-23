package jframe;

import javax.swing.*;
import java.awt.*;

public class HowToDraw extends JPanel {

    public HowToDraw() {
        JFrame secondWindow = new JFrame("My window");

        secondWindow.setMinimumSize(new Dimension(800,600));
        secondWindow.setLocation(100,100);

        secondWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        secondWindow.getContentPane().add(this);

        secondWindow.pack();
        secondWindow.setVisible(true);

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(50, 50, 300, 300);
    }

    public static void main(String[] args) {
        new HowToDraw();

    }
}
