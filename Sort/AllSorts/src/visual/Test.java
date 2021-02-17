package visual;

import visual.Frame;

import javax.swing.*;

public class Test
{
    public static void main(String [] args)
    {
        SwingUtilities.invokeLater(Frame::new);
    }

}
