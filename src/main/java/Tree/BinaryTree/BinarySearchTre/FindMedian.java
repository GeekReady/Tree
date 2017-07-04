/**
 * 
 */
package Tree.BinaryTree.BinarySearchTre;
/**
 * @author vinod<vinodpal458@gmail.com
 */
//http://www.geeksforgeeks.org/find-median-bst-time-o1-space/
public class FindMedian {
	//In-Order Traverse According to Mirros and get median of BST.
	public int getMedian(BSTNode root){
		int countCurrent = 0;
		int countNodes = (new CountInBST()).getNumberOfNodes(root);
		BSTNode prev = null;
		while(root!=null){
			if(root.getLeft()==null){
				++countCurrent;
				if((countNodes&1)!=0 && countCurrent==(countNodes+1)/2){
					return root.getData();
				}
				else if((countNodes&1)==0 && countCurrent==countNodes/2+1){
					return (root.getData()+prev.getData())/2;
				}
				prev = root;
				root = root.getRight();
				
			}else {
				BSTNode tempNode = root.getLeft();
				while(tempNode.getRight()!=null && tempNode.getRight()!=root){
					tempNode = tempNode.getRight();
				}
				if(tempNode.getRight()==null){
					tempNode.setRight(root);
					root= root.getLeft();
				}
				else{
					tempNode.setRight(null);
					prev = tempNode;
					++countCurrent;
					if((countNodes&1)!=0 && countCurrent==(countNodes+1)/2){
						return root.getData();
					}
					else if((countNodes&1)==0 && countCurrent==countNodes/2+1){
						return (root.getData()+prev.getData())/2;
					}
					prev = root;
					root = root.getRight();
				}
			}
			
		}
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
