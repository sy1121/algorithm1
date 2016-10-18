package algorithm;

public class BestTimetoBuyandSellStockwithCooldown309 {
	//AC 2ms   答题思路：两个数组代表profit代表第i天的最大收益，sign表示第i天是否是cooldown;所求位profit[size-1]
	/**
	 * 用动态规划的思想，寻找第i天于第i-1天收益的地推关系；
	 * 如果第i天价格小于第i-1天价格，则profit[i]=profit[i-1]
	 * 如果第i天价格大于等于第i-1天价格，则分为两个情况：
	 * 1）第i-1不是cooldown，则profit[i]=profit[i-1]+diff;其中diff为两天价格的差值
	 * 2）第i-1天是cooldown,则 profit[i]=max(profit[i-3]+diff,profit[i-1]+max(diff(i,i-2),0))
	 * 根据递推是求解
	 * @param prices
	 * @return
	 */
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2) return 0;
    	int size=prices.length;
    	boolean[] sign=new boolean[size];
        int[] profit=new int[size];
        profit[0]=0;
        sign[0]=true;
        for(int i=1;i<size&&i<3;i++){
        	if(prices[i]>prices[i-1]){
        	    profit[i]=profit[i-1]+prices[i]-prices[i-1];
        	    sign[i]=true;
        	}else{
        		profit[i]=profit[i-1];
        		sign[i]=sign[i-1]?false:true;
        	}
        }
        if(size<=3) return profit[size-1];
        for(int i=3;i<size;i++){
        	int diff=prices[i]-prices[i-1];
            if(diff>0){
                if(sign[i-1]){
                	profit[i]=profit[i-1]+diff;
                }else{
                	int profitOne=profit[i-1]+(prices[i]-prices[i-2]>0?prices[i]-prices[i-2]:0);
                	int profitTwo=profit[i-3]+diff;
                	if(profitOne>profitTwo){
                		profit[i]=profitOne;
                	}else{
                		profit[i]=profitTwo;
                		
                	}
                }
                sign[i]=true;
            }else{
            	profit[i]=profit[i-1];
            	sign[i]=sign[i-1]?false:true;
            }
        }
    	return profit[size-1];
        
    }
    
    public static void main(String[] args){
    	BestTimetoBuyandSellStockwithCooldown309 b=new BestTimetoBuyandSellStockwithCooldown309();
    	int[] prices={6,1,3,2,4,7};
    	int r=b.maxProfit(prices);
    	System.out.println("r="+r);
    }
}
