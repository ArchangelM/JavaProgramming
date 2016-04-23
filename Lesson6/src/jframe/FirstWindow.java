package jframe;

import javax.swing.*;
import java.awt.*;

public class FirstWindow {
    public static void main(String[] args) {
        JFrame firstWindow = new JFrame("First window");

        firstWindow.setBounds(300, 100, 800, 600);

        firstWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //firstWindow.pack();

        firstWindow.setVisible(true);

        /*
        JPanel p = new JPanel();

        firstWindow.getContentPane().add(p);
        */
        /*
        JFrame secondWindow = new JFrame();

        secondWindow.setMinimumSize(new Dimension(800,600));
        secondWindow.setLocation(100,100);

        secondWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        secondWindow.pack();
        secondWindow.setVisible(true);
        */

    }
}
