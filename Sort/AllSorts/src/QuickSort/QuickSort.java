package QuickSort;
import interfaces.Sort;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import visual.Frame;

public class QuickSort extends JPanel implements Sort
{

    private int[] values = new int[Frame.width];
    static double color = 255.0/Frame.width;
    Graphics2D g2;


    public QuickSort()
    {
        for (int i = 0;i< Frame.width; i++)
        {
            values[i] = new Random().nextInt(Frame.height);
        }
    }
    public synchronized void update()
    {
        quickSort(0,values.length-1);
    }
    public synchronized void quickSort(int start,int end)
    {
        if (start>= end)
            return;



        int index = partition(start,end);
        quickSort(start,index-1);
        quickSort(index+1,end);

    }

    private synchronized int partition(int start, int end)
    {


        int pivotIndex = start;
        int pivotValue = values[end];
        for (int i = start;i< end; i++)
        {
            if (values[i]<pivotValue)
            {
                swap(i,pivotIndex);
                pivotIndex++;
            }
        }
        swap(pivotIndex,end);
        return pivotIndex;
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
            g.drawLine(i,Frame.height,i,Frame.height-values[i]);

        }
    }

}
