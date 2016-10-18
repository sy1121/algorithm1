package algorithm;

public class FlattenBinaryTreetoLinkedList114 {
	  public static  class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	  //AC 1ms
	 public void flatten(TreeNode root) {
	        fatternE(root);
	    }
	 public  TreeNode fatternE(TreeNode root){
		 if(root==null) return null;
		 TreeNode left=root.left,right=root.right;
		 TreeNode leftLast=fatternE(left);
		 TreeNode rightLast=fatternE(right);
		 if(left!=null){
			 root.right=left;
			 root.left=null;
			 if(right!=null){
				 leftLast.right=right;
				 leftLast.left=null;
			 }
		 }else{
			 if(right!=null){
			 root.right=right;
			 root.left=null;
			 }
		 }
		  if(right!=null) return rightLast;
		  else if(left!=null) return leftLast;
		  else return root;
	 }
	 
	 public static void previsit(TreeNode root){
		 if(root==null)  return ;
		 System.out.print(root.val+"-->");
		 previsit(root.left);
		 previsit(root.right);
	 }
	 
	 public static void main(String[] args){
		 FlattenBinaryTreetoLinkedList114 f=new FlattenBinaryTreetoLinkedList114();
		 TreeNode root=new TreeNode(1);
		 TreeNode node2=new TreeNode(2);
		 TreeNode node3=new TreeNode(3);
		 TreeNode node4=new TreeNode(4);
		 TreeNode node5=new TreeNode(5);
		 TreeNode node6=new TreeNode(6);
		 TreeNode node7=new TreeNode(7);
		 root.left=node2;
		 root.right=node3;
		 node2.left=node4;
		 node2.right=node5;
		 node3.left=node6;
		 node3.right=node7;
		 f.fatternE(root);
		 previsit(root);
	 }
}
