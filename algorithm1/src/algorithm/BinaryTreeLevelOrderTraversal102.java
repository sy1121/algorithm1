package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algorithm.BinaryTreeInorderTraversal94.TreeNode;

public class BinaryTreeLevelOrderTraversal102 {
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
  public List<List<Integer>> levelOrder(TreeNode root) {
      Queue<TreeNode> q=new LinkedList<TreeNode>();
      List<List<Integer>>  rLists=new ArrayList<List<Integer>>();
      if(root==null)  return rLists;
      q.offer(root);
      int count=1,childCount=0;
      while(!q.isEmpty()){
    	  List<Integer> rlist=new ArrayList<Integer>();
    	  while(count>0){
    	  TreeNode currentNode=q.poll();
    	  rlist.add(currentNode.val);
    	  count--;
    	  if(currentNode.left!=null) {
    		  q.offer(currentNode.left);
    		  childCount++;
    	  }
    	  if(currentNode.right!=null) {
    		  q.offer(currentNode.right);
    		  childCount++;
    	  }
    	  }
    	 rLists.add(rlist);
    	 count=childCount;
    	 childCount=0;
      }
      
      return rLists;
    }
  
  public static void main(String[] args){
	  BinaryTreeLevelOrderTraversal102 b=new BinaryTreeLevelOrderTraversal102();
	  List<List<Integer>> r=new ArrayList<List<Integer>>();
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
	  r=b.levelOrder(root);
	  System.out.println("r="+r.toString());
  }
}
