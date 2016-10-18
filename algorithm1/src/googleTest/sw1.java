package googleTest;

import java.util.Scanner;

public class sw1 {
	 public static void main(String[] args){
		    Scanner cin = new Scanner(System.in);
			int n=cin.nextInt();
	        int[] nums=new int[n];
	        int even=0,odd=0;
		     for(int i=0;i<n;i++){
		    	 nums[i]=cin.nextInt();
		    	 if(isOdd(nums[i])) odd++;
		    	 else even++;
		     }
		     System.out.println(Math.abs(odd-even));
	  }
	 
	 private static boolean isOdd(int num){
		 return (num&1)==1?true:false;
	 }
}
