package algorithm;

import algorithm.ConvertSortedArraytoBinarySearchTree108.TreeNode;

public class CountCompleteTreeNodes222 {
	 public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 //这种方法超时
  /* public int countNodes(TreeNode root) {
	    if(root==null)  return 0;
        int d=deep(root);
       // Integer c=new Integer(0);
        int[] c={0};
        travese(1,root,d,c);
        int result=(1<<(d-1))-1+c[0];
        return result;
    }
   public void travese(int position,TreeNode root,int deep,int[] c){
	     if(root.left==null&&root.right==null){
	    	 if(position!=deep) return ;
	    	 else{
	    	          c[0]++;
	    	 }
	     }
	     if(root.left!=null) travese(position+1,root.left,deep,c);
	     if(root.right!=null) travese(position+1,root.right,deep,c);
   }
   public int deep(TreeNode root){
	   int count=0;
	   while(root!=null){
		   root=root.left;
		   count++;
	   }
	   return count;
   }*/
   //AC 78ms  用二分查找+递归的思想  把一个大问题变成小问题   递归的时候分析最小子问题确定递归的结束条件 
	 public int countNodes(TreeNode root) {
		 if(root==null)  return 0;
		  int rootd=deepleft(root);
		   return (1<<(rootd-1))-1+countNodes(root,1,rootd);
	 }
	 public int countNodes(TreeNode root,int position,int rootd){
		 if(root==null)  return 0;
		 if(root.left==null){
			 if(rootd==position) return 1;
			 else return 0;
		 }else{
			 if(position+deepright(root.left)==rootd){
				int r= 1<<(rootd-position-1);
				return r+countNodes(root.right,position+1,rootd);
			 }else{
			    return countNodes(root.left,position+1,rootd);
			 }
				 
		 }
	 }
	 
	  public int deepleft(TreeNode root){
		   int count=0;
		   while(root!=null){
			   root=root.left;
			   count++;
		   }
		   return count;
	   }
	  public int deepright(TreeNode root){
		   int count=0;
		   while(root!=null){
			   root=root.right;
			   count++;
		   }
		   return count;
	   }
   
   public static void main(String[] args){
	   TreeNode root=new TreeNode(1);
	   TreeNode node1=new TreeNode(2);
	   TreeNode node2=new TreeNode(3);
	   TreeNode node3=new TreeNode(4);
       root.left=node1;
       root.right=node2;
       node1.left=node3;
       CountCompleteTreeNodes222 c=new CountCompleteTreeNodes222();
       int r=c.countNodes(root);
       System.out.println("r="+r);
   }
}
