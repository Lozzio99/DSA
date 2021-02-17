import o.ArrayBasedIndexList;

public class testUnit
{
    public static void main(String [] args)
    {

        ArrayBasedIndexList<Integer> x = new ArrayBasedIndexList<>();
        x.insert(0,123);
        x.insert(1,124);
        x.insert(1,127);
        System.out.println(x.get(0));
        System.out.println(x.get(1));

        System.out.println(x.getSize());
        x.remove(1);
        System.out.println(x.getSize());
    }
}
