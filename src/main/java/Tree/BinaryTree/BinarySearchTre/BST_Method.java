package Tree.BinaryTree.BinarySearchTre;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

/**
 * @author vinod<vinodpal458@gmail.com
 */
public class BST_Method {
	public BSTNode root = null;

	public BST_Method() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void display() {
		display(this.root);
	}

	public void display(BSTNode root) {
		if (root == null)
			return;
		if (root.getLeft() != null)
			display(root.getLeft());
		System.out.print(root.getData() + "   ");
		if (root.getRight() != null)
			display(root.getRight());
	}

	// If list is sorted
	public void insertAsBalance(int[] list) {
		root = insertAsBalance(list, 0, list.length - 1);
		System.out.println();
	}

	private BSTNode insertAsBalance(int[] list, int low, int high) {
		if (low > high)
			return null;
		int mid = low + (high - low) / 2;
		BSTNode rootNode = new BSTNode(list[mid]);
		rootNode.setLeft(insertAsBalance(list, low, mid - 1));
		rootNode.setRight(insertAsBalance(list, mid + 1, high));
		return rootNode;
	}

	private BSTNode insertAsBalance(List<BSTNode> list, int low, int high) {
		if (low > high)
			return null;
		int mid = low + (high - low) / 2;
		BSTNode rootNode = list.get(mid);
		rootNode.setLeft(insertAsBalance(list, low, mid - 1));
		rootNode.setRight(insertAsBalance(list, mid + 1, high));
		return rootNode;
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	public BSTNode insert(BSTNode root, int data) {
		if (root == null) {
			root = new BSTNode(data);
			// System.out.println(count);
		} else if (root.getData() > data) {
			root.setLeft(insert(root.getLeft(), data));
		} else {
			root.setRight(insert(root.getRight(), data));
		}
		return root;
	}

	public BSTNode count(int data, BSTNode root, int count) {
		if (root == null) {
			root = new BSTNode(data);
			// System.out.println(count);
		} else if (root.getData() > data) {
			root.setLeft(insert(root.getLeft(), data));
		} else {
			root.setRight(insert(root.getRight(), data));
		}
		return root;
	}

	public boolean delete(int data, BSTNode root) {
		if (root == null)
			return false;
		if (root.getData() == data)
			return true;
		if (root.getData() > data) {
			return delete(data, root.getLeft());
		} else {
			return delete(data, root.getRight());
		}

	}

	public void delete(int data) {
		root = delete(root, data);
	}

	public BSTNode delete(BSTNode root, int data) {
		BSTNode p = null;
		if (root.getData() == data) {
			BSTNode nl, nr;
			nl = root.getLeft();
			nr = root.getRight();
			if (nl == null && nr == null)
				return null;
			if (nl == null) {
				return nr;
			} else if (nr == null) {
				return nl;
			} else {
				p = nr;
				while (p.getLeft() != null)
					p = p.getLeft();
				p.setLeft(nl);
				return nr;
			}
		} else if (root.getData() > data) {
			root.setLeft(delete(root.getLeft(), data));
		} else {
			root.setRight(delete(root.getRight(), data));
		}
		return root;
	}

	public boolean search(int data) {
		return search(root, data);
	}

	public static boolean search(BSTNode root, int data) {
		if (root == null)
			return false;
		if (root.getData() == data)
			return true;
		if (root.getData() > data) {
			return search(root.getLeft(), data);
		} else
			return search(root.getRight(), data);
	}

	// get kth smallest Node in BST
	public int getKthSmallestNode(int data) {
		ObtainKth kThObject = new ObtainKth();
		return kThObject.getKthSmallest(root, data);
	}

	// get kth largest Node in BST
	public int getKthLargestNode(int kth) {
		ObtainKth kthObject = new ObtainKth();
		int[] count = new int[1];
		BSTNode kthNode = kthObject.getKthLargest(root, kth, count);
		if (kthNode != null)
			return kthNode.getData();
		else
			return -1;
	}
	// get kth Node in BST using 
	public int getKthNode(BSTNode root , int kth){
		if(root==null)
			root = this.root;
		ObtainKth obj = new ObtainKth();
		BSTNode result = obj.getKthNodeByMirros(root,kth);
		if(result!=null){
			System.out.println(result.getData());
			return result.getData();
		}
		else return -1;
	}
	public void getPopulatedRightNode() {
		PopulatedRightNeigbhorNode obj = new PopulatedRightNeigbhorNode();
		obj.getPopulatedRightNeighorByLevelTravers(root);
	}

	public void getPopultatedRightNodeWithLevelOrderTraverse() {
		PopulatedRightNeigbhorNode obj = new PopulatedRightNeigbhorNode();
		obj.getPopulataedRightNeigborNode(root);
		System.out.println("");
	}

	public void leftViewTree() {
		LeftView leftView = new LeftView();
		leftView.viewLeftUsingLevelOrderTravers(root);
	}

	public void leftViewTreeRecursin() {
		LeftView leftView = new LeftView();
		leftView.viewLeftUsingRecursion(root, 1);
	}

	public int longestCommonAncenser(int node1, int node2) {
		LongestCommonAncenser lca = new LongestCommonAncenser();
		return lca.getLowestCommonAncestor(root, node1, node2);
	}

	public int getMinDepth() {
		MinMaxDepthBST minDepth = new MinMaxDepthBST();
		return minDepth.getMinDepth(root);
	}

	public int getMaxDepth() {
		MinMaxDepthBST minDepth = new MinMaxDepthBST();
		return minDepth.getMaxDepth(root);
	}

	// Recover BST for two numbers
	public void recoverTree(BSTNode root) {
		MissingTwoNumbersSwapInBST missing = new MissingTwoNumbersSwapInBST();
		missing.findMissingTwoNumbersSwapInBST(root);
	}

	public void getLevelOrderTraverse() {
		BSTTraverse traverse = new BSTTraverse();
		traverse.levelOrderTravers(root);
	}

	public void printInOrderTraverse(BSTNode root) {
		if (root == null)
			root = this.root;
		BSTTraverse traverse = new BSTTraverse();
		traverse.showInOrder(root);
	}

	public void printPreOrderTraverse(BSTNode root) {
		if (root == null)
			root = this.root;
		BSTTraverse traverse = new BSTTraverse();
		traverse.showPreOrder(root);
	}

	public void printPostOrderTraverse(BSTNode root) {
		if (root == null)
			root = this.root;
		BSTTraverse traverse = new BSTTraverse();
		traverse.showPostOrder(root);
	}

	public void printSpiralOrderTravers(BSTNode root) {
		if (root == null)
			root = this.root;
		BSTTraverse traverse = new BSTTraverse();
		traverse.spiralOrderTraversWithDeque(root);
	}

	public void printSpiralOrderTraversByStack(BSTNode root) {
		if (root == null)
			root = this.root;
		BSTTraverse traverse = new BSTTraverse();
		traverse.spiralOrderTraversWithStack(root);
	}

	public void printInOrderTraverseByMirros(BSTNode root) {
		if (root == null)
			root = this.root;
		BSTTraverse traverse = new BSTTraverse();
		traverse.inOrderTraversByMirros(root);
	}
	public void printPreOrderTraverseByMirros(BSTNode root) {
		if (root == null)
			root = this.root;
		BSTTraverse traverse = new BSTTraverse();
		traverse.PreOrderTraversByMirros(root);
	}
	public void printPostOrderTraverseByMirros(BSTNode root) {
		if (root == null)
			root = this.root;
		BSTTraverse traverse = new BSTTraverse();
		traverse.PostOrderTraversByMirros(root);
	}
	public void getNumberOfBST(int n) {
		GenerateBSTs generateBSTs = new GenerateBSTs();
		int[] solutionRecord = new int[n + 1];
		Arrays.fill(solutionRecord, -1);
		System.out.println(generateBSTs.getNumberOfBSTts(n, solutionRecord));
	}

	public Hashtable<Integer, Set<BSTNode>> getDigonalNodes() {
		BSTTraverse traverse = new BSTTraverse();
		traverse.setHashTable();
		traverse.digonalSumView(root,
				0/* ,Hashtable<Integer, Set<BSTNode>> hashTable */);
		return traverse.getHashTable();
	}

	public boolean checkMirror(BSTNode root) {
		if (root == null) {
			root = this.root;
		}
		Mirror mirror = new Mirror();
		return mirror.checkMirror(root.getLeft(), root.getRight());
	}

	public void generateBinaryToBST(BSTNode root) {
		if (root == null)
			root = this.root;
		GenerateBSTs generateBSTs = new GenerateBSTs();
		generateBSTs.generateBST(root);
	}

	public void setSerialize(String fileName) {
		Conversion conversion = new Conversion();
		conversion.serialize(fileName);
	}

	public boolean isBST(BSTNode root) {
		if (root == null)
			root = this.root;
		BST_Check bst_Check = new BST_Check();
		boolean result = bst_Check.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(result);
		return result;
	}
	
	public void getMedian(BSTNode root){
		if(root == null)
			root = this.root;
		FindMedian object = new FindMedian();
		System.out.println(object.getMedian(root));
	}
	
	public void currectMissingTwoNumbersSwapInBST(BSTNode root) {
		if (root == null)
			root = this.root;
		MissingTwoNumbersSwapInBST object = new MissingTwoNumbersSwapInBST();
		object.currectMissingTwoNumbersSwapInBST(root);
	}
}
