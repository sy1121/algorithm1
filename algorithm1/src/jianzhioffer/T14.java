package jianzhioffer;
/**
 * 把数组中的奇数偶数分别防放到数组的两边
 * @author sy
 *
 */
public class T14 {
    public void reorder(int[] nums){
    	if(nums.length==0) return ;
    	int left=0,right=nums.length-1;
    	while(left<right){
    		while(left<right&&((nums[left]&1)==1)) left++;
    		while(left<right&&((nums[right]&1)==0)) right--;
    		if(left<right){
    			int temp=nums[left];
    			nums[left]=nums[right];
    			nums[right]=temp;
    		}
    	}
    }
    
    public static void main(String[] args){
    	T14 t=new T14();
        int[] nums={1,4,2,5,3,5,6,29,43};
    	t.reorder(nums);
    	for(int i:nums){
    		System.out.print(i+" ");
    	}
    }
}
