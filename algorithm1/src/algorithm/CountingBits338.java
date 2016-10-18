package algorithm;

public class CountingBits338 {
	 public int[] countBits(int num) {
	       int[] dp=new int[num+1];
	       int half=num/2+1;
	       int[] index=new int[half];
	       dp[0]=0;
	       int c=0,cur=1,precount=0;
	       while(c<half){
	    	   index[c++]=cur;
	    	   precount=c-1;
	    	   for(int i=0;c<half&&i<precount;i++){
	    		   index[c++]=index[i];
	    	   }
	    	   cur++;
	       }
	       
	       int preIndex=0;
	       for(int i=1;i<=num;i++){
	    	   if((i-1)%2==0) preIndex=0;
	    	   else preIndex=index[(i-1)/2];
	    	   dp[i]=dp[i-1]-preIndex+1;
	       }

	 return dp;
	 }
	 
	 public static void main(String[] args){
		 CountingBits338 c=new CountingBits338();
		 int[] r=c.countBits(30);
		 for(int i=0;i<r.length;i++){
			 System.out.print(r[i]+" ");
		 }
	 }
}
