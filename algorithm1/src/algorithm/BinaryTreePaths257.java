package algorithm;

import java.util.ArrayList;
import java.util.List;

import algorithm.BinaryTreeLevelOrderTraversal102.TreeNode;

public class BinaryTreePaths257 {
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
	  //AC 3ms
  public List<String> binaryTreePaths(TreeNode root) {
          List<String> rlist=new ArrayList<String>();
          List<TreeNode> nodeList=new ArrayList<TreeNode>();
          travese(root,nodeList,rlist);
          return rlist;
    }
  
   public void travese(TreeNode root,List<TreeNode> nodeList,List<String> rlist){
	  if(root==null)  return ;
	   if(root.left==null&&root.right==null){  //如果当前节点是叶子节点，就打印路径
		   StringBuilder tempStr=new StringBuilder("");   //拼接路径 
		   for(int i=0;i<nodeList.size();i++){    //遍历当前节点列表
			   tempStr.append(nodeList.get(i).val+"->");
		   }
		   tempStr.append(root.val);   //加上该叶子节点
		   rlist.add(tempStr.toString());   //将路径添加到路径列表中
	   }else{
		   nodeList.add(root);    //如果不是叶子节点,就把当前节点加到节点列表中
	   }
	   if(root.left!=null) travese(root.left,nodeList,rlist);  //递归遍历左右子树
	   if(root.right!=null) travese(root.right,nodeList,rlist);
	   nodeList.remove(root);  //左右子节点都处理完后，从节点列表中删除当前节点
   }
  
   public static void main(String[] args){
	   BinaryTreePaths257 b=new BinaryTreePaths257();
		  List<String> r=new ArrayList<String>();
		  TreeNode root=new TreeNode(7);
		  TreeNode node1=new TreeNode(1);
		  TreeNode node2=new TreeNode(2);
		  TreeNode node3=new TreeNode(3);
		  TreeNode node4=new TreeNode(4);
		  TreeNode node5=new TreeNode(5);
		  TreeNode node6=new TreeNode(6);
		  root.left=node1;
		  root.right=node2;
		  node1.right=node3;
		  node2.left=node4;
		  node3.left=node5;
		  node5.right=node6;
		  r=b.binaryTreePaths(root);
		  System.out.println("r="+r.toString());
	  }
}
