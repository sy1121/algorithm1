package algorithm;

import java.util.ArrayList;
import java.util.List;

import algorithm.BinaryTreeLevelOrderTraversal102.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal106 {
	 public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	 
	 //AC  19ms  对于这种树的题目 考虑用递归的思想  ，这题要注意左右子树在两种遍历数组的位置
	 //这题用拷贝数组的方式  这样就可以不用考虑坐标的变化
	/*   public TreeNode buildTree(int[] inorder, int[] postorder) {
	    	 if(inorder==null||inorder.length==0)  return null;
	           return buildTreeHelp(inorder,postorder,0,inorder.length-1,0,postorder.length -1);
	    }
	    
	    public TreeNode buildTreeHelp(int[] inorder,int[] postorder,int instart,int inend,int poststart,int postend){
	          if(instart>inend||poststart>postend) return null;
	    	  int val=postorder[postend];
	          int index=0;
	          for(int i=instart;i<=inend;i++){
	        	  if(inorder[i]==val){
	        		  index=i;break;
	        	  }
	          }
	          TreeNode root=new TreeNode(val);
	          root.left=buildTreeHelp(inorder,postorder,instart,index-1,poststart,poststart+index-instart-1);
	          root.right=buildTreeHelp(inorder,postorder,index+1,inend,poststart+index-instart,postend-1);
	          return root;
	    }*/
	 
	 //复制数组的方法  时间较长  AC  68ms
	 public TreeNode buildTree(int[] inorder, int[] postorder) {
		 if(inorder==null||inorder.length==0)  return null;
		 int val=postorder[postorder.length-1];
		 int index=0;
		 for(int i=0;i<inorder.length;i++){
			 if(val==inorder[i]){
				 index=i;break;
			 }	 
		 }
		 TreeNode root=new TreeNode(val);
		 int[] leftinorder=new int[index];
		 int[] leftpostorder=new int[index];
		 int[] rightinorder=new int[inorder.length -index-1];
		 int[] rightpostorder=new int[inorder.length -index-1];
		 int li=0,lp=0,ri=0,rp=0;
		 for(int i=0;i<inorder.length;i++){
			 if(i<index) {
				 leftinorder[li++]=inorder[i];
			 }else if(i>index){
				 rightinorder[ri++]=inorder[i];
			 }
		 }
		 for(int i=0;i<postorder.length-1;i++){
			 if(i<index)
				 leftpostorder[lp++]=postorder[i];
			 else
				 rightpostorder[rp++]=postorder[i];
		 }
		 root.left=buildTree(leftinorder,leftpostorder);
		 root.right=buildTree(rightinorder,rightpostorder);
		 return root;
	 }
	    public static void main(String[] args){
	    	ConstructBinaryTreefromInorderandPostorderTraversal106 b=new ConstructBinaryTreefromInorderandPostorderTraversal106();
	  	    TreeNode root=b.buildTree(new int[]{1,2,3,4,5,6}, new int[]{5,4,6,3,2,1});
	  	    travese(root);
	    }
	    
	    public static  void travese(TreeNode root){
	    	if(root==null){
	    		System.out.print("null,");return;
	    	}else{
	    		System.out.print(root.val+",");
	    		travese(root.left);
	    		travese(root.right);
	    	}
	    }
}
