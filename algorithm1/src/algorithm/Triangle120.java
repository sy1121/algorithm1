package algorithm;

import java.util.List;

public class Triangle120 {
	//AC 7ms O(n2)时间复杂度/O(n)空间复杂度   
	 public int minimumTotal(List<List<Integer>> triangle) {
	        int xlen=triangle.size();
            if(xlen==0) return 0;
            int ylen=triangle.get(xlen-1).size();
            int[] dp=new int[ylen];
            for(int i=0;i<ylen;i++){
                dp[i]=triangle.get(xlen-1).get(i);
            }
            for(int i=1;i<xlen;i++){
            	for(int j=0;j<triangle.get(xlen-i-1).size();j++){
            		dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(xlen-1-i).get(j);
            	}
            }
            return dp[0];
	    }
	 
	 
}
