package BinarySearch;

import java.util.ArrayList;
import java.util.Random;

public class BinarySearchTree
{
    private Tree tree;

    public static void main(String[] args)
    {
        ArrayList<Integer> values = new ArrayList<>(5);
        for (int i = 0; i< 5; i++)
            values.add(new Random().nextInt(100));


        new BinarySearchTree(values);


    }

    public BinarySearchTree(ArrayList<Integer> values)
    {
        tree = new Tree();
        for (Integer i : values)
            tree.addValue(new Node(i));

        tree.addValue(new Node(10));


        System.out.println(tree.search(10).getValue());

        tree.traverse();
    }

}
