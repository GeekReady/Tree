
package Tree.BinaryTree;

import java.util.Arrays;

import Tree.BinaryTree.BinarySearchTre.BSTNode;


/*
 * 
 *http://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/ 
*/
public class ViewAllKthNodesFromTargetNodes {

	//View all kth Nodes from target Node 
	public int viewAllKthNodesFromTargetNodes(BSTNode root, BSTNode target, int k) {
		if (root == null)
			return -1;
		if (root == target) {
			printDownNodes(root, k);
			return 0;
		}
		int dl = viewAllKthNodesFromTargetNodes(root.getLeft(), target, k);
		if (dl != -1) {
			if (dl + 1 == k) {
				System.out.print(root.getData() + " , ");
			} else {
				printDownNodes(root.getRight(), k - dl - 2);
			}
			return dl + 1;
		}
		int dr = viewAllKthNodesFromTargetNodes(root.getRight(), target, k);
		if (dr != -1) {
			if (dr + 1 == k) {
				System.out.println(root.getData());
			} else {
				printDownNodes(root.getLeft(), k - dr - 2);
			}
			return dr + 1;
		}
		return -1;
	}

	public void printDownNodes(BSTNode root, int k) {
		if (root == null)
			return;
		if (k == 0) {
			System.out.println(root.getData());
			return;
		} else {
			printDownNodes(root.getLeft(), k - 1);
			printDownNodes(root.getRight(), k - 1);
		}
	}

	public static void main(String... strings) {
		Tree.BinaryTree.BinarySearchTre.BST_Method bst = new Tree.BinaryTree.BinarySearchTre.BST_Method();
		int[] array = { 19, 21, 46, 20, 10, 30, 25, 40 };// { 2, 1, 4, 8, 5 };
		Arrays.sort(array);
		bst.insertAsBalance(array);
		bst.display();
		System.out.println();
		ViewAllKthNodesFromTargetNodes object = new ViewAllKthNodesFromTargetNodes();
		System.out.println("ROOT :"+bst.root.getData());
		object.viewAllKthNodesFromTargetNodes(bst.root, bst.root.getRight(), 2);
	}
}
