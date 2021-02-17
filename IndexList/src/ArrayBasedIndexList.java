import o.IndexList;

import java.util.Arrays;

/**
 *
 * Max's code
 * @param <E>
 */
public class ArrayBasedIndexList<E> implements IndexList<E>
{
	private static int length;
	private E[] arr;
	private E[] newarr;
	
    public ArrayBasedIndexList()
	{
		length=0;
		arr = (E[])(new Object[length]);
	}
	
    public void insert(int index,E e) 
	{
		if (e==null || index <0 || index > length)
			throw new IllegalArgumentException("Non valid insertion");
		length++;
		newarr = (E[])(new Object[length]);
		for(int i = 0; i < length; i++)
		{
			if(i<index)
			{
				newarr[i] = arr[i];
			}
			else if(i == index)
			{
				newarr[i] = e;
			}
			else
			{
				newarr[i+1] = arr[i];
			}
		}
		this.arr = newarr;
    }
    public void remove(int index) 
	{
		if (length == 0 )
			throw new RuntimeException("Array is Empty");
		else if (index<0 || index> length)
			throw new IllegalArgumentException("Unexpected index");
		else{
			length--;
			newarr = (E[])(new Object[length]);
			for (int i = 0; i < length+1; i++)
			{
				if(i<index)
				{
					newarr[i] = arr[i];
				}
				if(i>index)
				{
					newarr[i-1] = arr[i];
				}
			}
			this.arr = newarr;
		}
	}
    public E get(int index) 
	{
		return arr[index]; //It should return the element that is stored at the index index of the ArrayBasedIndexList object
    }
    public int getSize() 
	{
		return length;
    }
	public E[] getArray()
	{
		return arr;
	}


	public static void main(String[] args)
	{
		ArrayBasedIndexList<Integer> a = new ArrayBasedIndexList<>();
		for (int i = 0; i< 10; i++)
			a.insert(i, i*10);
		System.out.println(a.getSize());
		System.out.println(a.get(0));
		System.out.println(Arrays.toString(a.getArray()));
		for (int i = 0; i< 2; i++)
			a.remove(i);
		System.out.println(Arrays.toString(a.getArray()));
	}
}

//fix length stuff
//fix and research what getSize is supposed to do and make it work
//runtimeerrors when negative index or array is empty