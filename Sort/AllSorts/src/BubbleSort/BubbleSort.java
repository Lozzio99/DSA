package BubbleSort;

import interfaces.Sort;
import visual.Frame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BubbleSort extends JPanel implements Sort
{
    static int [] values = new int[visual.Frame.width];
    static int i = 0 ,j = 0,end_i = visual.Frame.width,end_j;
    static double color = 255.0/ visual.Frame.width;

    public BubbleSort()
    {
        for (int i = 0; i< visual.Frame.width; i++)
        {
            values[i] = new Random().nextInt(visual.Frame.height);
        }
        //Arrays.sort(values);
    }

    public synchronized void update()
    {
        if (i<values.length)
        {
            int a = values[j];
            int b = values[j+1];
            if (a>b)
                swap(j,j+1);
            j++;
            if (j>= values.length-i-1)
            {
                j = 0;
                i++;
            }
        }

    }

    private void swap(int a, int b)
    {
        int temp = values[a];
        values[a] = values[b];
        values[b] =temp;
    }

    public void paint(Graphics graphics)
    {
        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setStroke(new BasicStroke(1.0f));
        g.setColor(new Color(255,255,255));

        for (int i = 0; i< values.length; i++)
        {
            int c = (int) (color*values[i]);
            g.setColor(new Color(c,255-c, 255));
            g.drawLine(i, visual.Frame.height,i, Frame.height-values[i]);

        }
    }
}
