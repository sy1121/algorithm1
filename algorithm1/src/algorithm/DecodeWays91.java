package algorithm;

public class DecodeWays91 {
	//2ms AC  动态规划
	  public int numDecodings(String s) {
	        int size=s.length();
	        if(size==0||s.charAt(0)=='0') return 0;
	        int[] w=new int[size];
	        w[0]=1;
	        if(size==1) return 1;
	        //size=2的情况
	        if(s.charAt(1)!='0') w[1]=w[0];
	        if(isAlpha(s.charAt(0),s.charAt(1))) w[1]=w[1]+1;
            if(w[1]==0) return 0;
            //size>2的情况
	        for(int i=2;i<size;i++){
	           if(s.charAt(i)!='0')
	        	  w[i]=w[i-1];
	           if(isAlpha(s.charAt(i-1),s.charAt(i)))
	        	   w[i]+=w[i-2];
	           if(w[i]==0)  return 0;
	        }
	        return w[size-1];
	    }
	  
	  public boolean isAlpha(char pre,char cur){
		  if(pre-'0'==1) return true;
		  else if(pre-'0'==2&&cur-'0'<7) return true;
		  else return false;
	  }
	  
	  public static void main(String[] args){
		  DecodeWays91 s=new DecodeWays91();
		  int r=s.numDecodings("9830421");
		  System.out.println("r="+r);
	  }
}
