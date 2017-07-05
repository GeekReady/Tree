package Tree.BinaryTree.BinarySearchTre;

import java.util.Stack;

/**
 * @author vinod<vinodpal458@gmail.com
 */
/*
 * 2 1 3
 */
public class ObtainKth {

	// get k'th smallest Node in BST
	public int getKthSmallest(BSTNode root, int k) {
		Stack<BSTNode> st = new Stack();
		BSTNode pCrawl = root;
		while (pCrawl != null) {
			st.push(pCrawl);
			pCrawl = pCrawl.getLeft();
		}
		while (!st.isEmpty()) {
			pCrawl = st.pop();
			if ((--k) == 0) {
				// st->stackIndex = 0;
				break;
			}
			if (pCrawl.getRight() != null) {
				pCrawl = pCrawl.getRight();
				while (pCrawl != null) {
					st.push(pCrawl);
					pCrawl = pCrawl.getLeft();
				}
			}
		}
		return pCrawl.getData();
	}

	// Find k'th largest element
	public BSTNode getKthLargest(BSTNode root, int k, int[] count) {
		if (root == null)
			return root;
		BSTNode maxNode = getKthLargest(root.getRight(), k, count);
		if (maxNode == null) {
			count[0] += 1;
			if (count[0] == k) {
				maxNode = root;
			}
		}
		if (maxNode == null) {
			maxNode = getKthLargest(root.getLeft(), k, count);
		}
		return maxNode;
	}

	//Find kth smallest element by Mirros
	public BSTNode getKthNodeByMirros(BSTNode root, int k){
		int count=0;
		BSTNode tempNode = null;
		while(root!=null){
			if(root.getLeft()==null){
				++count;
				if(count==k){
					return root;
				}
				root = root.getRight();
			}else{
				tempNode = root.getLeft();
				while(tempNode.getRight()!=null && tempNode.getRight()!=root){
					tempNode = tempNode.getRight();
				}
				if(tempNode.getRight()==null){
					tempNode.setRight(root);
					root=root.getLeft();
				}else{
					tempNode.setRight(null);
					++count;
					if(count==k){
						return root;
					}
					root = root.getRight();
				}
			}
		}
		return null;
	}
}
