package googleTest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class sw22 {
	 public static void main(String[] args){
		    Scanner cin = new Scanner(System.in);
		    int n=cin.nextInt();
	        String s=cin.next();
	        char[] chs=s.toCharArray();
	        int m=cin.nextInt();
	       // String[] ill=new String[m];
	        String temp="";
	        Set<String> set=new HashSet<String>();
	        for(int i=0;i<m;i++){
	        	set.add(cin.next());
	        }
	        int[][] dp=new int[100000][27];
	        dp[0][chs[0]-'a']=1;
	        for(int i=1;i<n;i++){
	        	for(int j=0;j<27;++j){
	        		dp[i][j]=Math.max(dp[i][j], dp[i-1][j]);
	        		char ch=(char)(j+'a');
	        		StringBuilder sb1=new StringBuilder();
	        		StringBuilder sb2=new StringBuilder();
	        		String tmp1=sb1.append(chs[i]).append(ch).toString();
	        		String tmp2=sb2.append(ch).append(chs[i]).toString();
	        		if(!set.contains(tmp1)&&!set.contains(tmp2)){
	        			dp[i][chs[i]-'a']=Math.max(dp[i][chs[i]-'a'], dp[i-1][j]+1);
	        		}
	        	}
	        }
	        int ans=0;
	        for(int i=0;i<27;i++){
	        	ans=Math.max(ans, dp[n-1][i]);
	        }
	        System.out.println(n-ans);
	 }
}
