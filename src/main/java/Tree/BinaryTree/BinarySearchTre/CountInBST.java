/**
 * 
 */
package Tree.BinaryTree.BinarySearchTre;

/**
 * @author vinod<vinodpal458@gmail.com
 */
public class CountInBST {

//In-Order Traverse According to Mirros and get count nodes.
	public int getNumberOfNodes(BSTNode root){
		int count=0;
		BSTNode tempNode;
		while(root!=null){
			if(root.getLeft()==null){
				++count;
				root=root.getRight();
			}else{
				tempNode = root.getLeft();
				while(tempNode.getRight()!=null && tempNode.getRight()!=root){
					tempNode = tempNode.getRight();
				}
				if(tempNode.getRight()==null){
					tempNode.setRight(root);
					root=root.getLeft();
				}else{
					++count;
					tempNode.setRight(null);
					root=root.getRight();
				}
			}
		}
		return count; 
	}
}
