
package Tree.BinaryTree.BinarySearchTre;

/**
 * @author vinod<vinodpal458@gmail.com
 */

public class BST_Check {

	/**
	 * Check binary search tree that is it balance or not
	 */
	public int getIsBalanceBST(BSTNode root) {
		if (root == null)
			return 0;
		int leftRoot = getIsBalanceBST(root.getLeft());
		if (leftRoot == -1)
			return -1;
		int rightRoot = getIsBalanceBST(root.getRight());
		if (rightRoot == -1)
			return -1;
		if (Math.abs(leftRoot - rightRoot) > 1)
			return -1;
		else
			return 1 + Math.max(leftRoot, rightRoot);
	}

	/**
	 * This method is useful for check Tree is BST or not. 
	 * Response body contains the boolean Which 
	 * </p>
	 * 
	 * @return the boolean
	 */
	public boolean isBST(BSTNode root, int low, int high) {
		if (root == null) {
			return true;
		}
		if (root.getData() <= low || root.getData() >= high)
			return false;
		else {
			return isBST(root.getLeft(), low, root.getData()) & isBST(root.getRight(), root.getData(), high);
		}
	}

}
