package algorithm;

public class FindMinimuminRotatedSortedArrayII154 {
	//AC  2ms
	 public int findMin(int[] nums) {
		 int len=nums.length;
	     return findMinRange(nums,0,len-1);
	     
	 }
	 
	 public int findMinRange(int[] nums,int l,int r) {
	        int left=l,right=r,mid=(left+right)/2;
	        while(mid!=left&&mid!=right){
	        	if((nums[left]<nums[mid]&&nums[mid]<=nums[right])||(nums[left]==nums[mid]&&nums[mid]<nums[right]))
	        		return  nums[left];
	        	if((nums[left]<nums[mid]&&nums[mid]>nums[right])||(nums[left]==nums[mid]&&nums[mid]>nums[right])) left=mid;
	        	else if(nums[left]>nums[mid]) right=mid;
	        	else if(nums[left]==nums[mid]&&nums[mid]==nums[right]) 
	        		return Math.min(findMinRange(nums,left,mid), findMinRange(nums,mid,right));
	        	mid=(left+right)/2;
	        }
	         return nums[left]<nums[right]?nums[left]:nums[right];
	 }
	  public static void main(String [] args){
		  FindMinimuminRotatedSortedArrayII154 f=new FindMinimuminRotatedSortedArrayII154();
		  int[] nums={1,2,2};
		  int result=f.findMin(nums);
		  System.out.println("r="+result);
	  }
}
