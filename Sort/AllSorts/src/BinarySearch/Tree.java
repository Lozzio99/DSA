package BinarySearch;

public class Tree
{
    Node root;
    public void addValue(Node n)
    {
        if (this.root == null)
            this.root = n;
        else
            this.root.addNode(n);
    }
    public void traverse()
    {
        this.root.visit();
    }
    public Node search(Integer value)
    {
        Node toFound = this.root.search(value);
        if (toFound == null)
            throw new RuntimeException("Node not found");
        return toFound;
    }
}
