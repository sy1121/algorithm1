package jianzhioffer;

import java.util.Arrays;

public class T12 {
   public void printToMaxOfNDigits(int n){
	    int[] nums=new int[n];
	    if(n<=0) return ;
	    System.out.println("0");
	    while(increment(nums)){
	    	printNum(nums);
	    }
   }
   private boolean increment(int[] nums){
	    boolean overflow=false;
	    int index=nums.length-1;
	    while(nums[index]==9){
	    	index--;
	    	if(index<0){
	    		overflow=true;
	    		break;
	    	}
	    }
	    if(overflow) return false;
	    else {
	    	nums[index]++;
	    	if(index<nums.length-1)
	    	Arrays.fill(nums, index+1, nums.length, 0);
	    	return true;
	    }
   }
   
   private void printNum(int[] nums){
	    boolean isZero=false;
	    for(int i=0;i<nums.length;i++){
	        if(nums[i]!=0){
	        	System.out.print(nums[i]);
	        	if(!isZero) isZero=true;
	        }else if(isZero){
	            System.out.print(nums[i]);
	        }
	    }
	    System.out.println();
   }
   
   public static void main(String[] args){
	   T12 t=new T12();
	   t.printToMaxOfNDigits(2);
   }
}
