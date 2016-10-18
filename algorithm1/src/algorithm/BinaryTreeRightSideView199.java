package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algorithm.BinaryTreePreorderTraversal144.TreeNode;

public class BinaryTreeRightSideView199 {
	 public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	//AC 2ms    类似树的层次遍历  每一层都是从右往左遍历  把左边的值记下来    
   public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rlist=new ArrayList<Integer>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        if(root==null)  return rlist;
        int count=1,childCount=0;
        boolean first=true;  //是否是某一层的最右边的元素
        q.offer(root);
        while(!q.isEmpty()){
        	while(count>0){
        	TreeNode curNode=q.poll();
        	if(first){   
        	rlist.add(curNode.val);   //记下每层最右边的元素
        	first=false;
        	}
        	count--;
        	if(curNode.right!=null) {q.offer(curNode.right);childCount++;}
        	if(curNode.left!=null) { q.offer(curNode.left);childCount++;}
        	}
            first=true;
            count=childCount;
            childCount=0;
        }
        
        return rlist;
    }
   
   public static void main(String[] args){
	   BinaryTreeRightSideView199 b=new BinaryTreeRightSideView199();
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
			  r=b.rightSideView(root);
			  System.out.println("r="+r.toString());
		  }
	 
}
