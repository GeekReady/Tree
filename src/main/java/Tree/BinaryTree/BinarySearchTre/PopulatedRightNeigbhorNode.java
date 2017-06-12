/**
 * 
 */
package Tree.BinaryTree.BinarySearchTre;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;



/**
 * @author vinod<vinodpal458@gmail.com
 */
public class PopulatedRightNeigbhorNode {
	
	
	
	
	
	
	
	
	public BSTNode getPopulatedRightNeighorByLevelTravers(BSTNode root) {
		//Queue<BSTNode> queue = (Queue<BSTNode>) new LinkedList();
		Deque<BSTNode> deQueue =  new LinkedList<BSTNode>();
		BSTNode temp = null;
		deQueue.add(temp);
		deQueue.addFirst(root);
		BSTNode tempRoot = null;
		boolean flag = true;
		while (deQueue.peek()!=null) {
			if(flag==true){
				while(deQueue.peekFirst()!=null){
					tempRoot = deQueue.pollFirst();
					if(tempRoot.getLeft()!=null)
						deQueue.addLast(tempRoot.getLeft());
					if(tempRoot.getRight()!=null)
						deQueue.addLast(tempRoot.getRight());
					System.out.println(tempRoot.getData());
				}
				flag=false;
			}
			if(deQueue.peekLast()==null)break;
			if(flag==false){
				while (deQueue.peekLast() != null) {
					tempRoot = deQueue.pollLast();
					if (tempRoot.getRight() != null)
						deQueue.addFirst(tempRoot.getRight());
					if (tempRoot.getLeft() != null)
						deQueue.addFirst(tempRoot.getLeft());
					System.out.println(tempRoot.getData());
				}
				flag=true;
			}
		}
		return root;
	}
	
	void getPopulataedRightNeigborNode(BSTNode root) {
		Queue<BSTNode> queue = new LinkedList<BSTNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			if (queue.peek().getLeft() != null)
				queue.add(queue.peek().getLeft());
			if (queue.peek().getRight() != null){
				queue.add(queue.peek().getRight());
				if (queue.peek().getLeft() != null)
				queue.peek().getLeft().setNextRight(queue.peek().getRight());
			}
			System.out.print(queue.poll().getData() + " : ");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


/*public*/ class PopulateRightNeighbors 
{
    private class TreeNode
    {
        TreeNode left;
        TreeNode right;
        TreeNode neighbor;
        int value;
     
        public TreeNode(int value)
        {
            this.value = value;
        }
    }
     
    TreeNode root;
 
    /*
                            0
                      1             2
                  3              5     6
                                      7   8
    */
    public TreeNode createTree()
    {
        this.root = new TreeNode(0);
         
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
          
        root.left  = n1;
        root.right = n2;
          
        n1.left = n3;
          
        n2.left = n5;
        n2.right = n6;
          
        n6.left = n7;
        n6.right = n8;
          
        return root;
    }
 
     
    private void populateNeighbors(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
 
        // populate the right neighbor for left child
        if (root.left != null)
        {
            if (root.right != null)
            {
                root.left.neighbor = root.right;
            }
            // find first non-null node after left child at its level
            else
            {
                TreeNode parentNeighbor = root.neighbor;
                TreeNode neighborNode;
                while (parentNeighbor != null)
                {
                    neighborNode = (parentNeighbor.left != null)? parentNeighbor.left : parentNeighbor.right;
                     
                    // we have found the non-null neighbor for left child 
                    if (neighborNode != null)
                    {
                        root.left.neighbor = neighborNode;
                        break;
                    }
                     
                    parentNeighbor = parentNeighbor.neighbor;
                }
            }
        }
         
        // populate the right neighbor for right child
        if (root.right != null)
        {
            // find first non-null node after right child at its level
            TreeNode parentNeighbor = root.neighbor;
            TreeNode neighborNode;
             
            while (parentNeighbor != null)
            {
                neighborNode = (parentNeighbor.left != null)? parentNeighbor.left : parentNeighbor.right;
                 
                // we have found the non-null neighbor for right child 
                if (neighborNode != null)
                {
                    root.right.neighbor = neighborNode;
                    break;
                }
                 
                parentNeighbor = parentNeighbor.neighbor;
            }
        }
         
        /* 
          Populating neighbors in the right sub-tree before that of left sub-tree
          allows us to access all nodes at the level of current node using neighbor-node chain 
          while populating neighbors for current node's child nodes. 
        */
         
        // populate neighbors in the right sub-tree first
        populateNeighbors(root.right);
      
        // and then populate neighbors in the left sub-tree
        populateNeighbors(root.left);
    }
     
     
    private void traverseUsingNeighbors(TreeNode root)
    {
        TreeNode currentNode = root;
        while (currentNode != null)
        {
            TreeNode temp = currentNode;
            currentNode = null;
             
            // print all the nodes in the current level
            while(temp != null)
            {
                // keep checking for the left-most node in the level below the current level
                // that is where traversal for next level is going to start
                if (currentNode == null)
                {
                    currentNode = (temp.left != null) ? temp.left : temp.right;
                }
                 
                System.out.print(temp.value + " ");
                temp = temp.neighbor;
            }
            System.out.print("\n\n");
        }
    }
 
    public void populateNeighbors()
    {
        populateNeighbors(root);
    }
     
    public void traverseUsingNeighbors()
    {
        traverseUsingNeighbors(root);
    }
     
     
    public static void main(String[] args)
    {
        PopulateRightNeighbors tree = new PopulateRightNeighbors();
 
        /*
                                0
                          1             2
                      3              5     6
                                          7  8
        */
        tree.createTree();
 
        tree.populateNeighbors();
 
        tree.traverseUsingNeighbors();
    }
}
