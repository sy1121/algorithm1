package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class LowestCommonAncestorofaBinaryTree236 {
	//

	//有一个测试例过不了
/*	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		 if(root==null||p==null||q==null) return null;
		 List<Stack<TreeNode>> rplist=travese(root,p);
		 List<Stack<TreeNode>> rqlist=travese(root,q);
		 int count=0,mincount=Integer.MAX_VALUE;
		 Stack<TreeNode> rq,rp;
		 TreeNode result=null;
		 for(int i=0;i<rplist.size();i++){
			 rp=(Stack<TreeNode>)rplist.get(i).clone();
			 for(int j=0;j<rqlist.size();j++){
				 rq=(Stack<TreeNode>)rqlist.get(j).clone();
				 count=0;
				 int diff=Math.abs(rq.size()-rp.size());
				 if(rq.size()>rp.size()){
				     while(diff>0){
				     	 rq.pop();
				     	 diff--;
				     }
				 }else{
					 while(diff>0){
						 rp.pop();
						 diff--;
					 } 
				 }
				 
				 while(rq.peek()!=rp.peek()){
					 count++;
					 rp.pop();rq.pop();
		    	 } 
				 if(count<mincount){
					 result=rp.peek();
				 } 
			 }
		 }
		 
		 return result;
	}
	
	public List<Stack<TreeNode>> travese(TreeNode root, TreeNode target){
		   Stack<TreeNode> s=new Stack<TreeNode>();
		   List<Stack<TreeNode>> rlist=new ArrayList<Stack<TreeNode>>();
		   Stack<TreeNode> r=new Stack<TreeNode>();
		   HashSet<TreeNode> set=new HashSet<TreeNode>();
		   TreeNode frontNode;
		   if(target==null||root==null) return rlist;
		   s.push(root);
		   while(!s.isEmpty()){
			   TreeNode curNode=s.pop();
			   r.push(curNode);
			   set.add(curNode);
			   if(curNode.val==target.val){   
				   Stack<TreeNode> temp=(Stack<TreeNode>)r.clone();
				   rlist.add(temp);
				   //return r;
			   }
			   while((!r.isEmpty())&&(frontNode=r.peek())!=null){
				    if((frontNode.left==null||set.contains(frontNode.left))
				    		&&(frontNode.right==null||set.contains(frontNode.right))){
				    	r.pop();
				    }else{
				    	break;
				    }
			   }
			   if(curNode.right!=null) s.push(curNode.right);
			   if(curNode.left!=null) s.push(curNode.left);
		   }
		   return rlist;
	}*/
	//别人的方法  太屌了 好好学习 理解递归的思想
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==p) return root;
        if(root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left!=null&&right!=null){
            return root;
        }else{
            return left==null?right:left;
        }
    }
    
	public  static void main(String[] args){
		LowestCommonAncestorofaBinaryTree236 l=new LowestCommonAncestorofaBinaryTree236();
		TreeNode root=new TreeNode(37);
		TreeNode node2=new TreeNode(-34);
		TreeNode node3=new TreeNode(-48);
		TreeNode node4=new TreeNode(-100);
		TreeNode node5=new TreeNode(-100);
		TreeNode node6=new TreeNode(48);
		TreeNode node7=new TreeNode(-54);
		TreeNode node8=new TreeNode(-71);
		TreeNode node9=new TreeNode(-22);
		TreeNode node10=new TreeNode(8);
		root.left=node2;
		root.right=node3;
		node2.right=node4;
		node3.left=node5;
		node3.right=node6;
		node6.left=node7;
		node7.left=node8;
		node7.right=node9;
		node9.right=node10;
		TreeNode r=l.lowestCommonAncestor(root,new TreeNode(-100),new TreeNode(-71));
		System.out.println("result="+r.val);
	}
	
	
	
}
