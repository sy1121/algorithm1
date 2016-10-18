package jianzhioffer;
/**
 * 数组中的逆序对
 * @author sy
 *
 */
public class T36 {
   public int inversePair(int[] nums){
	   if(nums.length==0) return 0;
	   int[] result=nums.clone();
	   return merge(nums,result,0,nums.length-1);
   }
	
   public int merge(int[] result,int[] nums,int left,int right){
	    if(left==right){
	        result[left]=nums[left];
	        return 0;
	    }else{
	    	 int length=(right-left)/2;
	    	 int l=merge(nums,result,left,left+length);
	    	 int r=merge(nums,result,left+length+1,right);
	    	 int count=0;
	    	 int lindex=left+length,rindex=right;
	    	 int index=right;
	    	 while(lindex>=left&&rindex>=left+length+1){
	    		 if(nums[lindex]>nums[rindex]){
	    			 result[index--]=nums[lindex--];
	    			 count+=rindex-left-length;
	    		 }else{
	    			 result[index--]=nums[rindex--];
	    		 }
	    	 }
	    	 while(lindex>=left) result[index--]=nums[lindex--];
	    	 while(rindex>=left+length+1) result[index--]=nums[rindex--];
	    	 return l+r+count;
	    }
   }
   
   public static void main(String[] args){
	   T36 t=new T36();
	   int[] nums={7,5,6,4};
	   int r=t.inversePair(nums);
	   System.out.println(r);
   }
}
