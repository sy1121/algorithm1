package jianzhioffer;

public class T31 {
	  public int maxSubArray(int[] nums) {
	        int len=nums.length;
	        if(len==0) return 0;
	        int result=Integer.MIN_VALUE;
	        int cursum=0;
	        for(int i=0;i<len;i++){
	            if(cursum>0) cursum+=nums[i];
	            else cursum=nums[i];
	            if(cursum>result) result=cursum;
	        }
	        return result;
	    }
}
