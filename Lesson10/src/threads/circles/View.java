package threads.circles;

import javax.swing.*;
import java.awt.*;

public class View {
    JPanel panel;


    public void frameWorker(JFrame frame) {
        frame.setLocation(500, 150);
        //frame.setMinimumSize(new Dimension(BF_WIDTH+15, BF_HEIGHT + 38));
        frame.setMinimumSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel = new JPanel();

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.repaint();


    }
}
