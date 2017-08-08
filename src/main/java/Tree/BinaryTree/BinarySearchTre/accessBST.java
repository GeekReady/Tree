package Tree.BinaryTree.BinarySearchTre;
/**
 * @author vinod<vinodpal458@gmail.com
 */
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class accessBST {
	public static void main(String... args) {
		BST_Method bst = new BST_Method();

		int[] array = /*{ 8, 1, 6, 2, 3, 4, 5 };*/{19,21,46,20,10,30,25,40};//{ 2, 1, 4, 8, 5 };
	/*	for (int i = 0; i < array.length; ++i) {
			bst.insert(array[i]);
		}
		bst.display();
		System.out.println();
		bst.delete(4);
		bst.display();
		System.out.println();
		System.out.println(bst.search(3));
		System.out.println(bst.search(4));
		System.out.println(bst.getKthSmallestNode(3));*/
		//bst.leftViewTreeRecursin();
		Arrays.sort(array);
		bst.insertAsBalance(array);
		bst.display();
		System.out.println();
		//Currect Missing number 
		bst.currectMissingTwoNumbersSwapInBST(null);
		
		/*bst.printPostOrderTraverse(null);
		System.out.println();
		bst.printPostOrderTraverseByMirros(null);*/
		//System.out.println("Median");
		//bst.getMedian(null);
		//bst.getKthNode(null,6);
		/*System.out.println(bst.longestCommonAncenser(10	, 12));
		System.out.println(bst.getMaxDepth());*/
		//bst.getLevelOrderTraverse();
		//bst.getNumberOfBST(3);
		
		//This for Print/Sum diagonale of BST 
		/*Hashtable<Integer, Set<BSTNode>> hashTable = bst.getDigonalNodes();
		Set<Integer> itr = (Set) hashTable.keySet();
		for(Integer i : itr){
			Set<BSTNode> list = hashTable.get(i);
			System.out.print(i + " :- ");
			list.stream().forEach(x->System.out.print(x.getData()+", "));
			System.out.println();
		}*/
		
		//get Kth Largest Node
		//System.out.println(bst.getKthLargestNode(5));
		
		//Populated right neigbhor node in BST
		/*bst.getPopultatedRightNodeWithLevelOrderTraverse();
		bst.getPopulatedRightNode();*/
		
		//Travers as spiral order
		/*bst.printSpiralOrderTravers(null);
		System.out.println();
		bst.printSpiralOrderTraversByStack(null);*/
		
		//Generate Binary Tree to BST 
		//bst.generateBinaryToBST(null);
		//bst.setSerialize("/home/devnew/Files/bstInOrder");
		
		
		//Check Binary Tree is Binary Search Tress or Not
		
		//bst.isBST(null);
	}
	
	
	
	
	
	
	//This Main method for missing two Number Recover BST  
	/*public static void main(String[] args)
	   {
	       BSTNode root = new BSTNode(10);
	       BSTNode n1   = new BSTNode(15);
	       BSTNode n2   = new BSTNode(5);
	       BSTNode n3   = new BSTNode(4);
	       BSTNode n4   = new BSTNode(7);
	       BSTNode n5   = new BSTNode(14);
	       BSTNode n6   = new BSTNode(17);
	        
	       root.setLeft(n1);
	       root.setRight(n2);
	        
	       n1.setLeft(n3); 
	       n1.setRight(n4); 
	        
	       n2.setLeft(n5);  
	       n2.setRight(n6); 
	        
	       BST_Method solution = new BST_Method();
	        
	       System.out.println("In-Order traversal of BST before recovery: ");
	       solution.printInOrderTraverse(root);
	 
	       solution.recoverTree(root);
	       System.out.println();
	       System.out.println("In-Order traversal of BST after recovery: ");
	       solution.printInOrderTraverse(root);
	   }*/
}
