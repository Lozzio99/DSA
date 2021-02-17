import Mine.BinarySearchTree;

import java.util.Random;

public class MoneySearch
{
    public static void main(String[] args) {


        BinarySearchTree searchTree = new BinarySearchTree();
        int[] find_em = new int [6];
        for (int i = 0; i< 6; i++)
        {
            int e = new Random().nextInt(100);
            find_em[i] = e;
            System.out.println(e);
            searchTree.insert(e);
        }


        System.out.println(new LinearFamilyTree().linearizeI(searchTree.getTree()));

        for (int i = 0; i< 6; i++)
            System.out.println(searchTree.find(find_em[i]));



    }

}
