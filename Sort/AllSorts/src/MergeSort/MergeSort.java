package MergeSort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort
{
    public static int[] merge(int[] left, int[] right) // Initial indexes of first and second subarrays
    {
        int[] arr = new int[left.length + right.length];
        int i,j,k = j = i = 0;
        while(i<left.length&&j<right.length)
        {
            if (left[i]<= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }
        while(i<left.length)
            arr[k++] = left[i++];

        while(j<right.length)
            arr[k++] = right[j++];

        return arr;
    }
    public static int[] sort(int arr[]) // Find the middle point
    {
        if (arr.length > 1)
        {
            int m = arr.length / 2;
            int[] l1 = Arrays.copyOfRange(arr, 0, m);
            int[] l2 = Arrays.copyOfRange(arr, m, arr.length);
            l1 = sort(l1);
            l2 = sort(l2);
            return merge(l1, l2);
        }
        else
            {
                return arr;
            }
    }

    public static void main(String[] args) {
        int [] arr = new int[10];
        for (int i = 0; i<arr.length;i++)
            arr[i] = new Random().nextInt(10);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(sort(arr)));
    }
}
