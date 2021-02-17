package hashing;

public class Entry
{
    int key;
    Object value;
    Entry next;

    public Entry(int key, Object value) {
          this.key = key;
          this.value= value;
          next = null;
    }
    public Entry() {
        next = null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Entry getNext() {
        return next;
    }

    public void setNext(Entry next) {
        this.next = next;
    }
}
