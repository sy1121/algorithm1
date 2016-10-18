package algorithm;

public class GasStation134 {
	//AC 1ms  
	 public int canCompleteCircuit(int[] gas, int[] cost) {
		 int len=gas.length,curIndex=0,sumdif=0,presum=0;
		 int[] dif=new int[len];
		 for(int i=0;i<len;i++){
			 dif[i]=gas[i]-cost[i];
		 }
		 for(int i=0;i<len;i++){
			 presum+=dif[i];
			 if(presum<0){
				 sumdif+=presum;
				 presum=0;
				 curIndex=i+1;
			 }
		 }
	     if(presum+sumdif>=0) return curIndex;
	     else return -1;
	 }
	 
	 public static void main(String [] args){
		 GasStation134 g=new GasStation134();
		 int[] gas={1,7,3,6,2,9,1,0,2};
		 int[] cost={2,3,6,9,4,6,8,1,2};
		 int r=g.canCompleteCircuit(gas, cost);
		 System.out.println("result="+r);
	 }
}
