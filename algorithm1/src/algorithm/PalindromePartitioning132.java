package algorithm;

import java.util.HashMap;

public class PalindromePartitioning132 {
    public int minCut(String s) {
        if(s.length()<=1) return 0;
        int len=s.length(),mincut=0;
        int[] mincuts=new int[len];
        mincuts[0]=0;
        for(int i=1;i<len;i++){
        	if(s.charAt(i)==s.charAt(i-1)){
        		mincuts[i]=mincuts[i-1];
        		continue;
        	}
        	mincuts[i]=mincuts[i-1]+1;
        	for(int j=i-1;j>=0;j--){
        		if(isPalin(s.substring(j, i+1))){
        			if(j==0) mincuts[i]=0;
        			else mincuts[i]=Math.min(mincuts[i], mincuts[j-1]+1);
        			if(mincuts[i]==0) break;
        		}
        	}
        }
        return mincuts[len-1];
    }
	 public boolean isPalin(String s){
		 char[] ss=s.toCharArray();
		 boolean flag=true;
		 if(ss.length<=1) return true;
		 int left=0,right=ss.length-1;
		 while(left<right){
			 if(ss[left++]!=ss[right--]){
				 flag=false;
				 break; 
			 }
		 }
		 return flag;
	 }
	 
	 public static void main(String[] args){
		 PalindromePartitioning132 p=new PalindromePartitioning132();
		 int r=p.minCut("aaabbbaaac");
		 System.out.println("r="+r);
	 }
}
