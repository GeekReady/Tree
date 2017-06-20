package Tree.BinaryTree.BinarySearchTre;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author vinod<vinodpal458@gmail.com
 */
public class LeftView {
	public void viewLeftUsingLevelOrderTravers(BSTNode root) {
		Queue<BSTNode> q1 = new LinkedList<BSTNode>();
		Queue<BSTNode> q2 = new LinkedList<BSTNode>();
		q1.add(root);
		while (!(q1.isEmpty() && q2.isEmpty())) {
			if (q1.peek() != null) {
				System.out.println(q1.peek().getData());
			}
			while (!q1.isEmpty()) {
				BSTNode node = q1.poll();
				if (node.getLeft() != null)
					q2.add(node.getLeft());
				if (node.getRight() != null)
					q2.add(node.getRight());
				// System.out.println(node.getData());
			}
			if (q2.peek() != null) {
				System.out.println(q2.peek().getData());
			}
			while (!q2.isEmpty()) {
				BSTNode node = q2.poll();
				if (node.getLeft() != null)
					q1.add(node.getLeft());
				if (node.getRight() != null)
					q1.add(node.getRight());
				// System.out.println(node.getData());
			}
		}
	}

	static int max_level = 0;
	// Travers Pre-Order
	public void viewLeftUsingRecursion(BSTNode root, int level) {
		// Base Case
		if (root == null)
			return;
		// If this is the first node of its level
		if (max_level < level) {
			System.out.print(" " + root.getData());
			max_level = level;
		}
		// Recur for left and right subtrees
		viewLeftUsingRecursion(root.getLeft(), level + 1);
		viewLeftUsingRecursion(root.getRight(), level + 1);
	}
}
