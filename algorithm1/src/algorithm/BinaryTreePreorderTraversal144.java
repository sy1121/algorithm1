package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import algorithm.BinaryTreePaths257.TreeNode;

public class BinaryTreePreorderTraversal144 {
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  //AC 2ms
	 public List<Integer> preorderTraversal(TreeNode root) {
	        List<Integer> rlist=new ArrayList<Integer>();
	        Stack<TreeNode> s=new Stack<TreeNode>();
	        if(root==null) return rlist;
	        s.push(root);
	        while(!s.isEmpty()){
	        	TreeNode curNode=s.pop();
	        	rlist.add(curNode.val);
	        	if(curNode.right!=null) s.push(curNode.right);
	        	if(curNode.left!=null) s.push(curNode.left);
	        }
	        return rlist;
	    }
	 public static void main(String[] args){
		 BinaryTreePreorderTraversal144 b=new BinaryTreePreorderTraversal144();
			  List<Integer> r=new ArrayList<Integer>();
			  TreeNode root=new TreeNode(7);
			  TreeNode node1=new TreeNode(1);
			  TreeNode node2=new TreeNode(2);
			  TreeNode node3=new TreeNode(3);
			  TreeNode node4=new TreeNode(4);
			  TreeNode node5=new TreeNode(5);
			  TreeNode node6=new TreeNode(6);
			  root.left=node1;
			  root.right=node2;
			  node1.right=node3;
			  node2.left=node4;
			  node3.left=node5;
			  node5.right=node6;
			  r=b.preorderTraversal(root);
			  System.out.println("r="+r.toString());
		  }
	 
}
