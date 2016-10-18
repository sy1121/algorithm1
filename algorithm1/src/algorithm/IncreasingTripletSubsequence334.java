package algorithm;

public class IncreasingTripletSubsequence334 {
	//AC 172ms  O(n*n)复杂度    太慢了
    /*public boolean increasingTriplet(int[] nums) {
       int len=nums.length ;
       if(len<3) return false;
       boolean flag=false;
       int[] count=new int[len];
       for(int i=0;i<len;i++){
    	   count[i]=1;
       }
       for(int i=1;i<len;i++){
    	   for(int j=0;j<i;j++){
    		   if(nums[j]<nums[i])
    			   count[i]=Math.max(count[i], count[j]+1);
    	   }
    	   if(count[i]>=3) {
    		   flag=true;
    		   break;
    	   }
       }
       return flag;
    }*/
	//参考网上的O(N)的解法  min ,min2 分别记录第一小和第二小的数
  	public boolean increasingTriplet(int[] nums) {
 	     if(nums.length<3) return false;
	int min=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
	for(int i=0;i<nums.length;i++){
		if(nums[i]<=min) {
			min=nums[i];
		}else if(nums[i]<=min2){
			min2=nums[i];
		}else if(nums[i]>min2){
			return true;
		}
	}
	return false;
}
    
    public static void main(String[] args){
    	IncreasingTripletSubsequence334 i=new IncreasingTripletSubsequence334();
    	int[] nums={1,9,3,6,1};
    	boolean r=i.increasingTriplet(nums);
    	System.out.println("result="+r);
    }
}
