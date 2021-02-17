public class Reverse
{
    public static int [] reverse(int [] list)
    {
        Stack<Integer> stack = new Stack<>(list.length);
        for (int j : list)
            stack.push(j);
        int [] res = new int [list.length];

        for (int i = 0; i< list.length; i++)
            res[i] = stack.pop();
        return res;
    }

    public static void main(String [] args)
    {
        Stack<Character> e = new Stack<>(10);
        e.push('a');
        e.push('c');
        e.push('d');

        System.out.println(e.pop());
        System.out.println(e.pop());

        e.push('f');
        e.push('f');
        e.push('g');
        System.out.println(e.pop());
    }
}

