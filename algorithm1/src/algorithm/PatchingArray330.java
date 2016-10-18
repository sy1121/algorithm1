package algorithm;

import java.util.Arrays;
import java.util.List;

public class PatchingArray330 {
	//AC 1ms  注意n为最大值的时候可能越界   每考虑一个数n 下一个需要考虑的数为n+n 因为n+n-1一定以可达  
    public int minPatches(int[] nums, int n) {
        long i=1;
        int index=0,len=nums.length,rcount=0;
    	while(i<=n){
           if(index<len&&nums[index]==i){
        	   index++;
           }else{   //数组中没有当前值 
        	   rcount++;
           }
           i=i+i-1;
           while(index<len&&i>=nums[index]){   //数组中的数比当前值小 这可以扩大可达值得范围    
        	   i=i+nums[index++];
           }
           i++;
        }
    	return rcount;
    }
    
    public static void main(String[] args){
    	PatchingArray330 p=new PatchingArray330();
    	int[] nums={1,2,31,33};
    	int r=p.minPatches(nums, 2147483647);
    	System.out.println("r="+r);
    }
}
