package text;


import com.sun.deploy.panel.JavaPanel;

import javax.swing.*;
import java.awt.*;

public class TextWindow extends JavaPanel{
     private JFrame window;

    public TextWindow() {
        window = new JFrame("Text");
        window.setBounds(100, 100, 800, 600);

        window.getContentPane().add(this);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.pack();
        window.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);

    }

    public void addTextField(JTextField txt) {
        window.add(txt);
    }

    public static void main(String[] args) {
        TextWindow text = new TextWindow();

        ///text.repaint();

        JTextField myText = new JTextField("My first text field in the panel.");

        myText.setFont(new Font("Garamond", Font.BOLD, 16));
        text.addTextField(myText);
        text.repaint();

        JTextField myText1 = new JTextField("\nВнатуре!!!");
        myText1.setFont(new Font("Serif", Font.ITALIC, 12));
        myText1.setForeground(Color.CYAN);

        //text.addTextField(new JTextField("Внатуре!!!"));
        text.addTextField(myText1);

        text.repaint();

    }
}
