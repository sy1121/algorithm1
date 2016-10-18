package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePartitioning131 {
	//AC 9ms
	 public List<List<String>> partition(String s) {
		     if(s==null) return null;
	         List<List<String>> rlist=new ArrayList<List<String>>();
	         HashMap<String,List<List<String>>> map=new HashMap<String,List<List<String>>>();
	         int len=s.length();
	         for(int i=0;i<len;i++){
	        	 List<List<String>> clist=new ArrayList<List<String>>();
	        	  for(int j=i;j>=0;j--){
	        		  String curs=s.substring(j, i+1);
	        		  if(isPalin(curs)){
	        			  List<List<String>> preList=map.get(s.substring(0,j));
	        			  if(preList!=null){
	        			  for(List<String> l:preList) {
	        				  List<String> list=new ArrayList<String>(l);
	        				  list.add(curs); clist.add(list);
	        			   }
	        			  }else{
	        				  List<String> list=new ArrayList<String>();
	        				  list.add(curs);
	        				   clist.add(list);
	        			   }
	        		  }
	        	  }
	        	  map.put(s.substring(0,i+1), clist);
	         }
		    return map.get(s);
	    }
	 
	 public boolean isPalin(String s){
		 char[] ss=s.toCharArray();
		 if(ss.length<=1) return true;
		 int left=0,right=ss.length-1;
		 while(left<right){
			 if(ss[left++]!=ss[right--]) return false; 
		 }
		 return true;
	 }
	 
	 public static void main(String[] args){
		 PalindromePartitioning131 p=new PalindromePartitioning131();
		 List<List<String>> rlist=p.partition("aba");
		 for(int i=0;i<rlist.size();i++){
			 for(int j=0;j<rlist.get(i).size();j++){
				 System.out.print(rlist.get(i).get(j)+",");
			 }
			 System.out.println();
		 }
	 }
}
