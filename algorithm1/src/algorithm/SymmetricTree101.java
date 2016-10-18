package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree101 {
	 //非递归  树的层次遍历  每层的所有节点构成回文
	  /*public boolean isSymmetric(TreeNode root) {
		  if(root==null) return true;
	        Queue<TreeNode> q=new LinkedList<TreeNode>();
	        q.offer(root);
	        int count=1,index=0,lastCount=0;
	        List<String> temp=new ArrayList<String>();
	        while(!q.isEmpty()){
	        while(index<count){
	           TreeNode cur=q.poll();
	           index++;
	           if(cur.left!=null){
	        	   lastCount++;
	        	   q.offer(cur.left);
	        	   temp.add(cur.left.val+"");
	           }else temp.add("#");
	           if(cur.right!=null){
	        	   lastCount++;
	        	   q.offer(cur.right);
	        	   temp.add(cur.right.val+"");
	           }else temp.add("#");
	          
	         }
	         if(!isPlalidrome(temp)) return false;
	         index=0;
	         count=lastCount;
	         lastCount=0;
	         temp.clear();
	        }
	        return true;
	    }
	  private boolean isPlalidrome(List<String> r){
	          int left=0,right=r.size()-1;
	          while(left<right){
	              if(!r.get(left).trim().equals(r.get(right).trim())) 
	            	  return false;
	              left++;
	              right--;
	          }
	          return true;
	    }
	  */
	public boolean isSymmetric(TreeNode root) {
		if(root==null) return true;
		return isSimilar(root.left,root.right);
	}
	
	private boolean isSimilar(TreeNode left,TreeNode right){
	    if(left==null&&right==null) return true;
	    else if(left==null||right==null) return false;
	    else{
	    	if(left.val!=right.val) return false;
	    	else{
	    	    return isSimilar(left.left,right.right)&&isSimilar(left.right,right.left);
	    	}
	    }
	        
	    
	}
	
	    public static void main(String[] args){
	    	SymmetricTree101 s=new SymmetricTree101();
	    	TreeNode node1=new TreeNode(1);
	    	TreeNode node2=new TreeNode(2);
	    	TreeNode node3=new TreeNode(2);
	    	TreeNode node4=new TreeNode(3);
	    	TreeNode node5=new TreeNode(2);
	    	node1.left=node2;
	    	node1.right=node3;
	    	/*node2.left=node4;
	    	node3.left=node5;*/
	    	boolean r=s.isSymmetric(node1);
	    	System.out.println("r="+r);
	    }
}
