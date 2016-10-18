package algorithm;

import java.util.HashSet;
import java.util.Stack;

public class KthSmallestElementinaBST230 {
	  public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	  //AC 5ms
	public int kthSmallest(TreeNode root, int k) {
	        return midTravese(root,k);
	    }
	
	public int midTravese(TreeNode root,int k){
		   if(root==null) return 0;
		   int count=0;
		   Stack<TreeNode> s=new Stack<TreeNode>();
		   HashSet<TreeNode> set=new HashSet<TreeNode>();
		   s.push(root);
		  while(!s.isEmpty()){
			  TreeNode tNode=s.peek();
			   if(tNode.left==null||set.contains(tNode.left)){
				  TreeNode markNode=s.pop();
				  set.add(markNode);
				  if(markNode.right!=null)  s.push(markNode.right);
				  count++;
				  if(count==k) return markNode.val;
			  }else{
				  s.push(tNode.left);
				  tNode=tNode.left;
			  }
		  }
		   
		  return 0;
	}


}
