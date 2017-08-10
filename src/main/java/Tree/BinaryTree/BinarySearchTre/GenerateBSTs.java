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
	/*
	 * Total number of BSTs for 'n' distinct keys = total number of BSTs with
	 * '1' as root + total number of BSTs with '2' as root + ... + total number
	 * of BSTs with 'n' as root
	 * 
	 * Total number of BSTs with 'i' as the root = (Total number of BSTs with
	 * 'i-1' distinct keys)*(Total number of BSTs with 'n-i' distinct keys)
	 */

	// n is input and 'solutionRecord' array stores the intermediate results. All
	// values are initialized to -1
	public int getNumberOfBSTts(int n, int[] solutionRecord) {
		int currentCross = 0;
		if (n == 0 || n == 1)
			return 1;
		// summation of total number of BSTs possible with each value of 'i' as the root
		for (int itr = n; itr > 0; --itr) {
			if (solutionRecord[itr-1] == -1) {
				solutionRecord[itr-1] = getNumberOfBSTts(itr - 1, solutionRecord);// compute all possible BSTs in its left-subtree
			}
			if (solutionRecord[n - itr] == -1) {
				solutionRecord[n - itr] = getNumberOfBSTts(n - itr, solutionRecord);// compute all possible BSTs in its right-subtree
			}
			currentCross += solutionRecord[itr-1] * solutionRecord[n - itr];// multiply these two values and add to total
		}
		return currentCross;
	}

	public BSTNode generateBST(BSTNode root) {
		ArrayList<BSTNode> inOrderTravers = new ArrayList<BSTNode>();
		(new BSTTraverse()).traverseInOrder(root, inOrderTravers);
		inOrderTravers.stream().forEach(x -> System.out.println(x.toString()));
		Collections.sort((List<BSTNode>) inOrderTravers, BSTNode.BSTDataComparator);
		// Collections.reverse(inOrderTravers); //Reverse directly by using the
		// compare of implements comparator of BSTNode Class.
		System.out.println("*************************************************");
		inOrderTravers.stream().forEach(x -> System.out.println(x.toString()));
		// inOrderTravers.sort(BSTNode);;
		return root;
	}

}
