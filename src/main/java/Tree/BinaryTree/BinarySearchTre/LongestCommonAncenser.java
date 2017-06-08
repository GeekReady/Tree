package Tree.BinaryTree.BinarySearchTre;

/**
 * @author vinod<vinodpal458@gmail.com
 */
public class LongestCommonAncenser {
	public int longestCommonAncenser(BSTNode root, int node1, int node2) {
		if (root == null)
			return -1;
		if (root.getData() >= node1 && root.getData() <= node2) {
			return root.getData();
		} else if (root.getData() < node1)
			return longestCommonAncenser(root.getRight(), node1, node2);
		else
			return longestCommonAncenser(root.getLeft(), node1, node2);
		// return 0;
	}

	public int getLowestCommonAncestor(BSTNode curr, int A, int B) {

		if (curr == null) {
			return -1;
		}

		// If we find A or B, we return the node data
		if (curr.getData() == A || curr.getData() == B)
			return curr.getData();

		// Recursive calls to find LCA in left and right subtrees
		int leftNode = getLowestCommonAncestor(curr.getLeft(), A, B);
		int rightNode = getLowestCommonAncestor(curr.getRight(), A, B);

		// If we found A and B in left or right subtree of the current node data,
		// this means current node is a common ancestor, so return the node data
		if (leftNode != -1 && rightNode != -1)
			return curr.getData();

		// If we found A or B in left or right subtree of the current node data,
		// the means current node is an ancestor, return the node data
		if (leftNode == -1) {
			return rightNode;
		} else {
			return leftNode;
		}
	}
	public BSTNode getLowestCommonAncestorNode(BSTNode curr, int A, int B) {

		if (curr == null) {
			return null;
		}

		// If we find A or B, we return the node
		if (curr.getData() == A || curr.getData() == B)
			return curr;

		// Recursive calls to find LCA in left and right subtrees
		BSTNode leftNode = getLowestCommonAncestorNode(curr.getLeft(), A, B);
		BSTNode rightNode = getLowestCommonAncestorNode(curr.getRight(), A, B);

		// If we found A and B in left or right subtree of the current node,
		// this means current node is a common ancestor, so return the node
		if (leftNode != null && rightNode != null)
			return curr;

		// If we found A or B in left or right subtree of the current node,
		// the means current node is an ancestor, return the node
		if (leftNode == null) {
			return rightNode;
		} else {
			return leftNode;
		}
	}
}
