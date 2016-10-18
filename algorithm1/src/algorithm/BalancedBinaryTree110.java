package algorithm;

import java.util.Stack;

public class BalancedBinaryTree110 {
	  public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	  //AC 2ms
	/* public boolean isBalanced(TreeNode root) {
	      if(root==null) return true;
	      else{
	    	 int leftDepth=depth(root.left);
	    	 int rightDepth=depth(root.right);
		     if(Math.abs(leftDepth-rightDepth)>1)
		    		 return false;
		     else{
			    return  isBalanced(root.left)&&isBalanced(root.right);
		     }
	      }
	    }
	 
	 public int depth(TreeNode root){
		 if(root==null) return 0;
		 else{
			 int leftDepth=depth(root.left);
			 int rightDepth=depth(root.right);
			 if(leftDepth>rightDepth)
					 return leftDepth+1;
			 else
				 return rightDepth+1;
		 }
	 }*/
	  
	  //AC 17ms  用HashMap存储节点深度，减少重复计算，为什么时间还更长？
	 /* public boolean isBalanced(TreeNode root) {
		  HashMap<TreeNode,Integer> list=new HashMap<TreeNode,Integer>();
		  depth(root,list);
	      if(root==null) 
	    	  return true;
	      else{
	    	 int leftDepth=list.get(root.left);
	    	 int rightDepth=list.get(root.right);
		     if(Math.abs(leftDepth-rightDepth)>1)
		    		 return false;
		     else{
			    return  isBalanced(root.left)&&isBalanced(root.right);
		     }
	      }
	    }
	 
	 public int depth(TreeNode root,HashMap<TreeNode,Integer> list){
		 if(root==null){
			 list.put(root, 0);
			 return 0;
		 }
		 else{
			 int leftDepth=depth(root.left,list);
			 int rightDepth=depth(root.right,list);
			 if(leftDepth>rightDepth){
				 list.put(root, leftDepth+1);
				 return leftDepth+1;
			 }
			 else{
				 list.put(root, rightDepth+1);
				 return rightDepth+1;
			 }
		 }
	 }*/
	  
	  public boolean isBalanced(TreeNode root) {
		  if(root==null)  return true;
		  Stack<TreeNode> s=new Stack<TreeNode>();
		  s.push(root);
	      while(!s.isEmpty()){
	    	  TreeNode temp=s.pop();
	    	 int leftDepth=depth(temp.left);
	    	 int rightDepth=depth(temp.right);
		     if(Math.abs(leftDepth-rightDepth)>1)
		    		 return false;
		     if(temp.left!=null)
		       s.push(temp.left);
		     if(temp.right!=null)
		       s.push(temp.right);
	      }
	      return true;
	    }
	 
	 public int depth(TreeNode root){
		 if(root==null) return 0;
		 else{
			 int leftDepth=depth(root.left);
			 int rightDepth=depth(root.right);
			 if(leftDepth>rightDepth)
					 return leftDepth+1;
			 else
				 return rightDepth+1;
		 }
	 }
	 
	 public static void main(String[] args){
		 BalancedBinaryTree110 b=new BalancedBinaryTree110();
		 TreeNode root=b.new TreeNode(1);
		 TreeNode node1=b.new TreeNode(2);
		 TreeNode node2=b.new TreeNode(3);
		 TreeNode node3=b.new TreeNode(3);
		 TreeNode node4=b.new TreeNode(2);
		 TreeNode node5=b.new TreeNode(4);
		 TreeNode node6=b.new TreeNode(4);
		 TreeNode node7=b.new TreeNode(1);
		// root.left=node1;
		 root.right=node2;
		// node1.left=node3;
		 node2.left=node4;
		 //node3.left=node5;
		 //node4.right=node6;
		 boolean r= b.isBalanced(root);
		 System.out.println("result="+r);
	 }
}
