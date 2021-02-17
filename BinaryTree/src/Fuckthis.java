import Mine.BinaryTree;
import Mine.BinaryTreeNode;

public class Fuckthis
{
    private String string = "(";
    private BinaryTreeNode<String> examined;
    public Fuckthis(BinaryTree<String> e )
    {
        string= linearize(e);
    }
    public String linearize(BinaryTree<String> tree)
    {
        String string = this.string;
        if (tree.hasRoot())
        {
            examined = tree.getRoot();
            string += examined.getElement();
        }
        BinaryTreeNode<String> copy = examined;
        while(hasChild(examined))
        {
            string += linearize(examined);
            if (examined.hasLeftChild())
            {
                copy = examined.getLeftChild();
                string += linearize(copy);
            }
            if (examined.hasRightChild())
            {
                copy = examined.getRightChild();
                string += linearize(copy);
            }
            examined = copy;
            string+=")";
        }
        return string;
    }

    public String linearize (BinaryTreeNode<String> n)
    {
        String string = "";
        if (n.hasLeftChild())
        {
            string += print(n.getLeftChild());
        }
        if (n.hasRightChild())
        {
            string += print(n.getRightChild());
        }
        if (!n.hasLeftChild()&& !n.hasRightChild())
            n.delete();
        return string;
    }
    private String print(BinaryTreeNode<String> n)
    {
        String string ="("+ n.getElement()+")";
        return string;
    }

    private boolean hasChild(BinaryTreeNode<String> n)
    {
        return n.hasRightChild()||n.hasLeftChild();
    }
    @Override
    public String toString() {
        return this.string;
    }
}