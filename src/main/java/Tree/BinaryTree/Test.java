/**
 * 
 */
package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author vinod<vinod.pal@nanobi.in(EmpId:1112)
 * @organization NanoBi Analytics
 */
public class Test {
	
     public static void main(String[] args) {
    	/* Scanner in =new Scanner(System.in);
    	 System.out.println("Enetr no of string");
		 int n = in.nextInt();
		 */
/*		 Object o = new Object()  Line 5 
			        {
			            public boolean equals(Object obj) 
			            {
			                return true;
			            } 
			        }  ;     Line 11 
			        
			        System.out.println(o.equals("Fred"));*/
    	 
    	//System.out.println( getpretopost("+34"));
    	System.out.println( getInOrderToPreOrder("3*4+5"));

	}	
    class t2{
    	public void foo(){
    		System.out.println("foo");
    	}
    }

	static String getInOrderToPreOrder(String num) {
		char[] chars = num.toCharArray();
		ArrayList<Character> op = new ArrayList<Character>();
		op.add('/');
		op.add('*');
		op.add('+');
		op.add('-');
		Stack<Character> stack = new Stack<>();
		StringBuffer result = new StringBuffer("");
		for (char c : chars) {
			if (op.contains(c)) {
				result.insert(result.length()-1, c);
			} else {
				result.append(c);
			}
		}
		return result.toString();
	}
	
	
    static String getPreOrderToPostOrder(String num){
    	char[] chars = num.toCharArray();
    	ArrayList<Character> op = new ArrayList<Character>();
    	op.add('-');op.add('+');op.add('/');op.add('*');
    	Stack<Character> stack = new Stack<>();
    	StringBuffer result = new StringBuffer("");
    	for(char aC: chars){
    		if(op.contains(aC)){
    			stack.push(aC);
    		}else{
    			result.append(String.valueOf(aC));
    			while(!stack.isEmpty() && stack.peek()=='l'){
    				stack.pop();
    				result.append(String.valueOf(stack.pop()));
    			}
    			stack.push('l');
    		}
    	}
    	return result.toString();
    }
}



