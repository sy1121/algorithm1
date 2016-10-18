package jianzhioffer;
/*
 * 数字在排序数组中出现的次数
 */
public class T38 {
    public int getCountOfK(int[] nums,int k){
    	if(nums.length==0) return 0;
    	int findex=getFirstIndexOfK(nums,k);
    	int lindex=getLastIndexOfK(nums,k);
    	if(findex==-1) return 0;
    	return lindex-findex+1;
    }
    
    private int getFirstIndexOfK(int[] nums,int k){
    	int left=0,right=nums.length-1,mid;
    	while(left<right){
    	   mid=left+(right-left)/2;
    	   if(nums[mid]>=k) right=mid;
    	   else left=mid+1;
    	}
    	if(nums[right]==k) 
        return right;
    	else return -1;
    }
    
    private int getLastIndexOfK(int[]nums,int k){
    	int left=0,right=nums.length-1,mid;
    	while(left<right){
    		mid=left+(right-left)/2;
    	    if(nums[mid]<=k) left=mid;
    	    else right=mid-1;
    	}
    	if(nums[left]==k)
    	return left;
    	else return -1;
    }
    
    public static void main(String[] args){
    	T38 t=new T38();
    	int[] nums={3,3,3,3,3,4,5};
    	int r=t.getCountOfK(nums, 2);
    	System.out.println(r);
    }
}
