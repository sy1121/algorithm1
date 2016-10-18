package googleTest;

import java.util.Scanner;

public class Buy {
	static int result=-1;
	public static void main(String[] args){
	Scanner cin = new Scanner(System.in);
	while (cin.hasNext()){
		int n = cin.nextInt();
		int x=cin.nextInt();
		int[] prices=new int[n];
		for(int i=0;i<n;i++){
			prices[i]=cin.nextInt();
		}
	    traceback(prices,x,0,0);
	    System.out.println(result);
	}
 }
	
  private static void traceback(int[] prices,int target,int index,int sum){
		if(sum>=target){
			if(result==-1||sum<result)
				result=sum;
			return;
		}else if(index>=prices.length){
			return ;
		}else{
		
			for(int i=0;i<2;i++){
				if(i==0)
					sum=sum+prices[index];
				traceback(prices,target,index+1,sum);
				if(i==0)
				    sum=sum-prices[index];
			}
		}
	}
}
