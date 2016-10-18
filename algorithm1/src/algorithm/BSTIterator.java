package algorithm;

import java.util.Stack;

public class BSTIterator {
	Stack<TreeNode> s=new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
       while(root!=null){
           s.push(root);
           root=root.left;
       }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
         TreeNode curNode=s.pop();
         if(curNode.right!=null){
             TreeNode r=curNode.right;
             while(r!=null){
                 s.push(r);
                 r=r.left;
             }
         }
         return curNode.val;
    }
    
    public static void main(String[] args){
    	TreeNode root=new TreeNode(1);
    	TreeNode node1=new TreeNode(2);
    	TreeNode node2=new TreeNode(3);
    	root.left=node1;
    	root.right=node2;
    	BSTIterator b=new BSTIterator(root);
        System.out.println(b.hasNext());
    	while(b.hasNext()){
    		System.out.println(b.next()+",");
    	}
    	
    }
}
