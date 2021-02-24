package Mine;

public class LinearFamilyTree
{

    public String linearize(BinaryTree<String> tree)
    {
        return linearize(tree.getRoot());
    }
    public String linearize(BinaryTreeNode<String> node)
    {
        String string = "("  ;
        string +=" "+ node.getElement()+" ";
        if (node.hasLeftChild())
        {
            string+= linearize(node.getLeftChild());
        }
        if (node.hasRightChild())
        {
            string+=linearize(node.getRightChild());
        }
        return string+") ";
    }
    public String print(BinaryTreeNode<String> n)
    {
        return linearize(n);
    }


    public String linearizeI(BinaryTree<Integer> tree)
    {
        return linearizeI(tree.getRoot());
    }

    public String linearizeI(BinaryTreeNode<Integer> node)
    {
        String string = "("  ;
        string +=" "+ node.getElement()+" ";
        if (node.hasLeftChild())
        {
            string+= linearizeI(node.getLeftChild());
        }
        if (node.hasRightChild())
        {
            string+=linearizeI(node.getRightChild());
        }
        return string+") ";
    }
    public String printI(BinaryTreeNode<Integer> n)
    {
        return linearizeI(n);
    }
}