package algorithm;

public class ValidateBinarySearchTree98 {
	//AC 1ms
	  public boolean isValidBST(TreeNode root){
	        if(root==null) return  true;
	        if(root.left==null&&root.right==null) return true;
	        return isValidBST(root.left)&&isValidBST(root.right)&&isLeftValid(root)&&isRightValid(root);
	    }
	  
	  public boolean isLeftValid(TreeNode root){
		  if(root.left==null) return true;
		  int rootVal=root.val,bigVal=root.left.val;
		  TreeNode tempRight=root.left;
		  while(tempRight!=null){
			  bigVal=tempRight.val;
			  tempRight=tempRight.right;
		  }
		 return rootVal>bigVal;
	  }
	  public boolean isRightValid(TreeNode root){
		  if(root.right==null) return true;
		  int rootVal=root.val,smallVal=root.right.val;
		  TreeNode tempLeft=root.right;
		  while(tempLeft!=null){
			  smallVal=tempLeft.val;
			  tempLeft=tempLeft.left;
		  }
		  return rootVal<smallVal;
	  }
}
