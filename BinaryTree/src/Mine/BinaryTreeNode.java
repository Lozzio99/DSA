package Mine;

public interface BinaryTreeNode<String>
{
    public String getElement();
    public void setElement(String element);
    public BinaryTreeNode<String> getParent();
    public BinaryTreeNode<String> getLeftChild();
    public BinaryTreeNode<String> getRightChild();
    public void addLeftChild(String element);
    public void addRightChild(String element);
    public void delete();
    public boolean hasLeftChild();
    public boolean hasRightChild();
}