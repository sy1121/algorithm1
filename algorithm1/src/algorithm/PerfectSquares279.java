package algorithm;

import java.util.HashMap;

public class PerfectSquares279 {
/*    public int numSquares(int n) {
        int[] minc=new int[n+1];
        minc[0]=0;
        int mincount=0;
        for(int i=1;i<=n;i++){
        	if(isSqrt(i)){
              minc[i]=1; continue;
        	}else minc[i]=Integer.MAX_VALUE;
        	 for(int j=1;j<=i/2+1;j++){
                minc[i]=Math.min(minc[i],minc[j]+minc[i-j]);        		 
        	 }
        }
        return minc[n];
     }
    
    public boolean isSqrt(int n){
    	int r=(int)Math.sqrt(n);
    	if(r*r==n) return true;
    	else return false;
    }*/
/*	int minRes;
	public int numSquares(int n) {
		 minRes=Integer.MAX_VALUE;
		 find(n,0);
		 return minRes;
	}
	
	public void find(int n,int count){
		if(n<4){
			count+=n;
			if(count<minRes){
				minRes=count;
			}
			return ;
		}
		int newcount=count+1;
		if(newcount>minRes) return;
		int sqrt=(int)Math.sqrt(n);
		if(sqrt*sqrt==n){
			if(newcount<minRes){
				minRes=newcount;
			}
			return ;
		}
		int i=sqrt;
		int mid=i/2+1;
		while(i>=mid){
			find(n-i*i,newcount);
			i--;
		}
			
	}*/
	 private HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
     public int numSquares(int n) {
    	 if(map.containsKey(n)) return map.get(n);
         int result=Integer.MAX_VALUE;
        if(isSqrt(n)){
        	result=1;
        }else {
           int s=(int)Math.sqrt(n);
           for(int i=s;i>=s/2+1;i--){
        	   result=Math.min(result,1+numSquares(n-i*i));
          }
        }
        map.put(n, result);
        return result;
    }
     private int helper(int n,int count){
    	 if(map.containsKey(n)) return map.get(n);
         int result=Integer.MAX_VALUE;
        if(isSqrt(n)){
        	result=1;
        }else {
           int s=(int)Math.sqrt(n);
           for(int i=s;i>=s/2+1;i--){
        	   result=Math.min(result,1+numSquares(n-i*i));
          }
        }
        map.put(n, result);
        return result;
     }
     
     private boolean isSqrt(int n){
    	 int s=(int)Math.sqrt(n);
    	 if(s*s==n) return true;
    	 else return false;
     }
	
    public static void main(String[] args){
    	PerfectSquares279 p=new PerfectSquares279();
    	int r=p.numSquares(1000);
    	System.out.println("r="+r);
    }
}
