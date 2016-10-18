package algorithm;

public class MaximumProductSubarray152 {
	//AC 4ms 
	/* public int maxProduct(int[] nums) {
	        int size=nums.length ;
	        if(size<1) return 0;
	        int[] max=new int[size];
	        int[] min=new int[size];
	        max[0]=nums[0];
	        min[0]=nums[0];
	        int result=nums[0];
	        for(int i=1;i<size;i++){
	        	if(nums[i]==0){
	        		max[i]=0;
	        		min[i]=0;
	        	}else if(nums[i]>0){
	        		max[i]=Math.max(nums[i], nums[i]*max[i-1]);
	        		min[i]=Math.min(nums[i], nums[i]*min[i-1]);
	        	}else{
	        		max[i]=Math.max(nums[i], nums[i]*min[i-1]);
	        		min[i]=Math.min(nums[i], nums[i]*max[i-1]);
	        	}
	        	if(max[i]>result) result=max[i];
	        }
	        return result;
	    }*/
	 
	 
}
