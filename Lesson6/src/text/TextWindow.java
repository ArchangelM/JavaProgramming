package text;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class TextWindow extends JPanel{
    private final static String IMAGE_NAME = "sprites\\eagle64.png";
    private Image image;

    public JFrame window;

    public TextWindow() {
        try {
            image = ImageIO.read(new File(IMAGE_NAME));
        } catch (IOException e) {
            System.out.println("Can't find image - " + IMAGE_NAME);
        }


        window = new JFrame("Text");
        window.setBounds(100, 100, 800, 600);

        window.getContentPane().add(this);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //window.pack();
        window.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.fillRect(10, 10, 750, 550);

        g.setColor(Color.GRAY);
        g.draw3DRect(34, 67, 100, 100, true);

        g.setColor(Color.ORANGE);
        g.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 12));
        g.drawString("My first text field in the panel.", 200, 200);

        g.drawImage(image, 300, 210, new ImageObserver() {
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        });

    }

    public void addTextField(JTextField txt) {
        window.add(txt);
    }

    public static void main(String[] args) {
        TextWindow text = new TextWindow();

       text.repaint();
/*
        JTextField myText = new JTextField("My first text field in the panel.");

        myText.setFont(new Font("Garamond", Font.BOLD, 16));
        text.addTextField(myText);
        text.repaint();
/*
        JTextField myText1 = new JTextField("\nВнатуре!!!");
        myText1.setFont(new Font("Serif", Font.ITALIC, 12));
        myText1.setForeground(Color.CYAN);

        //text.addTextField(new JTextField("Внатуре!!!"));
        text.addTextField(myText1);

        text.repaint();
*/
    }
}
