package algorithm;

public class FindMinimuminRotatedSortedArray153 {
	//1ms
   public int findMin(int[] nums) {
        int len=nums.length;
        int left=0,right=len-1,mid=(left+right)/2;
        while(mid!=left&&mid!=right){
        	if(nums[left]<nums[mid]&&nums[mid]<nums[right])
        		return  nums[left];
        	if(nums[left]<nums[mid]) left=mid;
        	else if(nums[mid]<nums[right]) right=mid;
        	mid=(left+right)/2;
        }
         return nums[left]<nums[right]?nums[left]:nums[right];
    }
   
   public static void main(String [] args){
	   FindMinimuminRotatedSortedArray153 f=new FindMinimuminRotatedSortedArray153();
	   int[] nums={1,1,2,4,5,6,7};
	   int r=f.findMin(nums);
	   System.out.println("result="+r);
   }
}
