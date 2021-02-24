package Mine;


public class LinkedBinaryTree<String> implements BinaryTree<String>
{
    private LinkedBinaryTreeNode<String> root ;
    public LinkedBinaryTree ()
    {
        this.root = new LinkedBinaryTreeNode<>(null, null);
    }
    public BinaryTreeNode<String> getRoot()
    {
        return this.root;
    }
    public void addRoot(String e)
    {
        this.root.setElement(e);
    }
    public boolean hasRoot()
    {
        return this.root.getElement()!=null;
    }
}