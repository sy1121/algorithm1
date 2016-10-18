package algorithm;

import java.util.ArrayList;
import java.util.List;

public class SumRoottoLeafNumbers129 {
	//AC 3ms
	  public int sumNumbers(TreeNode root) {
	        if(root==null) return 0;
	  //      return Integer.parseInt(sumNum(root));
	        List<List<Integer>> list=sumNum(root);
	        int result=0;
	        for(int i=0;i<list.size();i++){
	        	int part=0;
	        	for(int j=list.get(i).size()-1;j>=0;j--){
	        		part=part*10+list.get(i).get(j);
	        	}
	        	result+=part;
	        }
	        return result;
	    }
	    
	  private List<List<Integer>> sumNum(TreeNode root){
		  if(root==null) return null;
		  List<List<Integer>> lists=new ArrayList<List<Integer>>();
		  if(root.left==null&&root.right==null){
			  List<Integer> list=new ArrayList<Integer>();
			  list.add(root.val);
			  lists.add(list);
		  }else if(root.left!=null||root.right!=null){
			  List<List<Integer>> left=sumNum(root.left);
		      List<List<Integer>> right=sumNum(root.right);
		      if(left!=null){
		    	  for(int i=0;i<left.size();i++){
		    		  left.get(i).add(root.val);
		    		  lists.add(left.get(i));
		    	  }
		      }
		      if(right!=null){
		    	  for(int i=0;i<right.size();i++){
		    		  right.get(i).add(root.val);
		    		  lists.add(right.get(i));
		    	  }
		      }
		  }
		  return lists;
	  }
	  
	  //网上的简单解法
	/*  public int sumNumbers(TreeNode root) {
	        if (root == null) {
	            return 0;
	        }
	        return sum(root, 0);
	    }
	    private int sum(TreeNode root, int sum) {
	        if (root == null) {
	            return 0;
	        }
	        if (root.left == null && root.right == null) {
	            return sum + root.val;
	        }
	        return sum(root.right, (sum + root.val) * 10) + sum(root.left, (sum + root.val) * 10);
	    }
*/
	    public static void main(String[] args){
	    	SumRoottoLeafNumbers129 s=new SumRoottoLeafNumbers129();
	    	TreeNode node1=new TreeNode(8);
	    	TreeNode node2=new TreeNode(3);
	    	TreeNode node3=new TreeNode(5);
	    	TreeNode node4=new TreeNode(9);
	    	TreeNode node5=new TreeNode(9);
	    	TreeNode node6=new TreeNode(5);
	    	node1.left=node2;
	    	node1.right=node3;
	    	node2.left=node4;
	    	node4.left=node5;
	    	node4.right=node6;
	    	int result=s.sumNumbers(node1);
	    System.out.println("result="+result);
	    }
}
