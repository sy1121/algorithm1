package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeLevelOrderTraversalII107 {
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  //别人的好方法
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
           List<List<Integer>> rLists=new ArrayList<List<Integer>>();
           if(root==null) return rLists;
           travese(root,rLists,0);
           Collections.reverse(rLists);
           return rLists;
	    }
	
	public void travese(TreeNode root, List<List<Integer>> rLists,int level){
		  if(root==null) return;
		  else{
			  if(rLists.size()<level+1){
				  rLists.add(new ArrayList<Integer>());
			  }
			  rLists.get(level).add(root.val);
			  travese(root.left,rLists,level+1);
			  travese(root.right,rLists,level+1);
		  }
	}
}
