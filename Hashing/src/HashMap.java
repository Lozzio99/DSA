public class HashMap<E>
{
    private final static int TABLE_SIZE = 128;
    private KeyTree<E>[] table;
    public HashMap()
    {
        table = new KeyTree[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }
    public E get(int key)
    {
        int hash = (key % TABLE_SIZE);
        if (table[hash] == null)
            return null;
        else
            return table[hash].search(key).getValue();
    }
    public void put(int key, E value)
    {
        int hash = (key % TABLE_SIZE);
        if (table[hash]== null)
            table[hash] = new KeyTree<E>();
        table[hash].addKeyValue(new KeyNode<E>(key, value));
    }

        /**
         * Binary Tree class
         * @param <I> the value of the key that is stored
         * Performing a binary tree structure for key storing and retrieval
         */
        static class KeyTree <I> {
            KeyNode<I> root;

            public void addKeyValue(KeyNode<I> n) {
                if (this.root == null)
                    this.root = n;
                else
                    this.root.addNode(n);
            }

            public KeyNode<I> search(Integer keyValue) {
                KeyNode<I> tofind = this.root.search(keyValue);
                assert (tofind != null);
                return tofind;
            }
        }


            /**
             *  Binary Tree Node class
             * @param <T> the class of the Value Object
             */
            static class KeyNode<T>
            {
                KeyNode<T> left, right;
                T value;
                Integer key;

                public KeyNode(Integer keyValue, T value) {
                    left = right = null;
                    this.key = keyValue;
                    this.value = value;
                }
                public T getValue() {
                    return this.value;
                }

                public Integer getKey() {
                    return this.key;
                }

                public void addNode(KeyNode<T> n)
                {
                    if (n.getKey() < this.getKey())
                        if (this.left == null)
                            this.left = n;
                        else
                            this.left.addNode(n);
                    else if (this.right == null)
                        this.right = n;
                    else this.right.addNode(n);

                }

                public KeyNode<T> search(Integer keyValue)
                {
                    if (this.getKey().equals(keyValue)) {
                        return new KeyNode<T>(this.key, this.value);
                    } else if (keyValue < this.getKey() && this.left != null) {
                        return this.left.search(keyValue);
                    } else if (keyValue >= this.getKey() && this.right != null) {
                        return this.right.search(keyValue);
                    }
                    return null;
                }
            }

}