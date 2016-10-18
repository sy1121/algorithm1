package jianzhioffer;
//排序旋转数组找最小元素
public class T8 {
   // 无重复元素的情况 ：：直接二分
	 public int findMin(int[] nums) {
	        if (nums==null || nums.length==0) { return Integer.MIN_VALUE; } 
	        int left = 0, right = nums.length-1;
	        while (left < right-1) {  // while (left < right-1) is a useful technique
	            int mid = left + (right-left)/2;
	            if (nums[mid] > nums[right]) { left = mid; }
	            else { right = mid; }
	        }
	        if (nums[left] > nums[right]) { return nums[right]; }
	        return nums[left];
	   }
	 
	 //有重复元素的情况  ：： 分治
	 /* public int findMin(int[] nums) {
	       return divide(nums,0,nums.length-1);
	       
	    }
	    
	   private int divide(int[] nums,int left,int right){
	         if(left==right) return nums[left];
	         int mid=(left+right)/2;
	         if(mid>0&&nums[mid]<nums[mid-1]&&mid+1<nums.length&&nums[mid]<nums[mid+1]) 
	           return nums[mid];
	         else
	           return  Math.min(divide(nums,left,mid),divide(nums,mid+1,right));
	   }*/
}
