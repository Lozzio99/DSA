import java.util.*;
public class Heap
{
    private static final int d = 2;
    private int[] heap;
    private int heapSize;
    public Heap(int capacity)  //maxheap
    {
        heapSize = 0;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);
    }
    public boolean isEmpty()
    {
        return heapSize == 0;
    }
    public boolean isFull()
    {
        return heapSize == heap.length;
    }
    private int parent(int i)
    {

        return (i - 1) / d;
    }

    public void insert(int x)
    {
        if (isFull())
            throw new RuntimeException("Heap is full");
        heap[heapSize++] = x;
        upHeap(heapSize - 1);
    }
    public int delete(int x)
    {
        if (isEmpty())
            throw new RuntimeException("Heap is empty");
        int key = heap[x];
        heap[x] = heap[heapSize - 1];
        heapSize--;
        downHeap(x);
        return key;
    }
    // maintain heap property during insertion
    private void upHeap(int i)  // TODO Implement this method
    {
        for (int k = i; k>0; k--)
        {
            if (heap[k]>heap[parent(k)])
                swap(k,parent(k));
        }

        System.out.println(" max child from 0 "+ heap[maxChild(0)]);
    }
    // maintain heap property during deletion
    private void downHeap(int i)
    {
        int k = i;
        while(kthChild(k,2)<heapSize-1)
        {
            int c = maxChild(k);
            if (heap[k]<heap[c])
                swap(k,c);
            k++;
        }

    }
    private int maxChild(int i)
    {
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2);
        return heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
    }
    private int kthChild(int i, int k)
    {
        return d * i + k;
    }



    public void printHeap()
    {
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }    // return max from the heap
    public int findMax() //maxHeap, max is at the first element
    {
        if (isEmpty())
            throw new NoSuchElementException("Heap is empty.");
        return heap[0];
    }
    public int[] getHeap()
    {
        // This method is used for autotesting
        return heap;
    }

    public void swap(int index1,int index2)
    {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
}
