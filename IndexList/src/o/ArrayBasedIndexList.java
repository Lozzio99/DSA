package o;

import java.lang.reflect.Array;

public class ArrayBasedIndexList <E> implements IndexList<E>
{
    private int size;
    transient E [] list;


    public void insert(int index,E e)
    {
        if (index <0 || index>size+1)
            throw new RuntimeException(" Invalid insertion ");

        size++;

        @SuppressWarnings("unchecked")
        E[] substitute = (E[]) Array.newInstance(Object.class,size);
        substitute[index] = e;
        for (int i = 0; i< size-1; i++)
        {
            if (i<index)
                substitute[i] = list[i];
            else
                substitute[i+1] = list[i];
        }
        list = substitute;
    }


    public void remove(int index)
    {
        if (index<0 || index> size)
            throw new RuntimeException("index is out of bounds");
        size--;

        @SuppressWarnings({"unchecked","unsafe"})
        E[] substitute = (E[]) Array.newInstance(Object.class,size);
        for (int i = 0; i< size; i++)
        {
            if (i<index)
                substitute[i] = list[i];
            else
                substitute[i] = list[i+1];
        }
        list = substitute;
    }
    public E get(int index)
    {
        if (index<0 || index> size)
            throw new RuntimeException("index is out of bounds");
        return list[index];
    }
    public int getSize()
    {
        return size;
    }

}
