package jianzhioffer;
/**
 * 和位s的两个数
 * @author sy
 *
 */
public class T41 {
    public int[] find2NumSum(int[] nums,int target){
    	 if(nums.length==0) return null;
    	 int left=0,right=nums.length-1;
    	 while(left<right){
    		 int sum=nums[left]+nums[right];
    		 if(sum<target) left++;
    		 else if(sum>target) right--;
    		 else {
    			 int[] r={nums[left],nums[right]};
    			 return r;
    		 }
    	 }
    	 return null;
    }
    
    /**
     * 和为s的连续正整数序列
     * @param args
     */
    public void findContinueSequeue(int sum){
    	 if(sum<3) return ;
    	 int small=1,big=2,cursum=small+big,mid=(1+sum)/2;
    	 while(small<mid){
    		 if(cursum==sum) printSequeue(small,big);
    		 while(small<mid&&cursum>sum){
    			 cursum-=small;
    			 small++;
    			 if(cursum==sum) printSequeue(small,big);
    		 }
    		 big++;
    		 cursum+=big;
    	 }
    }
    
    private void printSequeue(int small,int big){
    	for(int i=small;i<=big;i++){
    		System.out.print(i+" ");
    	}
    	System.out.println();
    }
    
    
    public static void main(String[] args){
    	T41 t=new T41();
    	/*int[] nums={1,2,3,4,5,6,7,8};
    	int[] r=t.find2NumSum(nums, 8);
        for(int i:r){
        	System.out.print(i+" ");
        }*/
    	t.findContinueSequeue(15);
    	
    }
}
