import java.util.ArrayList;
import java.util.Random;

public class HashMapTest
{
    /*
    public static void main(String[] args)
    {
        int[] keys = { 1, 2, 3, 642, 4, 129};
        HashMap<String> myHashMap = new HashMap<String>();
        myHashMap.put(keys[0], "Caius");
        myHashMap.put(keys[1], "Lew");
        myHashMap.put(keys[2], "Roza");
        myHashMap.put(keys[3], "Mohammed");
        myHashMap.put(keys[4], "Petronela");
        myHashMap.put(keys[5], "Jacky");
        for(int i = 0; i < keys.length; i++)
        {
            System.out.println(myHashMap.get(keys[i]));
        }
    }
     */
    public static final char[] dictionary = new char[]{
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
    };
    public static final int TEST_SIZE = 10000, value_length = 10;
    public static final double start = System.nanoTime();
    public static void main(String[] args)
    {
        int [] keys = new int[TEST_SIZE];
        String[] values = new String[TEST_SIZE];
        for (int i = 0; i< TEST_SIZE; i++)
        {
            keys[i] = new Random().nextInt(TEST_SIZE);
            char[] value = new char[value_length];
            for (int k = 0; k<value_length; k++)
            {
                value[k] = dictionary[new Random().nextInt(dictionary.length)];
            }
            values[i] = new String(value);
        }
        System.out.println("Keys have been generated in "+ (System.nanoTime()-start)/1000 + " ms\n\n");
        HashMap<String> myHashMap = new HashMap<String>();
        for (int i = 0; i< TEST_SIZE; i++)
        {
            myHashMap.put(keys[i],values[i]);
        }
        System.out.println("\n\nKeys have been loaded in the map in "+ (System.nanoTime()-start)/1000 + " ms\n\n");

        for (int i = 0;i< TEST_SIZE; i++)
        {
            String e = myHashMap.get(keys[i]);
            assert(e).equals(values[i]);
            //System.out.println(e);
        }
        System.out.println(" \n\nEnd of execution at " + (System.nanoTime()-start)/1000 + " ms");


    }
}