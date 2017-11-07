/**
 * 
 */
package Tree.BinaryTree.BinarySearchTre;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @author vinod<vinodpal458@gmail.com
 */
public class BSTTraverse {

	public void levelOrderTravers(BSTNode root) {
		Queue<BSTNode> queue = new LinkedList<BSTNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			if (queue.peek().getLeft() != null)
				queue.add(queue.peek().getLeft());
			if (queue.peek().getRight() != null)
				queue.add(queue.peek().getRight());
			System.out.print(queue.poll().getData() + " : ");
		}
	}

	public void showInOrder(BSTNode root) {
		if (root == null)
			return;
		showInOrder(root.getLeft());
		System.out.print(root.getData() + " , ");
		showInOrder(root.getRight());
	}

	public void traverseInOrder(BSTNode root, ArrayList list) {
		if (root == null)
			return;
		if (list == null)
			list = new ArrayList<BSTNode>();
		traverseInOrder(root.getLeft(), list);
		list.add(root);
		traverseInOrder(root.getRight(), list);
	}

	public void showPreOrder(BSTNode root) {
		if (root == null)
			return;
		System.out.print(root.getData() + " , ");
		showPreOrder(root.getLeft());
		showPreOrder(root.getRight());
	}

	public void showPostOrder(BSTNode root) {
		if (root == null)
			return;
		showPostOrder(root.getLeft());
		showPostOrder(root.getRight());
		System.out.print(root.getData() + " , ");
	}

	// Traverse inorder, its right child access first
	public void digonalSumView(BSTNode root,
			int currentLevel/* ,Hashtable<Integer, Set<BSTNode>> hashTable */) {
		if (root == null)
			return;
		// Traverse left side of current root node and update level as same for
		// left of its level
		digonalSumView(root.getRight(), currentLevel/* , hashTable */);
		if (getHashTable().get(currentLevel) != null) {
			Set list = (TreeSet) getHashTable().get(currentLevel);
			list.add(root);
			getHashTable().put(currentLevel, list);
		} else {
			// Get temporary store for insert new node which is in same
			// diagonale
			Set<BSTNode> list = new TreeSet<BSTNode>(new BSTNode());
			list.add(root);
			getHashTable().put(currentLevel, list);
		}
		// Traverse left side of current root node and update level +1 for left
		// of its level
		digonalSumView(root.getLeft(), currentLevel + 1);
	}

	private Hashtable<Integer, Set<BSTNode>> hashTable = null;

	public Hashtable<Integer, Set<BSTNode>> getHashTable() {
		return hashTable;
	}

	public void setHashTable() {
		this.hashTable = new Hashtable<Integer, Set<BSTNode>>();
	}

	// Traverse tree as spiral order using by Deque.
	public void spiralOrderTraversWithDeque(BSTNode root) {
		Deque<BSTNode> deque = new LinkedList<BSTNode>();
		if (root == null)
			return;
		BSTNode nullNode = null;
		// add nullNode of BSTNode.
		deque.add(nullNode);
		deque.addFirst(root);// Add root node of binary tree.
		boolean flag = false;
		BSTNode tempNode = null; // Definition for temporary current parent node
									// of binary tree.
		// Traversing all nodes of Binary tree
		while (deque.peekFirst() != null) {
			if (flag == false) {// traverse for odd level of binary tree.
				while (deque.peekFirst() != null) {
					tempNode = deque.pollFirst();
					if (tempNode.getRight() != null) {
						deque.addLast(tempNode.getRight());
					}
					if (tempNode.getLeft() != null) {
						deque.addLast(tempNode.getLeft());
					}
					System.out.print(tempNode.getData() + " , ");
				}
				flag = true;
			}
			if (deque.peekLast() == null)
				break;
			if (flag == true) {// traverse for even level of binary tree.
				while (deque.peekLast() != null) {
					tempNode = deque.pollLast();
					if (tempNode.getLeft() != null) {
						deque.addFirst(tempNode.getLeft());
					}
					if (tempNode.getRight() != null) {
						deque.addFirst(tempNode.getRight());
					}
					System.out.print(tempNode.getData() + " , ");
				}
				flag = false;
			}
		}
	}

	public void spiralOrderTraversWithStack(BSTNode root) {
		Stack<BSTNode> stack1 = new Stack<BSTNode>();
		Stack<BSTNode> stack2 = new Stack<BSTNode>();
		stack1.push(root);
		BSTNode tempNode = null;
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				tempNode = stack1.pop();
				if (tempNode.getRight() != null)
					stack2.push(tempNode.getRight());
				if (tempNode.getLeft() != null)
					stack2.push(tempNode.getLeft());
				System.out.print(tempNode.getData() + " , ");
			}
			while (!stack2.isEmpty()) {
				tempNode = stack2.pop();
				if (tempNode.getLeft() != null)
					stack1.push(tempNode.getLeft());
				if (tempNode.getRight() != null)
					stack1.push(tempNode.getRight());
				System.out.print(tempNode.getData() + " , ");
			}
		}
	}

	// In-Order Traverse According to Mirros
	public void inOrderTraversByMirros(BSTNode root) {
		BSTNode preNode;
		while (root != null) {
			// Check current most left node
			if (root.getLeft() == null) {
				System.out.print(root.getData() + " , ");
				root = root.getRight();
			} else {
				preNode = root.getLeft();
				// Looking for node which is just small from current root node.
				while (preNode.getRight() != null && preNode.getRight() != root) {
					preNode = preNode.getRight();
				} // If right most node of current root node from just small
					// node.
				if (preNode.getRight() == null) {
					preNode.setRight(root);
					root = root.getLeft();
				} else {
					// If right most node of current root node is pointing
					// current root node from it's right child.
					System.out.print(root.getData() + " , ");
					preNode.setRight(null);
					root = root.getRight();
				}
			}
		}
	}

	// Pre-Order Traverse According to Mirros
	public void PreOrderTraversByMirros(BSTNode root) {
		BSTNode preNode;
		while (root != null) {
			// Check current most left node
			if (root.getLeft() == null) {
				System.out.print(root.getData() + " , ");
				root = root.getRight();
			} else {
				preNode = root.getLeft();
				// Looking for node which is just small from current root node.
				while (preNode.getRight() != null && preNode.getRight() != root) {
					preNode = preNode.getRight();
				} // If right most node of current root node from just small
					// node.
				if (preNode.getRight() == null) {
					System.out.print(root.getData() + " , ");
					preNode.setRight(root);
					root = root.getLeft();
				} else {
					// If right most node of current root node is pointing
					// current root node from it's right child.
					System.out.print(preNode.getData() + " , ");
					preNode.setRight(null);
					root = root.getRight();
				}
			}
		}
	}

	// Post-Order Traverse According to Mirros
	public void PostOrderTraversByMirros(BSTNode root) {
		BSTNode preNode;
		while (root != null) {
			// Check current most left node
			if (root.getRight() == null) {
				System.out.print(root.getData() + " , ");
				root = root.getLeft();
			} else {
				preNode = root.getRight();
				// Looking for node which is just small from current root node.
				while (preNode.getLeft() != null && preNode.getLeft() != root) {
					preNode = preNode.getLeft();
				} // If right most node of current root node from just small
					// node.
				if (preNode.getLeft() == null) {
					System.out.print(preNode.getData() + " , ");
					preNode.setLeft(root);
					root = root.getRight();
				} else {
					// If right most node of current root node is pointing
					// current root node from it's right child.
					preNode.setLeft(null);
					root = root.getLeft();
				}
			}
		}
	}

}
