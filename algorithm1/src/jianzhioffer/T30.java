package jianzhioffer;

public class T30 {
     public void smallK(int[] nums,int k){
    	 int[] r=new int[k];
    	 transact(nums,k,0,nums.length-1);
     }
     
     private void transact(int[] nums,int k,int left,int right){
    	 int begin=left,end=right;
    	 int key=nums[begin];
    	 while(begin<end){
    		 while(begin<end&&nums[end]>key) end--;
    		 nums[begin]=nums[end];
    		 while(begin<end&&nums[begin]<=key) begin++;
    		 nums[end]=nums[begin];
    	 }
    	 nums[begin]=key;
    	 if((begin+1)==k) return ;
    	 else if((begin+1)<k) transact(nums,k,begin+1,right);
    	 else transact(nums,k,left,begin);
     }
     
     public static void main(String[] args){
    	 T30 t=new T30();
         int[] nums={3,5,1,5,7,9,0,20,24};
         t.smallK(nums, 5);
         for(int i=0;i<5;i++){
        	 System.out.print(nums[i]+" ");
         }
     }
     
}
