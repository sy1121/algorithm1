package jianzhioffer;

import java.util.Arrays;

/**
 * 扑克牌的顺序
 * @author sy
 *
 */
public class T44 {
    public boolean isContinue(int[] nums){
    	if(nums.length==0) return false;
    	Arrays.sort(nums);
    	int zero=0,gap=0,i=0;
    	for(;i<nums.length;i++){
    		if(nums[i]!=0) break;
    		zero++;
    	}
    	int left=i,right=i+1;
    	while(right<nums.length){
    		if(nums[left]==nums[right]) return false;
    		gap+=nums[right]-nums[left]-1;
    	    left++;
    	    right++;
    	}
        return zero>=gap?true:false;
    }
    
   public static void main(String[] args){
	   T44 t=new T44();
	   int[] nums={0,3,8,5,0};
	   boolean  r=t.isContinue(nums);
	   System.out.println(r);
   }
}
