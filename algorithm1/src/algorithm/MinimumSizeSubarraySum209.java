package algorithm;

public class MinimumSizeSubarraySum209 {
	/*public int minSubArrayLen(int s, int[] nums) {
		if(nums.length<1) return 0;
		int[] sums=new int[nums.length+1];
		sums[0]=0;
		sums[1]=nums[0];
		for(int i=1;i<nums.length;i++){
			sums[i+1]=sums[i]+nums[i];
		}
       return helper(0,nums.length-1,sums,s);
    }
	
	public int helper(int i,int j,int[] sums,int target){
		   if(i==j){
			   if(sums[j+1]-sums[j]>=target) return 1;
			   else return 0;
		   }
		   if(target>sums[j+1]-sums[i]) return 0;
		   else if(target==sums[j+1]-sums[i]) return j-i+1;
		   else{
			   int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
			   if((sums[i+1]-sums[i])<(sums[j+1]-sums[j])) {
				   left=helper(i+1,j,sums,target);
				   if(left==0) left=j-i+1;
			   }
			   else if((sums[i+1]-sums[i])>(sums[j+1]-sums[j])) {
				    right=helper(i,j-1,sums,target);
				   if(right==0) right=j-i+1;
			   }
			   else{
				   left=helper(i+1,j,sums,target);
				   left=left==0?j-i+1:left;
				   right=helper(i,j-1,sums,target);
				   right=right==0?j-i+1:right;
			   }
			   return Math.min(left,right);
		   }
	}*/
	
    public int minSubArrayLen(int s, int[] nums) {
        int len=nums.length;
        boolean found=false;
        int sum=0,result=0,start=0;
        for(int i=0;i<len;i++){
        	 if(!found){
        	   sum+=nums[i];
        	   if(sum>=s) {
        		 found=true;
        		 while(sum>=s){
        			 sum=sum-nums[start];
        			 start++;
        		 }
                result=i-start+1;
        	   }
        	 }else{
        		 sum=sum-nums[start]+nums[i];
        		 start++;
        		 while(sum>=s){
        			 sum=sum-nums[start];
        			 start++;
        		 }
        		 result=i-start+1;
        		 if(result==0) return 1;
        	 }
        }
       if(!found) return 0;
       else return result+1;
    }
    
    private int rangeSum(int[] sum,int start,int end){
    	int len=sum.length;
        if(end>=len) return 0;
        if(start<0) start=0;
    	int result=0;
    	for(int i=start;i<=end;i++){
    		result+=sum[i];
    	}
    	return result;
    }
	
	public static void main(String[] args){
		MinimumSizeSubarraySum209 m=new MinimumSizeSubarraySum209();
		int r=m.minSubArrayLen(7, new int[]{2,3,1,2,4,3,7,1,3,1});
		
		System.out.println("r="+r);
	}
}
