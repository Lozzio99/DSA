import java.util.Arrays;
public class ReverseOld
{
    public static int[] reverse(int[] list,boolean test)
    {

        Stack<Integer> stack;//= new Stack<>(list.length);
        int l = list.length;
        int [] res = new int[l];
        for (int i = list.length; i>0; i--)
        {
            stack = new Stack<>(i);
            for (int j = 0; j< i; j++)
                stack.push(list[j]);
            res[l-i] = stack.pop();
        }
        return res;
    }

    public static int [] reverse(int [] list)
    {
        Stack<Integer> stack;//= new Stack<>(list.length);
        int l = list.length;
        int [] res = new int[l];
        for (int i = l; i>0; i-=2)
        {
            stack = new Stack<>(i);
            for(int j = 0; j<i; j++)
                stack.push(list[j]);
            res[l-i] = stack.pop();
            if(i==1)
                break;
            res[(l-i)+1] = stack.peek();
        }
        return res;
    }
    public static void main(String[] args)
    {
        // Every value in the argument array is a single element in the list
        int[] arr = new int[args.length];

        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = Integer.parseInt(args[i]);
        }
        System.out.println(Arrays.toString(arr));


        int[] result = Reverse.reverse(arr);
        System.out.println(Arrays.toString(result));
        result = reverse(arr,true);
        System.out.println(Arrays.toString(result));
    }
}