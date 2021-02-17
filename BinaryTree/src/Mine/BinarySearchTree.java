package Mine;

import Mine.BinaryTree;
import Mine.BinaryTreeNode;
import Mine.LinkedBinaryTree;
import Mine.LinkedBinaryTreeNode;

public class BinarySearchTree
{
    BinaryTree<Integer> tree = new LinkedBinaryTree<>();
    private static BinaryTreeNode<Integer> visited = new LinkedBinaryTreeNode<>(null,null);

    public BinaryTree<Integer> getTree() {
        return tree;
    }

    public void insert(Integer e)
    {
        if (!this.tree.hasRoot())
        {
            this.tree.addRoot(e);
            reset();
        }
        else
        {
            if(!(visited.getElement()==null && this.find(e)))
            {
                if (visited.getElement()==null) //first time we call this method, then visited is updated in recursion
                    visited = this.tree.getRoot();

                if (e< visited.getElement())
                {
                    if (!visited.hasLeftChild())
                    {
                        visited.addLeftChild(e);
                        reset();
                    }
                    else
                    {
                        visited = visited.getLeftChild();
                        this.insert(e);
                    }
                }
                else
                {
                    if (!visited.hasRightChild())
                    {
                        visited.addRightChild(e);
                        reset();
                    }
                    else
                    {
                        visited = visited.getRightChild();
                        this.insert(e);
                    }
                }
            }
        }
    }

    private static BinaryTreeNode<Integer> replace = new LinkedBinaryTreeNode<>(null,null);

    public boolean delete(Integer e)
    {
        if (this.tree.hasRoot() )
        {
            if (visited.getElement()==null) //first time we call this method, then visited is updated in recursion
                visited = this.tree.getRoot();

            if (visited.getElement().equals(e)) //first try or first check in recursion
            {
                if (!(visited.hasLeftChild()&& visited.hasRightChild()))
                {
                    visited.delete();
                    reset();
                    return true;
                }
                else if (!visited.hasLeftChild())
                {
                    visited.setElement(visited.getRightChild().getElement());
                    visited.getRightChild().delete();
                    reset();
                    return true;
                }
                else if (!visited.hasRightChild())
                {
                    visited.setElement(visited.getLeftChild().getElement());
                    visited.getLeftChild().delete();
                    reset();
                    return true;
                }
                else
                {
                    replace = visited;
                    visited = visited.getRightChild();
                    while(visited.hasLeftChild())
                        visited = visited.getLeftChild();
                    replace.setElement(visited.getElement());
                    visited.delete();
                    reset();
                }
            }
            if (!(visited.hasRightChild()&& visited.hasRightChild()))   //no child, no equals
            {
                reset();
                return false;
            }

            else  //has a child
            {
                if (e< visited.getElement())  //should go to the left
                {
                    if (visited.hasLeftChild())
                    {
                        visited = visited.getLeftChild();
                        return this.delete(e);
                    }
                    reset();
                    return false;   //can't go to the left
                }
                else if (e> visited.getElement())  //should go to the right
                {
                    if (visited.hasRightChild())
                    {
                        visited = visited.getRightChild();
                        return this.delete(e);
                    }
                    reset();
                    return false;   //can't go to the right
                }
            }
        }
        reset();
        return false;
    }
    private void reset()
    {
        visited = new LinkedBinaryTreeNode<>(null,null);
    }
    public boolean find(Integer e)
    {
        if (this.tree.hasRoot() )
        {
            if (visited.getElement()==null) //first time we call this method, then visited is updated in recursion
                visited = this.tree.getRoot();

            if (visited.getElement().equals(e)) //first try or first check in recursion
            {
                reset();
                return true;
            }

            if (!visited.hasRightChild()&&!visited.hasLeftChild())  //no child, no equals
            {
                reset();
                return false;
            }

            else  //has a child
            {
                if (e<visited.getElement())  //should go to the left
                {
                    if (visited.hasLeftChild())
                    {
                        visited = visited.getLeftChild();
                        return this.find(e);
                    }
                    reset();
                    return false;   //can't go to the left
                }
                else if (e>visited.getElement())  //should go to the right
                {
                    if (visited.hasRightChild())
                    {
                        visited = visited.getRightChild();
                        return this.find(e);
                    }
                    reset();
                    return false;   //can't go to the right
                }
            }
        }
        reset();
        return false;
    }
}
