package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal94 {
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	  //AC  2ms
  public List<Integer> inorderTraversal(TreeNode root) {
	  Stack<TreeNode> s=new Stack<TreeNode>();
	  List<Integer> rlist=new ArrayList<Integer>();
	  if(root==null) return rlist;
	  s.push(root);
	  while(!s.isEmpty()){
		  TreeNode topNode=s.peek();
		  if(topNode!=null&&topNode.left!=null){
			  s.push(topNode.left);
			  topNode.left=null;     //将左子节点设为null，表示已经处理过了
		  }else if(topNode!=null&&topNode.left==null){
			  rlist.add(topNode.val);
			  s.pop();
			  if(topNode.right!=null){
				  s.push(topNode.right);
			  }
		  }else{
			 break;
		  }
	  }
	   return rlist; 
    }
  
  
  public static void main(String[] args){
	  BinaryTreeInorderTraversal94 b=new BinaryTreeInorderTraversal94();
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
	  r=b.inorderTraversal(root);
	  System.out.println("r="+r.toString());
  }
}
