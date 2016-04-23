package jframe;

import javax.swing.*;
import java.awt.*;

public class HowToDraw extends JPanel {

    public HowToDraw() {
        JFrame secondWindow = new JFrame("My blue window");

        secondWindow.setMinimumSize(new Dimension(800,600));
        secondWindow.setLocation(100,100);

        secondWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        secondWindow.getContentPane().add(this);

        secondWindow.pack();
        secondWindow.setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 800, 600);
    }

    public static void main(String[] args) {
        HowToDraw myWindw = new HowToDraw();

        myWindw.repaint();

        JTextField text = new JTextField("My first text field ion the panel.");

        text.setFont(new Font("TimesNewRoman", Font.BOLD, 16));
        ///myWindw.getContentPane



    }
}
