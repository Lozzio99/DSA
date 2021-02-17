public class FindMin <E>
{
    E min;
    Compare<E> comparer;
    int count;

    public FindMin(Compare<E> compare)
    {
        this.comparer = compare;
        this.count = 0;
        this.min= null;
    }
    public void reset()
    {
        this.min = null;
        this.count =0;
    }
    public void add(E e)
    {

        if (min == null||comparer.smaller(e,min))
        {
            min = e;
            count= 1;
        }
        else if (comparer.equal(e,min))
        {
            count++;
        }
    }
    public E getMinimum()
    {
        return this.min;
    }
    public int getMinimumCount() {
        return count;
    }
}
