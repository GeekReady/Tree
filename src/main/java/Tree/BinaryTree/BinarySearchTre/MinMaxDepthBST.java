package Tree.BinaryTree.BinarySearchTre;
/**
 * @author vinod<vinodpal458@gmail.com
 */
public class MinMaxDepthBST {
	/**
	 * This method is useful for get Minimum depth of Tree from root node in BST . 
	 * Return body contains the Integer Which return length of minimum depth. 
	 * </p>
	 * 
	 * @return the Integer
	 */
	public int getMinDepth(BSTNode root) {
		if (root == null)
			return 0;
		if (root.getLeft() == null && root.getRight() == null)
			return 1;
		int left = root.getLeft() != null ? getMinDepth(root.getLeft()) : Integer.MAX_VALUE;
		int right = root.getRight() != null ? getMinDepth(root.getRight()) : Integer.MAX_VALUE;
		return 1 + Math.min(left, right);
	}
	/**
	 * This method is useful for get Maximum depth of Tree from root node in BST . 
	 * Return body contains the Integer Which return length of Maximum depth. 
	 * </p>
	 * 
	 * @return the Integer
	 */
	public int getMaxDepth(BSTNode root) {
		if (root == null)
			return 0;
		if (root.getLeft() == null && root.getRight() == null)
			return 1;
		int left = root.getLeft() != null ? getMaxDepth(root.getLeft()) : Integer.MIN_VALUE;
		int right = root.getRight() != null ? getMaxDepth(root.getRight()) : Integer.MIN_VALUE;
		return 1 + Math.max(left, right);
	}
	
}
