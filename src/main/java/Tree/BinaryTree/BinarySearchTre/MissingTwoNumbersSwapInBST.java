package Tree.BinaryTree.BinarySearchTre;
/**
 * @author vinod<vinodpal458@gmail.com
 */
public class MissingTwoNumbersSwapInBST {
	BSTNode firstNode, secondeNode, currentNode;

	//Traversing In Order way
	public void findMissingTwoNumbersSwapInBST(BSTNode root) {
		if (root == null)
			return;
		findMissingTwoNumbersSwapInBST(root.getLeft());
		if (currentNode != null && root.getData() < currentNode.getData()) {
			if (firstNode == null) {
				firstNode = currentNode;
			}
			//It's for when only one pair find 
			else
				secondeNode = root;
		}
		currentNode = root;
		//This condition will not work when "secondeNode" has without "else" condition. 
		if (firstNode != null && secondeNode != null) {
			firstNode.setData(firstNode.getData() ^ secondeNode.getData());
			secondeNode.setData(firstNode.getData() ^ secondeNode.getData());
			firstNode.setData(firstNode.getData() ^ secondeNode.getData());
			firstNode = null;
			secondeNode = null;
		}
		findMissingTwoNumbersSwapInBST(root.getRight());
		// return root;
	}
}
