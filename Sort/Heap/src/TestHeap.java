import com.sun.jdi.Value;

import java.security.Key;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Random;

public class TestHeap
{
    public static void main(String[] args) throws Exception {
        int [] heapify = new int [10] ;

        for (int i = 0; i< heapify.length; i++)
        {
            heapify[i] = new Random().nextInt(50);

        }

        Heap heap = new Heap(10);
        for(int i : heapify)
        {
            heap.insert(i);
        }
        print(heap);

        heap.delete(3);
        print(heap);

    }
    static void print(Heap heap)
    {
        System.out.println("      "+ heap.getHeap()[0]);
        System.out.println("   "+ heap.getHeap()[1]+ "   "+ heap.getHeap()[2]);
        System.out.println(heap.getHeap()[3]+ "  "+ heap.getHeap()[4]+ "  "+heap.getHeap()[5]+ "  "+ heap.getHeap()[6]);
    }
}
