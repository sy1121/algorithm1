package algorithm;

public class ConvertSortedArraytoBinarySearchTree108 {
	 public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	 //AC  1ms
	 public TreeNode sortedArrayToBST(int[] nums) {
	        return sortedArray(nums,0,nums.length-1);
	    }
	 
	 public TreeNode sortedArray(int[] nums,int left,int right){
		 if(left>right) return null;
		 int size=right-left+1,midIndex=left+size/2;
		 TreeNode root=new TreeNode(nums[midIndex]);
		 root.left=sortedArray(nums,left,midIndex-1);
		 root.right=sortedArray(nums,midIndex+1,right);
		 return root;
	 }
}
