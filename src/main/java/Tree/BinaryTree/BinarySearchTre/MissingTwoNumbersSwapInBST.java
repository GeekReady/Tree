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
	
	//Currect BST of two missing number by mirror 
	public void currectMissingTwoNumbersSwapInBST(BSTNode root){
		
		
		BSTNode currentRoot = root;
		BSTNode current = null;
		while(currentRoot!=null){
			
			if(currentRoot.getLeft()==null){
				System.out.print(currentRoot.getData()+ "   ");
				currentRoot = currentRoot.getRight();
			}
			else{
				current = currentRoot.getLeft();
				while(current.getRight()!=null && current.getRight()!=currentRoot){
					current = current.getRight();
				}
				if(current.getRight()==null){
					current.setRight(currentRoot);
					currentRoot = currentRoot.getLeft();
				}
				else{
					System.out.print(currentRoot.getData()+ "   ");
					current.setRight(null);
					currentRoot = currentRoot.getRight();
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
