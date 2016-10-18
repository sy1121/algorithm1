package jianzhioffer;

import algorithm.TreeNode;

public class T39 {
     public int depthOfTree(TreeNode head){
           if(head==null) return 0;
           int left=depthOfTree(head.left);
           int right=depthOfTree(head.right);
           return Math.max(left, right)+1;
     }
     
     public static void main(String[] args){
    	 T39 t=new T39();
    	 TreeNode head=new TreeNode(1);
    	 TreeNode node1=new TreeNode(2);
    	 TreeNode node2=new TreeNode(3);
    	 TreeNode node3=new TreeNode(4);
    	 head.left=node1;
    	 head.right=node2;
    	 node1.left=node3;
    	 int r=t.depthOfTree(head);
    	 System.out.println(r);
     }
}
