package jianzhioffer;
/**
 * 数组中出现次数超过一半的数
 * @author sy
 *
 */
public class T29 {
    public int moreHalf(int[] nums){
    	if(nums.length==0) return Integer.MIN_VALUE;
        int val=nums[0],count=1;
        for(int i=1;i<nums.length;i++){
        	if(count==0){
        		val=nums[i];
        		count=1;
        	}else{
        		if(val==nums[i]) count++;
        		else count--;
        	}
        }
        return val;
    }
    
    public static void main(String[] args){
    	T29 t=new T29();
    	int r=t.moreHalf(new int[]{1,2,3,2,2,2,5,4,2});
        System.out.println(r);
    }
}
