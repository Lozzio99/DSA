package Enders;

import Mine.BinaryTree;
import Mine.BinaryTreeNode;
import Mine.LinkedBinaryTree;

public class BinarySearchTree {
	BinaryTree<Integer> tree = new LinkedBinaryTree<>();

	public BinarySearchTree()
	{

	}

	//---------------------------------------------
	
	public void insert(Integer e) {

		if (tree.getRoot() == null) {
			tree.addRoot(e);
		} else {
			insert_Recursion(tree.getRoot(), e);
		}
	}

	public void insert_Recursion(BinaryTreeNode<Integer> node, Integer value) { // finds the leaf where the value needs to be added
																		

		if (node.getLeftChild() == null && node.getRightChild() == null) {
			if (node.getElement() < value) {
				node.addRightChild(value);
			} 
			else if (node.getElement() > value) {
				node.addLeftChild(value);
			}
			return;
		}

		if (node.getLeftChild() == null && node.getRightChild() != null) {
			if (node.getElement() > value) {
				node.addLeftChild(value);
			}
			else if (node.getElement() < value) {
				insert_Recursion(node.getRightChild(), value);
			}
			return;
		}

		if (node.getLeftChild() != null && node.getRightChild() == null) {
			if (node.getElement() < value) {
				node.addRightChild(value);
			}
			else if (node.getElement() > value) {
				insert_Recursion(node.getLeftChild(), value);
			}
			return;
		}

		if (node.getElement() > value) {
			insert_Recursion(node.getLeftChild(), value);
		}
		if (node.getElement() < value) {
			insert_Recursion(node.getRightChild(), value);
		}
	}

	//-------------------------------------------------
	
	public boolean delete(Integer e) { // returns true if the node was successfully removed
		
		if (find_Recursion(tree.getRoot(), e)) {
			delete_Recursion(tree.getRoot(), e);
			return !find_Recursion(tree.getRoot(), e);
		}
		return find_Recursion(tree.getRoot(), e);
	}

	public void delete_Recursion(BinaryTreeNode<Integer> node, Integer value)
	{ // deletes node
		BinaryTreeNode<Integer> foundNode = findingNode(node, value); // first finding the place where the value is
		BinaryTreeNode<Integer> right = foundNode.getRightChild();
		BinaryTreeNode<Integer> left = foundNode.getLeftChild();
		
		 if (right == null &&  left == null ) { // if it has no children just set
			System.out.println("0");
			foundNode.setElement(null);
		}

		else if (left == null) { // if only one child, set
																							// child null and set
																							// current node to child's
																							// value
			System.out.println("1right");
			foundNode.setElement(right.getElement());
			right.setElement(null);
		}

		else if (right == null) { // if only one child, set
																							// child null and set
																							// current node to child's
																							// value
			System.out.println("1left");
			foundNode.setElement(left.getElement());
			left.setElement(null);
		}

		else  { // if 2 child find a node through inOrder than replace
			System.out.println("2");
			BinaryTreeNode<Integer> traverse = inOrderSuccessor(foundNode.getRightChild());
			System.out.println(traverse.getElement());
			foundNode.setElement(traverse.getElement());
			traverse.setElement(null);
		}

	}
	
	//-------------------------------------
	// implement inOrderSuccessor
	public BinaryTreeNode<Integer> inOrderSuccessor(BinaryTreeNode<Integer> node) {
		
		if (node.getLeftChild() == null) {
			return node;
		}
		else {
			 inOrderSuccessor(node.getLeftChild());
		}
		return node;
		
	}
    
 
       
	//------------------------------------------------
	
	public boolean find(Integer e) {

		return find_Recursion(tree.getRoot(), e);
	}

	public boolean find_Recursion(BinaryTreeNode<Integer> node, Integer value) { // returns depending if value exists or not

		boolean answer = false;
		
		 if (node == null || node.getElement() == null) {
			return false;
		 }
		
		if (node.getElement() < value) {
			if (node.getRightChild() != null) {
				// System.out.println("a");
				return find_Recursion(node.getRightChild(), value);
			} 
		}

		else if (node.getElement() > value) {
			if (node.getLeftChild() != null) {
				// System.out.println("b");
				return find_Recursion(node.getLeftChild(), value);
			} 
		}

		else if (node.getLeftChild() == null && node.getRightChild() == null && node.getElement() != value) {
			// System.out.println("c");
			answer = false;
		}
		
		else if (node.getElement().equals(value)) {
			// System.out.println("d");
			answer = true;
		}
		return answer;
	}

	//---------------------------------------------------------
	
	public BinaryTreeNode<Integer> findingNode(BinaryTreeNode<Integer> node, Integer value)
	{ // finding the id of the node
																							// with the same value of
																							// given value

		if (node.getElement() < value) { // problem is here
			System.out.println("x");
			return findingNode(node.getRightChild(), value);
		}

		else if (node.getElement() > value) { // or here
			System.out.println("y");
			return findingNode(node.getLeftChild(), value);
		}
		
		else if (node.getElement().equals(value)) {
			System.out.println("z");
			return node;
		}
	return null;  // ???
		
	}
	
	public BinaryTreeNode<Integer> getRoot1() {
		return tree.getRoot();
	}
}