/**
 * 
 */
package Tree.BinaryTree.BinarySearchTre;

import java.util.Arrays;

import Tree.File.FileRead;



public class Conversion {
	FileRead file = null;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	void serialize(String fileName) {
		file = new FileRead();
		file.setRecordsOfFile(fileName);
		String recordAsTree = file.getStoreRecords();
		BST_Method bst = new BST_Method();
		int[] array = null;
		for (String line : recordAsTree.split(System.getProperty("line.separator"))) {
			 array = new int[line.split(",").length+1];
			 int i= 0;
			 for(String currentNumber : line.split(",")){
				 array[i++]=Integer.parseInt(currentNumber);
			 }
		}
		Arrays.sort(array);
		bst.insertAsBalance(array);
		bst.display();
		
	}
}

















