package jianzhioffer;

import algorithm.TreeNode;

public class T27 {
     private static TreeNode head=null;
     private static TreeNode tail=null;
     public static TreeNode convert(TreeNode root){
    	 visit(root);
    	 return head;
     }
     
     private static void visit(TreeNode root){
    	 if(root==null) return;
    	 visit(root.left);
    	 doConnect(root);
    	 visit(root.right);
     }
     
     private static void doConnect(TreeNode cur){
    	 cur.left=tail;
    	 if(tail!=null) tail.right=cur;
    	 else head=cur;
    	 tail=cur;
     }
     
     public static void main(String[] args){
    	 T27 t=new T27();
    	 TreeNode root=new TreeNode(5);
    	 TreeNode node1=new TreeNode(1);
    	 TreeNode node2=new TreeNode(3);
    	 TreeNode node3=new TreeNode(4);
    	 TreeNode node4=new TreeNode(7);
    	 TreeNode node5=new TreeNode(8);
    	 root.left=node2;
    	 root.right=node4;
    	 node2.left=node1;
    	 node2.right=node3;
    	 node4.right=node5;
    	 t.convert(root);
    	 TreeNode dummy=head;
    	 while(dummy!=null){
    		 System.out.print(dummy.val+" ");
    		 dummy=dummy.right;
    	 }
     }
}
