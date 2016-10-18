package algorithm;

public class BestTimetoBuyandSellStockwithCooldown309 {
	//AC 2ms   ����˼·�������������profit�����i���������棬sign��ʾ��i���Ƿ���cooldown;����λprofit[size-1]
	/**
	 * �ö�̬�滮��˼�룬Ѱ�ҵ�i���ڵ�i-1������ĵ��ƹ�ϵ��
	 * �����i��۸�С�ڵ�i-1��۸���profit[i]=profit[i-1]
	 * �����i��۸���ڵ��ڵ�i-1��۸����Ϊ���������
	 * 1����i-1����cooldown����profit[i]=profit[i-1]+diff;����diffΪ����۸�Ĳ�ֵ
	 * 2����i-1����cooldown,�� profit[i]=max(profit[i-3]+diff,profit[i-1]+max(diff(i,i-2),0))
	 * ���ݵ��������
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
