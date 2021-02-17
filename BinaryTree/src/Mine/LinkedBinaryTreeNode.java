package Mine;

public class LinkedBinaryTreeNode<E> implements BinaryTreeNode<E>
{
    private E element;
    private LinkedBinaryTreeNode<E> parent;
    private LinkedBinaryTreeNode<E> leftChild = null;
    private LinkedBinaryTreeNode<E> rightChild = null;

    public LinkedBinaryTreeNode(E e, LinkedBinaryTreeNode<E> p)
    {
        this.element = e;
        this.parent = p;
    }
    public E getElement()
    {
       return this.element;
    }
    public void setElement(E e)
    {
        if (this.element == null)
            this.element = e;

        else if (!hasLeftChild())
            this.addLeftChild(e);

        else if (!hasRightChild())
            this.addRightChild(e);

        else
           this.rightChild.setElement(e);

    }
    public BinaryTreeNode<E> getParent()
    {
        return this.parent;
    }
    public BinaryTreeNode<E> getLeftChild()
    {
        return this.leftChild;
    }
    public BinaryTreeNode<E> getRightChild()
    {
        return this.rightChild;
    }
    public void addLeftChild(E element)
    {
        this.leftChild = new LinkedBinaryTreeNode<>(element,this);
    }
    public void addRightChild(E element)
    {
        this.rightChild = new LinkedBinaryTreeNode<>(element,this);
    }
    public boolean hasLeftChild()
    {
        return this.getLeftChild()!=null;
    }
    public boolean hasRightChild()
    {
        return this.getRightChild()!=null;
    }
    public void delete()
    {
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
        this.element = null;
    }
}