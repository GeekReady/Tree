/**
 * 
 */
package Tree.BinaryTree.BinarySearchTre;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author vinod<vinodpal458@gmail.com
 */
public class GenerateBSTs {
	public int getNumberOfBSTts(int n, int[] solutionRecord) {
		int currentCross = 0;
		if (n == 0 || n == 1)
			return 1;
		for (int itr = n; itr > 0; --itr) {
			if (solutionRecord[itr] != -1) {
				solutionRecord[itr] = getNumberOfBSTts(itr - 1, solutionRecord);
			}
			if (solutionRecord[n - itr] != -1) {
				solutionRecord[n - itr] = getNumberOfBSTts(n - itr, solutionRecord);
			}
			currentCross += solutionRecord[itr] * solutionRecord[n - itr];
		}
		return currentCross;
	}
	
	
	
	
	
	
	
	
	
	
	
	public BSTNode generateBST(BSTNode root){
		ArrayList<BSTNode> inOrderTravers = new ArrayList<BSTNode>(); 
		(new BSTTraverse()).traverseInOrder(root,inOrderTravers);
		inOrderTravers.stream().forEach(x->System.out.println(x.toString()));
		Collections.sort((List<BSTNode>) inOrderTravers,BSTNode.BSTDataComparator);
		//Collections.reverse(inOrderTravers); //Reverse directly by using the compare of implements comparator of BSTNode Class. 
		System.out.println("*************************************************");
		inOrderTravers.stream().forEach(x->System.out.println(x.toString()));
		//inOrderTravers.sort(BSTNode);;
		return root;
	}
	
}
