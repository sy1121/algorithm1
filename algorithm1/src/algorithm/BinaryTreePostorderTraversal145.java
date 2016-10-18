package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import algorithm.BinaryTreePaths257.TreeNode;

public class BinaryTreePostorderTraversal145 {
	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	  
	  //AC  2ms
	  /**
	   * ���ı���ǵݹ�д�����и���������Ĺؼ���ȷ�����ʵ�ǰ�ڵ㣨��ǰ��ڵ㣩��ʱ��
	   * �����и����ʱ��ֻ�е�ǰ�ڵ�û�����ӽڵ㣨�����������Ѿ������ʹ��ʱ�򣬾Ϳ��Է��ʵ�ǰ�ڵ㣬������ص������������ӡ��ǰ�ڵ��ֵ�ȣ���
	   * �ں�������Ҳһ��ֻ�е�ǰ�ڵ�û���ӽڵ㣨�������������Ѿ������ʹ��ˣ�,�Ϳ��Է��ʵ�ǰ�ڵ�    
	   * ֪�������֮���Ϳ�����ջ���ݴ���Щ�������������ʵĽڵ�  ,���ڷ��ʹ�Ľڵ�����Ӧ�ı��
	   * @param root
	   * @return
	   */
   public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rlist=new ArrayList<Integer>();
        Stack<TreeNode> s=new Stack<TreeNode>();
        if(root==null) return rlist;
        s.push(root);
        while(!s.isEmpty()){
        	TreeNode tempNode=s.peek();
        	if((tempNode.left==null||tempNode.left.val==Integer.MIN_VALUE)&&(tempNode.right==null||tempNode.right.val==Integer.MIN_VALUE)){
        		rlist.add(tempNode.val);
        		tempNode=s.pop();
        		tempNode.val=Integer.MIN_VALUE;
        	}else{
        		if(tempNode.right!=null) s.push(tempNode.right);
        		if(tempNode.left!=null)  s.push(tempNode.left);
        	}
        }
        
        return rlist;
    }
   
   public static void main(String[] args){
	   BinaryTreePostorderTraversal145 b=new BinaryTreePostorderTraversal145();
		  List<Integer> r=new ArrayList<Integer>();
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
		  r=b.postorderTraversal(root);
		  System.out.println("r="+r.toString());
	  }
}
