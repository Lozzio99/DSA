public class unitTest
{

    public static void main (String [] args)
    {
        Money<Integer> my = new Money<>();
        FindMin<Integer> fcount = new FindMin<>(my);
        fcount.add(1000);
        fcount.add(29);
        fcount.add(1);
        fcount.add(-3);
        fcount.add(-3);
        fcount.add(29);
        System.out.println(fcount.getMinimum());
        System.out.println(fcount.getMinimumCount());
        fcount.reset();
        fcount.add(10);
        System.out.println(fcount.getMinimumCount()+ " -> "+ fcount.getMinimum());
    }
}
