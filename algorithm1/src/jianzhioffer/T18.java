package jianzhioffer;

import algorithm.TreeNode;

/**
 * 树的子结构
 * @author sy
 *
 */
public class T18 {
     public boolean hasSubtree(TreeNode root1,TreeNode root2){
    	 boolean result=false;
    	 if(root1!=null&&root2!=null){
    		 if(root1.val==root2.val)
    			 result=haveTree2(root1,root2);
    		 if(!result)
    			 result=hasSubtree(root1.left,root2);
    		 if(!result)
    			 result=hasSubtree(root1.right,root2);
    	 }
    	 return result;
     }
     
     private  boolean haveTree2(TreeNode root1,TreeNode root2){
    	  if(root2==null) return true;
    	  if(root1==null) return false;
    	  if(root1.val!=root2.val) return false;
    	  return  haveTree2(root1.left,root2.left)&&haveTree2(root1.right,root2.right);
     }
}
