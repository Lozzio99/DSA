package visual;

import QuickSort.*;
import BubbleSort.BubbleSort;
import interfaces.Sort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Frame extends JFrame
{
    private Engine engine;
    public static int width = 1200, height = 700;

    public Frame() {
        engine = createEngine();
        setWindowProperties();
    }

    private Engine createEngine() {
        Container cp = getContentPane();
        Engine engine = new Engine(new BubbleSort());
        //Engine engine = new Engine(new QuickSort());
        int canvasWidth = width;
        int canvasHeight = height;
        engine.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        addKeyListener(new MyKeyAdapter());
        cp.add(engine);
        return engine;
    }
    private void startSorting (Engine engine) {
        Thread th = new Thread(engine);
        th.start();
    }

    private void setWindowProperties() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Snake - Score: 0");
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);// Center window
    }

    private class Engine extends JPanel implements Runnable
    {
        public Sort visualization;

        public Engine(BubbleSort visualization) {
            this.visualization = visualization;
        }
        public Engine(QuickSort visualization2)
        {
            this.visualization = visualization2;
        }

        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            setBackground(new Color(0, 0, 0));
            visualization.paint(graphics);
        }

        @Override
        public void run()
        {
            long lastTime = System.nanoTime();
            double elapsedTime = 0.0;
            double FPS = 820000.0;
            // Game loop.
            while (true) {
                long now = System.nanoTime();
                elapsedTime += ((now - lastTime) / 1_000_000_000d) * FPS;
                lastTime = System.nanoTime();

                if (elapsedTime >= 1) {
                    visualization.update();
                    repaint();
                    elapsedTime--;
                }
                //sleep();

            }

        }

        private void sleep() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }


    private class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent keyEvent)
        {
            if (keyEvent.getKeyCode() == KeyEvent.VK_0)
                engine.visualization.update();

            if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE)
                startSorting(engine);
        }
    }
}