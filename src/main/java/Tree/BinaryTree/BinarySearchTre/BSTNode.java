/**
 * 
 */
package Tree.BinaryTree.BinarySearchTre;

import java.util.Comparator;

/**
 * @author vinod<vinodpal458@gmail.com
 */
public class BSTNode implements Comparator {
	private Integer data;
	private BSTNode left;
	private BSTNode right;
	private BSTNode nextRight;

	public BSTNode() {
		left = null;
		right = null;
		data = 0;
	}

	public BSTNode(int data) {
		left = null;
		right = null;
		this.data = data;
	}

	public Integer getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Object o1, Object o2) {
		BSTNode obj1 = (BSTNode) o1;
		BSTNode obj2 = (BSTNode) o2;
		if (obj1.getData() > obj2.getData())
			return 1;
		else if (obj1.getData() < obj2.getData())
			return -1;
		else
			return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (getData() == null)
			return false;
		if (object == this)
			return true;
		if (!(object instanceof BSTNode))
			return false;
		return this.getData().equals(((BSTNode) object).getData());
	}
	
	@Override
	public String toString(){
		return "Data Node : "+ getData()+", Left Data Node : " + (getLeft()!=null?getLeft().getData():null) 
				+", Right Data Node : " + (getRight()!=null?getRight().getData():null);
				//+", nextRight Data Node : " + (nextRight()!=null?nextRight().getData():null);
				
	}

	public BSTNode getNextRight() {
		return nextRight;
	}

	public void setNextRight(BSTNode nextRight) {
		this.nextRight = nextRight;
	}
	
	
	 /*Comparator for sorting the list by Data of BST */
	public static Comparator<BSTNode> BSTDataComparator = new Comparator<BSTNode>() {

		public int compare(BSTNode obj1, BSTNode obj2) {
			if (obj1.getData() > obj2.getData())
				return 1;
			else if (obj1.getData() < obj2.getData())
				return -1;
			else
				return 0;
		}
	};
}