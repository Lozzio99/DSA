import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame
{
    private JButton button = new JButton("MY BUTTON");
    private JButton button2 = new JButton("MY BUTTON 2");

    static int n = 0;
    static int m = 0;

    MyFrame()
    {
        button.setBounds(100,100,200,100);
        button2.setBounds(100,250,200,100);

        button.addActionListener(e -> {
            n++;
            System.out.println("you clicked this button "+ n + " times");
        });

        button2.addActionListener(e -> {
            m++;
            System.out.println("you clicked this button "+ m + " times");
        });

        this.add(button);
        this.add(button2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(420,420));
        this.setLayout(null);
        this.setVisible(true);

    }
}
