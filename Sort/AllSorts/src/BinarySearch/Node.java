package BinarySearch;

public class Node
{
    Integer value;
    Node left,right;
    public Node(Integer value)
    {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    public Integer getValue()
    {
        return this.value;
    }
    public void addNode(Node n)
    {
        if (n.value<this.value)
        {
            if (this.left == null)
                this.left = n;
            else
                this.left.addNode(n);
        }
        else
        {
            if (this.right == null)
                this.right = n;
            else
                this.right.addNode(n);
        }
    }
    public void visit()
    {
        if (this.left != null)
            this.left.visit();


        System.out.println(this.value);


        if (this.right != null)
            this.right.visit();


    }
    public Node search(Integer value)
    {
        if (this.value.equals(value)) {
            System.out.println("found ->" + value);
            return new Node(value);
        } else if (value < this.value && this.left != null) {
            return this.left.search(value);
        } else if (value >= this.value && this.right != null) {
            return this.right.search(value);
        }
        return null;
    }
}
