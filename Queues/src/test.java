public class test {
    public static void main (String [] args)
    {
        IQueue<Character> d = new Queue<>(11);

        d.enqueue('a');
        d.enqueue('c');
        d.enqueue('d');


        d.enqueue('f');
        d.enqueue('f');
        d.enqueue('g');
        System.out.println(d.dequeue());
        System.out.println(d.dequeue());
        System.out.println(d.dequeue());



    }
    static void test(IQueue<Character> e )
    {
        System.out.println("//=================================//");
        System.out.println("         Testing Queue               ");
        System.out.println("length:                    "+ e.size());
        System.out.println("dequeue :               "+ e.dequeue());
        System.out.println("peek    :                  "+ e.peek());
        System.out.println("//=================================//");

    }
}
