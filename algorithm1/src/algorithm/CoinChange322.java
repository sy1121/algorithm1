package algorithm;

import java.util.Arrays;
import java.util.Stack;

public class CoinChange322 {
	
	//这是一道动态规划的题  递归的写法肯定超时
   /*public int coinChange(int[] coins, int amount) {
	   if(amount==0) return 0;
        if(coins==null||coins.length==0) return -1;
        int size=coins.length,count=0,index=size-1;
        while(index>=0&&amount<coins[index]) index--;
        if(index<0) return -1;
        int r=change(coins,index,amount);
        return r;
    }
   
   public int change(int[] coins,int index,int amount){
	   int curIndex=index;
	   if(amount==0)  return 0;
	   if(curIndex<0&&amount>0)  return -1;
	   int maxCount=amount/coins[curIndex];
	   int minCount=Integer.MAX_VALUE,count=0;
	   for(int i=maxCount;i>=0;i--){
		    count=change(coins,index-1,amount-i*coins[index]);
		    if(count==-1)  continue;
		    else {
		       count=count+i;
		       if(minCount>count)   minCount=count;
		    }
	   }
	    if(minCount!=Integer.MAX_VALUE) return minCount;
	    else return -1;
   }*/
	
	/**
	 * 背包问题是动态规划问题中最典型最基础的一类问题，一般讲动态规划的文章或是书多会首先讲背包问题 
	 * 背包问题右分为几种 ，如基本的0-1背包问题、完全背包问题 还有其他其他一些延伸扩展问题，具体的可以参考网上“背包九讲”
	 * 这是一个典型的完全背包问题 ，当然就可以通过动态规划的方法来求解 
	 * 那动态规划问题的关键就是确定之问题，确定递推条件和初始条件
	 * 根据网上的总结 ，完全背包问题有下面的地推公式：
	 * for i=1..N
       for v=0..V
        f[v]=max{f[v],f[v-cost]+weight}
        
                     完全背包问题还可以转化为0-1背包问题来求解
	 * @param coins
	 * @param amount
	 * @return
	 */
	// AC 18ms   时间复杂度O（NV）  空间复杂度O（V）
	/*  public int coinChange(int[] coins, int amount) {
		  if(amount==0) return 0;
		  if(coins==null||coins.length<1)  return -1;
		  int[] f=new int[amount+1];
		  for(int i=1;i<amount+1;i++) f[i]=Integer.MAX_VALUE/2;
		  f[0]=0;
		  for(int k=0;k<coins.length;k++){
			  for(int j=coins[k];j<=amount;j++){
				  f[j]=Math.min(f[j],f[j-coins[k]]+1);
			  }
		  }
	        if(f[amount]>=Integer.MAX_VALUE/2)  return -1;
	        else return f[amount];
	  }*/
	  public int coinChange(int[] coins, int amount) {
		  if(amount==0) return 0;
		  if(coins==null||coins.length<1)  return -1;
		  Arrays.sort(coins);
		  int[][] f=new int[coins.length][amount+1];
		  for(int i=0;i<coins.length ;i++){
			  for(int j=1;j<=amount;j++){
				  f[i][j]=Integer.MAX_VALUE/2;
			  }
			  f[i][0]=0;
		  }
		  int t=coins[0],cc=1;
		  while(t<=amount){
			  f[0][t]=cc;
			  t=t+coins[0];
			  cc++;
		  }
	//	  if(coins.length<2)  return f[0][amount];
		  for(int k=1;k<coins.length;k++){
			  for(int j=0;j<=amount;j++){
				  int c=j/coins[k];
				  for(int m=0;m<=c;m++)
				  f[k][j]=Math.min(f[k-1][j],f[k-1][j-coins[k]*m]+m);
			  }
		  }
		  if(f[coins.length -1][amount]>=Integer.MAX_VALUE/2)  return -1;
	        else return f[coins.length -1][amount];
	  }
	  
   public static void main(String[] args){
	   CoinChange322   c=new CoinChange322();
	   int[] coins={186,419,83,408};
	   int r=c.coinChange(coins, 6249);
	   System.out.println("r="+r);
   }
}
