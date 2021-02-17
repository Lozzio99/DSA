public class Queue<E> implements IQueue<E>
{
    public Stack<E> enqueue;
    public Stack<E> dequeue;
    public int capacity;
    public int count;
    public Queue(int size) {
        enqueue = new Stack<>(size);
        dequeue = new Stack<>(size);
        capacity = size;
        count = 0;
    }
    @Override
    public E dequeue() {
        if (enqueue.isEmpty() && dequeue.isEmpty())
            throw new RuntimeException("Queue is empty");
        if (dequeue.isEmpty())
            while (!enqueue.isEmpty())
                dequeue.push(enqueue.pop());
        count--;
        return dequeue.pop();
    }
    @Override
    public void enqueue(E item) {
        if (isFull())
            throw new RuntimeException("Queue is full exception");
        enqueue.push(item);
        count++;
    }
    @Override
    public E peek() {
        if (enqueue.isEmpty()&& dequeue.isEmpty())
            throw new RuntimeException("Queue is empty exception");
        if (dequeue.isEmpty())
            while(!enqueue.isEmpty())
                dequeue.push(enqueue.pop());
        return dequeue.peek();
    }
    @Override
    public int size() { return count; }
    @Override
    public boolean isEmpty() {
        return size()==0;
    }
    @Override
    public boolean isFull() {
        return size()==capacity;
    }


}
