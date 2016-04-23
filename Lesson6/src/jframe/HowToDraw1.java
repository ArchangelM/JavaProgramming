package jframe;

        import javax.swing.*;
        import java.awt.*;

public class HowToDraw1 {

    public HowToDraw1() {
        JFrame panelWindow = new JFrame("My blue window");

        panelWindow.setMinimumSize(new Dimension(800,600));
        panelWindow.setLocation(100,100);

        panelWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.setColor(Color.BLUE);
                g.fillRect(0, 0, 800, 600);
            }
        };
        panelWindow.getContentPane().add(panel);
        panelWindow.getContentPane().add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.setColor(Color.GRAY);
                g.fillRect(0, 0, 800, 600);
            }
        });

        panelWindow.pack();
        panelWindow.setVisible(true);

    }

    public static void main(String[] args) {
        HowToDraw1 myWindw = new HowToDraw1();


    }
}
