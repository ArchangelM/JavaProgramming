package jframe;

import javax.swing.*;
import java.awt.*;

public class FirstWindow {
    public static void main(String[] args) {
        JFrame firstWindow = new JFrame();

        firstWindow.setBounds(300, 100, 800,600);
        firstWindow.setVisible(true);

        JFrame secondWindow = new JFrame();

        secondWindow.setMinimumSize(new Dimension(800,600));
        secondWindow.setLocation(100,100);

        secondWindow.pack();
        secondWindow.setVisible(true);
    }
}
