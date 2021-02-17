public class Main
{
    public static void main(String[] args) throws Exception {

       /*
        MyThread first = new MyThread();
        MyRunnable runnable = new MyRunnable();
        Thread second = new Thread(runnable);
        //first.setDaemon(true);
        //second.setDaemon(true);
        first.start();
        //first.join(3000);
        second.start();
        */

        //Thread.currentThread().setPriority(1);
        //System.out.println(Thread.currentThread().getPriority());

        System.out.println(Thread.currentThread().isAlive());

        for (int i = 3; i>0; i--)
        {
            System.out.println(i);
            Thread.sleep(1000);
        }
    }

}
