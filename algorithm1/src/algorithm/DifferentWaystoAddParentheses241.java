package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DifferentWaystoAddParentheses241 {
	//典型的分治思想  AC 3ms   注意加缓存相当于记忆化搜索
	//这提示关键是分析出这是一个分治的问题
	 public List<Integer> diffWaysToCompute(String input) {
	         HashMap<String,List<Integer>> cache=new HashMap<String,List<Integer>>();
	         return divide(input,cache);
	    }
	 
	 public List<Integer> divide(String input,HashMap<String,List<Integer>> cache){
		    if(cache.containsKey(input)) return cache.get(input);
		    List<Integer> rlist=new ArrayList<Integer>();
		    if(isNum(input)){
		    	rlist.add(toInt(input));
		    	return rlist;
		    }else{
		       for(int i=0;i<input.length();i++){
		    	   if(!Character.isDigit(input.charAt(i))){
		    		    List<Integer> left=divide(input.substring(0,i), cache);
		    		    List<Integer> right=divide(input.substring(i+1),cache);
		    		    for(int j=0;j<left.size();j++){
		    		    	for(int k=0;k<right.size();k++){
		    		    		rlist.add(calculate(left.get(j),right.get(k),input.charAt(i)));
		    		    	}
		    		    }
		    	   }
		       }
		        
		    }
		      cache.put(input, rlist);
		      return rlist;
		    
	 }
	 
	 public int calculate(int num1,int num2,char oper){
		  int result=0;
		  switch(oper){
		  case '+':result= num1+num2;break;
		  case '-':result= num1-num2;break;
		  case '*':result=num1*num2;break;
		  default:break;
		  }
		  return result;
	 }
	 
	 public boolean isNum(String input){
		 for(int i=0;i<input.length();i++){
			 if(!Character.isDigit(input.charAt(i)))
				 return false;
		 }
		 return true;
	 }
	 
	 public int toInt(String input){
		 int result=0;
		 for(int i=0;i<input.length();i++){
			 result=result*10+(input.charAt(i)-'0');
		 }
		 return result;
	 }
	 
	 public static void main(String[] args){
		 DifferentWaystoAddParentheses241 d=new DifferentWaystoAddParentheses241();
		 List<Integer> list=d.diffWaysToCompute("2*3-4*5");
		 System.out.println("list="+list);
	 }
}
