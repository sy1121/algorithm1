package algorithm;

import java.util.Arrays;

public class WiggleSortII324 {
	//AC 7ms
   public void wiggleSort(int[] nums) {
       int size=nums.length; 
       int[] temp=new int[size];
       for(int i=0;i<size;i++){
    	   temp[i]=nums[i];
       }
	   Arrays.sort(temp);
	   int midIndex=(size-1)/2;
	   int left=midIndex,right=size-1,index=0;
	   while(index<size){
		   nums[index++]=temp[left--];
		   if(index>=size) break;
		   nums[index++]=temp[right--];
	   }
    }
   
   public static void main(String[] args){
	   WiggleSortII324 w=new WiggleSortII324();
	   int[] nums={5,3,1,2,6,7,8,5,5};
	   w.wiggleSort(nums);
	   for(int i=0;i<nums.length;i++){
		   System.out.print(nums[i]+",");
	   }
   }
}
