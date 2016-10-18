package googleTest;

import java.util.Scanner;

public class reverseArray {
    public static void main(String[] args){
       Scanner scan=new Scanner(System.in);
    	   int n=scan.nextInt();
    	   int[] nums=new int[n];
    	   for(int i=0;i<n;i++){
    		   nums[i]=scan.nextInt();
    	   }
    	   boolean r=isCanReverse(nums);
    	   if(r)
    	   System.out.println("yes");
    	   else System.out.println("no");
    }
    
    private static  boolean isCanReverse(int[] nums){
    	int start=0,end=0,i=0,j=0,len=nums.length;
    	if(len<3) return true;
    	for(i=1;i<len;i++){
    		if(nums[i]<nums[i-1]){
    			start=i-1;
    			break;
    		}
    	}
    	for(j=start+1;j<len;j++){
    		if(nums[i]>nums[i-1]){
    			end=i-1;break;
    		}
    	}
    
    	for(int m=end+1;m<len;m++){
    		if(nums[m]<nums[m-1]) return false;
    	}
    	return true;
    }
   
}
