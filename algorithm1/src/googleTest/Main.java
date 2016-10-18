package googleTest;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
     public static void main(String[] args){
    	 Scanner cin = new Scanner(System.in);	
    	 while (cin.hasNext()){
    		    int result=0,count=0;
				int n = cin.nextInt(); 
				int[] nums=new int[n];
				for(int i=0;i<n;i++)
				nums[i]=cin.nextInt();
				count=n;
				while(count>1){
				Arrays.sort(nums);
			    result+=(nums[0]+nums[1]);
			    nums[0]=nums[0]+nums[1];
			    nums[1]=Integer.MAX_VALUE;
			    count--;
				}
				System.out.println(result);
			}
     }
}
