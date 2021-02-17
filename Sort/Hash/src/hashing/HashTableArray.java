package hashing;

public class HashTableArray <T>
{
    private Entry[] arrayHash;
    private int size;
    private static int predefinedSize = 100;

    public HashTableArray(int size) {
        this.size = size;
        this.arrayHash = new Entry[size];
        for (int i = 0; i< size; i++)
            this.arrayHash[i] = new Entry();
    }
    public HashTableArray(){
        this(predefinedSize);
    }

    public int getHash(int key)
    {
        return key%size;
    }
    public void put(int key, T value)
    {
        int hashIndex = getHash(key);
        Entry arrayValue = arrayHash[hashIndex];
        Entry next = new Entry(key,value);
        next.setNext(arrayValue.getNext());
        arrayValue.next = next;
    }
    public T get(int key)
    {
        T value = null;
        int hashIndex = getHash(key);
        Entry arrayValue = arrayHash[hashIndex];
        while(arrayValue != null)
        {
            if (arrayValue.getKey() == key)
            {
                value = (T) arrayValue.getValue();
                break;
            }
            arrayValue = arrayValue.getNext();
        }
        return  value;
    }

}
