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
	   if(root.left==null&&root.right==null){  //�����ǰ�ڵ���Ҷ�ӽڵ㣬�ʹ�ӡ·��
		   StringBuilder tempStr=new StringBuilder("");   //ƴ��·�� 
		   for(int i=0;i<nodeList.size();i++){    //������ǰ�ڵ��б�
			   tempStr.append(nodeList.get(i).val+"->");
		   }
		   tempStr.append(root.val);   //���ϸ�Ҷ�ӽڵ�
		   rlist.add(tempStr.toString());   //��·����ӵ�·���б���
	   }else{
		   nodeList.add(root);    //�������Ҷ�ӽڵ�,�Ͱѵ�ǰ�ڵ�ӵ��ڵ��б���
	   }
	   if(root.left!=null) travese(root.left,nodeList,rlist);  //�ݹ������������
	   if(root.right!=null) travese(root.right,nodeList,rlist);
	   nodeList.remove(root);  //�����ӽڵ㶼������󣬴ӽڵ��б���ɾ����ǰ�ڵ�
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
