package jianzhioffer;

import algorithm.TreeNode;

/**
 *  二叉树的镜像
 * @author sy
 *
 */
public class T19 {
    public void mirro(TreeNode head){
    	if(head==null) return;
    	if(head.left==null&&head.right==null) return ;
    	//交换左右节点
    	TreeNode temp=head.left;
    	head.left=head.right;
        head.right=temp;
        if(head.left!=null) mirro(head.left);
        if(head.right!=null) mirro(head.right);
    }
    
    
}
