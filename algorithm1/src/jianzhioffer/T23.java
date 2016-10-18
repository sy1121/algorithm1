package jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

import algorithm.TreeNode;

/**
 * 从上到下打印二叉树
 * @author sy
 *
 */
public class T23 {
   public void printTree(TreeNode head){
	    if(head==null) return ;
	    Queue<TreeNode> q=new LinkedList<TreeNode>();
	    q.add(head);
	    while(!q.isEmpty()){
	    	TreeNode cur=q.poll();
	    	System.out.print(cur.val);
	    	if(cur.left!=null) q.offer(cur.left);
	    	if(cur.right!=null) q.offer(cur.right);
	    }
	    
   }
}
