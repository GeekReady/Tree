/**
 * 
 */
package Tree.BinaryTree.BinarySearchTre;

/**
 * @author vinod<vinodpal458@gmail.com
 */
public class Mirror {

	
	
	
	
	
	
	
	
	
	
	
	
	boolean checkMirror(BSTNode root1, BSTNode root2) {

		if (root1 == null && root2 == null)//Check for leave node if both of its node name leave node or not.
			return true;
		if (root1 == null || root2 == null)//Check for leave if one of its not leave node 
			return false;
		if (root1.equals(root2)) {//Recursive check for child node of its current parents.
			return checkMirror(root1.getLeft(), root2.getRight()) && checkMirror(root1.getRight(), root2.getLeft());
		}
		return false;//return false if no any case true.
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
