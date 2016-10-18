package jianzhioffer;

import algorithm.TreeNode;

/**
 * 根据前序和中序构造二叉树
 * @author sy
 *
 */
public class T6 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0) return null;
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
  }
  
  private TreeNode helper(int[] preorder,int pleft,int pright,int[] inorder,int ileft,int iright){
         if(pleft>pright||ileft>iright) return null;
         int index=findIndex(preorder[pleft],inorder,ileft,iright);
         TreeNode root=new TreeNode(preorder[pleft]);
         root.left=helper(preorder,pleft+1,pleft+index,inorder,ileft,ileft+index-1);
         root.right=helper(preorder,pleft+index+1,pright,inorder,ileft+index+1,iright);
         return root;
  }
  
  private int findIndex(int target,int[] inorder,int ileft,int iright){
       int count=0;
       for(int i=ileft;i<=iright;i++){
           if(inorder[i]==target)
               break;
            count++;
       }
       return count;
  }
}
