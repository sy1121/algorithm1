package googleTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class sw2 {
	/* public static void main(String[] args){
		    Scanner cin = new Scanner(System.in);
			int n=cin.nextInt();
	        String s=cin.next();
	        int m=cin.nextInt();
	       // String[] ill=new String[m];
	        String temp="";
	        Set<String> set=new HashSet<String>();
	        for(int i=0;i<m;i++){
	        	temp=cin.next();
	          set.add(temp);
	          set.add(reverse(temp));
	        }
	        int r=count(s,set);
	        System.out.println(s.length()-r);
	 }
	 
	 private static int count(String s,Set<String> set,char pre){
		  if(s.length()==0){
			  return 0;
		  }else if(s.length()==1){
			 if(!set.contains(pre+s)) return 1;
			 else return 0;
		  }else{
			  int len=0;
			  if(!set.contains(s.substring(0,2)))
			    len=2+count(s.substring(2),set,s.charAt(0));
			  else{
				  len=1+Math.max(count(s.substring(1),set),
				  count(s.charAt(0)+s.substring(2),set));
				  }
			//  len2=count(s.substring(1),set);
			  return Math.max(len, 1+count(s.substring(1),set));
		  }
	 }
	 */
	 private static String reverse(String s){
		StringBuilder sb=new StringBuilder(s);
	    return sb.reverse().toString();
	 }
}
