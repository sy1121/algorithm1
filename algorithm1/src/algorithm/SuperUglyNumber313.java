package algorithm;

import java.util.ArrayList;
import java.util.List;

public class SuperUglyNumber313 {
public int nthSuperUglyNumber(int n, int[] primes) {
         int len=primes.length;
       //  List<List<Integer>> lists=new ArrayList<List<Integer>>();
         int[][] lists=new int[len][n+1];
         for(int i=0;i<len;i++){
        	 lists[i][0]=1;
         }
         int[] index=new int[len];
         int count=0,small=1;
         while(n!=count){
           small=lists[0][index[0]];
         for(int i=1;i<len;i++){
           small=Math.min(small,lists[i][index[i]]);
         }
         for(int i=0;i<len;i++){
        	 if(lists[i][index[i]]==small) index[i]++;
        	 lists[i][count+1]=small*primes[i];
         }
         count++;
         }
         return small;
    }

    public static void main(String[] args){
    	SuperUglyNumber313 s=new SuperUglyNumber313();
    	int r=s.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19});
    	System.out.println("r="+r);
    }
}
